package com.obric.cae.log;

import android.annotation.SuppressLint;
import android.os.SystemProperties;
import android.util.Log;
import com.google.protobuf.c;
import com.google.protobuf.d;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.EncryptUtil;
import defpackage.b;
import fd.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class CommSenseLog {
    private static volatile boolean ALOG_ENABLED = false;
    private static final int BUFFER_SIZE = 8192;
    public static boolean DBG = false;
    private static final int DEBUGGABLE = 0;
    private static final String DEBUGGABLE_PROPERTY = "ro.debuggable";
    private static final boolean DEBUG_DECRYPT_LOG = false;
    private static final ConcurrentHashMap<String, ReentrantReadWriteLock> FILE_LOCKS = null;
    private static final ConcurrentHashMap<String, File> FILE_MAP = null;
    private static final ConcurrentHashMap<String, Integer> FILE_SUFFIX_MAP = null;
    public static final String KEY_FILE_CELL_EVENTS = "cell_events";
    public static final String KEY_FILE_GEOFENCE = "geofence";
    public static final String KEY_FILE_HAR_STATE = "har_state";
    public static final String KEY_FILE_LOCATION = "star_location";
    public static final String KEY_FILE_NEARBY_INFO_AUDIO = "nearby_audio";
    public static final String KEY_FILE_NEARBY_INFO_BT = "nearby_bt";
    public static final String KEY_FILE_NEARBY_INFO_LOCATION = "nearby_location";
    public static final String KEY_FILE_NEARBY_INFO_WIFI = "nearby_wifi";
    public static final String KEY_FILE_POI = "poi";
    public static final String KEY_FILE_SENSOR_COLLECT = "sensor_collect";
    public static final String KEY_FILE_SENSOR_EVENTS = "sensor_events";
    public static final String KEY_FILE_SMART_BT = "smart_bt";
    public static final String KEY_FILE_USER_AWARE_EVENTS = "user_aware";
    public static final String KEY_FILE_ZPP = "zpp";
    public static final String LOG_TAG = "CommSenseLog";
    private static volatile boolean NEED_ENCRYPT;
    public static AtomicBoolean isUploading;

    static {
        int r8 = SystemProperties.getInt(DEBUGGABLE_PROPERTY, 1);
        DEBUGGABLE = r8;
        if (r8 != 1) goto L5;
        boolean r10 = true;
    L6:
        DBG = r10;
        NEED_ENCRYPT = true;
        ALOG_ENABLED = false;
        FILE_LOCKS = new ConcurrentHashMap();
        FILE_MAP = new ConcurrentHashMap();
        FILE_SUFFIX_MAP = new ConcurrentHashMap();
        isUploading = new AtomicBoolean(false);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public CommSenseLog() {
    }

    public static /* synthetic */ ReentrantReadWriteLock a(String r8) {
        return lambda$readFromFileWithBuffer$1(r8);
    }

    public static void addTimeLog(String r10, File r11) {
        if (isUploading.get() == false) goto L5;
        return;
    L5:
        long r8 = System.currentTimeMillis();
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r8);
        write2FileWithBuffer(r11, String.format(Locale.CHINA, "%tm-%td %tH:%tM:%tS.%tL", new Object[]{r12, r12, r12, r12, r12, r12}) + "  " + r10 + "\n");
    }

    public static /* synthetic */ ReentrantReadWriteLock b(String r8) {
        return lambda$write2FileWithBuffer$0(r8);
    }

    private static String buildUserScopedKey(String r8, int r10) {
        if (r10 > 0) goto L5;
        return r8;
    L5:
        return r8 + "#user_" + r10;
    }

    public static /* synthetic */ ReentrantReadWriteLock c(String r8) {
        return lambda$dumpFileContent$2(r8);
    }

    @SuppressLint({"LogTagMismatch"})
    public static String d(String r8, String r10) {
        if (NEED_ENCRYPT == false) goto L7;
        return encryptedD(r8, LOG_TAG, r10, LOG_TAG);
    L7:
        if (isLoggable(3) == false) goto L13;
        String r11 = formatMessage(r8, r10);
        Log.d(LOG_TAG, r11);
        if (ALOG_ENABLED == false) goto L14;
        a.c(LOG_TAG, r11);
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    public static void dWithMethodName(String r8, String r10) {
        d(r8, formatMethodMessage(r10));
    }

    public static String decryptCaeLog(String r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.isEmpty() == true) goto L33;
        int r10 = r8.indexOf("=CommSenseLog EN=");
        if (r10 >= 0) goto L9;
        return r8;
    L9:
        int r11 = r10 + 17;
        int r12 = r11;
    L11:
        if (r12 >= r8.length()) goto L15;
        if (isBase64Char(r8.charAt(r12)) == false) goto L15;
        r12 = r12 + 1;
    L15:
        if (r12 != r11) goto L17;
        return r8;
    L17:
        String r13 = r8.substring(r10, r12);
        String r14 = EncryptUtil.decrypt(LOG_TAG, r13, LOG_TAG, true);
        if (r14 != null) goto L20;
        return r8;
    L20:
        if (r14.isEmpty() == false) goto L22;
        return r8;
    L22:
        if (r14.equals(r13) == false) goto L25;
        return r8;
    L25:
        return r8.substring(0, r10) + r14 + r8.substring(r12);
    L33:
        return "";
    }

    public static void decryptLog() {
        NEED_ENCRYPT = false;
    }

    public static void dumpD(String r8, String r10, File r11) {
        dumpLog(r8, r10, r11, encryptedD(r8, LOG_TAG, r10, LOG_TAG));
    }

    private static void dumpEN(String r8, String r10, File r11) {
        addTimeLog(r8 + ": " + r10, r11);
    }

    public static void dumpFileContent(File r8, PrintWriter r10, Function<String, String> r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.exists() == false) goto L44;
        ReentrantReadWriteLock r12 = FILE_LOCKS.computeIfAbsent(r8.getAbsolutePath(), new d(9));
        r12.readLock().lock();
        BufferedReader r13 = new BufferedReader(Files.newBufferedReader(r8.toPath()));     // Catch: Throwable -> L25 IOException -> L27
    L38:
        String r14 = r13.readLine();     // Catch: Throwable -> L19
        if (r14 == null) goto L17;
        if (Thread.currentThread().isInterrupted() == true) goto L12;
        if (r11 == null) goto L15;
        r14 = r11.apply(r14);     // Catch: Throwable -> L19
    L15:
        r10.println(r14);     // Catch: Throwable -> L19
        goto L38
    L12:
        r10.println("dump interrupted");     // Catch: Throwable -> L19
    L17:
        r13.close();     // Catch: Throwable -> L25 IOException -> L27
    L18:
        r12.readLock().unlock();
        return;
    L19:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25 IOException -> L27
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 IOException -> L27
    L27:
        e = move-exception;
        r10.println("Error reading log file: " + e.getMessage());     // Catch: Throwable -> L25
        e(LOG_TAG, "dumpFileContent failed", e);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r12.readLock().unlock();
        throw th;
    }

    public static void dumpI(String r8, String r10, File r11) {
        dumpLog(r8, r10, r11, encryptedI(r8, LOG_TAG, r10, LOG_TAG));
    }

    private static void dumpLog(String r8, String r10, File r11, String r12) {
        if (r12 != null) goto L4;
        dumpRow(r8, r10, r11);
        return;
    L4:
        dumpEN(r8, r12, r11);
    }

    private static void dumpRow(String r8, String r10, File r11) {
        StringBuilder r12 = android.aimedia.a.k(r8, ": ");
        r12.append(encryptCaeLog(r10));
        addTimeLog(r12.toString(), r11);
    }

    public static void dumpV(String r8, String r10, File r11) {
        dumpLog(r8, r10, r11, encryptedV(r8, LOG_TAG, r10, LOG_TAG));
    }

    @SuppressLint({"LogTagMismatch"})
    public static void e(String r8, String r10) {
        if (NEED_ENCRYPT == false) goto L7;
        encryptedE(r8, LOG_TAG, r10, LOG_TAG);
        return;
    L7:
        if (isLoggable(6) == false) goto L12;
        String r11 = formatMessage(r8, r10);
        Log.e(LOG_TAG, r11);
        if (ALOG_ENABLED == false) goto L13;
        a.d(LOG_TAG, r11);
        return;
    L13:
        return;
    }

    public static void eWithMethodName(String r8, String r10) {
        e(r8, formatMethodMessage(r10));
    }

    public static void enableAlog() {
        ALOG_ENABLED = true;
    }

    public static String encryptCaeLog(String r8) {
        return EncryptUtil.encrypt(LOG_TAG, r8, LOG_TAG, true);
    }

    @SuppressLint({"LogTagMismatch"})
    public static String encryptedD(String r8, String r10, String r11, String r12) {
        if (isLoggable(3) == false) goto L8;
        String r13 = EncryptUtil.encrypt(r10, r11, r12, true);
        Log.d(LOG_TAG, formatMessage(r8, r13));
        if (ALOG_ENABLED == false) goto L7;
        a.c(LOG_TAG, formatMessage(r8, r13));
    L7:
        return r13;
    L8:
        return null;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void encryptedE(String r8, String r10, String r11, String r12) {
        if (isLoggable(6) == false) goto L8;
        String r13 = EncryptUtil.encrypt(r10, r11, r12, true);
        Log.e(LOG_TAG, formatMessage(r8, r13));
        if (ALOG_ENABLED == false) goto L9;
        a.d(LOG_TAG, formatMessage(r8, r13));
        return;
    L9:
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static String encryptedI(String r8, String r10, String r11, String r12) {
        if (isLoggable(4) == false) goto L8;
        String r13 = EncryptUtil.encrypt(r10, r11, r12, true);
        Log.i(LOG_TAG, formatMessage(r8, r13));
        if (ALOG_ENABLED == false) goto L7;
        a.f(LOG_TAG, formatMessage(r8, r13));
    L7:
        return r13;
    L8:
        return null;
    }

    @SuppressLint({"LogTagMismatch"})
    public static String encryptedV(String r8, String r10, String r11, String r12) {
        if (isLoggable(2) == false) goto L8;
        String r13 = EncryptUtil.encrypt(r10, r11, r12, true);
        Log.v(LOG_TAG, formatMessage(r8, r13));
        if (ALOG_ENABLED == false) goto L7;
        a.i(LOG_TAG, formatMessage(r8, r13));
    L7:
        return r13;
    L8:
        return null;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void encryptedW(String r8, String r10, String r11, String r12) {
        if (isLoggable(5) == false) goto L8;
        String r13 = EncryptUtil.encrypt(r10, r11, r12, true);
        Log.w(LOG_TAG, formatMessage(r8, r13));
        if (ALOG_ENABLED == false) goto L9;
        a.j(LOG_TAG, formatMessage(r8, r13));
        return;
    L9:
        return;
    }

    private static String formatMessage(String r8, String r10) {
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        return b.e("<", r8, "> ", r10);
    }

    private static String formatMethodMessage(String r8) {
        StackTraceElement[] r10 = Thread.currentThread().getStackTrace();
        if (r10.length >= 5) goto L6;
        return r8;
    L6:
        return "[" + r10[4].getMethodName() + "] " + r8;
    }

    public static String getMethodName() {
        StackTraceElement[] r8 = Thread.currentThread().getStackTrace();
        if (r8 != null) goto L7;
        return "";
    L7:
        if (r8.length >= 4) goto L11;
        StackTraceElement r10 = r8[r8.length - 1];
    L10:
        return r10.getMethodName();
    L11:
        r10 = r8[3];
        goto L10
    }

    public static File getRecordFile(String r8) {
        ConcurrentHashMap<String, File> r10 = FILE_MAP;
        if (r10.containsKey(r8) == false) goto L18;
        File r11 = r10.get(r8);
        if (r11 != null) goto L7;
    L17:
        return r11;
    L7:
        if (r11.exists() == false) goto L17;
        if (r11.isFile() == false) goto L17;
        if (CaelibUtils.isFileLargerThanMB(r11, 100) == false) goto L17;
        ConcurrentHashMap<String, Integer> r12 = FILE_SUFFIX_MAP;
        Integer r13 = r12.get(r8);
        if (r13 != null) goto L15;
        r13 = 0;
    L15:
        StringBuilder r14 = new StringBuilder();
        r14.append(r11.getAbsolutePath().replaceAll("\\.\\d{3}$", ""));
        r14.append(".");
        Locale r15 = Locale.US;
        Integer r16 = Integer.valueOf(r13.intValue() + 1);
        r14.append(String.format(r15, "%03d", new Object[]{r16}));
        File r17 = new File(r14.toString());
        r10.put(r8, r17);
        r12.put(r8, r16);
        return r17;
    L18:
        Log.d(LOG_TAG, "getRecordFile: " + r8 + ", file not found.");
        return null;
    }

    @SuppressLint({"LogTagMismatch"})
    public static String i(String r8, String r10) {
        if (NEED_ENCRYPT == false) goto L7;
        return encryptedI(r8, LOG_TAG, r10, LOG_TAG);
    L7:
        if (isLoggable(4) == false) goto L13;
        String r11 = formatMessage(r8, r10);
        Log.i(LOG_TAG, r11);
        if (ALOG_ENABLED == false) goto L14;
        a.f(LOG_TAG, r11);
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    public static void iWithMethodName(String r8, String r10) {
        i(r8, formatMethodMessage(r10));
    }

    private static boolean isBase64Char(char r8) {
        if (r8 < 'A') goto L7;
        if (r8 > 'Z') goto L7;
    L22:
        return true;
    L7:
        if (r8 < 'a') goto L11;
        if (r8 <= 'z') goto L22;
    L11:
        if (r8 < '0') goto L15;
        if (r8 <= '9') goto L22;
    L15:
        if (r8 == '+') goto L22;
        if (r8 == '/') goto L22;
        if (r8 == '=') goto L22;
        return false;
    }

    public static boolean isLoggable(int r8) {
        if (DBG == false) goto L5;
        int r10 = 3;
    L6:
        if (r10 > r8) goto L8;
        return true;
    L8:
        return false;
    L5:
        r10 = 4;
        goto L6
    }

    private static /* synthetic */ ReentrantReadWriteLock lambda$dumpFileContent$2(String r8) {
        return new ReentrantReadWriteLock();
    }

    private static /* synthetic */ ReentrantReadWriteLock lambda$readFromFileWithBuffer$1(String r8) {
        return new ReentrantReadWriteLock();
    }

    private static /* synthetic */ ReentrantReadWriteLock lambda$write2FileWithBuffer$0(String r8) {
        return new ReentrantReadWriteLock();
    }

    public static String readFromFileWithBuffer(File r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        ReentrantReadWriteLock r10 = FILE_LOCKS.computeIfAbsent(r8.getAbsolutePath(), new c(4));
        r10.readLock().lock();
        BufferedInputStream r11 = new BufferedInputStream(Files.newInputStream(r8.toPath(), new OpenOption[0]), 8192);     // Catch: Throwable -> L21 IOException -> L23
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L15
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L15
    L8:
        int r14 = r11.read(r13);     // Catch: Throwable -> L15
        if (r14 == (-1)) goto L11;
        r12.append(new String(r13, 0, r14, StandardCharsets.UTF_8));     // Catch: Throwable -> L15
        goto L8
    L11:
        String r15 = r12.toString();     // Catch: Throwable -> L15
        r11.close();     // Catch: Throwable -> L21 IOException -> L23
        r10.readLock().unlock();
        return r15;
    L15:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L21 IOException -> L23
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21 IOException -> L23
    L21:
        th = move-exception;
        r10.readLock().unlock();
        throw th;
    L23:
        e = move-exception;
        e(LOG_TAG, "readWithBuffer failed", e);     // Catch: Throwable -> L21
        r10.readLock().unlock();
        return "";
    }

    public static void recordFileWithKey(String r8, int r10, File r11) {
        recordFileWithKey(buildUserScopedKey(r8, r10), r11);
    }

    @SuppressLint({"LogTagMismatch"})
    public static String v(String r8, String r10) {
        if (NEED_ENCRYPT == false) goto L7;
        return encryptedV(r8, LOG_TAG, r10, LOG_TAG);
    L7:
        if (isLoggable(2) == false) goto L13;
        String r11 = formatMessage(r8, r10);
        Log.v(LOG_TAG, r11);
        if (ALOG_ENABLED == false) goto L14;
        a.i(LOG_TAG, r11);
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    public static void vWithMethodName(String r8, String r10) {
        v(r8, formatMethodMessage(r10));
    }

    @SuppressLint({"LogTagMismatch"})
    public static void w(String r8, String r10) {
        if (NEED_ENCRYPT == false) goto L7;
        encryptedW(r8, LOG_TAG, r10, LOG_TAG);
        return;
    L7:
        if (isLoggable(5) == false) goto L12;
        String r11 = formatMessage(r8, r10);
        Log.w(LOG_TAG, r11);
        if (ALOG_ENABLED == false) goto L13;
        a.j(LOG_TAG, r11);
        return;
    L13:
        return;
    }

    public static void wWithMethodName(String r8, String r10) {
        w(r8, formatMethodMessage(r10));
    }

    private static void write2FileWithBuffer(File r8, String r10) {
        if (r8 != null) goto L6;
        Log.d(LOG_TAG, "write2FileWithBuffer, file is null");
        return;
    L6:
        File r11 = r8.getParentFile();
        if (r11 != null) goto L9;
    L14:
        ReentrantReadWriteLock r12 = FILE_LOCKS.computeIfAbsent(r8.getAbsolutePath(), new com.obric.cae.BWDL.BwdlDrop.a(7));
        r12.writeLock().lock();
        BufferedOutputStream r13 = new BufferedOutputStream(new FileOutputStream(r8, true), 8192);     // Catch: Throwable -> L25 IOException -> L27
        r13.write(r10.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L19
        r13.close();     // Catch: Throwable -> L25 IOException -> L27
    L29:
        r12.writeLock().unlock();
        return;
    L19:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25 IOException -> L27
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 IOException -> L27
    L27:
        e = move-exception;
        e(LOG_TAG, "writeWithBuffer failed", e);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r12.writeLock().unlock();
        throw th;
    L9:
        if (r11.exists() == true) goto L14;
        if (r11.mkdirs() == true) goto L14;
        Log.e(LOG_TAG, "Failed to create parent directories: " + r11.getAbsolutePath());
    }

    @SuppressLint({"LogTagMismatch"})
    public static void e(String r8, String r10, Throwable r11) {
        if (NEED_ENCRYPT == false) goto L7;
        encryptedE(r8, LOG_TAG, r10, LOG_TAG);
        return;
    L7:
        if (isLoggable(6) == false) goto L12;
        String r12 = formatMessage(r8, r10);
        Log.e(LOG_TAG, r12, r11);
        if (ALOG_ENABLED == false) goto L13;
        a.e(LOG_TAG, r12, r11);
        return;
    L13:
        return;
    }

    public static void eWithMethodName(String r8, String r10, Throwable r11) {
        e(r8, formatMethodMessage(r10), r11);
    }

    public static File getRecordFile(String r8, int r10) {
        return getRecordFile(buildUserScopedKey(r8, r10));
    }

    public static void recordFileWithKey(String r8, File r10) {
        StringBuilder r11 = b.h("recordFileWithKey: ", r8, ", file: ");
        r11.append(r10.getAbsolutePath());
        Log.d(LOG_TAG, r11.toString());
        ConcurrentHashMap<String, File> r12 = FILE_MAP;
        if (r12.putIfAbsent(r8, r10) != null) goto L6;
        r12.put(r8, r10);
        FILE_SUFFIX_MAP.put(r8, 0);
        return;
    }
}
