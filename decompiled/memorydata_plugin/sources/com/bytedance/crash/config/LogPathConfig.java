package com.bytedance.crash.config;

import android.content.Context;
import com.bytedance.crash.Global;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
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
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r2 == null) goto L7;
        return r2.getFilesDir().getAbsolutePath();
    L7:
        return "";
    L12:
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

    private void updateRootDir(String r1) {
        this.mNpthRootDirStr = r1;
        updateFilePath();
    }
}
