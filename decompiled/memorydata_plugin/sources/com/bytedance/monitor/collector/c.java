package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b {
    public c(int r2) {
        super(r2, "atrace_event");
    }

    private String a() {
        if (k.f2867a == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtrace();
    }

    private String a(long r1, long r3) {
        if (k.f2867a == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtraceRange(r1, r3);
    }

    public void a(long r2) {
        if (k.f2867a == true) goto L5;
        return;
    L5:
        MonitorJni.doEnableAtrace(this.mRunMode, r2);     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> dumpInfo() {
    L8:
        return null;
    L4:
        if (k.f2867a == true) goto L6;
        return null;
    L6:
        return new Pair(this.mCollectorType, a());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> dumpInfosRange(long r4, long r6) {
    L8:
        return null;
    L4:
        if (k.f2867a == true) goto L6;
        return null;
    L6:
        return new Pair(this.mCollectorType, a(r4, r6));
    }

    @Override // com.bytedance.monitor.collector.b
    void dumpInfosToALog(long r3, long r5, long r7) {
        if (k.f2867a == true) goto L6;
        return;
    L6:
        if ((r5 - r3) <= 250) goto L8;
        r5 = r3 + 250;     // Catch: Throwable -> L10
    L8:
        MonitorJni.doDumpAtraceRangeToALog(r3, r5);     // Catch: Throwable -> L10
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void updateConfig(int r1) {
    }
}
