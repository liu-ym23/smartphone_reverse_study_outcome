package com.bumptech.glide.load.engine;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.request.d f1562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1563c;

    public /* synthetic */ t(w r5, com.bumptech.glide.request.d r10, int r11) {
        this.f1561a = r11;
        this.f1563c = r5;
        this.f1562b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f1561a) {
            case 0: goto L28;
            default: goto L4;
        };
    L4:
        com.bumptech.glide.request.d r5 = this.f1562b;
        r5.f1686b.b();
        Object r10 = r5.f1687c;
        monitor-enter(r10);
        w r11 = this.f1563c;     // Catch: Throwable -> L22
        monitor-enter(r11);     // Catch: Throwable -> L22
        v r12 = this.f1563c.f1569a;     // Catch: Throwable -> L13
        com.bumptech.glide.request.d r13 = this.f1562b;     // Catch: Throwable -> L13
        r12.getClass();     // Catch: Throwable -> L13
        u r14 = new u(r13, q0.e.f21452b);     // Catch: Throwable -> L13
        if (((ArrayList) r12.f1567b).contains(r14) == false) goto L18;
        this.f1563c.s.b();     // Catch: Throwable -> L13
        w r15 = this.f1563c;     // Catch: Throwable -> L13
        com.bumptech.glide.request.d r16 = this.f1562b;     // Catch: Throwable -> L13
        r15.getClass();     // Catch: Throwable -> L13
        r16.j(r15.s, r15.f1579o);     // Catch: Throwable -> L15
        this.f1563c.h(this.f1562b);     // Catch: Throwable -> L13
        goto L18
    L15:
        th = move-exception;
        throw new CallbackException(th);     // Catch: Throwable -> L13
    L18:
        this.f1563c.d();     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L28:
        com.bumptech.glide.request.d r17 = this.f1562b;
        r17.f1686b.b();
        Object r18 = r17.f1687c;
        monitor-enter(r18);
        w r19 = this.f1563c;     // Catch: Throwable -> L46
        monitor-enter(r19);     // Catch: Throwable -> L46
        v r20 = this.f1563c.f1569a;     // Catch: Throwable -> L40
        com.bumptech.glide.request.d r21 = this.f1562b;     // Catch: Throwable -> L40
        r20.getClass();     // Catch: Throwable -> L40
        u r22 = new u(r21, q0.e.f21452b);     // Catch: Throwable -> L40
        if (((ArrayList) r20.f1567b).contains(r22) == false) goto L42;
        w r23 = this.f1563c;     // Catch: Throwable -> L40
        com.bumptech.glide.request.d r24 = this.f1562b;     // Catch: Throwable -> L40
        r23.getClass();     // Catch: Throwable -> L40
        r24.i(r23.f1581q, 5);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw new CallbackException(th);     // Catch: Throwable -> L40
    L42:
        this.f1563c.d();     // Catch: Throwable -> L40
        monitor-exit(r19);     // Catch: Throwable -> L40
        monitor-exit(r18);     // Catch: Throwable -> L46
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }
}
