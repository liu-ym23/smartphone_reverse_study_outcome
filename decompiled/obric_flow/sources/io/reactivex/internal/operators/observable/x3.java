package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class x3 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.observers.d f18057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayCompositeDisposable f18058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f18059c;
    public volatile boolean d;
    public boolean e;

    public x3(io.reactivex.observers.d r5, ArrayCompositeDisposable r10) {
        this.f18057a = r5;
        this.f18058b = r10;
    }

    @Override // mt.u
    public final void onComplete() {
        this.f18058b.dispose();
        this.f18057a.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f18058b.dispose();
        this.f18057a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.e == false) goto L6;
        this.f18057a.onNext(r5);
        return;
    L6:
        if (this.d == false) goto L10;
        this.e = true;
        this.f18057a.onNext(r5);
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f18059c, r5) == false) goto L6;
        this.f18059c = r5;
        this.f18058b.setResource(0, r5);
        return;
    }
}
