package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTakeLastOne$TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements xb.g<T> {
    private static final long serialVersionUID = -5467847744262967226L;
    tc.d upstream;

    FlowableTakeLastOne$TakeLastOneSubscriber(tc.c<? super T> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        T r10 = this.value;
        if (r10 == null) goto L5;
        complete(r10);
        return;
    L5:
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.value = null;
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.value = r10;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
