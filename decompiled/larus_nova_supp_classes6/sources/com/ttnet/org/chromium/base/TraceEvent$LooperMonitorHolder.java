package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class TraceEvent$LooperMonitorHolder {
    private static final TraceEvent$BasicLooperMonitor sInstance = null;

    private TraceEvent$LooperMonitorHolder() {
    }

    static {
        if (CommandLine.getInstance().hasSwitch("enable-idle-tracing") == false) goto L5;
        TraceEvent.IdleTracingLooperMonitor r0 = new TraceEvent.IdleTracingLooperMonitor(null);
    L6:
        sInstance = r0;
        return;
    L5:
        r0 = new TraceEvent$BasicLooperMonitor();
        goto L6
    }

    public static /* synthetic */ TraceEvent$BasicLooperMonitor access$000() {
        return sInstance;
    }
}
