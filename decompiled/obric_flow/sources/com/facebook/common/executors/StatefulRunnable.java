package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StatefulRunnable<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f7647a;

    public StatefulRunnable() {
        this.f7647a = new AtomicInteger(0);
    }

    public abstract Object a();

    public abstract void a(Exception r5);

    public abstract void a(Object r5);

    public abstract void b(Object r5);

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7647a.compareAndSet(0, 1) == true) goto L18;
        return;
    L18:
        Object r5 = a();     // Catch: Exception -> L13
        this.f7647a.set(3);
        b(r5);     // Catch: Throwable -> L10
        a(r5);
        return;
    L10:
        th = move-exception;
        a(r5);
        throw th;
    L13:
        e = move-exception;
        this.f7647a.set(4);
        a(e);
    }
}
