package com.bytedance.crash.config;

import android.content.Context;
import com.bytedance.crash.Global;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class LogPathConfig {
    public static final String CORE_DUMP_LOG_DIR = "asdawd";
    public static final String NPTH_LIB_DIR = "selflib";
    public static final String PRIO_MONITOR_DIR = "PriorityMonitor";
    private static final LogPathConfig sInstance = null;
    private final String mAppRootDirStr;
    private File mCoreDump;
    private File mNpthLib;
    private File mNpthRoot;
    private String mNpthRootDirStr;
    private File mPrioMonitor;

    static {
        sInstance = new LogPathConfig();
    }

    private LogPathConfig() {
        this.mAppRootDirStr = getAppRootDirectory();
        this.mNpthRootDirStr = "npth";
        updateFilePath();
        if (this.mNpthRoot.exists() == true) goto L6;
        this.mNpthRoot.mkdirs();
        return;
    }

    private static LogPathConfig get() {
        return sInstance;
    }

    private String getAppRootDirectory() {
        Context r10 = Global.getContext();     // Catch: Throwable -> L8
        if (r10 == null) goto L6;
        return r10.getFilesDir().getAbsolutePath();
    L6:
        return "";
    L11:
        return "";
    }

    public static File getCoreDumpPath() {
        return get().mCoreDump;
    }

    public static File getNpthLibDir() {
        return get().mNpthLib;
    }

    public static File getNpthRootPath() {
        return get().mNpthRoot;
    }

    public static File getPrioMonitorPath() {
        return get().mPrioMonitor;
    }

    private void updateFilePath() {
        this.mNpthRoot = new File(this.mAppRootDirStr, this.mNpthRootDirStr);
        this.mCoreDump = new File(this.mNpthRoot, CORE_DUMP_LOG_DIR);
        this.mNpthLib = new File(this.mNpthRoot, NPTH_LIB_DIR);
        this.mPrioMonitor = new File(this.mNpthRoot, PRIO_MONITOR_DIR);
    }

    private void updateRootDir(String r10) {
        this.mNpthRootDirStr = r10;
        updateFilePath();
    }
}
