package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class u4 extends io.reactivex.internal.observers.h implements Disposable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f17989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeUnit f17990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final mt.z f17991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f17993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f17994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final mt.y f17995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f17996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f17997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f17998q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public io.reactivex.subjects.i f17999r;
    public volatile boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicReference f18000t;

    public u4(io.reactivex.observers.d r5, long r10, TimeUnit r11, mt.z r12, int r13, long r14, boolean r15) {
        super(r5, new io.reactivex.internal.queue.a());
        this.f18000t = new AtomicReference();
        this.f17989h = r10;
        this.f17990i = r11;
        this.f17991j = r12;
        this.f17992k = r13;
        this.f17994m = r14;
        this.f17993l = r15;
        if (r15 == false) goto L5;
        this.f17995n = r12.a();
        return;
    L5:
        this.f17995n = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.d = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // mt.u
    public final void onComplete() {
        this.e = true;
        if (i() == false) goto L5;
        u();
    L5:
        this.f17639b.onComplete();
        t();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f = r5;
        this.e = true;
        if (i() == false) goto L5;
        u();
    L5:
        this.f17639b.onError(r5);
        t();
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        if (this.s == false) goto L6;
        return;
    L6:
        if (j() == false) goto L16;
        io.reactivex.subjects.i r5 = this.f17999r;
        r5.onNext(r10);
        long r11 = this.f17996o + 1;
        if (r11 < this.f17994m) goto L12;
        this.f17997p++;
        this.f17996o = 0;
        r5.onComplete();
        io.reactivex.subjects.i r12 = new io.reactivex.subjects.i(this.f17992k);
        this.f17999r = r12;
        this.f17639b.onNext(r12);
        if (this.f17993l == false) goto L14;
        ((Disposable) this.f18000t.get()).dispose();
        mt.y r13 = this.f17995n;
        t4 r14 = new t4(this.f17997p, this);
        long r15 = this.f17989h;
        DisposableHelper.replace(this.f18000t, r13.c(r14, r15, r15, this.f17990i));
    L14:
        if (this.f17638a.addAndGet(-1) != 0) goto L19;
        return;
    L19:
        u();
        return;
    L12:
        this.f17996o = r11;
        goto L14
    L16:
        this.f17640c.offer(NotificationLite.next(r10));
        if (i() == true) goto L19;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.f17998q, r10) == false) goto L13;
        this.f17998q = r10;
        io.reactivex.observers.d r11 = this.f17639b;
        r11.onSubscribe(this);
        if (this.d == false) goto L7;
        return;
    L7:
        io.reactivex.subjects.i r5 = new io.reactivex.subjects.i(this.f17992k);
        this.f17999r = r5;
        r11.onNext(r5);
        t4 r12 = new t4(this.f17997p, this);
        if (this.f17993l == false) goto L10;
        mt.y r13 = this.f17995n;
        long r14 = this.f17989h;
        Disposable r15 = r13.c(r12, r14, r14, this.f17990i);
    L11:
        DisposableHelper.replace(this.f18000t, r15);
        return;
    L10:
        mt.z r16 = this.f17991j;
        long r17 = this.f17989h;
        r15 = r16.e(r12, r17, r17, this.f17990i);
        goto L11
    }

    public final void t() {
        DisposableHelper.dispose(this.f18000t);
        mt.y r5 = this.f17995n;
        if (r5 == null) goto L6;
        r5.dispose();
        return;
    }

    public final void u() {
        io.reactivex.internal.queue.a r5 = this.f17640c;
        io.reactivex.observers.d r10 = this.f17639b;
        io.reactivex.subjects.i r11 = this.f17999r;
        int r12 = 1;
    L4:
        if (this.s == true) goto L5;
        boolean r13 = this.e;
        Object r14 = r5.poll();
        if (r14 != null) goto L10;
        boolean r15 = true;
    L11:
        boolean r16 = r14 instanceof t4;
        if (r13 == false) goto L20;
        if (r15 == true) goto L15;
        if (r16 == false) goto L20;
    L15:
        this.f17999r = null;
        r5.clear();
        t();
        Throwable r17 = this.f;
        if (r17 == null) goto L18;
        r11.onError(r17);
        return;
    L18:
        r11.onComplete();
        return;
    L20:
        if (r15 == true) goto L21;
        if (r16 == true) goto L26;
        r11.onNext(NotificationLite.getValue(r14));
        long r18 = this.f17996o + 1;
        if (r18 >= this.f17994m) goto L34;
        this.f17996o = r18;
        goto L4
    L34:
        this.f17997p++;
        this.f17996o = 0;
        r11.onComplete();
        io.reactivex.subjects.i r19 = new io.reactivex.subjects.i(this.f17992k);
        this.f17999r = r19;
        this.f17639b.onNext(r19);
        if (this.f17993l == true) goto L36;
    L31:
        r11 = r19;
        goto L4
    L36:
        Disposable r20 = (Disposable) this.f18000t.get();
        r20.dispose();
        mt.y r21 = this.f17995n;
        t4 r22 = new t4(this.f17997p, this);
        long r110 = this.f17989h;
        Disposable r23 = r21.c(r22, r110, r110, this.f17990i);
        AtomicReference r24 = this.f18000t;
    L38:
        if (r24.compareAndSet(r20, r23) == true) goto L31;
        if (r24.get() == r20) goto L38;
        r23.dispose();
        goto L31
    L26:
        t4 r25 = (t4) r14;
        if (this.f17993l == true) goto L30;
        if (this.f17997p != r25.f17978a) goto L4;
    L30:
        r11.onComplete();
        this.f17996o = 0;
        r19 = new io.reactivex.subjects.i(this.f17992k);
        this.f17999r = r19;
        r10.onNext(r19);
        goto L31
    L21:
        r12 = this.f17638a.addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L10:
        r15 = false;
        goto L11
    L5:
        this.f17998q.dispose();
        r5.clear();
        t();
    }
}
