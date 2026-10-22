package com.bytedance.crash.resource.utils;

import com.bytedance.crash.config.LogPathConfig;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class LogPath {
    private static final String FD_TRACK_DIR = "FdTrack";
    private static final String GWP_ASAN_LOG_DIR = "xasanReport";
    private static final String NATIVE_HEAP_TRACKER_DIR = "NativeHeapReport";
    private static final String PRIO_MONITOR_DIR = "PriorityMonitor";
    private static final String REF_MONITOR_DIR = "RefMonitor";
    private static final String TLS_MONITOR_DIR = "TLSMonitor";
    private static final String VM_MONITOR_DIR = "VmMonitor";
    private static final LogPath sInstance = null;
    private File mFdTrack;
    private File mGwpReport;
    private File mHeapTrack;
    private File mNpthRootDir;
    private File mPrioMonitor;
    private File mRefMonitor;
    private File mTLSMonitor;
    private File mVmMonitor;

    static {
        sInstance = new LogPath();
    }

    private LogPath() {
        this.mNpthRootDir = LogPathConfig.getNpthRootPath();
        updateFilePath();
    }

    private static LogPath get() {
        return sInstance;
    }

    public static File getFdTrackPath() {
        return get().mFdTrack;
    }

    public static File getGwpAsanLogPath() {
        return get().mGwpReport;
    }

    public static File getNativeHeapTrackerPath() {
        return get().mHeapTrack;
    }

    public static File getPriorityMonitorPath() {
        return get().mPrioMonitor;
    }

    public static File getRefMonitorPath() {
        return get().mRefMonitor;
    }

    public static File getTLSMonitorPath() {
        return get().mTLSMonitor;
    }

    public static File getVmMonitorPath() {
        return get().mVmMonitor;
    }

    public void updateFilePath() {
        this.mGwpReport = new File(this.mNpthRootDir, GWP_ASAN_LOG_DIR);
        this.mHeapTrack = new File(this.mNpthRootDir, NATIVE_HEAP_TRACKER_DIR);
        this.mVmMonitor = new File(this.mNpthRootDir, VM_MONITOR_DIR);
        this.mFdTrack = new File(this.mNpthRootDir, FD_TRACK_DIR);
        this.mRefMonitor = new File(this.mNpthRootDir, REF_MONITOR_DIR);
        this.mTLSMonitor = new File(this.mNpthRootDir, TLS_MONITOR_DIR);
        this.mPrioMonitor = new File(this.mNpthRootDir, "PriorityMonitor");
    }
}
