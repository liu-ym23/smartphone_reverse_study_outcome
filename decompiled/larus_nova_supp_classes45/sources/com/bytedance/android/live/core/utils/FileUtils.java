package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.common.utility.Logger;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FileUtils {
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
    static final String[] VIDEO_TYPE = null;

    static {
        VIDEO_TYPE = new String[]{"mp4", "flv", "mov", "mkv"};
    }

    public static boolean isSdcardWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    L4:
        return false;
    }

    private FileUtils() {
    }

    public static String calculateMD5(File r4) {
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L18
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r4);
        byte[] r5 = new byte[IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR];
    L30:
        int r0 = r2.read(r5);     // Catch: Throwable -> L11 IOException -> L13
        if (r0 <= 0) goto L8;
        r1.update(r5, 0, r0);     // Catch: Throwable -> L11 IOException -> L13
        goto L30
    L8:
        String r6 = String.format("%32s", new Object[]{new BigInteger(1, r1.digest()).toString(16)}).replace(' ', '0');     // Catch: Throwable -> L11 IOException -> L13
        r2.close();     // Catch: IOException -> L19
    L10:
        return r6;
    L11:
        th = move-exception;
        r2.close();     // Catch: IOException -> L20
    L17:
        throw th;
    L22:
        r2.close();     // Catch: IOException -> L21
    L15:
        return "";
    L18:
        return null;
    }

    public static boolean checkFileExists(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r1).exists();
    }

    public static boolean ensureDirExists(File r1) {
        if (r1 == null) goto L7;
        if (r1.exists() == true) goto L7;
        r1.mkdirs();
    L7:
        return r1.exists();
    }

    public static File getExternalCacheDir(Context r3) {
        File r4 = r3.getExternalCacheDir();
        if (r4 == null) goto L5;
        ensureDirExists(r4);
        Logger.d(TAG, "cache path:" + r4.getAbsolutePath());
    L6:
        return r4;
    L5:
        Logger.d(TAG, "cache path: is null");
        goto L6
    }

    public static long getFileSize(File r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (r3.exists() == false) goto L16;
    L17:
        return new PolarisFileInputStreamWrapper(r3).available();
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

    public static boolean isFileEmpty(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return true;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6);
        if (r0.exists() == true) goto L8;
        return true;
    L8:
        if (r0.length() <= 0) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isGIF(File r2) {
        String r3 = r2.getName().substring(r2.getName().lastIndexOf(".") + 1);
        if ("gif".equals(r3) == false) goto L5;
    L9:
        return true;
    L5:
        if ("webp".equals(r3) == true) goto L9;
        return false;
    }

    public static boolean isVideo(File r6) {
        String r7 = r6.getName().substring(r6.getName().lastIndexOf(".") + 1);
        String[] r0 = VIDEO_TYPE;
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        if (r0[r4].equals(r7) == true) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public static String readFromFile(File r5) {
        String r1 = "";
        if (checkFileExists(r5.getPath()) == true) goto L52;
        return "";
    L52:
        PolarisFileReaderWrapper r2 = new PolarisFileReaderWrapper(r5);     // Catch: Throwable -> L25 Exception -> L27
        BufferedReader r6 = new BufferedReader(r2);     // Catch: Throwable -> L21 Exception -> L23
    L56:
        String r0 = r6.readLine();     // Catch: Exception -> L19 Throwable -> L38
        if (r0 == null) goto L59;
        r1 = r1 + r0;     // Catch: Exception -> L19 Throwable -> L38
        goto L56
    L59:
        r2.close();     // Catch: IOException -> L13
    L15:
        r6.close();     // Catch: IOException -> L17
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
        if (r6 == null) goto L37;
        r6.close();     // Catch: IOException -> L17
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
        if (r6 == null) goto L69;
        r6.close();     // Catch: IOException -> L47
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
        r6 = null;
    L21:
        th = move-exception;
        th = th;
        r6 = null;
        goto L39
    L17:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        r2 = null;
        e = e;
        r6 = null;
    L25:
        th = move-exception;
        r2 = null;
        th = th;
        r6 = null;
        goto L39
    }

    public static void removeDir(File r5) {
        if (r5.isDirectory() == false) goto L21;
        File[] r0 = r5.listFiles();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.length == 0) goto L23;
        int r1 = r0.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L16;
        File r3 = r0[r2];
        if (r3.isDirectory() == false) goto L14;
        removeDir(r3);
    L15:
        r2 = r2 + 1;
        goto L10
    L14:
        r3.delete();
        goto L15
    L16:
        r5.delete();
        return;
    L23:
        return;
    }

    public static boolean removeFile(String r2) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L19;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
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

    public static long getFileSize(String r2) {
        return getFileSize(new PolarisFileWrapper(r2));
    L4:
        return 0;
    }

    public static boolean isVideo(String r6) {
        r6.substring(r6.lastIndexOf(".") + 1);
        String[] r0 = VIDEO_TYPE;
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        if (r0[r4].equals(r6) == true) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public static boolean fileChannelCopy(FileInputStream r9, FileOutputStream r11) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        FileChannel r0 = null;
        FileChannel r8 = r9.getChannel();     // Catch: Throwable -> L22 IOException -> L24 FileNotFoundException -> L40
    L80:
        r0 = r11.getChannel();     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
        r8.transferTo(0, r8.size(), r0);     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
        r9.close();     // Catch: IOException -> L12
        r8.close();     // Catch: IOException -> L12
        r11.close();     // Catch: IOException -> L12
        if (r0 == null) goto L82;
        r0.close();     // Catch: IOException -> L12
        return true;
    L82:
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return true;
    L20:
        e = move-exception;
        FileNotFoundException r3 = e;
        FileChannel r2 = r0;
        r0 = r8;
    L42:
        r3.printStackTrace();     // Catch: Throwable -> L56
        if (r9 != null) goto L71;
    L47:
        if (r0 == null) goto L49;
        r0.close();     // Catch: IOException -> L45
    L49:
        if (r11 == null) goto L51;
        r11.close();     // Catch: IOException -> L45
    L51:
        if (r2 == null) goto L55;
        r2.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L55:
        return false;
    L71:
        r9.close();     // Catch: IOException -> L45
    L18:
        e = move-exception;
        IOException r4 = e;
        FileChannel r5 = r0;
        r0 = r8;
    L26:
        r4.printStackTrace();     // Catch: Throwable -> L56
        if (r9 != null) goto L73;
    L31:
        if (r0 == null) goto L33;
        r0.close();     // Catch: IOException -> L29
    L33:
        if (r11 == null) goto L35;
        r11.close();     // Catch: IOException -> L29
    L35:
        if (r5 == null) goto L39;
        r5.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L39:
        return false;
    L73:
        r9.close();     // Catch: IOException -> L29
    L16:
        th = th;
        FileChannel r6 = r0;
        r0 = r8;
    L57:
        if (r9 != null) goto L75;
    L61:
        if (r0 == null) goto L63;
        r0.close();     // Catch: IOException -> L59
    L63:
        if (r11 == null) goto L65;
        r11.close();     // Catch: IOException -> L59
    L65:
        if (r6 == null) goto L69;
        r6.close();     // Catch: IOException -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
    L69:
        throw th;
    L75:
        r9.close();     // Catch: IOException -> L59
    L56:
        th = th;
    L40:
        e = move-exception;
        r3 = e;
        r2 = null;
    L24:
        e = move-exception;
        r4 = e;
        r5 = null;
    L22:
        th = th;
        r6 = null;
        goto L57
    }

    public static boolean renameFile(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L10;
        return false;
    L10:
        if (r0.renameTo(r4) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static void unZipFolder(String r11, String r12) throws IOException {
        ZipInputStream r0 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r11)));
    L3:
        ZipEntry r1 = r0.getNextEntry();
        if (r1 == null) goto L23;
        String r4 = r1.getName();
        if (r4.contains("../") == true) goto L7;
        if (new PolarisFileWrapper(r12, r4).getCanonicalPath().startsWith(new PolarisFileWrapper(r12).getCanonicalPath()) == false) goto L10;
        if (r1.isDirectory() == true) goto L13;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r12 + File.separator + r4);
        if (r2.exists() == false) goto L17;
        r2.delete();
    L18:
        r2.createNewFile();
        BufferedOutputStream r3 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r2));
        byte[] r5 = new byte[2048];
    L19:
        int r6 = r0.read(r5);
        if (r6 == (-1)) goto L22;
        r3.write(r5, 0, r6);
        goto L19
    L22:
        r3.flush();
        r3.close();
        goto L3
    L17:
        r2.getParentFile().mkdirs();
        goto L18
    L13:
        new PolarisFileWrapper(r12 + File.separator + r4).mkdirs();
        goto L3
    L10:
        ALogger.e(TAG, "unZipFolder slip exception; name=" + r4 + ", outPath=" + r12 + ", zipFilePath=" + r11);
        SafetyGuard.b(new SecurityException("live unzip slip exception;"));
        goto L3
    L7:
        ALogger.e(TAG, "unZipFolder slip exception; name=" + r4 + ", outPath=" + r12 + ", zipFilePath=" + r11);
        SafetyGuard.b(new SecurityException("live unzip slip exception;"));
        goto L3
    L23:
        r0.close();
        ALogger.i(TAG, "UNZIP FINISH; zipFilePath=" + r11 + ", outPath=" + r12);
    }

    public static boolean writeFile(String r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L11:
        return true;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        PolarisFileWriterWrapper r2 = new PolarisFileWriterWrapper(r3, false);     // Catch: Exception -> L10
        r2.write(r4);     // Catch: Exception -> L10
        r2.flush();     // Catch: Exception -> L10
        r2.close();     // Catch: Exception -> L10
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0063 -> B:73:0x0066). Please report as a decompilation issue!!! */
    public static boolean writeStreamToFile(InputStream e, String r4) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);
        boolean r5 = false;
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        ?? r2 = new PolarisFileOutputStreamWrapper(r0);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L37
    L80:
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
    L6:
        r1 = e.read(r3);     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
        if (r1 <= 0) goto L9;
        r2.write(r3, 0, r1);     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
        goto L6
    L9:
        r2.flush();     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
        e.close();     // Catch: IOException -> L12
        ?? r6 = e;
    L67:
        r2.close();     // Catch: IOException -> L16
        e = r6;
    L18:
        r5 = true;
    L73:
        return r5;
    L16:
        e = move-exception;
        e.printStackTrace();
        e = e;
    L12:
        e = move-exception;
        e.printStackTrace();
        r6 = e;
        goto L67
    L23:
        e = e;
        r1 = r2;
    L38:
        e.printStackTrace();     // Catch: Throwable -> L25
        e = e;
        if (e != 0) goto L63;
    L44:
        if (r1 == 0) goto L73;
        r1.close();     // Catch: IOException -> L47
        goto L73
    L63:
        e.close();     // Catch: IOException -> L42
        e = e;
    L42:
        e = move-exception;
        e.printStackTrace();
        e = e;
    L21:
        e = e;
        r1 = r2;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L25
        e = e;
        if (e != 0) goto L69;
    L34:
        if (r1 == 0) goto L73;
        r1.close();     // Catch: IOException -> L47
        goto L73
    L69:
        e.close();     // Catch: IOException -> L32
        e = e;
    L32:
        e = move-exception;
        e.printStackTrace();
        e = e;
    L19:
        th = th;
        r1 = r2;
    L50:
        if (e != 0) goto L65;
    L55:
        if (r1 == 0) goto L83;
        r1.close();     // Catch: IOException -> L58
        throw th;
    L58:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L83:
        throw th;
    L65:
        e.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = th;
    L37:
        e = e;
    L27:
        e = e;
    L47:
        e = e;
        e.printStackTrace();
        goto L73
    }

    public static boolean fileChannelCopy(String r2, String r3) {
        if (isSdcardWritable() == true) goto L11;
        return false;
    L11:
        fileChannelCopy(new PolarisFileInputStreamWrapper(r2), new PolarisFileOutputStreamWrapper(r3));     // Catch: FileNotFoundException -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void saveImageToGallery(Context r2, String r3, String r4) {
        MediaStore.Images.Media.insertImage(r2.getContentResolver(), r3, r4, null);     // Catch: FileNotFoundException -> L4
    L6:
        r2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriProtector.parse("file://" + r3)));
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }
}
