package com.bytedance.android.live.saas.middleware.store;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
class FileUtils implements IFileUtils {
    public static final String BEAUTY = "beauty";
    private static final int BYTE_PER_KB = 1024;
    public static final String CACHE_DIR = "huoshan/cache";
    public static final String DIR_VIDEO_EDIT = "VideoEdit";
    private static final String EDIT_MUSIC = "edit_music";
    public static final String FEED_CACHE = "feed";
    public static final String FILTER = "filter";
    public static final String MODEL = "models";
    public static final String PICTURE = "picture";
    public static final String PICTURE_THEME = "theme";
    public static final String QRCODE = "qrcode";
    private static final int RADIX = 16;
    public static final String RESHARP = "resharp";
    public static final String SDKLOG = "sdklog";
    public static final String SDKLOG_UPLOAD = "sdklog_upload";
    public static final String SEGMENT_ROOT = "segment_draft";
    public static final String STICKER = "sticker";
    public static final String TAG = "file_path";
    public static final String TMP = "/tmp/";
    private static final String UNIT_B = "unit_b";
    public static final String UNIT_KB = "unit_kb";
    public static final String UNIT_MB = "unit_mb";
    public static final String VIDEO = "video";
    public static final String VIDEO_TMP = "video_tmp";

    public FileUtils() {
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalAppPath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/livestream";
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalPictureDir() {
        return getAppExternalTypeDir(PICTURE);
    }

    public File getExternalVideoDir() {
        return getAppExternalTypeDir(VIDEO);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    L4:
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalAppDir() {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/livestream");
        ensureDirExists(r0);
        Logger.d(TAG, "app path:" + r0.getAbsolutePath());
        return r0;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardAvailable() {
        String r0 = Environment.getExternalStorageState();     // Catch: Exception -> L4
    L7:
        if ("mounted".equals(r0) == false) goto L9;
    L12:
        return true;
    L9:
        if ("mounted_ro".equals(r0) == true) goto L12;
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L7
    }

    private File getAppExternalTypeDir(String r3) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r0 = new PolarisFileWrapper(getExternalAppDir(), r3);
        ensureDirExists(r0);
        Logger.d(TAG, r3 + " path:" + r0.getAbsolutePath());
        return r0;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String appendFileSeparateForPath(String r3) {
        if (StringUtils.isEmpty(r3) == true) goto L8;
        String r0 = File.separator;
        if (r3.endsWith(r0) == false) goto L7;
        return r3;
    L7:
        return r3 + r0;
    L8:
        return r3;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkFileExists(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r2).exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeExternalDirIsExist(String r3) {
        return new PolarisFileWrapper(getExternalAppDir(), r3).exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r1) throws Exception {
        com.bytedance.common.utility.io.FileUtils.clearDir(r1);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean ensureDirExists(File r2) {
        if (r2.exists() == true) goto L6;
        r2.mkdirs();
    L6:
        return r2.exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public byte[] getByteArray(String r1) {
        return com.bytedance.common.utility.io.FileUtils.getByteArray(r1);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getCacheDirPath(Context r1) throws NullPointerException {
        return com.bytedance.common.utility.io.FileUtils.getCacheDirPath(r1);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getCacheSize(Context r5) {
        File r0 = getExternalCacheDir(r5);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return getDirSize(r0.getAbsolutePath()) + getDirSize(getEidtAbsoluteExternalDir(CACHE_DIR, r5));
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getConfiJsonFilePath(String r4) {
        String r0 = File.separator;
        if (r4.endsWith(r0) == false) goto L6;
        return r4.concat("config.json");
    L6:
        return r4 + r0 + "config.json";
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getDirSize(String r7) {
        long r1 = 0;
        if (isSdcardWritable() == true) goto L5;
    L25:
        return r1;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L25;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r7);
        if (r0.exists() == false) goto L25;
        if (r0.isDirectory() == false) goto L25;
        File[] r8 = r0.listFiles();
        if (r8 != null) goto L15;
        return 0;
    L15:
        int r2 = r8.length;
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L25;
        File r4 = r8[r3];
        if (r4.isFile() == false) goto L22;
        long r5 = r4.length();
    L20:
        r1 = r1 + r5;
    L24:
        r3 = r3 + 1;
        goto L16
    L22:
        if (r4.isDirectory() == false) goto L24;
        r5 = getDirSize(r4.getAbsolutePath());
        goto L20
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheDir(Context r4) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r4.getPackageName() + "/cache");
        ensureDirExists(r0);
        StringBuilder r5 = new StringBuilder("cache path:");
        r5.append(r0.getAbsolutePath());
        Logger.d(TAG, r5.toString());
        return r0;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalCachePath(Context r3) {
        return Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r3.getPackageName() + "/cache";
    }

    public File getExternalFeedCacheDir(Context r2) {
        return getExternalCacheTypeDir(FEED_CACHE, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalFilesDir(Context r4) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r4.getPackageName() + "/files");
        ensureDirExists(r0);
        return r0;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalModelDir(Context r2) {
        return getEditExternalTypeDir(MODEL, r2);
    }

    public File getExternalPictureCacheDir(Context r2) {
        return getExternalCacheTypeDir(PICTURE, r2);
    }

    public File getExternalVideoCacheDir(Context r2) {
        return getExternalCacheTypeDir(VIDEO, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getFileSize(File r4) {
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.exists() == false) goto L16;
    L17:
        return new PolarisFileInputStreamWrapper(r4).available();
    L11:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L16:
        return 0;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getFilesDir(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Environment.isExternalStorageEmulated() == true) goto L13;
        File r0 = r3.getExternalFilesDir(null);
        if (r0 == null) goto L12;
        ensureDirExists(r0);
        return r0;
    L12:
        return r3.getFilesDir();
    L13:
        return r3.getFilesDir();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public com.bytedance.common.utility.io.FileUtils.ImageType getImageType(String r1) {
        return com.bytedance.common.utility.io.FileUtils.getImageType(r1);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public InputStream getInputStream(String r1) {
        return com.bytedance.common.utility.io.FileUtils.getInputStream(r1);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDir(Context r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3.getFilesDir().getPath());
        if (ensureDirExists(r0) == true) goto L6;
        return null;
    L6:
        Logger.d(TAG, "internal storage path:" + r0.getAbsolutePath());
        return r0;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalDataDir(Context r5) {
        if (Environment.isExternalStorageEmulated() == false) goto L6;
        File r6 = r5.getDir(DIR_VIDEO_EDIT, 0);
    L11:
        ensureDirExists(r6);
        return r6;
    L6:
        if (isSdcardAvailable() == true) goto L8;
        return null;
    L8:
        if (isSdcardWritable() == false) goto L15;
        r6 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r5.getPackageName() + File.separator + DIR_VIDEO_EDIT);
        goto L11
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getOutDataDir(Context r4) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r4.getPackageName() + "/VideoEdit");
        ensureDirExists(r0);
        return r0;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public JSONObject parseJsonFile(String r6) {
        if (new PolarisFileWrapper(r6).exists() == true) goto L56;
    L45:
        return null;
    L56:
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(r6);     // Catch: Throwable -> L20 IOException -> L22
    L58:
        InputStreamReader r7 = new InputStreamReader(r0, "UTF-8");     // Catch: Throwable -> L16 IOException -> L18
        char[] r2 = new char[r0.available()];     // Catch: IOException -> L14 Throwable -> L35
        r7.read(r2);     // Catch: IOException -> L12 Throwable -> L35
        r7.close();     // Catch: IOException -> L12 Throwable -> L35
        r0.close();     // Catch: IOException -> L12 Throwable -> L35
        r7.close();     // Catch: IOException -> L10
        r0.close();     // Catch: IOException -> L10
    L29:
        if (r2 == null) goto L45;
        return new JSONObject(new String(r2));
    L33:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L35
        if (r7 == null) goto L27;
        r7.close();     // Catch: IOException -> L10
    L27:
        if (r0 == null) goto L29;
        r0.close();     // Catch: IOException -> L10
    L14:
        e = e;
        r2 = null;
    L35:
        Throwable th = th;
    L36:
        if (r7 != null) goto L53;
    L40:
        if (r0 == null) goto L44;
        r0.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L44:
        throw th;
    L53:
        r7.close();     // Catch: IOException -> L38
        goto L40
    L18:
        e = e;
        r7 = null;
        r2 = null;
    L16:
        th = move-exception;
        th = th;
        r7 = null;
    L22:
        e = e;
        r7 = null;
        r0 = null;
        r2 = null;
    L20:
        th = move-exception;
        r0 = null;
        th = th;
        r7 = null;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readConfigJsonFile(String r6) {
        if (new PolarisFileWrapper(r6).exists() == true) goto L51;
    L42:
        return null;
    L51:
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(r6);     // Catch: Throwable -> L20 IOException -> L22
    L53:
        InputStreamReader r7 = new InputStreamReader(r0, "UTF-8");     // Catch: Throwable -> L16 IOException -> L18
        char[] r2 = new char[r0.available()];     // Catch: IOException -> L14 Throwable -> L32
        r7.read(r2);     // Catch: IOException -> L12 Throwable -> L32
        r7.close();     // Catch: IOException -> L12 Throwable -> L32
        r0.close();     // Catch: IOException -> L12 Throwable -> L32
        r7.close();     // Catch: IOException -> L10
        r0.close();     // Catch: IOException -> L10
    L29:
        if (r2 == null) goto L42;
        return new String(r2);
    L12:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L32
        if (r7 == null) goto L27;
        r7.close();     // Catch: IOException -> L10
    L27:
        if (r0 == null) goto L29;
        r0.close();     // Catch: IOException -> L10
    L14:
        e = e;
        r2 = null;
    L32:
        Throwable th = th;
    L33:
        if (r7 != null) goto L45;
    L37:
        if (r0 == null) goto L41;
        r0.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    L41:
        throw th;
    L45:
        r7.close();     // Catch: IOException -> L35
        goto L37
    L18:
        e = e;
        r7 = null;
        r2 = null;
    L16:
        th = move-exception;
        th = th;
        r7 = null;
    L22:
        e = e;
        r7 = null;
        r0 = null;
        r2 = null;
    L20:
        th = move-exception;
        r0 = null;
        th = th;
        r7 = null;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readStringFromFile(File r6) {
        String r1 = "";
        if (checkFileExists(r6.getPath()) == true) goto L52;
        return "";
    L52:
        PolarisFileReaderWrapper r2 = new PolarisFileReaderWrapper(r6);     // Catch: Throwable -> L25 Exception -> L27
        BufferedReader r7 = new BufferedReader(r2);     // Catch: Throwable -> L21 Exception -> L23
    L56:
        String r0 = r7.readLine();     // Catch: Exception -> L19 Throwable -> L38
        if (r0 == null) goto L59;
        r1 = r1 + r0;     // Catch: Exception -> L19 Throwable -> L38
        goto L56
    L59:
        r2.close();     // Catch: IOException -> L13
    L15:
        r7.close();     // Catch: IOException -> L17
    L51:
    L37:
        return r1;
    L13:
        e = move-exception;
        e.printStackTrace();
    L19:
        Exception e = e;
    L29:
        e.printStackTrace();     // Catch: Throwable -> L38
        if (r2 != null) goto L63;
    L35:
        if (r7 == null) goto L37;
        r7.close();     // Catch: IOException -> L17
        goto L51
    L63:
        r2.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L38:
        Throwable th = th;
    L39:
        if (r2 != null) goto L61;
    L44:
        if (r7 == null) goto L69;
        r7.close();     // Catch: IOException -> L47
        throw th;
    L47:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L69:
        throw th;
    L61:
        r2.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L23:
        e = move-exception;
        e = e;
        r7 = null;
    L21:
        th = move-exception;
        th = th;
        r7 = null;
        goto L39
    L17:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        r2 = null;
        e = e;
        r7 = null;
    L25:
        th = move-exception;
        r2 = null;
        th = th;
        r7 = null;
        goto L39
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void removeDir(File r5) {
        if (r5.isDirectory() == false) goto L16;
        File[] r6 = r5.listFiles();
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length == 0) goto L21;
        int r0 = r6.length;
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L22;
        File r2 = r6[r1];
        if (r2.isDirectory() == false) goto L14;
        removeDir(r2);
    L15:
        r1 = r1 + 1;
        goto L10
    L14:
        r2.delete();
        goto L15
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean removeFile(String r3) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L19;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L10;
        return false;
    L10:
        if (r0.canWrite() == true) goto L12;
        return false;
    L12:
        if (r0.delete() == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void updateMediaStore(String r4) {
        final Context r0 = BDLiveSdk.getContext();
        MediaScannerConnection.scanFile(r0, new String[]{r4}, null, new AnonymousClass1(this, r0));
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeInternalDirIsExist(String r2, Context r3) {
        return new PolarisFileWrapper(getInternalAppDir(r3), r2).exists();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r1, Set<String> r2) throws Exception {
        com.bytedance.common.utility.io.FileUtils.clearDir(r1, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File createFile(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == true) goto L16;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        if (r0.exists() == true) goto L15;
        if (r3 == true) goto L18;
        r0.mkdirs();
        goto L15
    L18:
        File r4 = r0.getParentFile();     // Catch: IOException -> L13
        if (r4.exists() == true) goto L11;
        r4.mkdirs();     // Catch: IOException -> L13
    L11:
        r0.createNewFile();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        return r0;
    L16:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19, types: [com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean fileChannelCopy(String r12, String r13) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        PolarisFileInputStreamWrapper r0 = null;
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r12);     // Catch: Throwable -> L39 IOException -> L42 FileNotFoundException -> L59
        r12 = new PolarisFileOutputStreamWrapper(r13);     // Catch: Throwable -> L30 IOException -> L33 FileNotFoundException -> L36
    L101:
        r13 = r2.getChannel();     // Catch: Throwable -> L24 IOException -> L26 FileNotFoundException -> L28
    L103:
        r0 = r12.getChannel();     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L22
        r13.transferTo(0, r13.size(), r0);     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L22
        r2.close();     // Catch: IOException -> L14
        r13.close();     // Catch: IOException -> L14
        r12.close();     // Catch: IOException -> L14
        if (r0 == null) goto L106;
        r0.close();     // Catch: IOException -> L14
        return true;
    L106:
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L22:
        e = e;
        PolarisFileInputStreamWrapper r3 = r0;
        r0 = r2;
        ?? r14 = r12;
        ?? r15 = r13;
    L62:
        e.printStackTrace();     // Catch: Throwable -> L76
        if (r0 != null) goto L90;
    L67:
        if (r15 == 0) goto L69;
        r15.close();     // Catch: IOException -> L65
    L69:
        if (r14 == 0) goto L71;
        r14.close();     // Catch: IOException -> L65
    L71:
        if (r3 == null) goto L75;
        r3.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L75:
        return false;
    L90:
        r0.close();     // Catch: IOException -> L65
    L20:
        e = e;
        PolarisFileInputStreamWrapper r4 = r0;
        r0 = r2;
        ?? r16 = r12;
        ?? r17 = r13;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L76
        if (r0 != null) goto L94;
    L50:
        if (r17 == 0) goto L52;
        r17.close();     // Catch: IOException -> L48
    L52:
        if (r16 == 0) goto L54;
        r16.close();     // Catch: IOException -> L48
    L54:
        if (r4 == null) goto L58;
        r4.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
    L58:
        return false;
    L94:
        r0.close();     // Catch: IOException -> L48
    L18:
        th = th;
        ?? r5 = r0;
        r0 = r2;
    L77:
        if (r0 != null) goto L96;
    L81:
        if (r13 == 0) goto L83;
        r13.close();     // Catch: IOException -> L79
    L83:
        if (r12 == 0) goto L85;
        r12.close();     // Catch: IOException -> L79
    L85:
        if (r5 == 0) goto L89;
        r5.close();     // Catch: IOException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
    L89:
        throw th;
    L96:
        r0.close();     // Catch: IOException -> L79
    L28:
        e = e;
        PolarisFileInputStreamWrapper r18 = null;
        ?? r19 = r12;
    L38:
        r0 = r2;
        ?? r110 = r19;
        PolarisFileInputStreamWrapper r111 = r18;
    L61:
        r3 = r111;
        r14 = r110;
        r15 = r111;
    L26:
        e = e;
        PolarisFileInputStreamWrapper r112 = null;
        ?? r113 = r12;
    L35:
        r0 = r2;
        ?? r114 = r113;
        PolarisFileInputStreamWrapper r115 = r112;
    L44:
        r4 = r115;
        r16 = r114;
        r17 = r115;
    L24:
        th = th;
        Object r116 = null;
        ?? r117 = r12;
    L32:
        r0 = r2;
        r12 = r117;
        r13 = r116;
    L41:
        r5 = r13;
    L36:
        e = e;
        r19 = 0;
        r18 = null;
    L33:
        e = e;
        r113 = 0;
        r112 = null;
    L30:
        th = th;
        r117 = 0;
        r116 = null;
        goto L32
    L76:
        th = th;
    L59:
        e = e;
        r110 = 0;
        r111 = null;
    L42:
        e = e;
        r114 = 0;
        r115 = null;
    L39:
        th = th;
        r12 = 0;
        r13 = 0;
        goto L41
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getEditExternalTypeDir(String r4, Context r5) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == true) goto L8;
        return null;
    L8:
        if (TextUtils.equals("InnerSDKCore.getChannel();", "local_test") == false) goto L10;
        File r6 = getOutDataDir(r5);
    L11:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6, r4);
        ensureDirExists(r0);
        Logger.d(TAG, r4 + " path:" + r0.getAbsolutePath());
        return r0;
    L10:
        r6 = getInternalDataDir(r5);
        goto L11
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getEidtAbsoluteExternalDir(String r2, Context r3) {
        return getEditExternalTypeDir(r2, r3).getAbsolutePath() + "/";
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheTypeDir(String r2, Context r3) {
        if (isSdcardAvailable() == true) goto L5;
        return null;
    L5:
        if (isSdcardWritable() == false) goto L11;
        PolarisFileWrapper r0 = new PolarisFileWrapper(getExternalCacheDir(r3), r2);
        ensureDirExists(r0);
        Logger.d(TAG, r2 + " cache path:" + r0.getAbsolutePath());
        return r0;
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDirWithType(String r2, Context r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(getInternalAppDir(r3), r2);
        if (ensureDirExists(r0) == true) goto L6;
        return null;
    L6:
        Logger.d(TAG, r2 + " path:" + r0.getAbsolutePath());
        return r0;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean renameFile(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        PolarisFileWrapper r5 = new PolarisFileWrapper(r4);
        if (r0.exists() == true) goto L10;
        return false;
    L10:
        if (r0.renameTo(r5) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void saveImageToGallery(Context r5, File r6) {
        String r0 = r6.getAbsolutePath();
        MediaStore.Images.Media.insertImage(r5.getContentResolver(), r6.getAbsolutePath(), r6.getName(), null);     // Catch: FileNotFoundException -> L5
    L7:
        r5.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriProtector.parse("file://" + r0)));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void unZipFolder(String r5, String r6) throws IOException {
        ZipInputStream r0 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r5)));
    L3:
        ZipEntry r7 = r0.getNextEntry();
        if (r7 == null) goto L20;
        String r1 = r7.getName();
        if (r1.contains("..") == true) goto L3;
        if (r7.isDirectory() == true) goto L10;
        PolarisFileWrapper r8 = new PolarisFileWrapper(r6 + File.separator + r1);
        if (r8.exists() == false) goto L14;
        r8.delete();
    L15:
        r8.createNewFile();
        BufferedOutputStream r2 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r8));
        byte[] r9 = new byte[2048];
    L16:
        int r3 = r0.read(r9);
        if (r3 == (-1)) goto L19;
        r2.write(r9, 0, r3);
        goto L16
    L19:
        r2.flush();
        r2.close();
        goto L3
    L14:
        r8.getParentFile().mkdirs();
        goto L15
    L10:
        new PolarisFileWrapper(r6 + File.separator + r1).mkdirs();
        goto L3
    L20:
        r0.close();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean writeString2File(String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L11:
        return true;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L11;
        PolarisFileWriterWrapper r2 = new PolarisFileWriterWrapper(r4, false);     // Catch: Exception -> L10
        r2.write(r5);     // Catch: Exception -> L10
        r2.flush();     // Catch: Exception -> L10
        r2.close();     // Catch: Exception -> L10
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean copyFile(String r1, String r2, String r3) {
        return com.bytedance.common.utility.io.FileUtils.copyFile(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean saveInputStream(InputStream r1, String r2, String r3) {
        return com.bytedance.common.utility.io.FileUtils.saveInputStream(r1, r2, r3);
    }
}
