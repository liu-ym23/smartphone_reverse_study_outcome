package com.bytedance.pia.core.utils;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f7139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f7140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f7141c;
    public volatile boolean d;

    public a() {
        this.f7139a = new AtomicReference();
        this.f7140b = new ConcurrentLinkedQueue();
        this.f7141c = new AtomicBoolean(false);
        this.d = false;
    }

    public final void a() {
        AtomicReference r5 = this.f7139a;
        if (r5.get() == null) goto L20;
        AtomicBoolean r10 = this.f7141c;
        if (r10.compareAndSet(false, true) == false) goto L19;
    L7:
        ConcurrentLinkedQueue r11 = this.f7140b;
        if (r11.isEmpty() == true) goto L12;
        Object r12 = r11.poll();
        if (r12 == null) goto L7;
        ((fh.a) r5.get()).accept(r12);
        goto L7
    L12:
        r10.set(false);
        return;
    L19:
        return;
    }

    public final void b(fh.a r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        AtomicReference r10 = this.f7139a;
    L7:
        if (r10.compareAndSet(null, r5) == true) goto L11;
        if (r10.get() == null) goto L7;
    L11:
        a();
    }

    public final void c(Object r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        this.f7140b.offer(r5);
        a();
    }
}
