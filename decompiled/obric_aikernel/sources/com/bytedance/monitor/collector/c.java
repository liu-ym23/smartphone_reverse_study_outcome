package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public c(int r10) {
        super(r10, "atrace_event");
    }

    private String g() {
        if (k.f2350p == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtrace();
    }

    private String h(long r10, long r11) {
        if (k.f2350p == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtraceRange(r10, r11);
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> a() {
    L8:
        return null;
    L4:
        if (k.f2350p == true) goto L6;
        return null;
    L6:
        return new Pair(this.f2245a, g());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> b(long r10, long r11) {
    L8:
        return null;
    L4:
        if (k.f2350p == true) goto L6;
        return null;
    L6:
        return new Pair(this.f2245a, h(r10, r11));
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r10) {
    }

    public void i(long r10) {
        if (k.f2350p == true) goto L5;
        return;
    L5:
        MonitorJni.doEnableAtrace(this.f2247c, r10);     // Catch: Throwable -> L7
        return;
    }
}
