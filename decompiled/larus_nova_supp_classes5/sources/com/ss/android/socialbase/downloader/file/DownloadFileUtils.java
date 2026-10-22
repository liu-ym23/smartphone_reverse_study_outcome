package com.ss.android.socialbase.downloader.file;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadFileUtils {
    private static SparseArray<MediaItem> MEDIA_STORE_DATA = null;
    public static final String MODE_READ = "r";
    public static final String MODE_WRITE = "w";
    private static final String TAG = "DownloadFileUtils";
    private static volatile Boolean mEnableExternalDownload;

    public static class MediaItem {
        public String columnId;
        public Uri contentUri;
        public String contentUriString;

        public MediaItem() {
        }

        public static MediaItem build(Uri r1, String r2) {
            MediaItem r0 = new MediaItem();
            r0.contentUri = r1;
            r0.contentUriString = r1.toString();
            r0.columnId = r2;
            return r0;
        }
    }

    public DownloadFileUtils() {
    }

    static {
        MEDIA_STORE_DATA = new SparseArray();     // Catch: Throwable -> L9
        if (isAtLeastAndroidQ() == false) goto L7;
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.getContentUri("external_primary"), DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(5, MediaItem.build(MediaStore.Downloads.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
    L13:
    L11:
        mEnableExternalDownload = null;
        return;
    L7:
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, DBDefinition.ID));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Logger.globalError(TAG, "init", "Error:" + th);
        goto L11
    }

    public static boolean isAtLeastAndroidQ() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isExternalDownloadEnabled() {
        if (mEnableExternalDownload != null) goto L12;
        if (Build.VERSION.SDK_INT > 29) goto L7;
    L9:
        boolean r0 = false;
    L10:
        mEnableExternalDownload = Boolean.valueOf(r0);
        goto L12
    L7:
        if (DownloadSetting.obtainGlobal().optInt("enable_external_download") <= 0) goto L9;
        r0 = true;
    L12:
        return mEnableExternalDownload.booleanValue();
    }

    public static boolean isScopedStorage() {
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 == null) goto L5;
        int r1 = r0.getApplicationInfo().targetSdkVersion;
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT:" + Build.VERSION.SDK_INT + " targetSdkVersion:" + r1);
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT < Android Q");
    L16:
        return false;
    L18:
        if (r1 == 29) goto L20;
    L25:
        if (r1 <= 29) goto L31;
        if (Logger.debug() == false) goto L29;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT > Android Q");
    L29:
        return true;
    L31:
        if (Logger.debug() == false) goto L33;
        Logger.globalDebug(TAG, "isScopedStorage", "ScopedStorage = False");
    L33:
        return false;
    L20:
        if (DownloadDirUtils.isExternalStorageLegacy(false) == true) goto L25;
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT = Android Q and isExternalStorageLegacy");
    L24:
        return true;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "isScopedStorage", "Context is null");
    L7:
        return false;
    }

    public static boolean checkUriInsert(String r1) {
        checkUri(UriProtector.parse(r1), getTypeByUri(r1));     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static void deleteUri(Uri r2) throws Throwable {
        com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_delete(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), r2, null, null);
    }

    public static boolean emptyFile(FileOutputStream r3) {
        r3.write(new byte[0]);     // Catch: Throwable -> L6
        r3.close();     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        Logger.globalError(TAG, "emptyFile", "Error:" + th);
        return false;
    }

    public static boolean exists(Uri r4) {
        if (getLength(r4) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean existsAndNotEmpty(DownloadFile r4) {
        if (r4.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r4.length() <= 0) goto L7;
        return true;
    }

    public static String getContentUriString(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        if (r3.startsWith("content") == false) goto L18;
        int r0 = 0;
    L8:
        if (r0 >= MEDIA_STORE_DATA.size()) goto L19;
        int r1 = MEDIA_STORE_DATA.keyAt(r0);
        MediaItem r2 = MEDIA_STORE_DATA.get(r1);
        if (r3.startsWith(r2.contentUriString) == true) goto L12;
        r0 = r0 + 1;
        goto L8
    L12:
        return r2.contentUriString;
    L19:
        return null;
    L18:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getFilePathFromUri(Uri r10) {
        String[] r0 = {"_data"};
        String r9 = null;
        Context r1 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();     // Catch: Throwable -> L17
        if (r1 != null) goto L7;
        DownloadUtils.safeClose(new Cursor[]{null});
        return null;
    L7:
        Cursor r11 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(r1.getContentResolver(), r10, r0, null, null, null);     // Catch: Throwable -> L17
        if (r11 != null) goto L22;
    L15:
        DownloadUtils.safeClose(new Cursor[]{r11});
        return r9;
    L22:
    L13:
        th = th;
        r9 = r11;
    L18:
        DownloadUtils.safeClose(new Cursor[]{r9});
        throw th;
    L10:
        if (r11.moveToFirst() == false) goto L15;
        r9 = r11.getString(r11.getColumnIndex(r0[0]));     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    }

    public static long getLength(Uri r5) {
        ParcelFileDescriptor r2 = null;
        r2 = getParcelFileDescriptor(r5, MODE_READ);     // Catch: Throwable -> L6
        long r3 = r2.getStatSize();     // Catch: Throwable -> L6
        DownloadUtils.safeClose(new Closeable[]{r2});
        return r3;
    L6:
        DownloadUtils.safeClose(new Closeable[]{r2});
        return -1;
    }

    public static Pair<String, String> getParentAndNameFromRelativePath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        return new Pair(r0.getParent(), r0.getName());
    L6:
        return null;
    }

    public static Pair<String, String> getParentAndNameFromUri(Uri r0) {
        return getParentAndNameFromRelativePath(getFilePathFromUri(r0));
    }

    public static int getTypeByUri(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return -1;
    L6:
        if (r4.startsWith("content") == false) goto L15;
        int r0 = 0;
    L9:
        if (r0 >= MEDIA_STORE_DATA.size()) goto L14;
        int r2 = MEDIA_STORE_DATA.keyAt(r0);
        if (r4.startsWith(MEDIA_STORE_DATA.get(r2).contentUriString) == true) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r2;
    L14:
        return -1;
    L15:
        return 1;
    }

    public static Uri getUriFromFilePath(String r13) {
        Uri r0 = DownloadDirUtils.getRootContentUri();
        Cursor r3 = null;
    L19:
        th = th;
    L20:
        DownloadUtils.safeClose(new Cursor[]{r3});
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Cursor r14 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), MediaStore.setIncludePending(r0), new String[]{DBDefinition.ID}, "_data=? ", new String[]{r13}, null);     // Catch: Throwable -> L19
    L9:
        if (r14 != null) goto L22;
    L17:
        DownloadUtils.safeClose(new Cursor[]{r14});
        return null;
    L22:
    L15:
        th = move-exception;
        r3 = r14;
        th = th;
        goto L20
    L11:
        if (r14.moveToFirst() == false) goto L17;
        Uri r1 = ContentUris.withAppendedId(r0, r14.getInt(r14.getColumnIndex(DBDefinition.ID)));     // Catch: Throwable -> L15
        DownloadUtils.safeClose(new Cursor[]{r14});
        return r1;
    L8:
        r14 = null;
        goto L9
    }

    public static boolean isFilePathInExternalPublicDir(String r6) {
        if (isMediaUri(r6) == false) goto L5;
        return true;
    L5:
        File r2 = DownloadDirUtils.getExternalStorageDirectory(false);
        if (r2 != null) goto L8;
    L31:
        return false;
    L8:
        if (r6.startsWith(r2.getPath()) == false) goto L31;
        Context r3 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r3 != null) goto L13;
        Logger.globalError(TAG, "isFilePathInExternalPublicDir", "Context is null");
        return false;
    L13:
        File r5 = DownloadDirUtils.getExternalCacheDir(r3, false);
        if (r5 != null) goto L17;
        Logger.globalError(TAG, "isFilePathInExternalPublicDir", "ExternalCacheDir is null");
        return false;
    L17:
        String r4 = r5.getParent();
        if (r4 != null) goto L20;
    L22:
        File r7 = DownloadDirUtils.getObbDirStr(r3, false);
        if (r7 == null) goto L28;
        if (r6.startsWith(r7.getAbsolutePath()) == false) goto L28;
        return false;
    L28:
        if (DownloadSetting.obtainGlobal().optInt("uncheck_external_public_dir", 0) <= 0) goto L30;
        return false;
    L30:
        return true;
    L20:
        if (r6.startsWith(r4) == false) goto L22;
        return false;
    }

    public static boolean isMediaUri(String r1) {
        if (getTypeByUri(r1) > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setEnableExternalDownload(boolean r0) {
        mEnableExternalDownload = Boolean.valueOf(r0);
    }

    public static void checkUri(Uri r8, int r9) throws Throwable {
        MediaItem r0 = MEDIA_STORE_DATA.get(r9);
        if (r0 == null) goto L20;
        String r5 = r0.columnId + " = ?";
        String[] r6 = {r8.getLastPathSegment()};
        Cursor r10 = null;
        Uri r1 = r0.contentUri;     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r1 = MediaStore.setIncludePending(r1);     // Catch: Throwable -> L16
    L8:
        r10 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), r1, null, r5, r6, null);     // Catch: Throwable -> L16
        if (r10 == null) goto L15;
        if (r10.moveToFirst() == false) goto L15;
        DownloadUtils.safeClose(new Cursor[]{r10});
        return;
    L15:
        throw new Throwable("Fail to check Uri with cursor.");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r10});
        throw th;
    L20:
        throw new Throwable("Fail to check Uri, type error :" + r9);
    }

    public static FileDescriptor getFileDescriptor(Uri r0, String r1) throws IOException {
        ParcelFileDescriptor r2 = getParcelFileDescriptor(r0, r1);
        if (r2 == null) goto L7;
        return r2.getFileDescriptor();
    L7:
        throw new IOException("Fail to get FileDescriptor, ParcelFileDescriptor is null");
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(Uri r1, String r2) throws IOException {
        if (r1 == null) goto L12;
        ParcelFileDescriptor r3 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_openFileDescriptor(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), r1, r2);     // Catch: Exception -> L8
        if (r3 == null) goto L7;
        return r3;
    L7:
        throw new IOException("Fail to get ParcelFileDescriptor, fileDescriptor is null");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        throw new IOException("Fail to get ParcelFileDescriptor", e);
    L12:
        throw new IOException("Fail to get ParcelFileDescriptor, uri is null");
    }

    private static Uri com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_insert(ContentResolver r18, Uri r19, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static ParcelFileDescriptor com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_openFileDescriptor(ContentResolver r18, Uri r19, String r20) throws IOException {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(240020);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r18, r1, "android.os.ParcelFileDescriptor", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ParcelFileDescriptor) r4.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r18, r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static ContentValues createContentValues(String r2, String r3, String r4) {
        ContentValues r0 = new ContentValues();
        r0.put("relative_path", r2);
        r0.put("_display_name", r3);
        r0.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.put("mime_type", r4);
    L5:
        return r0;
    }

    public static String getExternalUriPath(String r6, String r7, String r8) {
        if (isExternalDownloadEnabled() == true) goto L5;
        return null;
    L5:
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 != null) goto L8;
        return null;
    L8:
        List r9 = Downloader.getInstance(r0).getDownloadInfoList(r6);
        if (r9 != null) goto L11;
    L37:
        Uri r10 = createUriAtLeastQ(MediaStore.Downloads.EXTERNAL_CONTENT_URI, DownloadDirUtils.getExternalRelativePath(), r7, r8);     // Catch: Throwable -> L31
    L33:
        if (r10 != null) goto L36;
        return null;
    L36:
        return r10.toString();
    L31:
        th = move-exception;
        Logger.globalError(TAG, "getExternalSavePath", "Error:" + th);
        r10 = null;
        goto L33
    L11:
        if (r9.isEmpty() == true) goto L37;
        Iterator r11 = r9.iterator();
        String r2 = null;
    L14:
        if (r11.hasNext() == false) goto L27;
        DownloadInfo r3 = (DownloadInfo) r11.next();
        String r4 = r3.getSavePath();
        if (TextUtils.isEmpty(r2) == false) goto L25;
        if (TextUtils.isEmpty(r2) == false) goto L24;
        if (isMediaUri(r4) == false) goto L24;
        if (checkUriInsert(r4) == false) goto L25;
    L24:
        r2 = r4;
    L25:
        Downloader.getInstance(r0).clearDownloadData(r3.getId());
        goto L14
    L27:
        if (TextUtils.isEmpty(r2) == true) goto L37;
        return r2;
    }

    private static int com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_delete(ContentResolver r18, Uri r19, String r20, String[] r21) throws Throwable {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(240019);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240019, "android/content/ContentResolver", "delete", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.delete(r19, r20, r21);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static Uri createUriAtLeastQ(Uri r1, String r2, String r3, String r4) {
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_insert(r0.getContentResolver(), r1, createContentValues(r2, r3, r4));
    }

    public static Uri getUriAtLeastQ(Uri r1, String r2, String r3, String r4) {
        Uri r0 = queryUriAtLeastQ(r1, r2, r3, r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return createUriAtLeastQ(r1, r2, r3, r4);
    }

    public static Uri queryUriAtLeastQ(Uri r7, String r8, String r9, String r10) {
        Cursor r2 = null;
        if (r7 != null) goto L5;
    L41:
        return null;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L41;
        if (TextUtils.isEmpty(r9) == true) goto L41;
        if (r8.startsWith("/") == false) goto L13;
        r8 = r8.substring(1);
    L13:
        if (r8.endsWith("/") == true) goto L44;
        r8 = r8.concat("/");
    L44:
    L38:
        th = th;
    L39:
        DownloadUtils.safeClose(new Cursor[]{r2});
        throw th;
    L17:
        if (TextUtils.isEmpty(r10) == false) goto L19;
        String r4 = "";
    L20:
        String r1 = "relative_path = ? AND _display_name = ?".concat(r4);     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r10) == false) goto L23;
        String[] r11 = {r8, r9};     // Catch: Throwable -> L38
    L24:
        Bundle r12 = new Bundle();     // Catch: Throwable -> L38
        r12.putString("android:query-arg-sql-selection", r1);     // Catch: Throwable -> L38
        r12.putStringArray("android:query-arg-sql-selection-args", r11);     // Catch: Throwable -> L38
        r12.putString("android:query-arg-sql-sort-order", "_id DESC");     // Catch: Throwable -> L38
        if (Build.VERSION.SDK_INT <= 30) goto L27;
        r12.putInt("android:query-arg-match-pending", 1);     // Catch: Throwable -> L38
    L27:
        Cursor r13 = com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext().getContentResolver(), MediaStore.setIncludePending(r7), new String[]{DBDefinition.ID}, r12, null);     // Catch: Throwable -> L38
        if (r13 != null) goto L42;
    L36:
        DownloadUtils.safeClose(new Cursor[]{r13});
        return null;
    L42:
    L34:
        th = th;
        r2 = r13;
        goto L39
    L30:
        if (r13.moveToFirst() == false) goto L36;
        Uri r14 = ContentUris.withAppendedId(r7, r13.getLong(r13.getColumnIndexOrThrow(DBDefinition.ID)));     // Catch: Throwable -> L34
        DownloadUtils.safeClose(new Cursor[]{r13});
        return r14;
    L23:
        r11 = new String[]{r8, r9, r10};     // Catch: Throwable -> L38
        goto L24
    L19:
        r4 = " AND mime_type = ?";
        goto L20
    }

    private static Cursor com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, Bundle r16, CancellationSignal r17) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17);
        r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r13, r9, r12, r10, true);
        return r12;
    }

    private static Cursor com_ss_android_socialbase_downloader_file_DownloadFileUtils_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) throws Throwable {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r13, r9, r12, r10, true);
        return r12;
    }
}
