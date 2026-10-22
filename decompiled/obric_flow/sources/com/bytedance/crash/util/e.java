package com.bytedance.crash.util;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet f4178a = null;

    static {
        HashSet r5 = new HashSet();
        f4178a = r5;
        r5.add("HeapTaskDaemon");
        r5.add("ThreadPlus");
        r5.add("ApiDispatcher");
        r5.add("ApiLocalDispatcher");
        r5.add("AsyncLoader");
        r5.add("AsyncTask");
        r5.add("Binder");
        r5.add("PackageProcessor");
        r5.add("SettingsObserver");
        r5.add("WifiManager");
        r5.add("JavaBridge");
        r5.add("Compiler");
        r5.add("Signal Catcher");
        r5.add("GC");
        r5.add("ReferenceQueueDaemon");
        r5.add("FinalizerDaemon");
        r5.add("FinalizerWatchdogDaemon");
        r5.add("CookieSyncManager");
        r5.add("RefQueueWorker");
        r5.add("CleanupReference");
        r5.add("VideoManager");
        r5.add("DBHelper-AsyncOp");
        r5.add("InstalledAppTracker2");
        r5.add("AppData-AsyncOp");
        r5.add("IdleConnectionMonitor");
        r5.add("LogReaper");
        r5.add("ActionReaper");
        r5.add("Okio Watchdog");
        r5.add("CheckWaitingQueue");
        r5.add("NPTH-CrashTimer");
        r5.add("NPTH-JavaCallback");
        r5.add("NPTH-LocalParser");
        r5.add("ANR_FILE_MODIFY");
    }
}
