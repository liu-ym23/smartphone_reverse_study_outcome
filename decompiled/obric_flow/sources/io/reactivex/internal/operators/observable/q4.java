package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class q4 extends io.reactivex.internal.observers.h implements Disposable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final mt.s f17928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final pt.o f17929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f17930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final io.reactivex.disposables.a f17931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f17932l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference f17933m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f17934n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicLong f17935o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f17936p;

    public q4(io.reactivex.observers.d r5, mt.s r10, pt.o r11, int r12) {
        super(r5, new io.reactivex.internal.queue.a());
        this.f17933m = new AtomicReference();
        AtomicLong r13 = new AtomicLong();
        this.f17935o = r13;
        this.f17936p = new AtomicBoolean();
        this.f17928h = r10;
        this.f17929i = r11;
        this.f17930j = r12;
        this.f17931k = new io.reactivex.disposables.a();
        this.f17934n = new ArrayList();
        r13.lazySet(1);
    }

    @Override // io.reactivex.internal.observers.h
    public final void d(io.reactivex.observers.d r5, Object r10) {
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f17936p.compareAndSet(false, true) == false) goto L8;
        DisposableHelper.dispose(this.f17933m);
        if (this.f17935o.decrementAndGet() != 0) goto L9;
        this.f17932l.dispose();
        return;
    L9:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17936p.get();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        if (i() == false) goto L9;
        t();
    L9:
        if (this.f17935o.decrementAndGet() != 0) goto L11;
        this.f17931k.dispose();
    L11:
        this.f17639b.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.e == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f = r5;
        this.e = true;
        if (i() == false) goto L10;
        t();
    L10:
        if (this.f17935o.decrementAndGet() != 0) goto L12;
        this.f17931k.dispose();
    L12:
        this.f17639b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (j() == false) goto L11;
        Iterator r10 = this.f17934n.iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        ((io.reactivex.subjects.i) r10.next()).onNext(r5);
        goto L6
    L9:
        if (this.f17638a.addAndGet(-1) != 0) goto L14;
        return;
    L14:
        t();
        return;
    L11:
        this.f17640c.offer(NotificationLite.next(r5));
        if (i() == true) goto L14;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f17932l, r5) == false) goto L13;
        this.f17932l = r5;
        this.f17639b.onSubscribe(this);
        if (this.f17936p.get() == false) goto L7;
        return;
    L7:
        u r10 = new u(this, 1);
        AtomicReference r11 = this.f17933m;
    L9:
        if (r11.compareAndSet(null, r10) == true) goto L10;
        if (r11.get() == null) goto L9;
        return;
    L10:
        this.f17928h.subscribe(r10);
        return;
    }

    public final void t() {
        io.reactivex.internal.queue.a r5 = this.f17640c;
        io.reactivex.observers.d r10 = this.f17639b;
        ArrayList r11 = this.f17934n;
        int r12 = 1;
    L3:
        boolean r13 = this.e;
        Object r14 = r5.poll();
        if (r14 != null) goto L6;
        boolean r15 = true;
    L7:
        if (r13 == false) goto L21;
        if (r15 == false) goto L21;
        this.f17931k.dispose();
        DisposableHelper.dispose(this.f17933m);
        Throwable r16 = this.f;
        if (r16 == null) goto L15;
        Iterator r17 = r11.iterator();
    L13:
        if (r17.hasNext() == false) goto L19;
        ((io.reactivex.subjects.i) r17.next()).onError(r16);
    L19:
        r11.clear();
        return;
    L15:
        Iterator r18 = r11.iterator();
    L17:
        if (r18.hasNext() == false) goto L19;
        ((io.reactivex.subjects.i) r18.next()).onComplete();
    L21:
        if (r15 == true) goto L22;
        if ((r14 instanceof r4) == true) goto L27;
        Iterator r19 = r11.iterator();
    L47:
        if (r19.hasNext() == false) goto L3;
        ((io.reactivex.subjects.i) r19.next()).onNext(NotificationLite.getValue(r14));
        goto L47
    L27:
        r4 r20 = (r4) r14;
        io.reactivex.subjects.i r21 = r20.f17946a;
        if (r21 != null) goto L30;
        if (this.f17936p.get() == true) goto L3;
        io.reactivex.subjects.i r22 = new io.reactivex.subjects.i(this.f17930j);
        r11.add(r22);
        r10.onNext(r22);
        Object r23 = this.f17929i.apply(r20.f17947b);     // Catch: Throwable -> L43
        io.reactivex.internal.functions.e.d(r23, "The ObservableSource supplied is null");     // Catch: Throwable -> L43
        mt.s r24 = (mt.s) r23;     // Catch: Throwable -> L43
        p4 r25 = new p4(this, r22);
        if (this.f17931k.b(r25) == false) goto L3;
        this.f17935o.getAndIncrement();
        r24.subscribe(r25);
    L43:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.f17936p.set(true);
        r10.onError(th);
        goto L3
    L30:
        if (r11.remove(r21) == false) goto L3;
        r20.f17946a.onComplete();
        if (this.f17935o.decrementAndGet() != 0) goto L3;
        this.f17931k.dispose();
        DisposableHelper.dispose(this.f17933m);
        return;
    L22:
        r12 = this.f17638a.addAndGet(-r12);
        if (r12 != 0) goto L3;
        return;
    L6:
        r15 = false;
        goto L7
    }
}
