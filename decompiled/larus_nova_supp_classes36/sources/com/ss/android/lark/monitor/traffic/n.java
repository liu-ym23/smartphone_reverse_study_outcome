package com.ss.android.lark.monitor.traffic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n extends a {
    public final ConcurrentHashMap<String, TrafficMetrics> b;
    public List<TrafficMetrics> c;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r0 = new TrafficMetrics();
        r0.from = TrafficMetrics.FROM_WEB_VIEW;
        if (this.b.isEmpty() == false) goto L5;
        ArrayList r1 = new ArrayList();
    L12:
        this.c = r1;
        return r0;
    L5:
        monitor-enter(this);
        r1 = new ArrayList(this.b.size());     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, TrafficMetrics>> r2 = this.b.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r2.hasNext() == false) goto L10;
        TrafficMetrics r3 = r2.next().getValue();     // Catch: Throwable -> L14
        r1.add(r3);     // Catch: Throwable -> L14
        r0.wifiBytesRx += r3.wifiBytesRx;     // Catch: Throwable -> L14
        r0.wifiBytesTx += r3.wifiBytesTx;     // Catch: Throwable -> L14
        r0.mobileBytesRx += r3.mobileBytesRx;     // Catch: Throwable -> L14
        r0.mobileBytesTx += r3.mobileBytesTx;     // Catch: Throwable -> L14
        goto L8
    L10:
        this.b.clear();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public n() {
        this.b = new ConcurrentHashMap(4);
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r5) {
        List<TrafficMetrics> r0 = this.c;
        if (r0 == null) goto L8;
        Iterator<TrafficMetrics> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        TrafficMetrics r2 = r1.next();
        r5.p += r2.totalKBytes();
        r5.q += r2.totalMobileKBytes();
        r5.r += r2.totalWifiKBytes();
        r5.s += r2.totalRxKBytes();
        r5.t += r2.totalTxKBytes();
        goto L6
    L10:
        return;
    }
}
