package com.bytedance.monitor.collector;

import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorJni {
    public MonitorJni() {
    }

    public static native void clearAllocateInfo();

    static native void disableBinderHook();

    static native void disableLock();

    static native void doCollect();

    static native void doDestroy();

    static native void doDisableAtrace();

    static native String doDumpAtrace();

    static native String doDumpAtraceRange(long r0, long r2);

    static native void doDumpAtraceRangeToALog(long r0, long r2);

    static native String doDumpNativeStack(int r0);

    static native void doEnableAtrace(int r0, long r1);

    public static native long doGetAppCpuTime();

    static native long doGetCpuTime(int r0);

    static native String doGetSchedInfo(int r0);

    static native void doInit();

    static native void doSetDebugMode(boolean r0);

    static native void doStart();

    static native void doStop();

    static native void dumpProcInfoTimeRangeToALog(long r0, long r2);

    static native void enableBinderHook();

    static native void enableLock(long r0);

    static native void enableLockAll(long r0, boolean r2);

    public static native ByteBuffer getAllocReportInfo();

    public static native long getBlockGCCount();

    public static native long getBlockGCTime();

    public static native long getBytesAllocatedEver();

    public static native long getGCCount();

    public static native long getGCTime();

    public static native long getMajorFaults();

    public static native long getMinorFaults();

    public static native long getObjectsAllocatedEver();

    static native int getProcCGroup(int r0);

    static native String getProcInfoTimeRange(long r0, long r2);

    static native String getProcInfos();

    static native ThreadStatInfo getThreadStatInfo(int r0, int r1);

    static native long getTotalCPUTimeByTimeInStat(int r0);

    public static native boolean initJavaMem();

    static native void keepProcHyperOpen(boolean r0);

    static native boolean readProcFile(String r0, int[] r1, Object[] r2, long[] r3, float[] r4);

    public static native void releaseByteBuffer(long r0);

    static native void setAlogInstance(long r0);

    static native void setBufferSize(int r0);

    public static native boolean setEnableAllocatedMonitor(boolean r0, int r1, int r2, int r3, long r4, ClassLoader r6);

    static native void startHyperMonitor();

    public static native boolean startOrStopAllocatedMonitor(boolean r0, String r1);

    static native void stopHyperMonitor();
}
