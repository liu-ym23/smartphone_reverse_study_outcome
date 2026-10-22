package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTakeLastOne$TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements mt.g {
    private static final long serialVersionUID = -5467847744262967226L;
    zu.d upstream;

    public FlowableTakeLastOne$TakeLastOneSubscriber(zu.c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        T r5 = this.value;
        if (r5 == null) goto L5;
        complete(r5);
        return;
    L5:
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.value = null;
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.value = r5;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }
}
