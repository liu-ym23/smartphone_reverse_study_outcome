package com.ss.android.lark.monitor.traffic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends a {
    public volatile TrafficMetrics b;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r0 = new TrafficMetrics();
        this.a = r0;
        r0.from = TrafficMetrics.FROM_RTC;
        monitor-enter(this);
        this.a.set(this.b);     // Catch: Throwable -> L8
        this.b.reset();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return this.a;
    L8:
        th = move-exception;
        throw th;
    }

    public d() {
        this.b = new TrafficMetrics();
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r2) {
        TrafficMetrics r0 = this.a;
        if (r0 == null) goto L6;
        r2.u = r0.totalKBytes();
        r2.v = this.a.totalMobileKBytes();
        r2.w = this.a.totalWifiKBytes();
        r2.x = this.a.totalRxKBytes();
        r2.y = this.a.totalTxKBytes();
        return;
    }
}
