package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class CpuUtils {
    private static final FileFilter CPU_FILTER = null;
    private static String TAG = "CpuUtils";
    private static int sCpuCores = 0;
    private static final Object sCpuCoresLock = null;
    private static String sCpuDirectory = "/sys/devices/system/cpu/";
    private static String sCpuInfoPath = "/proc/cpuinfo";
    private static String sCpuModelTitle = "Hardware";
    private static String sCpuPossiblePath = "/sys/devices/system/cpu/possible";
    private static String sCpuPresentPath = "/sys/devices/system/cpu/present";
    private static String sCpuVendorTag = "vendor";
    private static boolean sInitialized = false;
    private static String sModel = "unknown";
    private static final Object sModelLock = null;

    static {
        sModelLock = new Object();
        sCpuCoresLock = new Object();
        CPU_FILTER = $$Lambda$CpuUtils$Qi84Q_9Yg5ccA20OkfRTNjbbCKk.INSTANCE;
    }

    public CpuUtils() {
    }

    private static boolean fetchCPUCores() {
        if (fetchCoresFromFile(sCpuPossiblePath) == false) goto L5;
        return true;
    L5:
        if (fetchCoresFromFile(sCpuPresentPath) == false) goto L7;
        return true;
    L7:
        if (fetchCoresFromFileList() == true) goto L14;
        return false;
    L14:
        return true;
    }

    private static boolean fetchCPUModel() {
        String r0 = null;
        FileReader r1 = new FileReader(sCpuInfoPath);     // Catch: Throwable -> L34 Exception -> L36
        BufferedReader r2 = new BufferedReader(r1);     // Catch: Throwable -> L30 Exception -> L32
    L86:
        String r3 = r2.readLine();     // Catch: Exception -> L28 Throwable -> L54
        if (r3 == null) goto L12;
        if (r3.contains(sCpuModelTitle) == false) goto L86;
        if (r3.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L86;
        r0 = r3.substring(r3.indexOf(58) + 1).trim();     // Catch: Exception -> L28 Throwable -> L54
    L12:
        if (r0 != null) goto L14;
    L16:
        if (r0 == null) goto L92;
        Object r4 = sModelLock;
        monitor-enter(r4);
        sModel = r0;     // Catch: Throwable -> L22
        monitor-exit(r4);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L92:
        r2.close();     // Catch: Exception -> L69
    L88:
        r1.close();     // Catch: Exception -> L70
    L27:
        return true;
    L14:
        if (r0.contains(sCpuVendorTag) == false) goto L16;
        r0 = r0.substring((r0.indexOf(sCpuVendorTag) + sCpuVendorTag.length()) + 1).trim();     // Catch: Exception -> L28 Throwable -> L54
    L28:
        e = e;
    L38:
        android.util.Log.w(TAG, "Cannot get CPU model from " + sCpuInfoPath, e);     // Catch: Throwable -> L54
        if (0 == 0) goto L49;
        Object r5 = sModelLock;
        monitor-enter(r5);
        sModel = null;     // Catch: Throwable -> L46
        monitor-exit(r5);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    L49:
        if (r2 != null) goto L94;
    L51:
        if (r1 != null) goto L84;
    L53:
        return false;
    L84:
        r1.close();     // Catch: Exception -> L72
        goto L53
    L94:
        r2.close();     // Catch: Exception -> L71
        goto L51
    L32:
        e = e;
        r2 = null;
    L30:
        th = th;
        BufferedReader r6 = null;
    L55:
        if (0 == 0) goto L64;
        Object r7 = sModelLock;
        monitor-enter(r7);
        sModel = null;     // Catch: Throwable -> L61
        monitor-exit(r7);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;
    L64:
        if (r6 != null) goto L80;
    L66:
        if (r1 == null) goto L105;
        r1.close();     // Catch: Exception -> L74
        throw th;
    L106:
        throw th;
    L105:
        throw th;
    L80:
        r6.close();     // Catch: Exception -> L73
        goto L66
    L54:
        th = th;
    L36:
        e = e;
        r1 = null;
        r2 = null;
    L34:
        th = th;
        r1 = null;
        r6 = null;
        goto L55
    }

    private static boolean fetchCoresFromFile(String r6) {
        BufferedReader r0 = null;
        FileReader r1 = new FileReader(r6);     // Catch: Throwable -> L29 Exception -> L36
        BufferedReader r7 = new BufferedReader(r1);     // Catch: Throwable -> L27 Exception -> L47
        String r2 = r7.readLine();     // Catch: Throwable -> L24 Exception -> L26
        if (TextUtils.isEmpty(r2) == false) goto L8;
    L11:
        int r3 = -1;
    L12:
        if (r3 == (-1)) goto L58;
        Object r4 = sCpuCoresLock;
        monitor-enter(r4);
        sCpuCores = r3;     // Catch: Throwable -> L18
        monitor-exit(r4);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L58:
        r7.close();     // Catch: Exception -> L43
    L54:
        r1.close();     // Catch: Exception -> L44
    L23:
        return true;
    L8:
        if (r2.startsWith("0-") == false) goto L11;
        r3 = getFirstInteger(r2.substring(2)) + 1;
        goto L12
    L26:
        r0 = r7;
    L24:
        Throwable th = th;
    L31:
        if (r7 != null) goto L50;
    L33:
        if (r1 == null) goto L70;
        r1.close();     // Catch: Exception -> L46
        throw th;
    L71:
        throw th;
    L70:
        throw th;
    L50:
        r7.close();     // Catch: Exception -> L45
        goto L33
    L27:
        th = move-exception;
        th = th;
        r7 = null;
    L38:
        if (r0 != null) goto L52;
    L40:
        if (r1 != null) goto L62;
    L42:
        return false;
    L62:
        r1.close();     // Catch: Exception -> L49
        goto L42
    L52:
        r0.close();     // Catch: Exception -> L48
        goto L40
    L36:
        r1 = null;
    L29:
        th = move-exception;
        r1 = null;
        th = th;
        r7 = null;
        goto L31
    }

    private static boolean fetchCoresFromFileList() {
        File[] r0 = new File(sCpuDirectory).listFiles(CPU_FILTER);
        if (r0 == null) goto L13;
        Object r1 = sCpuCoresLock;
        monitor-enter(r1);
        sCpuCores = r0.length;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    L13:
        return false;
    }

    public static String getCPUCores() {
        Object r0 = sCpuCoresLock;
        monitor-enter(r0);
        String r1 = String.valueOf(sCpuCores);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getCPUModel() {
        Object r0 = sModelLock;
        monitor-enter(r0);
        String r1 = sModel;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static int getFirstInteger(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L25;
        int r0 = 0;
    L6:
        if (r0 >= r4.length()) goto L17;
        if (Character.isDigit(r4.charAt(r0)) == true) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        int r2 = r0 + 1;
    L11:
        if (r2 < r4.length()) goto L13;
    L21:
        return Integer.parseInt(r4.substring(r0, r2));
    L26:
        return 0;
    L13:
        if (Character.isDigit(r4.charAt(r2)) == false) goto L21;
        r2 = r2 + 1;
        goto L11
    L17:
        r0 = 0;
        r2 = 0;
        goto L21
    L25:
        return 0;
    }

    public static void initialize() {
        if (sInitialized == false) goto L6;
        return;
    L6:
        if (fetchCPUModel() == false) goto L8;
    L10:
        sInitialized = true;
        return;
    L8:
        if (fetchCPUCores() == true) goto L10;
    }

    static /* synthetic */ boolean lambda$static$0(File r3) {
        String r4 = r3.getName();
        if (r4.startsWith("cpu") == false) goto L13;
        int r0 = 3;
    L6:
        if (r0 >= r4.length()) goto L11;
        if (Character.isDigit(r4.charAt(r0)) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }
}
