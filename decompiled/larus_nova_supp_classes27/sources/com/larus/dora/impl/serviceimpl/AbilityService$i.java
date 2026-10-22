package com.larus.dora.impl.serviceimpl;

import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AbilityService$i implements jk4.d.d {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicReference<String> b;
    public final /* synthetic */ AtomicReference<Long> c;
    public final /* synthetic */ long d;
    public final /* synthetic */ CountDownLatch e;

    public final void a(boolean r5, String r6) {
        this.a.set(r5);
        this.b.set(r6);
        if (r5 == false) goto L5;
        this.c.set(Long.valueOf(SystemClock.elapsedRealtime() - this.d));
    L5:
        this.e.countDown();
    }

    public AbilityService$i(AtomicBoolean r1, AtomicReference<String> r2, AtomicReference<Long> r3, long r4, CountDownLatch r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
