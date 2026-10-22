package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import mt.b0;

/* JADX INFO: loaded from: classes3.dex */
final class SingleToFlowable$SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements b0 {
    private static final long serialVersionUID = 187782011903685568L;
    Disposable upstream;

    public SingleToFlowable$SingleToFlowableObserver(zu.c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.dispose();
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
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
