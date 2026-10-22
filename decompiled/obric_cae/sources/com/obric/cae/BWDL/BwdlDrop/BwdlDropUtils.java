package com.obric.cae.BWDL.BwdlDrop;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropUtils {
    public static final long DROP_SHOW_GIGABYTES = 1000000000;
    public static final long DROP_SHOW_KBYTES = 1000;
    public static final long DROP_SHOW_MEGABYTES = 1000000;
    private static final int MAXIMUM_NUMBER = 100;
    private static final long MAXIMUM_SIZE = 53687091200L;
    private static final long SECURE_BLOCK_SIZE = 10;
    private static final long SECURE_SIZE = 1073741824;
    private static final String TAG = "BwdlDropUtils";

    public static final enum RequestResultCode extends Enum<RequestResultCode> {
        private static final /* synthetic */ RequestResultCode[] $VALUES = null;
        public static final RequestResultCode NumberOverflow = null;
        public static final RequestResultCode Permit = null;
        public static final RequestResultCode SizeOverflow = null;

        private static /* synthetic */ RequestResultCode[] $values() {
            return new RequestResultCode[]{Permit, NumberOverflow, SizeOverflow};
        }

        static {
            Permit = new RequestResultCode("Permit", 0);
            NumberOverflow = new RequestResultCode("NumberOverflow", 1);
            SizeOverflow = new RequestResultCode("SizeOverflow", 2);
            $VALUES = $values();
        }

        private RequestResultCode(String r8, int r10) {
            super(r8, r10);
        }

        public static RequestResultCode valueOf(String r8) {
            return (RequestResultCode) Enum.valueOf(RequestResultCode.class, r8);
        }

        public static RequestResultCode[] values() {
            return (RequestResultCode[]) $VALUES.clone();
        }
    }

    public BwdlDropUtils() {
    }

    public static Uri ObtainFileUri(Context r8, String r10, String r11) {
        ContentResolver r12 = r8.getContentResolver();
        if (Environment.getExternalStorageState().equals("mounted") == true) goto L6;
        CaeLog.e(TAG, "Receive File aborted - no external storage");
        return null;
    L6:
        String r13 = Environment.DIRECTORY_DOWNLOADS;
        ContentValues r14 = new ContentValues();
        r14.put("_display_name", r10);
        r14.put("mime_type", r11);
        r14.put("relative_path", r13);
        if (r11.startsWith("image/") == false) goto L11;
        Uri r15 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L14:
        return r12.insert(r15, r14);
    L11:
        if (r11.startsWith("video/") == false) goto L13;
        r15 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L14
    L13:
        r15 = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        goto L14
    }

    public static boolean checkAllUrisCallerPermission(Context r8, ClipData r10, int r11, int r12) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r13 = 0;
    L7:
        if (r13 >= r10.getItemCount()) goto L15;
        Uri r14 = r10.getItemAt(r13).getUri();
        if (r14 == null) goto L14;
        if (checkCallerUriReadPermission(r8, r14, r11, r12) == true) goto L14;
        CaeLog.w(TAG, "Caller does not have permission for URI: " + r14);
        return false;
    L14:
        r13 = r13 + 1;
        goto L7
    L15:
        return true;
    }

    public static boolean checkCallerUriReadPermission(Context r8, Uri r10, int r11, int r12) {
        if (r8.checkUriPermission(r10, r11, r12, 1) == 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        e = move-exception;
        CaeLog.e(TAG, "Error checking caller URI permission for: " + r10, e);
        return false;
    }

    public static boolean checkExternalStorageAvailability(long r8) {
        CaeLog.e(TAG, "checkExternalStorageAvailability size：" + r8);
        if (r8 >= 0) goto L6;
        return false;
    L6:
        if (getExternalStorageByte() < (r8 + SECURE_SIZE)) goto L9;
        return true;
    L9:
        return false;
    }

    @SuppressLint({"DefaultLocale"})
    public static String formatSizeToString(long r8) {
        if (r8 >= 1000) goto L7;
        return r8 + " Bytes";
    L7:
        if (r8 < DROP_SHOW_MEGABYTES) goto L9;
        float r10 = r8;
        if (r8 >= DROP_SHOW_GIGABYTES) goto L15;
        return String.format("%.2f MB", new Object[]{Float.valueOf(r10 / 1000000.0f)});
    L15:
        return String.format("%.2f GB", new Object[]{Float.valueOf(r10 / 1.0E9f)});
    L9:
        return String.format("%.2f KB", new Object[]{Float.valueOf(r8 / 1000.0f)});
    }

    public static String getDeviceName(Context r8) {
        return Settings.Global.getString(r8.getContentResolver(), "device_name");
    }

    public static long getExternalStorageByte() {
        long r8 = -1;
        StatFs r10 = new StatFs(Environment.getExternalStorageDirectory().getPath());     // Catch: Exception -> L7
        long r11 = r10.getBlockSizeLong();
        long r12 = r10.getAvailableBlocksLong();
        if (r12 <= SECURE_BLOCK_SIZE) goto L10;
        r8 = (r12 - SECURE_BLOCK_SIZE) * r11;
        CaeLog.e(TAG, "get external storage blockSize：" + r11);
        String r13 = "get external storage availableBlocks：" + r12;
    L9:
        CaeLog.e(TAG, r13);
    L10:
        return r8;
    L7:
        e = move-exception;
        r13 = "get External Storage error：" + e.getMessage();
        goto L9
    }

    public static String getFileName(Uri r8, Context r10) {
        if (r8.getScheme().equals("content") == false) goto L25;
        String r11 = null;
        Cursor r12 = r10.getContentResolver().query(r8, null, null, null, null);     // Catch: Exception -> L22
        if (r12 != null) goto L34;
    L19:
        if (r12 == null) goto L28;
        r12.close();     // Catch: Exception -> L22
    L28:
        if (r11 != null) goto L32;
        r11 = r8.getPath();
        int r13 = r11.lastIndexOf(47);
        if (r13 == (-1)) goto L32;
        r11 = r11.substring(r13 + 1);
    L32:
        b.o("FileName:", r11, TAG);
        return r11;
    L34:
    L13:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Exception -> L22
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
        goto L18
    L8:
        if (r12.moveToFirst() == false) goto L19;
        int r14 = r12.getColumnIndex("_display_name");     // Catch: Throwable -> L13
        if (r14 == (-1)) goto L19;
        r11 = r12.getString(r14);     // Catch: Throwable -> L13
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L25:
        if (r8.getScheme().equals(BwdlDropConstant.FILE) == false) goto L27;
        r11 = new File(r8.getPath()).getName();
        goto L28
    L27:
        r11 = r8.getLastPathSegment();
        goto L28
    }

    public static long getFileSize(Uri r10, Context r11) {
        long r8 = 0;
        if (r10.getScheme().equals("content") == false) goto L10;
        Cursor r12 = r11.getContentResolver().query(r10, new String[]{"_size"}, null, null, null);
        if (r12 != null) goto L7;
    L12:
        CaeLog.d(TAG, "FileSize:" + r8);
        return r8;
    L7:
        if (r12.moveToFirst() == false) goto L12;
        long r13 = r12.getLong(r12.getColumnIndex("_size"));
        r12.close();
        r8 = r13;
        goto L12
    L10:
        if (r10.getScheme().equals(BwdlDropConstant.FILE) == false) goto L12;
        r8 = new File(r10.getPath()).length();
        goto L12
    }

    public static String getPackageNameByPid(int r8, Context r10) {
        Iterator<ActivityManager.RunningAppProcessInfo> r11 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ActivityManager.RunningAppProcessInfo r12 = r11.next();
        if (r12.pid != r8) goto L4;
        return r12.processName;
    L9:
        return null;
    }

    public static void getPackageNameByUid(int r10, Context r11) {
        PackageManager r12 = r11.getPackageManager();
        String[] r8 = r12.getPackagesForUid(r10);
        if (r8 == null) goto L9;
        int r13 = r8.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L15;
        String r15 = r8[r14];
        CaeLog.d(TAG, "uid=" + r10 + " pkg=" + r15 + " label=" + r12.getApplicationLabel(r12.getApplicationInfo(r15, 0)));     // Catch: PackageManager.NameNotFoundException -> L10
    L8:
        r14 = r14 + 1;
        goto L5
    L15:
        return;
    }

    public static void grantPermissionToUri(Context r8, ClipData r10) {
        if (r10 != null) goto L20;
        CaeLog.i(TAG, "ClipData is null ");
        return;
    L20:
        String r11 = r8.getPackageName();     // Catch: Exception -> L17
        int r12 = 0;
    L8:
        if (r12 >= r10.getItemCount()) goto L27;
        Uri r13 = r10.getItemAt(r12).getUri();     // Catch: Exception -> L17
        if (r13 == null) goto L16;
        String r14 = r13.getScheme();     // Catch: Exception -> L17
        if (r14 == null) goto L16;
        if (r14.equals("content") == false) goto L16;
        r8.grantUriPermission(r11, r13, 1);     // Catch: Exception -> L17
    L16:
        r12 = r12 + 1;
        goto L8
    L27:
        return;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "GrantUriPermission :" + e.toString());
    }

    public static RequestResultCode isTransmissionIllegal(int r8, long r10) {
        if (r8 <= 100) goto L7;
        return RequestResultCode.NumberOverflow;
    L7:
        if (r10 <= MAXIMUM_SIZE) goto L11;
        return RequestResultCode.SizeOverflow;
    L11:
        return RequestResultCode.Permit;
    }

    public static String obtainReceiveDirectoryPath(String r8) {
        Path r10 = Paths.get(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(), new String[0]);     // Catch: IOException -> L13
        Path r11 = r10.resolve(r8);     // Catch: IOException -> L13
        int r12 = 1;
    L5:
        if (Files.exists(r11, new LinkOption[0]) == false) goto L11;
        int r13 = r8.lastIndexOf(46);     // Catch: IOException -> L13
        if (r13 == (-1)) goto L9;
        String r14 = r8.substring(0, r13);     // Catch: IOException -> L13
        String r15 = r8.substring(r13);     // Catch: IOException -> L13
    L10:
        r11 = r10.resolve(r14 + "_" + r12 + r15);     // Catch: IOException -> L13
        r12 = r12 + 1;     // Catch: IOException -> L13
        goto L5
    L9:
        r15 = "";
        r14 = r8;
        goto L10
    L11:
        Files.createDirectories(r11.getParent(), new FileAttribute[0]);     // Catch: IOException -> L13
        CaeLog.d(TAG, "obtainReceiveDirectoryPath:" + r11.getParent().toString());     // Catch: IOException -> L13
        return r11.getParent().toString();
    L13:
        e = move-exception;
        CaeLog.e(TAG, "IOException:" + e.getMessage());
        return null;
    }

    public static boolean shouldClipToCircle(Context r8) {
        String r10 = Settings.System.getString(r8.getApplicationContext().getContentResolver(), "obric_theme_path");
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        CaeLog.d(TAG, "shouldClipToCircle: obricThemePath = " + r10);
        return r10.contains("RoundTheme.ot");
    }
}
