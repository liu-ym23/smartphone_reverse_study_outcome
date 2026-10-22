package com.obric.cae.log;

import android.annotation.SuppressLint;
import android.os.SystemProperties;
import com.google.protobuf.c;
import com.google.protobuf.d;
import com.obric.cae.BWDL.BwdlDrop.a;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.EncryptUtil;
import com.obric.cae.utils.ALogUtil;
import defpackage.b;
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
public class CaeLog {
    private static final int BUFFER_SIZE = 8192;
    public static boolean DBG = false;
    private static final int DEBUGGABLE = 0;
    private static final String DEBUGGABLE_PROPERTY = "ro.debuggable";
    private static final ConcurrentHashMap<String, ReentrantReadWriteLock> FILE_LOCKS = null;
    private static final ConcurrentHashMap<String, File> FILE_MAP = null;
    private static final ConcurrentHashMap<String, Integer> FILE_SUFFIX_MAP = null;
    public static final String KEY_FILE_CELL_EVENTS = "cell_events";
    public static final String KEY_FILE_GEOFENCE = "geofence";
    public static final String KEY_FILE_HAR_STATE = "har_state";
    public static final String KEY_FILE_NEARBY_INFO_AUDIO = "nearby_audio";
    public static final String KEY_FILE_NEARBY_INFO_BT = "nearby_bt";
    public static final String KEY_FILE_NEARBY_INFO_LOCATION = "nearby_location";
    public static final String KEY_FILE_NEARBY_INFO_WIFI = "nearby_wifi";
    public static final String KEY_FILE_SENSOR_COLLECT = "sensor_collect";
    public static final String KEY_FILE_SENSOR_EVENTS = "sensor_events";
    public static final String KEY_FILE_SMART_BT = "smart_bt";
    public static final String KEY_FILE_USER_AWARE_EVENTS = "user_aware";
    public static final String KEY_FILE_ZPP = "zpp";
    public static final String LOG_TAG = "CaeLog";
    public static AtomicBoolean isUploading;

    static {
        boolean r8 = true;
        int r10 = SystemProperties.getInt(DEBUGGABLE_PROPERTY, 1);
        DEBUGGABLE = r10;
        if (r10 == 1) goto L6;
        r8 = false;
    L6:
        DBG = r8;
        FILE_LOCKS = new ConcurrentHashMap();
        FILE_MAP = new ConcurrentHashMap();
        FILE_SUFFIX_MAP = new ConcurrentHashMap();
        isUploading = new AtomicBoolean(false);
    }

    public CaeLog() {
    }

    public static /* synthetic */ ReentrantReadWriteLock a(String r8) {
        return lambda$dumpFileContent$2(r8);
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

    public static /* synthetic */ ReentrantReadWriteLock c(String r8) {
        return lambda$readFromFileWithBuffer$1(r8);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String r8, String r10) {
        if (isLoggable(3) == false) goto L6;
        ALogUtil.d(LOG_TAG, formatMessage(r8, r10));
        return;
    }

    public static void dumpD(String r8, String r10, File r11) {
        addTimeLog(r8 + ": " + r10, r11);
        d(r8, r10);
    }

    public static void dumpFileContent(File r8, PrintWriter r10, Function<String, String> r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.exists() == false) goto L40;
        ReentrantReadWriteLock r12 = FILE_LOCKS.computeIfAbsent(r8.getAbsolutePath(), new a(6));
        r12.readLock().lock();
        BufferedReader r13 = new BufferedReader(Files.newBufferedReader(r8.toPath()));     // Catch: Throwable -> L22 IOException -> L24
    L35:
        String r14 = r13.readLine();     // Catch: Throwable -> L16
        if (r14 == null) goto L14;
        if (r11 == null) goto L12;
        r14 = r11.apply(r14);     // Catch: Throwable -> L16
    L12:
        r10.println(r14);     // Catch: Throwable -> L16
        goto L35
    L14:
        r13.close();     // Catch: Throwable -> L22 IOException -> L24
    L15:
        r12.readLock().unlock();
        return;
    L16:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Throwable -> L22 IOException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22 IOException -> L24
    L24:
        e = move-exception;
        r10.println("Error reading log file: " + e.getMessage());     // Catch: Throwable -> L22
        e(LOG_TAG, "dumpFileContent failed", e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r12.readLock().unlock();
        throw th;
    }

    public static void dumpI(String r8, String r10, File r11) {
        addTimeLog(r8 + ": " + r10, r11);
        i(r8, r10);
    }

    public static void dumpIEn(String r8, String r10, File r11) {
        addTimeLog(r8 + ": " + r10, r11);
        i(r8, EncryptUtil.encrypt(LOG_TAG, r10, LOG_TAG, true));
    }

    public static void e(String r8, String r10) {
        ALogUtil.e(LOG_TAG, formatMessage(r8, r10));
    }

    public static String encryptCaeLog(String r8) {
        return EncryptUtil.encrypt(LOG_TAG, r8, LOG_TAG, true);
    }

    public static void encryptedD(String r8, String r10, String r11, String r12) {
        if (isLoggable(3) == false) goto L6;
        ALogUtil.d(LOG_TAG, formatMessage(r8, EncryptUtil.encrypt(r10, r11, r12, true)));
        return;
    }

    public static void encryptedI(String r8, String r10, String r11) {
        if (isLoggable(4) == false) goto L6;
        ALogUtil.i(LOG_TAG, formatMessage(r8, EncryptUtil.encrypt(r8, r10, r11, true)));
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
        d(LOG_TAG, "getRecordFile: " + r8 + ", file not found.");
        return null;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String r8, String r10) {
        if (isLoggable(4) == false) goto L6;
        ALogUtil.i(LOG_TAG, formatMessage(r8, r10));
        return;
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
        ReentrantReadWriteLock r10 = FILE_LOCKS.computeIfAbsent(r8.getAbsolutePath(), new c(3));
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

    public static void recordFileWithKey(String r8, File r10) {
        StringBuilder r11 = b.h("recordFileWithKey: ", r8, ", file: ");
        r11.append(r10.getAbsolutePath());
        d(LOG_TAG, r11.toString());
        ConcurrentHashMap<String, File> r12 = FILE_MAP;
        if (r12.putIfAbsent(r8, r10) != null) goto L6;
        r12.put(r8, r10);
        FILE_SUFFIX_MAP.put(r8, 0);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void v(String r8, String r10) {
        if (isLoggable(2) == false) goto L6;
        ALogUtil.v(LOG_TAG, formatMessage(r8, r10));
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void w(String r8, String r10) {
        if (isLoggable(5) == false) goto L6;
        ALogUtil.w(LOG_TAG, formatMessage(r8, r10));
        return;
    }

    private static void write2FileWithBuffer(File r8, String r10) {
        if (r8 != null) goto L6;
        d(LOG_TAG, "write2FileWithBuffer, file is null");
        return;
    L6:
        File r11 = r8.getParentFile();
        if (r11 != null) goto L9;
    L14:
        ReentrantReadWriteLock r12 = FILE_LOCKS.computeIfAbsent(r8.getAbsolutePath(), new d(8));
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
    L25:
        th = move-exception;
        r12.writeLock().unlock();
        throw th;
    L27:
        e = move-exception;
        e(LOG_TAG, "writeWithBuffer failed", e);     // Catch: Throwable -> L25
        goto L29
    L9:
        if (r11.exists() == true) goto L14;
        if (r11.mkdirs() == true) goto L14;
        e(LOG_TAG, "Failed to create parent directories: " + r11.getAbsolutePath());
    }

    public static void e(String r8, String r10, Throwable r11) {
        ALogUtil.e(LOG_TAG, formatMessage(r8, r10), r11);
    }
}
