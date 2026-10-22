package com.bytedance.crash.resource.tlsmonitor;

import com.bytedance.crash.resource.ResourceMonitorAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class TLSMonitorAdapter extends ResourceMonitorAdapter {
    private static TLSMonitorAdapter mInstance;
    private TLSMonitorConfig mConfig;

    static {
    }

    public TLSMonitorAdapter() {
    }

    public static TLSMonitorAdapter get() {
        if (mInstance != null) goto L15;
        monitor-enter(TLSMonitorAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TLSMonitorAdapter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TLSMonitorAdapter.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static void updateConfig(TLSMonitorConfig r1) {
        TLSMonitorAdapter r0 = get();
        r0.mConfig = r1;
        r0.startMonitor(r1);
    }
}
