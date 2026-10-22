package com.lynx.tasm.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements Runnable {
    public final Runnable a;
    public final AtomicInteger b;
    public final AtomicReference<Throwable> c;
    public final CountDownLatch d;

    public final void a() {
        if (this.b.compareAndSet(0, 1) == true) goto L13;
        return;
    L13:
        this.a.run();     // Catch: Throwable -> L6
        this.b.set(3);     // Catch: Throwable -> L6
        this.d.countDown();
        return;
    L6:
        th = move-exception;
        this.b.set(2);     // Catch: Throwable -> L9
        this.c.set(th);     // Catch: Throwable -> L9
        throw new RuntimeException(th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.d.countDown();
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(i8a.k r3) {
        this.b = new AtomicInteger(0);
        this.c = new AtomicReference(null);
        this.d = new CountDownLatch(1);
        this.a = r3;
    }
}
