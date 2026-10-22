package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableAmb$AmbInnerSubscriber<T> extends AtomicReference<tc.d> implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -1185974347409665484L;
    final tc.c<? super T> downstream;
    final int index;
    final AtomicLong missedRequested;
    final b<T> parent;
    boolean won;

    FlowableAmb$AmbInnerSubscriber(b<T> r10, int r11, tc.c<? super T> r12) {
        this.missedRequested = new AtomicLong();
        this.index = r11;
        this.downstream = r12;
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        if (this.won == false) goto L7;
        this.downstream.onComplete();
        return;
    L7:
        throw null;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.won == false) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        throw null;
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.won == false) goto L7;
        this.downstream.onNext(r10);
        return;
    L7:
        throw null;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this, this.missedRequested, r10);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this, this.missedRequested, r10);
    }
}
