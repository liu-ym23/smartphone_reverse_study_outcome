package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCombineLatest$CombineLatestInnerSubscriber<T> extends AtomicReference<zu.d> implements mt.g {
    private static final long serialVersionUID = -8730235182291002949L;
    final int index;
    final int limit;
    final FlowableCombineLatest$CombineLatestCoordinator<T, ?> parent;
    final int prefetch;
    int produced;

    public FlowableCombineLatest$CombineLatestInnerSubscriber(FlowableCombineLatest$CombineLatestCoordinator<T, ?> r5, int r10, int r11) {
        this.parent = r5;
        this.index = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.innerError(this.index, r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.parent.innerValue(this.index, r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, this.prefetch);
    }

    public void requestOne() {
        int r5 = this.produced + 1;
        if (r5 != this.limit) goto L5;
        this.produced = 0;
        get().request(r5);
        return;
    L5:
        this.produced = r5;
    }
}
