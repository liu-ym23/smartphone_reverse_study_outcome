package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCount$CountSubscriber extends DeferredScalarSubscription<Long> implements xb.g<Object> {
    private static final long serialVersionUID = 4973004223787171406L;
    long count;
    tc.d upstream;

    FlowableCount$CountSubscriber(tc.c<? super Long> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        complete(Long.valueOf(this.count));
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        this.count++;
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
