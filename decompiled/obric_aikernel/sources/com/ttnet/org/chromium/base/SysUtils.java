package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import androidx.annotation.VisibleForTesting;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.crash.dumper.ProcInfo;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
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

    interface Natives {
        void logPageFaultCountToTracing();
    }

    static {
    }

    private SysUtils() {
    }

    @CalledByNative
    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB != null) goto L6;
        sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    L6:
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern r10 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r11 = StrictMode.allowThreadDiskReads();
        FileReader r12 = new FileReader(CommonProcUtil.MEMORY_INFO_PATH);     // Catch: Throwable -> L29 Exception -> L31
        BufferedReader r13 = new BufferedReader(r12);     // Catch: Throwable -> L26
    L38:
        String r14 = r13.readLine();     // Catch: Throwable -> L23
        if (r14 == null) goto L7;
        Matcher r15 = r10.matcher(r14);     // Catch: Throwable -> L23
        if (r15.find() == false) goto L38;
        int r16 = Integer.parseInt(r15.group(1));     // Catch: Throwable -> L23
        if (r16 > 1024) goto L19;
        String r17 = "Invalid /proc/meminfo total size in kB: " + r15.group(1);     // Catch: Throwable -> L23
    L8:
        android.util.Log.w(TAG, r17);     // Catch: Throwable -> L23
        r13.close();     // Catch: Throwable -> L26
        r12.close();     // Catch: Throwable -> L29 Exception -> L31
    L33:
        StrictMode.setThreadPolicy(r11);
        return 0;
    L19:
        r13.close();     // Catch: Throwable -> L26
        r12.close();     // Catch: Throwable -> L29 Exception -> L31
        StrictMode.setThreadPolicy(r11);
        return r16;
    L7:
        r17 = "/proc/meminfo lacks a MemTotal entry?";
    L23:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L29 Exception -> L31
        throw th;     // Catch: Throwable -> L29 Exception -> L31
    L31:
        e = move-exception;
        android.util.Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        StrictMode.setThreadPolicy(r11);
        throw th;
    }

    private static boolean detectHighEndDiskDevice() {
        StrictModeContext r10 = StrictModeContext.allowDiskReads();     // Catch: IllegalArgumentException -> L19
    L6:
        if ((new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes() / ProcInfo.GB) < HIGH_END_DEVICE_DISK_CAPACITY_GB) goto L8;
        boolean r11 = true;
    L9:
        if (r10 == null) goto L11;
        r10.close();     // Catch: IllegalArgumentException -> L19
    L11:
        return r11;
    L8:
        r11 = false;
    L12:
        th = move-exception;
        if (r10 != null) goto L22;
    L18:
        throw th;     // Catch: IllegalArgumentException -> L19
    L22:
        r10.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalArgumentException -> L19
    L19:
        e = move-exception;
        android.util.Log.v(TAG, "Cannot get disk data capacity", e);
        return false;
    }

    private static boolean detectLowEndDevice() {
        boolean r10 = true;
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE) == false) goto L6;
        return true;
    L6:
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE) == false) goto L8;
        return false;
    L8:
        Integer r11 = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
        sAmountOfPhysicalMemoryKB = r11;
        if (r11.intValue() > 0) goto L12;
    L10:
        boolean r12 = false;
    L20:
        if (ContextUtils.getApplicationContext() != null) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r12 == r13) goto L28;
        r10 = false;
    L28:
        RecordHistogram.recordBooleanHistogram("Android.SysUtilsLowEndMatches", r10);
        return r12;
    L22:
        if (Build.VERSION.SDK_INT < 19) goto L24;
        r13 = ((ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity")).isLowRamDevice();
        goto L25
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 1024) goto L10;
    L15:
        r12 = true;
        goto L20
    L17:
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 512) goto L10;
        goto L10
    }

    public static boolean hasCamera(Context r10) {
        PackageManager r11 = r10.getPackageManager();
        if (r11.hasSystemFeature("android.hardware.camera") == false) goto L5;
    L8:
        return true;
    L5:
        if (r11.hasSystemFeature("android.hardware.camera.any") == true) goto L8;
        return false;
    }

    public static boolean isAndroidGo() {
        if (isLowEndDevice() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return true;
    }

    @CalledByNative
    public static boolean isCurrentlyLowMemory() {
        ActivityManager r10 = (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo r11 = new ActivityManager.MemoryInfo();
        r10.getMemoryInfo(r11);
        return r11.lowMemory;
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
        SysUtilsJni.get().logPageFaultCountToTracing();
    }

    @VisibleForTesting
    public static void resetForTesting() {
        sLowEndDevice = null;
        sAmountOfPhysicalMemoryKB = null;
    }

    @VisibleForTesting
    public static void setAmountOfPhysicalMemoryKBForTesting(int r10) {
        sAmountOfPhysicalMemoryKB = Integer.valueOf(r10);
    }
}
