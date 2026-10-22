package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import xb.j;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeToObservable$MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements j<T> {
    private static final long serialVersionUID = 7603343402964826922L;
    io.reactivex.disposables.b upstream;

    MaybeToObservable$MaybeToObservableObserver(o<? super T> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // xb.j
    public void onComplete() {
        complete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        error(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        complete(r10);
    }
}
