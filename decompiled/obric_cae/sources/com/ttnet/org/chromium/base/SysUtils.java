package com.ttnet.org.chromium.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.metrics.CachedMetrics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class SysUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB = 512;
    private static final int ANDROID_O_LOW_MEMORY_DEVICE_THRESHOLD_MB = 1024;
    private static final int BYTES_PER_GIGABYTE = 1073741824;
    private static final long HIGH_END_DEVICE_DISK_CAPACITY_GB = 24;
    private static final String TAG = "SysUtils";
    private static Integer sAmountOfPhysicalMemoryKB;
    private static Boolean sHighEndDiskDevice;
    private static Boolean sLowEndDevice;
    private static CachedMetrics.BooleanHistogramSample sLowEndMatches;

    static {
        sLowEndMatches = new CachedMetrics.BooleanHistogramSample("Android.SysUtilsLowEndMatches");
    }

    private SysUtils() {
    }

    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB != null) goto L6;
        sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    L6:
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern r8 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r10 = StrictMode.allowThreadDiskReads();
        FileReader r11 = new FileReader("/proc/meminfo");     // Catch: Throwable -> L29 Exception -> L31
        BufferedReader r12 = new BufferedReader(r11);     // Catch: Throwable -> L26
    L38:
        String r13 = r12.readLine();     // Catch: Throwable -> L23
        if (r13 == null) goto L7;
        Matcher r14 = r8.matcher(r13);     // Catch: Throwable -> L23
        if (r14.find() == false) goto L38;
        int r15 = Integer.parseInt(r14.group(1));     // Catch: Throwable -> L23
        if (r15 > 1024) goto L19;
        String r16 = "Invalid /proc/meminfo total size in kB: " + r14.group(1);     // Catch: Throwable -> L23
    L8:
        android.util.Log.w(TAG, r16);     // Catch: Throwable -> L23
        r12.close();     // Catch: Throwable -> L26
        r11.close();     // Catch: Throwable -> L29 Exception -> L31
    L33:
        StrictMode.setThreadPolicy(r10);
        return 0;
    L19:
        r12.close();     // Catch: Throwable -> L26
        r11.close();     // Catch: Throwable -> L29 Exception -> L31
        StrictMode.setThreadPolicy(r10);
        return r15;
    L7:
        r16 = "/proc/meminfo lacks a MemTotal entry?";
    L23:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L29 Exception -> L31
        throw th;     // Catch: Throwable -> L29 Exception -> L31
    L31:
        e = move-exception;
        android.util.Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        StrictMode.setThreadPolicy(r10);
        throw th;
    }

    private static boolean detectHighEndDiskDevice() {
        StrictModeContext r8 = StrictModeContext.allowDiskReads();     // Catch: IllegalArgumentException -> L21
    L6:
        if ((new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes() / 1073741824) < HIGH_END_DEVICE_DISK_CAPACITY_GB) goto L8;
        boolean r10 = true;
    L9:
        if (r8 == null) goto L11;
        r8.close();     // Catch: IllegalArgumentException -> L21
    L11:
        return r10;
    L8:
        r10 = false;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r8 != null) goto L24;
    L20:
        throw th;     // Catch: IllegalArgumentException -> L21
    L24:
        r8.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalArgumentException -> L21
    L21:
        e = move-exception;
        android.util.Log.v(TAG, "Cannot get disk data capacity", e);
        return false;
    }

    @TargetApi(19)
    private static boolean detectLowEndDevice() {
        boolean r8 = true;
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE) == false) goto L6;
        return true;
    L6:
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE) == false) goto L8;
        return false;
    L8:
        Integer r10 = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
        sAmountOfPhysicalMemoryKB = r10;
        if (r10.intValue() > 0) goto L12;
    L10:
        boolean r11 = false;
    L15:
        if (ContextUtils.getApplicationContext() == null) goto L17;
        boolean r12 = ((ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity")).isLowRamDevice();
    L18:
        CachedMetrics.BooleanHistogramSample r13 = sLowEndMatches;
        if (r11 == r12) goto L22;
        r8 = false;
    L22:
        r13.record(r8);
        return r11;
    L17:
        r12 = false;
        goto L18
    L12:
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 1024) goto L10;
        r11 = true;
        goto L15
    }

    public static boolean hasCamera(Context r8) {
        PackageManager r10 = r8.getPackageManager();
        boolean r11 = r10.hasSystemFeature("android.hardware.camera");
        return r10.hasSystemFeature("android.hardware.camera.any") | r11;
    }

    @CalledByNative
    public static boolean isCurrentlyLowMemory() {
        ActivityManager r8 = (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo r10 = new ActivityManager.MemoryInfo();
        r8.getMemoryInfo(r10);
        return r10.lowMemory;
    }

    public static boolean isHighEndDiskDevice() {
        if (sHighEndDiskDevice != null) goto L6;
        sHighEndDiskDevice = Boolean.valueOf(detectHighEndDiskDevice());
    L6:
        return sHighEndDiskDevice.booleanValue();
    }

    @CalledByNative
    public static boolean isLowEndDevice() {
        if (sLowEndDevice != null) goto L6;
        sLowEndDevice = Boolean.valueOf(detectLowEndDevice());
    L6:
        return sLowEndDevice.booleanValue();
    }

    public static void logPageFaultCountToTracing() {
        nativeLogPageFaultCountToTracing();
    }

    private static native void nativeLogPageFaultCountToTracing();

    @VisibleForTesting
    public static void resetForTesting() {
        sLowEndDevice = null;
        sAmountOfPhysicalMemoryKB = null;
    }
}
