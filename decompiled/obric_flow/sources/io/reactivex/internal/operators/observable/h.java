package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f17794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.n f17795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17796c;
    public boolean d;
    public boolean e;
    public Throwable f;
    public boolean g;

    public h(mt.n r5, i r10) {
        this.d = true;
        this.e = true;
        this.f17795b = r5;
        this.f17794a = r10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Throwable r5 = this.f;
        if (r5 != null) goto L33;
        if (this.d == true) goto L8;
        return false;
    L8:
        if (this.e == false) goto L31;
        boolean r10 = this.g;
        i r11 = this.f17794a;
        AtomicInteger r12 = r11.f17807c;
        if (r10 == true) goto L34;
        this.g = true;
        r12.set(1);
        new j0(this.f17795b, 5).subscribe(r11);
    L34:
        r12.set(1);     // Catch: InterruptedException -> L27
        mt.l r13 = (mt.l) r11.f17806b.take();     // Catch: InterruptedException -> L27
        boolean r14 = r13.c();
        Object r15 = r13.f20170a;
        if (r14 == false) goto L22;
        this.e = false;
        if (r15 != null) goto L18;
    L20:
        r15 = null;
    L21:
        this.f17796c = r15;
        goto L31
    L18:
        if (NotificationLite.isError(r15) == true) goto L20;
    L22:
        this.d = false;
        if (r15 == null) goto L36;
        Throwable r16 = r13.b();
        this.f = r16;
        throw io.reactivex.internal.util.d.d(r16);
    L36:
        return false;
    L27:
        e = move-exception;
        r11.dispose();
        this.f = e;
        throw io.reactivex.internal.util.d.d(e);
    L31:
        return true;
    L33:
        throw io.reactivex.internal.util.d.d(r5);
    }

    @Override // java.util.Iterator
    public final Object next() {
        Throwable r5 = this.f;
        if (r5 != null) goto L11;
        if (hasNext() == false) goto L9;
        this.e = true;
        return this.f17796c;
    L9:
        throw new NoSuchElementException("No more elements");
    L11:
        throw io.reactivex.internal.util.d.d(r5);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read only iterator");
    }
}
