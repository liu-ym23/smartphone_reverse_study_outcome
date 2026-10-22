package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 extends FutureTask implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f9446a;

    public x0(com.airbnb.lottie.k r5) {
        super(r5);
        this.f9446a = new k0();
    }

    @Override // com.google.common.util.concurrent.w0
    public final void addListener(Runnable r5, Executor r10) {
        k0 r11 = this.f9446a;
        r11.getClass();
        com.google.common.base.b0.n(r10, "Executor was null.");
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r11.f9417b == true) goto L11;
        int r12 = 14;
        r11.f9416a = new com.google.common.reflect.w(r5, r12, r10, r11.f9416a);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
        k0.a(r5, r10);
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        k0 r5 = this.f9446a;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r5.f9417b == false) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L10:
        r5.f9417b = true;     // Catch: Throwable -> L8
        com.google.common.reflect.w r10 = r5.f9416a;     // Catch: Throwable -> L8
        com.google.common.reflect.w r11 = null;
        r5.f9416a = null;     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
    L12:
        if (r10 == null) goto L14;
        com.google.common.reflect.w r12 = (com.google.common.reflect.w) r10.d;
        r10.d = r11;
        r11 = r10;
        r10 = r12;
    L14:
        if (r11 == null) goto L22;
        k0.a((Runnable) r11.f9377c, (Executor) r11.f9376b);
        r11 = (com.google.common.reflect.w) r11.d;
        goto L14
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public final Object get(long r10, TimeUnit r11) {
        long r5 = r11.toNanos(r10);
        if (r5 > 2147483647999999999L) goto L7;
        return super.get(r10, r11);
    L7:
        return super.get(Math.min(r5, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }
}
