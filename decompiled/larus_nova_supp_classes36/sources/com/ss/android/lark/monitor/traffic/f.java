package com.ss.android.lark.monitor.traffic;

import android.content.Context;
import com.facebook.battery.metrics.core.StatefulSystemMetricsCollector;
import com.facebook.battery.metrics.network.NetworkMetrics;
import com.facebook.battery.metrics.network.NetworkMetricsCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends a {
    public StatefulSystemMetricsCollector<NetworkMetrics, NetworkMetricsCollector> b;
    public boolean c;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r0 = new TrafficMetrics();
        if (this.c == false) goto L8;
        NetworkMetrics r1 = this.b.getLatestDiffAndReset();
        if (r1 == null) goto L7;
        r0.mobileBytesRx = r1.mobileBytesRx;
        r0.mobileBytesTx = r1.mobileBytesTx;
        r0.wifiBytesRx = r1.wifiBytesRx;
        r0.wifiBytesTx = r1.wifiBytesTx;
    L7:
        r0.from = TrafficMetrics.FROM_TOTAL;
        this.a = r0;
    L8:
        return r0;
    }

    public f(com.ss.android.lark.monitor.i r3) {
        super(0);
        Context r0 = r3.a;
        boolean r4 = r3.d;
        this.b = new StatefulSystemMetricsCollector(new NetworkMetricsCollector(r0));
        this.c = r4;
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r2) {
        TrafficMetrics r0 = this.a;
        if (r0 == null) goto L6;
        r2.a = r0.totalKBytes();
        r2.b = this.a.totalMobileKBytes();
        r2.c = this.a.totalWifiKBytes();
        r2.d = this.a.totalRxKBytes();
        r2.e = this.a.totalTxKBytes();
        return;
    }
}
