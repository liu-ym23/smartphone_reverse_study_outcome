package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;

/* JADX INFO: loaded from: classes2.dex */
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
        CPU_FILTER = b.f8405a;
    }

    public CpuUtils() {
    }

    public static /* synthetic */ boolean a(File r10) {
        return lambda$static$0(r10);
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
        String r10 = null;
        FileReader r11 = new FileReader(sCpuInfoPath);     // Catch: Throwable -> L34 Exception -> L36
        BufferedReader r12 = new BufferedReader(r11);     // Catch: Throwable -> L30 Exception -> L32
    L86:
        String r13 = r12.readLine();     // Catch: Exception -> L28 Throwable -> L54
        if (r13 == null) goto L12;
        if (r13.contains(sCpuModelTitle) == false) goto L86;
        if (r13.contains(":") == false) goto L86;
        r10 = r13.substring(r13.indexOf(58) + 1).trim();     // Catch: Exception -> L28 Throwable -> L54
    L12:
        if (r10 != null) goto L14;
    L16:
        if (r10 == null) goto L94;
        Object r14 = sModelLock;
        monitor-enter(r14);
        sModel = r10;     // Catch: Throwable -> L22
        monitor-exit(r14);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L94:
        r12.close();     // Catch: Exception -> L69
    L88:
        r11.close();     // Catch: Exception -> L70
    L27:
        return true;
    L14:
        if (r10.contains(sCpuVendorTag) == false) goto L16;
        r10 = r10.substring((r10.indexOf(sCpuVendorTag) + sCpuVendorTag.length()) + 1).trim();     // Catch: Exception -> L28 Throwable -> L54
    L28:
        e = e;
    L38:
        android.util.Log.w(TAG, "Cannot get CPU model from " + sCpuInfoPath, e);     // Catch: Throwable -> L54
        if (0 == 0) goto L49;
        Object r15 = sModelLock;
        monitor-enter(r15);
        sModel = null;     // Catch: Throwable -> L46
        monitor-exit(r15);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    L49:
        if (r12 != null) goto L80;
    L51:
        if (r11 != null) goto L90;
    L53:
        return false;
    L90:
        r11.close();     // Catch: Exception -> L72
        goto L53
    L80:
        r12.close();     // Catch: Exception -> L71
        goto L51
    L32:
        e = e;
        r12 = null;
    L30:
        th = th;
        BufferedReader r16 = null;
    L55:
        if (0 == 0) goto L64;
        Object r17 = sModelLock;
        monitor-enter(r17);
        sModel = null;     // Catch: Throwable -> L61
        monitor-exit(r17);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;
    L64:
        if (r16 != null) goto L76;
    L66:
        if (r11 == null) goto L105;
        r11.close();     // Catch: Exception -> L74
        throw th;
    L106:
        throw th;
    L105:
        throw th;
    L76:
        r16.close();     // Catch: Exception -> L73
        goto L66
    L54:
        th = th;
    L36:
        e = e;
        r11 = null;
        r12 = null;
    L34:
        th = th;
        r11 = null;
        r16 = null;
        goto L55
    }

    private static boolean fetchCoresFromFile(String r10) {
        BufferedReader r11 = null;
        FileReader r12 = new FileReader(r10);     // Catch: Throwable -> L29 Exception -> L36
        BufferedReader r13 = new BufferedReader(r12);     // Catch: Throwable -> L27 Exception -> L47
        String r14 = r13.readLine();     // Catch: Throwable -> L24 Exception -> L26
        if (TextUtils.isEmpty(r14) == false) goto L8;
    L11:
        int r15 = -1;
    L12:
        if (r15 == (-1)) goto L58;
        Object r16 = sCpuCoresLock;
        monitor-enter(r16);
        sCpuCores = r15;     // Catch: Throwable -> L18
        monitor-exit(r16);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L58:
        r13.close();     // Catch: Exception -> L43
    L54:
        r12.close();     // Catch: Exception -> L44
    L23:
        return true;
    L8:
        if (r14.startsWith("0-") == false) goto L11;
        r15 = getFirstInteger(r14.substring(2)) + 1;
        goto L12
    L26:
        r11 = r13;
    L24:
        Throwable th = th;
    L31:
        if (r13 != null) goto L50;
    L33:
        if (r12 == null) goto L70;
        r12.close();     // Catch: Exception -> L46
        throw th;
    L71:
        throw th;
    L70:
        throw th;
    L50:
        r13.close();     // Catch: Exception -> L45
        goto L33
    L27:
        th = move-exception;
        th = th;
        r13 = null;
    L38:
        if (r11 != null) goto L52;
    L40:
        if (r12 != null) goto L62;
    L42:
        return false;
    L62:
        r12.close();     // Catch: Exception -> L49
        goto L42
    L52:
        r11.close();     // Catch: Exception -> L48
        goto L40
    L36:
        r12 = null;
    L29:
        th = move-exception;
        r12 = null;
        th = th;
        r13 = null;
        goto L31
    }

    private static boolean fetchCoresFromFileList() {
        File[] r10 = new File(sCpuDirectory).listFiles(CPU_FILTER);
        if (r10 == null) goto L13;
        Object r11 = sCpuCoresLock;
        monitor-enter(r11);
        sCpuCores = r10.length;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    L13:
        return false;
    }

    public static String getCPUCores() {
        Object r10 = sCpuCoresLock;
        monitor-enter(r10);
        String r11 = String.valueOf(sCpuCores);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getCPUModel() {
        Object r10 = sModelLock;
        monitor-enter(r10);
        String r11 = sModel;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    private static int getFirstInteger(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L25;
        int r11 = 0;
    L6:
        if (r11 >= r10.length()) goto L17;
        if (Character.isDigit(r10.charAt(r11)) == true) goto L9;
        r11 = r11 + 1;
        goto L6
    L9:
        int r12 = r11 + 1;
    L11:
        if (r12 < r10.length()) goto L13;
    L21:
        return Integer.parseInt(r10.substring(r11, r12));
    L26:
        return 0;
    L13:
        if (Character.isDigit(r10.charAt(r12)) == false) goto L21;
        r12 = r12 + 1;
        goto L11
    L17:
        r11 = 0;
        r12 = 0;
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

    private static /* synthetic */ boolean lambda$static$0(File r10) {
        String r11 = r10.getName();
        if (r11.startsWith("cpu") == false) goto L13;
        int r12 = 3;
    L6:
        if (r12 >= r11.length()) goto L11;
        if (Character.isDigit(r11.charAt(r12)) == false) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }
}
