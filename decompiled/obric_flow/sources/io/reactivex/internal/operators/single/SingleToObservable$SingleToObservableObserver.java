package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import mt.b0;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class SingleToObservable$SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements b0 {
    private static final long serialVersionUID = 3786543492451018833L;
    Disposable upstream;

    public SingleToObservable$SingleToObservableObserver(u r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        error(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        complete(r5);
    }
}
