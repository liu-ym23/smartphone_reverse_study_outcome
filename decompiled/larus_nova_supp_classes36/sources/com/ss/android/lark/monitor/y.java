package com.ss.android.lark.monitor;

import androidx.core.util.Pair;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements z {
    public final c a;
    public b.a b;

    public final boolean isSampled() {
        return true;
    }

    public final void logAndRelease() {
        this.b.j = System.currentTimeMillis();
        b.a r0 = this.b;
        r0.getClass();
        b r1 = new b(r0);
        Log.i("LarkMetrics", "process:" + r1.g + ", activityName:" + r1.a);
        if (((CopyOnWriteArrayList) r1.k).isEmpty() == true) goto L11;
        Iterator r2 = ((CopyOnWriteArrayList) r1.k).iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        Pair r3 = (Pair) r2.next();
        if (r3 == null) goto L6;
        Log.i("LarkMetrics", "thread name:" + ((String) r3.first) + " usage:" + r3.second);
        goto L6
    L17:
        return;
    }

    public y(i r1) {
        this.a = r1.b;
    }

    @Override // com.ss.android.lark.monitor.z
    public final void a(String r3, double r4) {
        List<Pair<String, Double>> r0 = this.b.k;
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) r0;
        r1.add(new Pair(r3, Double.valueOf(r4)));
    }

    public final void acquireEvent(String r1, String r2) {
        b.a r3 = new b.a();
        r3.a = r2;
        this.b = r3;
    }

    public final void add(String r4, long r5) {
        if ("mobile_bytes_rx".equals(r4) == false) goto L6;
        this.b.e = (r5 * 1.0f) / 1024.0f;
        return;
    L6:
        if ("mobile_bytes_tx".equals(r4) == false) goto L9;
        this.b.d = (r5 * 1.0f) / 1024.0f;
        return;
    L9:
        if ("wifi_bytes_rx".equals(r4) == false) goto L12;
        this.b.c = (r5 * 1.0f) / 1024.0f;
        return;
    L12:
        if ("wifi_bytes_tx".equals(r4) == false) goto L15;
        this.b.b = (r5 * 1.0f) / 1024.0f;
        return;
    L15:
        if ("realtime_ms".equals(r4) == false) goto L22;
        this.b.i = (r5 * 1.0f) / 1000.0f;
        return;
    }

    public final void add(String r1, int r2) {
        if ("max_mem".equals(r1) == false) goto L6;
        this.b.getClass();
        return;
    L6:
        if ("total_mem".equals(r1) == false) goto L9;
        this.b.getClass();
        return;
    L9:
        if ("native_heap".equals(r1) == false) goto L12;
        this.b.getClass();
        return;
    L12:
        if ("java_heap".equals(r1) == false) goto L18;
        this.b.getClass();
        return;
    }

    public final void add(String r2, double r3) {
        if ("cpu_system_time_s".equals(r2) == false) goto L6;
        this.b.f = r3;
        return;
    L6:
        if ("cpu_user_time_s".equals(r2) == false) goto L9;
        this.b.g = r3;
        return;
    L9:
        if ("cpu_overload_multiple".equals(r2) == false) goto L14;
        this.b.getClass();
        return;
    }

    public final void add(String r2, String r3) {
        if ("process_name".equals(r2) == false) goto L6;
        this.b.h = r3;
        return;
    }
}
