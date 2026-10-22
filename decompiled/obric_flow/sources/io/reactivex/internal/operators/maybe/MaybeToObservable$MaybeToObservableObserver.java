package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import mt.j;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeToObservable$MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements j {
    private static final long serialVersionUID = 7603343402964826922L;
    Disposable upstream;

    public MaybeToObservable$MaybeToObservableObserver(u r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // mt.j
    public void onComplete() {
        complete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        error(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        complete(r5);
    }
}
