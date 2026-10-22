package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class w3 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayCompositeDisposable f18041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x3 f18042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.reactivex.observers.d f18043c;
    public Disposable d;

    public w3(ArrayCompositeDisposable r5, x3 r10, io.reactivex.observers.d r11) {
        this.f18041a = r5;
        this.f18042b = r10;
        this.f18043c = r11;
    }

    @Override // mt.u
    public final void onComplete() {
        this.f18042b.d = true;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f18041a.dispose();
        this.f18043c.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        this.d.dispose();
        this.f18042b.d = true;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.d, r5) == false) goto L6;
        this.d = r5;
        this.f18041a.setResource(1, r5);
        return;
    }
}
