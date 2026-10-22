package com.bytedance.monitor.collector;

import androidx.annotation.Keep;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class MonitorJni {
    public MonitorJni() {
    }

    @Keep
    public static native void clearAllocateInfo();

    @Keep
    static native void disableBinderHook();

    @Keep
    static native void disableLock();

    @Keep
    static native void doCollect();

    @Keep
    static native void doDestroy();

    @Keep
    static native void doDisableAtrace();

    @Keep
    static native String doDumpAtrace();

    @Keep
    static native String doDumpAtraceRange(long r10, long r11);

    @Keep
    static native void doDumpAtraceRangeToALog(long r10, long r11);

    @Keep
    static native String doDumpNativeStack(int r10);

    @Keep
    static native void doEnableAtrace(int r10, long r11);

    @Keep
    public static native long doGetAppCpuTime();

    @Keep
    static native long doGetCpuTime(int r10);

    @Keep
    static native String doGetSchedInfo(int r10);

    @Keep
    static native void doInit();

    @Keep
    static native void doSetDebugMode(boolean r10);

    @Keep
    static native void doStart();

    @Keep
    static native void doStop();

    @Keep
    static native void dumpProcInfoTimeRangeToALog(long r10, long r11);

    @Keep
    static native void enableBinderHook();

    @Keep
    static native void enableLock(long r10);

    @Keep
    static native void enableLockAll(long r10, boolean r11);

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
    static native int getProcCGroup(int r10);

    @Keep
    static native String getProcInfoTimeRange(long r10, long r11);

    @Keep
    static native String getProcInfos();

    @Keep
    static native ThreadStatInfo getThreadStatInfo(int r10, int r11);

    @Keep
    static native long getTotalCPUTimeByTimeInStat(int r10);

    @Keep
    public static native boolean initJavaMem();

    @Keep
    static native void keepProcHyperOpen(boolean r10);

    @Keep
    static native boolean readProcFile(String r10, int[] r11, Object[] r12, long[] r13, float[] r14);

    @Keep
    public static native void releaseByteBuffer(long r10);

    @Keep
    static native void setAlogInstance(long r10);

    @Keep
    static native void setBufferSize(int r10);

    @Keep
    public static native boolean setEnableAllocatedMonitor(boolean r10, int r11, int r12, int r13, long r14, ClassLoader r15);

    @Keep
    static native void startHyperMonitor();

    @Keep
    public static native boolean startOrStopAllocatedMonitor(boolean r10, String r11);

    @Keep
    static native void stopHyperMonitor();
}
