package com.bytedance.applog.monitor.v3.impl;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ Map b;

    public /* synthetic */ b(c r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r0 = this.a;
        Map r1 = this.b;
        SharedPreferences.Editor r2 = r0.d.edit();
        Map r3 = r0.c;
        monitor-enter(r3);
        Iterator r4 = r1.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r4.hasNext() == false) goto L8;
        String r5 = (String) ((Map.Entry) r4.next()).getKey();     // Catch: Throwable -> L11
        ((ConcurrentHashMap) r0.c).remove(r5);     // Catch: Throwable -> L11
        r2.remove(r5);     // Catch: Throwable -> L11
        goto L6
    L8:
        monitor-exit(r3);     // Catch: Throwable -> L11
        r2.apply();
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
