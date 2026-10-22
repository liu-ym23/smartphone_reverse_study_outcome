package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends io.reactivex.observers.b implements Iterator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mt.l f17735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Semaphore f17736c;
    public final AtomicReference d;

    public c() {
        this.f17736c = new Semaphore(0);
        this.d = new AtomicReference();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        mt.l r5 = this.f17735b;
        if (r5 == null) goto L10;
        if (NotificationLite.isError(r5.f20170a) == false) goto L10;
        throw io.reactivex.internal.util.d.d(this.f17735b.b());
    L10:
        if (this.f17735b != null) goto L21;
        this.f17736c.acquire();     // Catch: InterruptedException -> L17
        mt.l r10 = (mt.l) this.d.getAndSet(null);
        this.f17735b = r10;
        if (NotificationLite.isError(r10.f20170a) == false) goto L21;
        throw io.reactivex.internal.util.d.d(r10.b());
    L17:
        e = move-exception;
        dispose();
        this.f17735b = mt.l.a(e);
        throw io.reactivex.internal.util.d.d(e);
    L21:
        return this.f17735b.c();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L13;
        Object r5 = this.f17735b.f20170a;
        if (r5 != null) goto L7;
    L9:
        r5 = null;
    L10:
        this.f17735b = null;
        return r5;
    L7:
        if (NotificationLite.isError(r5) == true) goto L9;
    L13:
        throw new NoSuchElementException();
    }

    @Override // mt.u
    public final void onComplete() {
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        wn.f.k(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        AtomicReference r10 = this.d;
        if (r10.getAndSet((mt.l) r5) != null) goto L6;
        this.f17736c.release();
        return;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read-only iterator.");
    }
}
