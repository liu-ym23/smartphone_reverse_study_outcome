package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17909c;
    public final SequentialDisposable d;
    public boolean e;
    public boolean f;

    public p2(mt.u r5, pt.o r10, boolean r11) {
        this.f17907a = r5;
        this.f17908b = r10;
        this.f17909c = r11;
        this.d = new SequentialDisposable();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        this.e = true;
        this.f17907a.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        boolean r10 = this.e;
        mt.u r11 = this.f17907a;
        if (r10 == true) goto L5;
        this.e = true;
        if (this.f17909c == true) goto L13;
    L25:
        mt.s r12 = (mt.s) this.f17908b.apply(r5);     // Catch: Throwable -> L22
        if (r12 != null) goto L20;
        NullPointerException r13 = new NullPointerException("Observable is null");
        r13.initCause(r5);
        r11.onError(r13);
        return;
    L20:
        r12.subscribe(this);
        return;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r11.onError(new CompositeException(new Throwable[]{r5, th}));
        return;
    L13:
        if ((r5 instanceof Exception) == true) goto L25;
        r11.onError(r5);
        return;
    L5:
        if (this.f == false) goto L8;
        wn.f.k(r5);
        return;
    L8:
        r11.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f17907a.onNext(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        this.d.replace(r5);
    }
}
