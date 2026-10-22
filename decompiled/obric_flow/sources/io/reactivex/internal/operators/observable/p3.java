package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class p3 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.u f17911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.c f17912c;
    public Object d;
    public Disposable e;
    public boolean f;

    public p3(mt.u r5, pt.c r10) {
        this.f17910a = 0;
        this.f17911b = r5;
        this.f17912c = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17910a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.e.dispose();
        return;
    L6:
        this.e.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17910a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.e.isDisposed();
    L7:
        return this.e.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17910a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.f == true) goto L14;
        this.f = true;
        this.f17911b.onComplete();
        return;
    L14:
        return;
    L10:
        if (this.f == true) goto L15;
        this.f = true;
        this.f17911b.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17910a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.f == false) goto L7;
        wn.f.k(r5);
        return;
    L7:
        this.f = true;
        this.f17911b.onError(r5);
        return;
    L10:
        if (this.f == false) goto L12;
        wn.f.k(r5);
        return;
    L12:
        this.f = true;
        this.f17911b.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17910a) {
            case 0: goto L14;
            default: goto L5;
        };
    L5:
        if (this.f == true) goto L29;
        Object r10 = this.d;
        Object r11 = this.f17912c.apply(r10, r5);     // Catch: Throwable -> L10
        io.reactivex.internal.functions.e.d(r11, "The accumulator returned a null value");     // Catch: Throwable -> L10
        this.d = r11;
        this.f17911b.onNext(r11);
        return;
    L10:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.e.dispose();
        onError(th);
        return;
    L29:
        return;
    L14:
        if (this.f == true) goto L32;
        Object r12 = this.d;
        mt.u r13 = this.f17911b;
        if (r12 != null) goto L24;
        this.d = r5;
        r13.onNext(r5);
        return;
    L24:
        Object r14 = this.f17912c.apply(r12, r5);     // Catch: Throwable -> L21
        io.reactivex.internal.functions.e.d(r14, "The value returned by the accumulator is null");     // Catch: Throwable -> L21
        this.d = r14;
        r13.onNext(r14);
        return;
    L21:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.e.dispose();
        onError(th);
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17910a) {
            case 0: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.e, r5) == false) goto L12;
        this.e = r5;
        mt.u r10 = this.f17911b;
        r10.onSubscribe(this);
        r10.onNext(this.d);
        return;
    L12:
        return;
    L9:
        if (DisposableHelper.validate(this.e, r5) == false) goto L13;
        this.e = r5;
        this.f17911b.onSubscribe(this);
        return;
    }

    public p3(mt.u r5, pt.c r10, Object r11) {
        this.f17910a = 1;
        this.f17911b = r5;
        this.f17912c = r10;
        this.d = r11;
    }
}
