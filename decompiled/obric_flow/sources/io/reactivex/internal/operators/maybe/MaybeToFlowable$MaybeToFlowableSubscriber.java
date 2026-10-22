package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeToFlowable$MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements j {
    private static final long serialVersionUID = 7603343402964826922L;
    Disposable upstream;

    public MaybeToFlowable$MaybeToFlowableSubscriber(zu.c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.dispose();
    }

    @Override // mt.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
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
