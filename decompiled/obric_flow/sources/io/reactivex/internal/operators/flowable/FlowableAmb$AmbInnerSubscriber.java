package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableAmb$AmbInnerSubscriber<T> extends AtomicReference<zu.d> implements mt.g, zu.d {
    private static final long serialVersionUID = -1185974347409665484L;
    final zu.c downstream;
    final int index;
    final AtomicLong missedRequested;
    final b parent;
    boolean won;

    public FlowableAmb$AmbInnerSubscriber(b r5, int r10, zu.c r11) {
        this.missedRequested = new AtomicLong();
        this.index = r10;
        this.downstream = r11;
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        if (this.won == false) goto L7;
        this.downstream.onComplete();
        return;
    L7:
        throw null;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.won == false) goto L7;
        this.downstream.onError(r5);
        return;
    L7:
        throw null;
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.won == false) goto L7;
        this.downstream.onNext(r5);
        return;
    L7:
        throw null;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this, this.missedRequested, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this, this.missedRequested, r5);
    }
}
