package com.ss.android.lark.monitor.traffic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends a {
    public volatile TrafficMetrics b;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r0 = new TrafficMetrics();
        this.a = r0;
        r0.from = TrafficMetrics.FROM_VIDEO_PLAY;
        monitor-enter(this);
        this.a.set(this.b);     // Catch: Throwable -> L8
        this.b.reset();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return this.a;
    L8:
        th = move-exception;
        throw th;
    }

    public m() {
        this.b = new TrafficMetrics();
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r2) {
        TrafficMetrics r0 = this.a;
        if (r0 == null) goto L6;
        r2.z = r0.totalKBytes();
        r2.A = this.a.totalMobileKBytes();
        r2.B = this.a.totalWifiKBytes();
        r2.C = this.a.totalRxKBytes();
        r2.D = this.a.totalTxKBytes();
        return;
    }
}
