package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLogDefaultLoggingDelegate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseConsumer<T> implements Consumer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8255a;

    public BaseConsumer() {
        this.f8255a = false;
    }

    public static boolean a(int r5) {
        if ((r5 & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract void b();

    public abstract void b(float r5);

    public abstract void b(Object r5, int r10);

    public abstract void b(Throwable r5);

    public static boolean a(int r5, int r10) {
        if ((r5 & r10) != r10) goto L6;
        return true;
    L6:
        return false;
    }

    public final synchronized void a(Object r5, int r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f8255a == true) goto L14;
        this.f8255a = a(r10);     // Catch: Throwable -> L10
        b(r5, r10);     // Catch: Throwable -> L10 Exception -> L12
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        a(e);     // Catch: Throwable -> L10
    L14:
        monitor-exit(this);
    }

    public final synchronized void a(Throwable r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f8255a == true) goto L14;
        this.f8255a = true;     // Catch: Throwable -> L10
        b(r5);     // Catch: Throwable -> L10 Exception -> L12
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        a(e);     // Catch: Throwable -> L10
    L14:
        monitor-exit(this);
    }

    public final synchronized void a() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f8255a == true) goto L14;
        this.f8255a = true;     // Catch: Throwable -> L10
        b();     // Catch: Throwable -> L10 Exception -> L12
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        a(e);     // Catch: Throwable -> L10
    L14:
        monitor-exit(this);
    }

    public final synchronized void a(float r5) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f8255a == false) goto L17;
    L13:
        monitor-exit(this);
        return;
    L17:
        b(r5);     // Catch: Throwable -> L9 Exception -> L11
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        a(e);     // Catch: Throwable -> L9
        goto L13
    }

    public final void a(Exception r5) {
        Class<?> r10 = getClass();
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L6;
        FLogDefaultLoggingDelegate.a(6, r10.getSimpleName(), "unhandled exception", r5);
        return;
    }
}
