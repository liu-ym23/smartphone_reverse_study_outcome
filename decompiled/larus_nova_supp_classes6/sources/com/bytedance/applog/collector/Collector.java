package com.bytedance.applog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.applog.b;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import rw3.f;
import zw3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Collector extends BroadcastReceiver {
    public Collector() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r11, Intent r12) {
        String[] r13 = r12.getStringArrayExtra("K_DATA");
        if (r13 != null) goto L5;
    L29:
        n.w().i("Collector onReceive empty", new Object[0]);
        return;
    L5:
        if (r13.length <= 0) goto L29;
        Iterator r0 = ((CopyOnWriteArrayList) b.A0).iterator();
    L8:
        if (r0.hasNext() == false) goto L42;
        b r1 = (b) r0.next();
        String[] r2 = (String[]) r13.clone();
        r1.getClass();
        if (r2.length == 0) goto L8;
        int r3 = r2.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L16;
        String r5 = r2[r4];
        r4 = r4 + 1;
        goto L13
    L16:
        if (r1.n == null) goto L17;
        f r6 = r1.n;
        r6.m.removeMessages(4);
        r6.m.obtainMessage(4, r2).sendToTarget();
        goto L8
    L17:
        a r7 = r1.d;
        LinkedList r8 = r7.b;
        monitor-enter(r8);
        if (r7.b.size() <= r7.c) goto L22;
        String r9 = (String) r7.b.poll();     // Catch: Throwable -> L25
        r7.d.t0.f(0, a.e, "AppLogCache overflow2 remove data: {}", new Object[]{r9});     // Catch: Throwable -> L25
        r7.d.W.b(StatsCountKeys.CACHE_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L25
        int r10 = bx3.a.a;     // Catch: Throwable -> L25
    L22:
        r7.b.addAll(Arrays.asList(r2));     // Catch: Throwable -> L25
        monitor-exit(r8);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
