package com.obric.cae.cldReport;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import androidx.activity.d;
import com.obric.cae.log.CaeLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CldUtil {
    public static final String BUGREPORTOUTPUTEND = "/data/syslog/logsdk/bugreportoutputend";
    private static final String BUGREPORT_ABSOLUTE_PATH = "/data/syslog/logsdk";
    private static final int BUGREPORT_DELETE_END_FILE_RETRY_TIME = 10;
    private static final int BUGREPORT_DELETE_END_FILE_WAITING_MILLISECOND = 3000;
    private static final String BUGREPORT_PREFIX = "bugreport-";
    private static final int CAP_BUGREPORT = 16;
    private static final String TAG = "CldUtil";

    public CldUtil() {
    }

    public static /* synthetic */ void a(String r8) {
        lambda$startAndMoveBugreport$0(r8);
    }

    public static long calculateDirectorySize(File r8) {
        long r10 = 0;
        if (r8 != null) goto L5;
    L23:
        return r10;
    L5:
        if (r8.exists() == false) goto L23;
        if (r8.isDirectory() == false) goto L23;
        ArrayDeque r11 = new ArrayDeque();
        r11.push(r8);
    L11:
        if (r11.isEmpty() == true) goto L23;
        File[] r12 = ((File) r11.pop()).listFiles();
        if (r12 == null) goto L11;
        int r13 = r12.length;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L11;
        File r15 = r12[r14];
        if (r15.isDirectory() == false) goto L20;
        r11.push(r15);
    L22:
        r14 = r14 + 1;
        goto L15
    L20:
        if (r15.isFile() == false) goto L22;
        r10 = r15.length() + r10;
        goto L22
    }

    public static boolean copyDirectory(File r8, File r10) {
        if (r8.exists() == true) goto L9;
        StringBuilder r11 = new StringBuilder("source directory is not exist: ");
    L5:
        r11.append(r8.getAbsolutePath());
        String r12 = r11.toString();
    L6:
        CaeLog.e(TAG, r12);
        return false;
    L9:
        if (r8.isDirectory() == true) goto L12;
        r11 = new StringBuilder("source directory is not a directory: ");
        goto L5
    L12:
        if (r10.exists() == false) goto L14;
    L16:
        File[] r13 = r8.listFiles();
        if (r13 != null) goto L19;
        return true;
    L19:
        int r14 = r13.length;
        int r15 = 0;
    L20:
        if (r15 >= r14) goto L30;
        File r16 = r13[r15];
        if (r16.isDirectory() == false) goto L27;
        if (copyDirectory(r16, new File(r10, r16.getName())) == true) goto L29;
        return false;
    L29:
        r15 = r15 + 1;
        goto L20
    L27:
        if (copyFile(r16, new File(r10, r16.getName())) == true) goto L29;
        return false;
    L30:
        return true;
    L14:
        if (r10.mkdirs() == true) goto L16;
        r12 = "dest directory is not exist: " + r10.getAbsolutePath();
        goto L6
    }

    public static boolean copyFile(File r8, File r10) {
        FileInputStream r11 = new FileInputStream(r8);     // Catch: IOException -> L27
        FileOutputStream r12 = new FileOutputStream(r10);     // Catch: Throwable -> L21
        byte[] r13 = new byte[4096];     // Catch: Throwable -> L15
    L7:
        int r14 = r11.read(r13);     // Catch: Throwable -> L15
        if (r14 == (-1)) goto L11;
        r12.write(r13, 0, r14);     // Catch: Throwable -> L15
    L11:
        r12.close();     // Catch: Throwable -> L21
        r11.close();     // Catch: IOException -> L27
        return true;
    L15:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IOException -> L27
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L27
    L27:
        e = move-exception;
        CaeLog.e(TAG, "copy fail: " + r8.getAbsolutePath() + " -> " + r10.getAbsolutePath(), e);
        return false;
    }

    public static boolean copyFile2Directory(String r8, String r10) {
        if (r8 == null) goto L32;
        if (r10 == null) goto L32;
        File r11 = new File(r8);
        if (r11.exists() == true) goto L9;
    L30:
        CaeLog.e(TAG, "copyFile _srcFile doesn't exist || isDirectory");
        return false;
    L9:
        if (r11.isDirectory() == true) goto L30;
        File r12 = new File(r10);
        if (r12.exists() == false) goto L17;
        if (r12.isFile() == false) goto L17;
        r12.delete();
    L17:
        if (r12.exists() == true) goto L20;
        r12.mkdirs();
    L20:
        if (r12.exists() == true) goto L22;
    L34:
        Files.copy(r11.toPath(), r12.toPath(), new CopyOption[0]);     // Catch: Exception -> L27
        return true;
    L27:
        e = move-exception;
        CaeLog.e(TAG, "moveFile error : " + e.getMessage());
        e.printStackTrace();
        return false;
    L22:
        if (r12.isDirectory() == false) goto L34;
        StringBuilder r13 = android.aimedia.a.j(r10);
        r13.append(File.separator);
        r13.append(r11.getName());
        r12 = new File(r13.toString());
    L32:
        CaeLog.e(TAG, "copyFile srcFile is null or dstFile is null");
        return false;
    }

    public static String createFolder(String r8) {
        File r10 = new File(r8);
        if (r10.exists() == false) goto L10;
        if (r10.isDirectory() == false) goto L7;
        CaeLog.i(TAG, "createFolder: Directory already exists, path=" + r8);
    L8:
        return r8;
    L7:
        CaeLog.e(TAG, "createFolder failed: Path exists but is a file, path=" + r8);
        goto L8
    L10:
        if (r10.mkdirs() == true) goto L21;
        File r11 = r10.getParentFile();
        if (r11 == null) goto L17;
        if (r11.exists() == true) goto L17;
        StringBuilder r12 = new StringBuilder("createFolder failed: Parent directory does not exist, path=");
    L20:
        r12.append(r8);
        CaeLog.e(TAG, r12.toString());
    L17:
        if (r10.getParentFile().canWrite() == true) goto L19;
        r12 = new StringBuilder("createFolder failed: No write permission on parent directory, path=");
        goto L20
    L19:
        r12 = new StringBuilder("createFolder failed: Unknown reason, path=");
    L21:
        return r8;
    }

    public static boolean deleteDirectory(File r11) {
        if (r11 != null) goto L5;
    L41:
        return true;
    L5:
        if (r11.exists() == false) goto L41;
        if (r11.isDirectory() == true) goto L11;
        CaeLog.w(TAG, "Not a directory: " + r11.getAbsolutePath());
        return false;
    L11:
        ArrayDeque r8 = new ArrayDeque();
        r8.push(r11);
        boolean r12 = true;
    L42:
        if (r8.isEmpty() == true) goto L32;
        File r10 = (File) r8.peek();     // Catch: Throwable -> L33 Exception -> L35
        File[] r13 = r10.listFiles();     // Catch: Throwable -> L33 Exception -> L35
        if (r13 == null) goto L16;
        int r14 = r13.length;     // Catch: Throwable -> L33 Exception -> L35
        boolean r15 = true;
        int r16 = 0;
    L18:
        if (r16 >= r14) goto L26;
        File r17 = r13[r16];     // Catch: Throwable -> L33 Exception -> L35
        if (r17.isDirectory() == false) goto L23;
        r8.push(r17);     // Catch: Throwable -> L33 Exception -> L35
        r15 = false;
    L25:
        r16 = r16 + 1;     // Catch: Throwable -> L33 Exception -> L35
        goto L18
    L23:
        if (r17.delete() == true) goto L25;
        CaeLog.w(TAG, "Failed to delete file: " + r17.getAbsolutePath());     // Catch: Throwable -> L33 Exception -> L35
        r12 = false;
        goto L25
    L26:
        if (r15 == false) goto L42;
        if (r10.delete() == true) goto L30;
        CaeLog.w(TAG, "Failed to delete directory: " + r10.getAbsolutePath());     // Catch: Throwable -> L33 Exception -> L35
        r12 = false;
    L30:
        r8.pop();     // Catch: Throwable -> L33 Exception -> L35
        goto L42
    L16:
        CaeLog.w(TAG, "Failed to list files in directory: " + r10.getAbsolutePath());     // Catch: Throwable -> L33 Exception -> L35
        r8.pop();     // Catch: Throwable -> L33 Exception -> L35
        r12 = false;
        goto L42
    L32:
        r8.clear();
        return r12;
    L33:
        th = move-exception;
        r8.clear();
        throw th;
    L35:
        e = move-exception;
        CaeLog.e(TAG, "Error deleting directory", e);     // Catch: Throwable -> L33
        r8.clear();
        return false;
    }

    public static void dumpsys(String r8, String... r10) {
        execCommand(r8, "dumpsys", r10);
    }

    private static void execCommand(String r8, String r10, String... r11) {
        String[] r12 = new String[r11.length + 1];
        r12[0] = r10;
        System.arraycopy(r11, 0, r12, 1, r11.length);
        InputStream r13 = null;
        OutputStream r14 = null;
        r14 = null;
        r13 = null;
        InputStream r15 = Runtime.getRuntime().exec(r12).getInputStream();     // Catch: Throwable -> L21 IOException -> L23
    L66:
        r14 = Files.newOutputStream(new File(r8).toPath(), new OpenOption[0]);     // Catch: Throwable -> L17 IOException -> L19
        byte[] r16 = new byte[1024];     // Catch: Throwable -> L17 IOException -> L19
    L5:
        int r17 = r15.read(r16);     // Catch: Throwable -> L17 IOException -> L19
        if (r17 == (-1)) goto L8;
        r14.write(r16, 0, r17);     // Catch: Throwable -> L17 IOException -> L19
        goto L5
    L8:
        r14.flush();     // Catch: Throwable -> L17 IOException -> L19
        r15.close();     // Catch: IOException -> L11
    L54:
        r14.close();     // Catch: IOException -> L15
        return;
    L15:
        e = e;
        StringBuilder r18 = new StringBuilder("execCommand error! e=");
    L36:
        r18.append(e);
        CaeLog.e(TAG, r18.toString());
        return;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "execCommand error! e=" + e);
        goto L54
    L19:
        e = e;
        OutputStream r19 = r14;
        r13 = r15;
    L62:
        CaeLog.e(TAG, "execCommand error! e=" + e);     // Catch: Throwable -> L38
        if (r13 != null) goto L56;
    L31:
        if (r19 == null) goto L69;
        r19.close();     // Catch: IOException -> L34
        return;
    L34:
        e = e;
        r18 = new StringBuilder("execCommand error! e=");
        goto L36
    L69:
        return;
    L56:
        r13.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        CaeLog.e(TAG, "execCommand error! e=" + e);
    L38:
        th = th;
    L39:
        if (r13 != null) goto L58;
    L44:
        if (r19 == null) goto L72;
        r19.close();     // Catch: IOException -> L47
        throw th;
    L47:
        e = move-exception;
        CaeLog.e(TAG, "execCommand error! e=" + e);
        throw th;
    L72:
        throw th;
    L58:
        r13.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        CaeLog.e(TAG, "execCommand error! e=" + e);
    L17:
        th = th;
        r19 = r14;
        r13 = r15;
    L23:
        e = e;
        r19 = null;
    L21:
        th = th;
        r19 = null;
        goto L39
    }

    public static String getCurrentTimeFormatted() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String getProperty(String r8, String r10) {
        return SystemProperties.get(r8, r10);
    }

    private static /* synthetic */ void lambda$startAndMoveBugreport$0(String r8) {
        if (r8 != null) goto L5;
    L35:
        String r10 = "startAndMoveBugreport - targetPath is null or empty!";
    L10:
        CaeLog.e(TAG, r10);
        return;
    L5:
        if (r8.isEmpty() == true) goto L35;
        if (startBugreport() == true) goto L12;
        r10 = "startAndMoveBugreport - startBugreport failed!";
        goto L10
    L12:
        File r11 = new File(BUGREPORT_ABSOLUTE_PATH);
        if (r11.exists() == true) goto L15;
        r10 = "startAndMoveBugreport - bugreportDir not exists!";
        goto L10
    L15:
        File[] r12 = r11.listFiles();
        if (r12 != null) goto L18;
    L34:
        r10 = "startAndMoveBugreport - bugreportDir is empty!";
        goto L10
    L18:
        if (r12.length == 0) goto L34;
        int r13 = r12.length;
        int r14 = 0;
    L21:
        if (r14 >= r13) goto L33;
        File r15 = r12[r14];
        if (r15.exists() == false) goto L32;
        if (r15.isFile() == false) goto L32;
        if (r15.getName().startsWith(BUGREPORT_PREFIX) == false) goto L32;
        if (copyFile2Directory(r15.getAbsolutePath(), r8) == false) goto L30;
        r15.delete();
        CaeLog.i(TAG, "startAndMoveBugreport - move " + r15.getName() + " successfully!");
        goto L32
    L30:
        r10 = "startAndMoveBugreport - copy bugreport failed!";
    L32:
        r14 = r14 + 1;
        goto L21
    }

    public static void setProperty(String r8, String r10) {
        SystemProperties.set(r8, r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        StringBuilder r11 = defpackage.b.i("setProperty key:", r8, " value:", r10, " error! e=");
        r11.append(e);
        CaeLog.e(TAG, r11.toString());
    }

    public static void startAndMoveBugreport(String r8) {
        new Thread(new d(r8, 17), "StartBugreportThread").start();
    }

    private static boolean startBugreport() {
        CaeLog.i(TAG, "bugreport starts...");
        Parcel r8 = Parcel.obtain();
        IBinder r10 = ServiceManager.getService("sysoptserver");
        if (r10 != null) goto L50;
        CaeLog.e(TAG, "bugreport: fail to get Service : sysoptserver");
        return false;
    L50:
        boolean r11 = r10.transact(16, r8, null, 1);     // Catch: Throwable -> L38 RemoteException -> L40
        CaeLog.d(TAG, "bugreport transact res: " + r11);     // Catch: Throwable -> L38 RemoteException -> L40
        if (r11 == true) goto L12;
        CaeLog.e(TAG, "bugreport transact error");     // Catch: Throwable -> L38 RemoteException -> L40
        r8.recycle();
        return false;
    L12:
        r8.recycle();
        long r12 = System.currentTimeMillis();
        File r13 = new File(BUGREPORTOUTPUTEND);
    L46:
        Thread.sleep(1000);     // Catch: InterruptedException -> L16
    L19:
        if (r13.exists() == true) goto L20;
        if ((System.currentTimeMillis() - r12) <= 300000) goto L46;
        CaeLog.e(TAG, "bugreport:  produce file over 5min");
    L37:
        return false;
    L20:
        int r14 = 0;
    L22:
        if (r14 >= 10) goto L33;
        Thread.sleep(3000);     // Catch: Exception -> L30
        if (r13.delete() == false) goto L28;
        CaeLog.i(TAG, "bugreport delete end file success");     // Catch: Exception -> L30
        return true;
    L28:
        CaeLog.e(TAG, "bugreport delete end file error, retry times: " + r14);     // Catch: Exception -> L30
    L32:
        r14 = r14 + 1;
    L30:
        e = move-exception;
        CaeLog.e(TAG, "bugreport delete end file error, retry times: " + r14, e);
        goto L32
    L33:
        CaeLog.d(TAG, "bugreport zip file finished");
    L16:
        e = move-exception;
        CaeLog.e(TAG, "bugreport sleep error: " + e.getMessage());
    L38:
        th = move-exception;
        r8.recycle();
        throw th;
    L40:
        e = move-exception;
        CaeLog.e(TAG, "bugreport transact error: " + e.getMessage());     // Catch: Throwable -> L38
        r8.recycle();
        return false;
    }

    public static long stringToTimeMillis(String r8) {
        if (r8 != null) goto L12;
        return -1;
    L12:
        Date r10 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(r8);     // Catch: ParseException -> L9
        if (r10 == null) goto L14;
        return r10.getTime();
    L14:
        return -1;
    L9:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static String timeMillisToDateString(long r8) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(r8));
    L4:
        e = move-exception;
        Log.e(TAG, "fail: e=" + e);
        return "";
    }
}
