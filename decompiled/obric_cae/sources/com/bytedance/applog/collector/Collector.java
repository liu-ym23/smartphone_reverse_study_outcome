package com.bytedance.applog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import c4.m;
import d4.a;
import i4.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import r3.c;

/* JADX INFO: loaded from: classes.dex */
public class Collector extends BroadcastReceiver {
    public Collector() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        String[] r11 = r10.getStringArrayExtra("K_DATA");
        if (r11 != null) goto L5;
    L29:
        m.u().b("Collector onReceive empty", new Object[0]);
        return;
    L5:
        if (r11.length <= 0) goto L29;
        Iterator r12 = c.N.iterator();
    L8:
        if (r12.hasNext() == false) goto L42;
        c r13 = (c) r12.next();
        String[] r14 = (String[]) r11.clone();
        r13.getClass();
        if (r14.length == 0) goto L8;
        int r15 = r14.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L16;
        String r17 = r14[r16];
        r16 = r16 + 1;
        goto L13
    L16:
        if (r13.f11405m == null) goto L17;
        Handler r18 = r13.f11405m.f13947w;
        r18.removeMessages(4);
        r18.obtainMessage(4, r14).sendToTarget();
        goto L8
    L17:
        a r19 = r13.f11395c;
        LinkedList<String> r20 = r19.f6752b;
        monitor-enter(r20);
        if (r19.f6752b.size() <= r19.f6753c) goto L22;
        r19.f6754d.H.f(0, a.f6750e, "AppLogCache overflow2 remove data: {}", new Object[]{r19.f6752b.poll()});     // Catch: Throwable -> L25
        r19.f6754d.f11417y.b(k.f8270v, 1);     // Catch: Throwable -> L25
    L22:
        r19.f6752b.addAll(Arrays.asList(r14));     // Catch: Throwable -> L25
        monitor-exit(r20);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
