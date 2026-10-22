package com.ss.android.lark.monitor.traffic;

import android.util.ArrayMap;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends a {
    public final ConcurrentHashMap<String, TrafficMetrics> b;
    public List<TrafficMetrics> c;
    public final ArrayMap<String, Float> d;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r0 = new TrafficMetrics();
        r0.from = TrafficMetrics.FROM_HTTP;
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

    public final void c() {
        ArrayMap<String, Float> r0 = this.d;
        monitor-enter(r0);
        Iterator<String> r1 = this.d.keySet().iterator();     // Catch: Throwable -> L14 Exception -> L16
    L6:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();     // Catch: Throwable -> L14 Exception -> L16
        if (this.d.get(r2) == null) goto L6;
        if (this.d.get(r2).floatValue() < 1000.0f) goto L6;
        Log.i("TrafficMonitorHttpTraffic", "http_url: " + r2 + "url_cost(KB): " + this.d.get(r2));     // Catch: Throwable -> L14 Exception -> L16
        goto L6
    L12:
        this.d.clear();     // Catch: Throwable -> L14 Exception -> L16
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public b() {
        this.b = new ConcurrentHashMap();
        this.d = new ArrayMap();
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r7) {
        List<TrafficMetrics> r0 = this.c;
        if (r0 == null) goto L19;
        Iterator<TrafficMetrics> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L23;
        TrafficMetrics r2 = r1.next();
        Log.i("HttpTraffic", "http_url:" + r2.from + ", url_cost(kb):" + r2.totalKBytes());
        ArrayMap<String, Float> r3 = this.d;
        monitor-enter(r3);
        if (this.d.get(r2.from) != null) goto L12;
        float r4 = 0.0f;
    L13:
        this.d.put(r2.from, Float.valueOf(r4 + r2.totalKBytes()));     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        r7.k += r2.totalKBytes();
        r7.l += r2.totalMobileKBytes();
        r7.m += r2.totalWifiKBytes();
        r7.n += r2.totalRxKBytes();
        r7.o += r2.totalTxKBytes();
        goto L6
    L12:
        r4 = this.d.get(r2.from).floatValue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L23:
        return;
    }
}
