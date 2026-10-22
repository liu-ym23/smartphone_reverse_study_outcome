package com.lynx.tasm.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.oui.lisitem.a f11174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f11175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f11176c;
    public final CountDownLatch d;

    public h(com.obric.oui.lisitem.a r5) {
        this.f11175b = new AtomicInteger(0);
        this.f11176c = new AtomicReference(null);
        this.d = new CountDownLatch(1);
        this.f11174a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch r5 = this.d;
        AtomicInteger r10 = this.f11175b;
        if (r10.compareAndSet(0, 1) == true) goto L17;
        return;
    L17:
        this.f11174a.run();     // Catch: Throwable -> L7
        r10.set(3);     // Catch: Throwable -> L7
        r5.countDown();
        return;
    L7:
        th = move-exception;
        r10.set(2);     // Catch: Throwable -> L11
        this.f11176c.set(th);     // Catch: Throwable -> L11
        throw new RuntimeException(th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r5.countDown();
        throw th;
    }
}
