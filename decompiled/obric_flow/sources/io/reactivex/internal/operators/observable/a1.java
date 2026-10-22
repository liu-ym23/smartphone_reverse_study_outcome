package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.j f17705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f17707c;
    public long d;
    public boolean e;

    public a1(mt.j r5, long r10) {
        this.f17705a = r5;
        this.f17706b = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f17707c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17707c.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.e == true) goto L6;
        this.e = true;
        this.f17705a.onComplete();
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.e == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.e = true;
        this.f17705a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.e == false) goto L5;
        return;
    L5:
        long r10 = this.d;
        if (r10 != this.f17706b) goto L9;
        this.e = true;
        this.f17707c.dispose();
        this.f17705a.onSuccess(r5);
        return;
    L9:
        this.d = r10 + 1;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f17707c, r5) == false) goto L6;
        this.f17707c = r5;
        this.f17705a.onSubscribe(this);
        return;
    }
}
