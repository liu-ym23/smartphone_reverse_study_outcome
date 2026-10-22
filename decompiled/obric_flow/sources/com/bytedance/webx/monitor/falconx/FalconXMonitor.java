package com.bytedance.webx.monitor.falconx;

import com.bytedance.falconx.WebOfflineGlobalMonitor;
import wk.a;

/* JADX INFO: loaded from: classes2.dex */
public class FalconXMonitor {
    private static volatile FalconXMonitor instance;
    private boolean hasSetMonitor;

    public FalconXMonitor() {
        this.hasSetMonitor = false;
    }

    public static FalconXMonitor getInstance() {
        if (instance != null) goto L16;
        monitor-enter(FalconXMonitor.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L11;
        instance = new FalconXMonitor();     // Catch: Throwable -> L9
    L11:
        monitor-exit(FalconXMonitor.class);     // Catch: Throwable -> L9
    L16:
        return instance;
    }

    public void beginMonitor() {
        if (this.hasSetMonitor == true) goto L6;
        this.hasSetMonitor = true;
        WebOfflineGlobalMonitor.setGlobalMonitor(new a());
        return;
    }
}
