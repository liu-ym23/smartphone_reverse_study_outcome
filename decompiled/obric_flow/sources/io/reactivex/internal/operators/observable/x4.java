package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class x4 extends io.reactivex.internal.observers.h implements Disposable, Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f18060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TimeUnit f18062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final mt.y f18063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f18064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList f18065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f18066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f18067o;

    public x4(io.reactivex.observers.d r5, long r10, long r11, TimeUnit r12, mt.y r13, int r14) {
        super(r5, new io.reactivex.internal.queue.a());
        this.f18060h = r10;
        this.f18061i = r11;
        this.f18062j = r12;
        this.f18063k = r13;
        this.f18064l = r14;
        this.f18065m = new LinkedList();
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
        t();
    L5:
        this.f17639b.onComplete();
        this.f18063k.dispose();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f = r5;
        this.e = true;
        if (i() == false) goto L5;
        t();
    L5:
        this.f17639b.onError(r5);
        this.f18063k.dispose();
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (j() == false) goto L11;
        Iterator r10 = this.f18065m.iterator();
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
        this.f17640c.offer(r5);
        if (i() == true) goto L14;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r12) {
        if (DisposableHelper.validate(this.f18066n, r12) == false) goto L9;
        this.f18066n = r12;
        this.f17639b.onSubscribe(this);
        if (this.d == false) goto L7;
        return;
    L7:
        io.reactivex.subjects.i r5 = new io.reactivex.subjects.i(this.f18064l);
        this.f18065m.add(r5);
        this.f17639b.onNext(r5);
        this.f18063k.b(new z3(3, this, r5), this.f18060h, this.f18062j);
        mt.y r10 = this.f18063k;
        long r11 = this.f18061i;
        r10.c(this, r11, r11, this.f18062j);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w4 r5 = new w4(new io.reactivex.subjects.i(this.f18064l), true);
        if (this.d == true) goto L6;
        this.f17640c.offer(r5);
    L6:
        if (i() == false) goto L9;
        t();
        return;
    }

    public final void t() {
        io.reactivex.internal.queue.a r5 = this.f17640c;
        io.reactivex.observers.d r10 = this.f17639b;
        LinkedList r11 = this.f18065m;
        int r12 = 1;
    L4:
        if (this.f18067o == true) goto L5;
        boolean r13 = this.e;
        Object r14 = r5.poll();
        if (r14 != null) goto L10;
        boolean r15 = true;
    L11:
        boolean r16 = r14 instanceof w4;
        if (r13 == false) goto L27;
        if (r15 == true) goto L15;
        if (r16 == false) goto L27;
    L15:
        r5.clear();
        Throwable r17 = this.f;
        if (r17 == null) goto L21;
        Iterator r18 = r11.iterator();
    L19:
        if (r18.hasNext() == false) goto L25;
        ((io.reactivex.subjects.i) r18.next()).onError(r17);
    L25:
        this.f18063k.dispose();
        r11.clear();
        return;
    L21:
        Iterator r19 = r11.iterator();
    L23:
        if (r19.hasNext() == false) goto L25;
        ((io.reactivex.subjects.i) r19.next()).onComplete();
    L27:
        if (r15 == true) goto L28;
        if (r16 == true) goto L32;
        Iterator r20 = r11.iterator();
    L45:
        if (r20.hasNext() == false) goto L4;
        ((io.reactivex.subjects.i) r20.next()).onNext(r14);
        goto L45
    L32:
        w4 r21 = (w4) r14;
        if (r21.f18045b == true) goto L35;
        r11.remove(r21.f18044a);
        r21.f18044a.onComplete();
        if (r11.isEmpty() == false) goto L4;
        if (this.d == false) goto L4;
        this.f18067o = true;
        goto L4
    L35:
        if (this.d == true) goto L4;
        io.reactivex.subjects.i r22 = new io.reactivex.subjects.i(this.f18064l);
        r11.add(r22);
        r10.onNext(r22);
        this.f18063k.b(new z3(3, this, r22), this.f18060h, this.f18062j);
        goto L4
    L28:
        r12 = this.f17638a.addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L10:
        r15 = false;
        goto L11
    L5:
        this.f18066n.dispose();
        this.f18063k.dispose();
        r5.clear();
        r11.clear();
    }
}
