package com.ss.android.socialbase.downloader.file;

import ai.j0;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import com.lynx.jsbridge.a;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadFileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f15609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f15610b;

    public static class MediaItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Uri f15611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15613c;

        public MediaItem() {
        }

        public static MediaItem a(Uri r5) {
            MediaItem r10 = new MediaItem();
            r10.f15611a = r5;
            r10.f15612b = r5.toString();
            r10.f15613c = "_id";
            return r10;
        }
    }

    static {
        SparseArray r5 = new SparseArray();     // Catch: Throwable -> L6
        f15609a = r5;     // Catch: Throwable -> L6
        if (a() == false) goto L8;
        r5.put(2, MediaItem.a(MediaStore.Images.Media.getContentUri("external_primary")));     // Catch: Throwable -> L6
        r5.put(3, MediaItem.a(MediaStore.Video.Media.getContentUri("external_primary")));     // Catch: Throwable -> L6
        r5.put(4, MediaItem.a(MediaStore.Audio.Media.getContentUri("external_primary")));     // Catch: Throwable -> L6
        r5.put(5, MediaItem.a(MediaStore.Downloads.EXTERNAL_CONTENT_URI));     // Catch: Throwable -> L6
    L13:
    L11:
        f15610b = null;
        return;
    L8:
        r5.put(2, MediaItem.a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI));     // Catch: Throwable -> L6
        r5.put(3, MediaItem.a(MediaStore.Video.Media.EXTERNAL_CONTENT_URI));     // Catch: Throwable -> L6
        r5.put(4, MediaItem.a(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        c.e("Error:", th, "DownloadFileUtils", "init");
        goto L11
    }

    public static boolean a() {
        return true;
    }

    public static int b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return -1;
    L6:
        if (r5.startsWith("content") == false) goto L15;
        int r10 = 0;
    L8:
        SparseArray r11 = f15609a;
        if (r10 >= r11.size()) goto L14;
        int r12 = r11.keyAt(r10);
        if (r5.startsWith(((MediaItem) r11.get(r12)).f15612b) == true) goto L12;
        r10 = r10 + 1;
        goto L8
    L12:
        return r12;
    L14:
        return -1;
    L15:
        return 1;
    }

    public static Uri c(String r12) {
        String r5 = DownloadDirUtils.f16126b;
        Uri r10 = MediaStore.Files.getContentUri("external");
        Cursor r11 = null;
        Cursor r13 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e().getContentResolver().query(MediaStore.setIncludePending(r10), new String[]{"_id"}, "_data=? ", new String[]{r12}, null);     // Catch: Throwable -> L14
        if (r13 != null) goto L19;
    L12:
        DownloadUtils.a(new Cursor[]{r13});
        return null;
    L19:
    L10:
        th = th;
        r11 = r13;
    L15:
        DownloadUtils.a(new Cursor[]{r11});
        throw th;
    L6:
        if (r13.moveToFirst() == false) goto L12;
        Uri r14 = ContentUris.withAppendedId(r10, r13.getInt(r13.getColumnIndex("_id")));     // Catch: Throwable -> L10
        DownloadUtils.a(new Cursor[]{r13});
        return r14;
    L14:
        th = th;
        goto L15
    }

    public static boolean d(String r10) {
        if (e(r10) == false) goto L6;
        return true;
    L6:
        if (DownloadDirUtils.g == null) goto L40;
        File r5 = DownloadDirUtils.g;
    L14:
        if (r5 != null) goto L16;
    L39:
        return false;
    L16:
        if (r10.startsWith(r5.getPath()) == false) goto L39;
        Context r11 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();
        if (r11 != null) goto L21;
        Logger.c("DownloadFileUtils", "isFilePathInExternalPublicDir", "Context is null");
        return false;
    L21:
        File r12 = DownloadDirUtils.a(r11, false);
        if (r12 != null) goto L25;
        Logger.c("DownloadFileUtils", "isFilePathInExternalPublicDir", "ExternalCacheDir is null");
        return false;
    L25:
        String r13 = r12.getParent();
        if (r13 != null) goto L28;
    L30:
        File r14 = DownloadDirUtils.d(r11, false);
        if (r14 == null) goto L36;
        if (r10.startsWith(r14.getAbsolutePath()) == false) goto L36;
        return false;
    L36:
        if (DownloadSetting.f.a("uncheck_external_public_dir", 0) <= 0) goto L38;
        return false;
    L38:
        return true;
    L28:
        if (r10.startsWith(r13) == false) goto L30;
        return false;
    L40:
        DownloadDirUtils.g = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L10
    L12:
        r5 = DownloadDirUtils.g;
    L10:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getExternalStorageDirectory");
        goto L12
    }

    public static boolean e(String r5) {
        if (b(r5) <= 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(DownloadFile r5) {
        if (r5.f15607a.f() == true) goto L5;
        return false;
    L5:
        if (r5.f15607a.length() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static String a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (r5.startsWith("content") == false) goto L18;
        int r10 = 0;
    L7:
        SparseArray r11 = f15609a;
        if (r10 >= r11.size()) goto L19;
        MediaItem r12 = (MediaItem) r11.get(r11.keyAt(r10));
        if (r5.startsWith(r12.f15612b) == true) goto L12;
        r10 = r10 + 1;
        goto L7
    L12:
        return r12.f15612b;
    L19:
        return null;
    L18:
        return null;
    }

    public static long b(Uri r5) {
        ParcelFileDescriptor r10 = a(r5, "r");     // Catch: Throwable -> L7
        long r11 = r10.getStatSize();     // Catch: Throwable -> L10
        DownloadUtils.a(new Closeable[]{r10});
        return r11;
    L8:
        DownloadUtils.a(new Closeable[]{r10});
        return -1;
    L7:
        r10 = null;
        goto L8
    }

    public static void a(Uri r11, int r12) {
        MediaItem r5 = (MediaItem) f15609a.get(r12);
        if (r5 == null) goto L18;
        String r10 = j0.q(new StringBuilder(), r5.f15613c, " = ?");
        String[] r13 = {r11.getLastPathSegment()};
        Cursor r14 = null;
        r14 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e().getContentResolver().query(MediaStore.setIncludePending(r5.f15611a), null, r10, r13, null);     // Catch: Throwable -> L11
        if (r14 == null) goto L14;
        if (r14.moveToFirst() == false) goto L14;
        DownloadUtils.a(new Cursor[]{r14});
        return;
    L14:
        throw new Throwable("Fail to check Uri with cursor.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DownloadUtils.a(new Cursor[]{r14});
        throw th;
    L18:
        throw new Throwable(a.d(r12, "Fail to check Uri, type error :"));
    }

    public static boolean b() {
        if (f15610b != null) goto L9;
        boolean r5 = false;
        if (DownloadSetting.f.a("enable_external_download", 0) <= 0) goto L7;
        r5 = true;
    L7:
        f15610b = Boolean.valueOf(r5);
    L9:
        return f15610b.booleanValue();
    }

    public static boolean c() {
        Context r5 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();
        if (r5 == null) goto L5;
        int r10 = r5.getApplicationInfo().targetSdkVersion;
        if (Logger.b() == false) goto L12;
        Logger.b("DownloadFileUtils", "isScopedStorage", "SDK_INT:" + Build.VERSION.SDK_INT + " targetSdkVersion:" + r10);
    L12:
        if (r10 == 29) goto L14;
    L19:
        if (r10 <= 29) goto L25;
        if (Logger.b() == false) goto L23;
        Logger.b("DownloadFileUtils", "isScopedStorage", "SDK_INT > Android Q");
    L23:
        return true;
    L25:
        if (Logger.b() == false) goto L27;
        Logger.b("DownloadFileUtils", "isScopedStorage", "ScopedStorage = False");
    L27:
        return false;
    L14:
        if (DownloadDirUtils.a(false) == true) goto L19;
        if (Logger.b() == false) goto L18;
        Logger.b("DownloadFileUtils", "isScopedStorage", "SDK_INT = Android Q and isExternalStorageLegacy");
    L18:
        return true;
    L5:
        if (Logger.b() == false) goto L7;
        Logger.b("DownloadFileUtils", "isScopedStorage", "Context is null");
    L7:
        return false;
    }

    public static ParcelFileDescriptor a(Uri r5, String r10) {
        ParcelFileDescriptor r11 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e().getContentResolver().openFileDescriptor(r5, r10);     // Catch: Exception -> L7
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IOException("Fail to get ParcelFileDescriptor, fileDescriptor is null");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        throw new IOException("Fail to get ParcelFileDescriptor", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(Uri r10) {
        String[] r5 = {"_data"};
        String r11 = null;
        Context r12 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();     // Catch: Throwable -> L17
        if (r12 != null) goto L7;
        DownloadUtils.a(new Cursor[]{null});
        return null;
    L7:
        Cursor r13 = r12.getContentResolver().query(r10, r5, null, null, null);     // Catch: Throwable -> L17
        if (r13 != null) goto L22;
    L15:
        DownloadUtils.a(new Cursor[]{r13});
        return r11;
    L22:
    L13:
        th = th;
        r11 = r13;
    L18:
        DownloadUtils.a(new Cursor[]{r11});
        throw th;
    L10:
        if (r13.moveToFirst() == false) goto L15;
        r11 = r13.getString(r13.getColumnIndex(r5[0]));     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    }
}
