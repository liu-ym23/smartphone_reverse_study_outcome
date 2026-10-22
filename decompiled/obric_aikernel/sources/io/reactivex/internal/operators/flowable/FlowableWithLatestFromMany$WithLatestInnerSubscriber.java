package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableWithLatestFromMany$WithLatestInnerSubscriber extends AtomicReference<tc.d> implements xb.g<Object> {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> parent;

    FlowableWithLatestFromMany$WithLatestInnerSubscriber(FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.innerError(this.index, r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        if (this.hasValue == true) goto L5;
        this.hasValue = true;
    L5:
        this.parent.innerNext(this.index, r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
