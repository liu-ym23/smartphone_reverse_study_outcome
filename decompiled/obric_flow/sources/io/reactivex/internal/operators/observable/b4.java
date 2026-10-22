package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class b4 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f17734c;
    public long d;

    public b4(mt.u r5, long r10) {
        this.f17732a = r5;
        this.d = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f17734c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17734c.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f17733b == true) goto L6;
        this.f17733b = true;
        this.f17734c.dispose();
        this.f17732a.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.f17733b == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f17733b = true;
        this.f17734c.dispose();
        this.f17732a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        if (this.f17733b == true) goto L14;
        long r5 = this.d;
        long r11 = r5 - 1;
        this.d = r11;
        if (r5 > 0) goto L7;
        return;
    L7:
        if (r11 != 0) goto L9;
        boolean r12 = true;
    L10:
        this.f17732a.onNext(r10);
        if (r12 == false) goto L16;
        onComplete();
        return;
    L16:
        return;
    L9:
        r12 = false;
        goto L10
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f17734c, r5) == false) goto L9;
        this.f17734c = r5;
        long r10 = this.d;
        mt.u r11 = this.f17732a;
        if (r10 != 0) goto L7;
        this.f17733b = true;
        r5.dispose();
        EmptyDisposable.complete(r11);
        return;
    L7:
        r11.onSubscribe(this);
        return;
    }
}
