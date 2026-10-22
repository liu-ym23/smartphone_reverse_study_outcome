package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableWithLatestFromMany$WithLatestInnerSubscriber extends AtomicReference<zu.d> implements mt.g {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> parent;

    public FlowableWithLatestFromMany$WithLatestInnerSubscriber(FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> r5, int r10) {
        this.parent = r5;
        this.index = r10;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.innerError(this.index, r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        if (this.hasValue == true) goto L5;
        this.hasValue = true;
    L5:
        this.parent.innerNext(this.index, r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
