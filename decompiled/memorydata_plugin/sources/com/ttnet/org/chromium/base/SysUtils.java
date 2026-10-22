package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.crash.dumper.ProcInfo;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
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

    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB != null) goto L6;
        sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    L6:
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern r1 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r2 = StrictMode.allowThreadDiskReads();
        FileReader r3 = new FileReader(CommonProcUtil.MEMORY_INFO_PATH);     // Catch: Throwable -> L29 Exception -> L31
        BufferedReader r4 = new BufferedReader(r3);     // Catch: Throwable -> L26
    L37:
        String r5 = r4.readLine();     // Catch: Throwable -> L23
        if (r5 == null) goto L7;
        Matcher r6 = r1.matcher(r5);     // Catch: Throwable -> L23
        if (r6.find() == false) goto L37;
        int r7 = Integer.parseInt(r6.group(1));     // Catch: Throwable -> L23
        if (r7 > 1024) goto L19;
        String r8 = "Invalid /proc/meminfo total size in kB: " + r6.group(1);     // Catch: Throwable -> L23
    L8:
        android.util.Log.w(TAG, r8);     // Catch: Throwable -> L23
        r4.close();     // Catch: Throwable -> L26
        r3.close();     // Catch: Throwable -> L29 Exception -> L31
    L33:
        StrictMode.setThreadPolicy(r2);
        return 0;
    L19:
        r4.close();     // Catch: Throwable -> L26
        r3.close();     // Catch: Throwable -> L29 Exception -> L31
        StrictMode.setThreadPolicy(r2);
        return r7;
    L7:
        r8 = "/proc/meminfo lacks a MemTotal entry?";
    L23:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L29 Exception -> L31
        throw th;     // Catch: Throwable -> L29 Exception -> L31
    L31:
        e = move-exception;
        android.util.Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        StrictMode.setThreadPolicy(r2);
        throw th;
    }

    private static boolean detectHighEndDiskDevice() {
        StrictModeContext r1 = StrictModeContext.allowDiskReads();     // Catch: IllegalArgumentException -> L19
    L6:
        if ((new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes() / ProcInfo.GB) < HIGH_END_DEVICE_DISK_CAPACITY_GB) goto L8;
        boolean r2 = true;
    L9:
        if (r1 == null) goto L11;
        r1.close();     // Catch: IllegalArgumentException -> L19
    L11:
        return r2;
    L8:
        r2 = false;
    L12:
        th = move-exception;
        if (r1 != null) goto L22;
    L18:
        throw th;     // Catch: IllegalArgumentException -> L19
    L22:
        r1.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalArgumentException -> L19
    L19:
        e = move-exception;
        android.util.Log.v(TAG, "Cannot get disk data capacity", e);
        return false;
    }

    private static boolean detectLowEndDevice() {
        boolean r1 = true;
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE) == false) goto L6;
        return true;
    L6:
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE) == false) goto L8;
        return false;
    L8:
        Integer r0 = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
        sAmountOfPhysicalMemoryKB = r0;
        if (r0.intValue() > 0) goto L12;
    L10:
        boolean r2 = false;
    L20:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L22;
    L24:
        boolean r3 = false;
    L25:
        if (r2 == r3) goto L28;
        r1 = false;
    L28:
        RecordHistogram.recordBooleanHistogram("Android.SysUtilsLowEndMatches", r1);
        return r2;
    L22:
        if (Build.VERSION.SDK_INT < 19) goto L24;
        r3 = ((ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).isLowRamDevice();
        goto L25
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 1024) goto L10;
    L15:
        r2 = true;
        goto L20
    L17:
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 512) goto L10;
        goto L10
    }

    public static boolean hasCamera(Context r2) {
        PackageManager r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        if (r3.hasSystemFeature("android.hardware.camera") == false) goto L5;
    L8:
        return true;
    L5:
        if (r3.hasSystemFeature("android.hardware.camera.any") == true) goto L8;
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

    public static boolean isCurrentlyLowMemory() {
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        return r1.lowMemory;
    }

    public static boolean isHighEndDiskDevice() {
        if (sHighEndDiskDevice != null) goto L6;
        sHighEndDiskDevice = Boolean.valueOf(detectHighEndDiskDevice());
    L6:
        return sHighEndDiskDevice.booleanValue();
    }

    public static boolean isLowEndDevice() {
        if (sLowEndDevice != null) goto L6;
        sLowEndDevice = Boolean.valueOf(detectLowEndDevice());
    L6:
        return sLowEndDevice.booleanValue();
    }

    public static void logPageFaultCountToTracing() {
        SysUtilsJni.get().logPageFaultCountToTracing();
    }

    public static void resetForTesting() {
        sLowEndDevice = null;
        sAmountOfPhysicalMemoryKB = null;
    }

    public static void setAmountOfPhysicalMemoryKBForTesting(int r0) {
        sAmountOfPhysicalMemoryKB = Integer.valueOf(r0);
    }
}
