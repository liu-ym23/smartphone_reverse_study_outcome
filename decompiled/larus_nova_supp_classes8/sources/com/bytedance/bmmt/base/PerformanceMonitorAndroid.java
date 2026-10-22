package com.bytedance.bmmt.base;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.PowerManager;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class PerformanceMonitorAndroid implements ComponentCallbacks2 {
    private static final FileFilter CPU_IDLE_STATE_FILTER = null;
    private static final float ERROR_RESULT = 0.0f;
    private static int mCpuCoreCount;
    private static int mCpuIdleStateCount;
    private static int mMemoryState;
    private static boolean mMemoryStateRegisterd;
    private static PerformanceMonitorAndroid mPerformanceMonitor;
    private static int mThermalState;

    public PerformanceMonitorAndroid() {
    }

    public static /* bridge */ /* synthetic */ void a(int r0) {
        mThermalState = r0;
    }

    public static /* bridge */ /* synthetic */ int b(int r0) {
        return convertThermalState(r0);
    }

    private static int convertThermalState(int r0) {
        switch(r0) {
            case 0: goto L7;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L4;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return 4;
    L4:
        return 3;
    L5:
        return 2;
    L6:
        return 1;
    L7:
        return 0;
    }

    private static int getCpuIdleStateCount() {
        File[] r1 = new PolarisFileWrapper("/sys/devices/system/cpu/cpu0/cpuidle/").listFiles(CPU_IDLE_STATE_FILTER);     // Catch: Exception -> L7
        if (r1 == null) goto L10;
        return r1.length;
    L10:
        return 0;
    L11:
        return 0;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    static {
        CPU_IDLE_STATE_FILTER = new AnonymousClass1();
        mCpuCoreCount = -1;
        mCpuIdleStateCount = -1;
        mThermalState = -1;
        mMemoryState = 0;
        mMemoryStateRegisterd = false;
        mPerformanceMonitor = new PerformanceMonitorAndroid();
    }

    public static boolean getIfRoomsDevice() {
        if ("a3382".equals(Build.MODEL.toLowerCase()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static int getThermalState() {
        if (Build.VERSION.SDK_INT < 29) goto L17;
        if (mThermalState != (-1)) goto L17;
        PowerManager.OnThermalStatusChangedListener r0 = new AnonymousClass2();
        mThermalState = 4;
        Context r1 = ContextUtils.getApplicationContext();
        if (r1 == null) goto L9;
        PowerManager r2 = (PowerManager) r1.getSystemService("power");
        if (r2 == null) goto L20;
        int r3 = r2.getCurrentThermalStatus();     // Catch: Exception -> L14
        mThermalState = r3;     // Catch: Exception -> L14
        mThermalState = convertThermalState(r3);
        r2.addThermalStatusListener(r0);
    L15:
        return mThermalState;
    L20:
        return mThermalState;
    L9:
        return mThermalState;
    L17:
        if (mThermalState != (-1)) goto L20;
        mThermalState = 4;
        goto L20
    }

    public static int getCurrentPidMemorySize() {
        Context r0 = ContextUtils.getApplicationContext();
        if (r0 != null) goto L19;
        return 0;
    L19:
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");     // Catch: Exception -> L18
        if (r1 != null) goto L8;
        return 0;
    L8:
        Debug.MemoryInfo[] r2 = r1.getProcessMemoryInfo(new int[]{Process.myPid()});     // Catch: Exception -> L18
        if (r2 == null) goto L17;
        if (r2.length == 0) goto L17;
        Debug.MemoryInfo r3 = r2[0];     // Catch: Exception -> L18
        if (r3 == null) goto L17;
        return r3.getTotalPss();
    L17:
        return 0;
    }

    public static int getJavaAppMemoryUsage() {
        Context r0 = ContextUtils.getApplicationContext();
        if (r0 != null) goto L19;
        return 0;
    L19:
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");     // Catch: Exception -> L18
        if (r1 != null) goto L8;
        return 0;
    L8:
        Debug.MemoryInfo[] r2 = r1.getProcessMemoryInfo(new int[]{Process.myPid()});     // Catch: Exception -> L18
        if (r2 == null) goto L17;
        if (r2.length == 0) goto L17;
        Debug.MemoryInfo r3 = r2[0];     // Catch: Exception -> L18
        if (r3 == null) goto L17;
        return r3.dalvikPss;
    L17:
        return 0;
    }

    public static int getMemoryState() {
        Context r0 = ContextUtils.getApplicationContext();
        if (r0 != null) goto L7;
        return -1;
    L7:
        if (mMemoryStateRegisterd == true) goto L19;
        monitor-enter(PerformanceMonitorAndroid.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (mMemoryStateRegisterd == true) goto L13;
        r0.registerComponentCallbacks(mPerformanceMonitor);     // Catch: Throwable -> L15
        mMemoryStateRegisterd = true;     // Catch: Throwable -> L15
    L13:
        monitor-exit(PerformanceMonitorAndroid.class);     // Catch: Throwable -> L15
    L19:
        return mMemoryState;
    }

    public static int getThreadCount() {
        return Thread.activeCount();
    }

    public static void setThermalState(int r0) {
        mThermalState = r0;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r3) {
        if (r3 != 5) goto L5;
        mMemoryState = 1;
        return;
    L5:
        if (r3 != 10) goto L7;
        mMemoryState = 2;
        return;
    L7:
        if (r3 != 15) goto L9;
        mMemoryState = 3;
        return;
    L9:
        if (r3 != 20) goto L11;
        mMemoryState = 4;
        return;
    L11:
        if (r3 != 40) goto L13;
        mMemoryState = 5;
        return;
    L13:
        if (r3 != 60) goto L15;
        mMemoryState = 6;
        return;
    L15:
        if (r3 != 80) goto L31;
        mMemoryState = 7;
        return;
    }
}
