package com.bytedance.monitor.collector;

import androidx.annotation.Keep;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;

/* JADX INFO: loaded from: classes.dex */
public class MonitorJni {
    public MonitorJni() {
    }

    @Keep
    public static native void disableBinderHook();

    @Keep
    public static native void disableLock();

    @Keep
    public static native void doCollect();

    @Keep
    public static native void doDestroy();

    @Keep
    public static native void doDisableAtrace();

    @Keep
    public static native String doDumpAtrace();

    @Keep
    public static native String doDumpAtraceRange(long r8, long r10);

    @Keep
    public static native void doDumpAtraceRangeToALog(long r8, long r10);

    @Keep
    public static native String doDumpNativeStack(int r8);

    @Keep
    public static native void doEnableAtrace(int r8, long r10);

    @Keep
    public static native long doGetAppCpuTime();

    @Keep
    public static native long doGetCpuTime(int r8);

    @Keep
    public static native String doGetSchedInfo(int r8);

    @Keep
    public static native void doInit();

    @Keep
    public static native void doSetDebugMode(boolean r8);

    @Keep
    public static native void doStart();

    @Keep
    public static native void doStop();

    @Keep
    public static native void dumpProcInfoTimeRangeToALog(long r8, long r10);

    @Keep
    public static native void enableBinderHook();

    @Keep
    public static native void enableLock(long r8);

    @Keep
    public static native void enableLockAll(long r8, boolean r10);

    @Keep
    public static native int getProcCGroup(int r8);

    @Keep
    public static native String getProcInfoTimeRange(long r8, long r10);

    @Keep
    public static native String getProcInfos();

    @Keep
    public static native ThreadStatInfo getThreadStatInfo(int r8, int r10);

    @Keep
    public static native long getTotalCPUTimeByTimeInStat(int r8);

    @Keep
    public static native void keepProcHyperOpen(boolean r8);

    @Keep
    public static native boolean readProcFile(String r8, int[] r10, Object[] r11, long[] r12, float[] r13);

    @Keep
    public static native void setAlogInstance(long r8);

    @Keep
    public static native void setBufferSize(int r8);

    @Keep
    public static native void startHyperMonitor();

    @Keep
    public static native void stopHyperMonitor();
}
