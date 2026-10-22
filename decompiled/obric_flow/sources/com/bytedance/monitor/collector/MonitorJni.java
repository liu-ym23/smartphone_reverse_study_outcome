package com.bytedance.monitor.collector;

import androidx.annotation.Keep;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorJni {
    @Keep
    public static native void clearAllocateInfo();

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
    public static native String doDumpAtraceRange(long r5, long r10);

    @Keep
    public static native void doDumpAtraceRangeToALog(long r5, long r10);

    @Keep
    public static native String doDumpNativeStack(int r5);

    @Keep
    public static native void doEnableAtrace(int r5, long r10);

    @Keep
    public static native long doGetAppCpuTime();

    @Keep
    public static native long doGetCpuTime(int r5);

    @Keep
    public static native String doGetSchedInfo(int r5);

    @Keep
    public static native void doInit();

    @Keep
    public static native void doSetDebugMode(boolean r5);

    @Keep
    public static native void doStart();

    @Keep
    public static native void doStop();

    @Keep
    public static native void dumpProcInfoTimeRangeToALog(long r5, long r10);

    @Keep
    public static native void enableBinderHook();

    @Keep
    public static native void enableLock(long r5);

    @Keep
    public static native void enableLockAll(long r5, boolean r10);

    @Keep
    public static native ByteBuffer getAllocReportInfo();

    @Keep
    public static native long getBlockGCCount();

    @Keep
    public static native long getBlockGCTime();

    @Keep
    public static native long getBytesAllocatedEver();

    @Keep
    public static native long getGCCount();

    @Keep
    public static native long getGCTime();

    @Keep
    public static native long getMajorFaults();

    @Keep
    public static native long getMinorFaults();

    @Keep
    public static native long getObjectsAllocatedEver();

    @Keep
    public static native int getProcCGroup(int r5);

    @Keep
    public static native String getProcInfoTimeRange(long r5, long r10);

    @Keep
    public static native String getProcInfos();

    @Keep
    public static native ThreadStatInfo getThreadStatInfo(int r5, int r10);

    @Keep
    public static native long getTotalCPUTimeByTimeInStat(int r5);

    @Keep
    public static native boolean initJavaMem();

    @Keep
    public static native void keepProcHyperOpen(boolean r5);

    @Keep
    public static native boolean readProcFile(String r5, int[] r10, Object[] r11, long[] r12, float[] r13);

    @Keep
    public static native void releaseByteBuffer(long r5);

    @Keep
    public static native void setAlogInstance(long r5);

    @Keep
    public static native void setBufferSize(int r5);

    @Keep
    public static native boolean setEnableAllocatedMonitor(boolean r5, int r10, int r11, int r12, long r13, ClassLoader r14);

    @Keep
    public static native void startHyperMonitor();

    @Keep
    public static native boolean startOrStopAllocatedMonitor(boolean r5, String r10);

    @Keep
    public static native void stopHyperMonitor();
}
