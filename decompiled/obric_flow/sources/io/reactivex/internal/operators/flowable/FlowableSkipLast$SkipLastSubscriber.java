package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSkipLast$SkipLastSubscriber<T> extends ArrayDeque<T> implements mt.g, zu.d {
    private static final long serialVersionUID = -3807491841935125653L;
    final zu.c downstream;
    final int skip;
    zu.d upstream;

    public FlowableSkipLast$SkipLastSubscriber(zu.c r5, int r10) {
        super(r10);
        this.downstream = r5;
        this.skip = r10;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.skip != size()) goto L5;
        this.downstream.onNext(poll());
    L6:
        offer(r5);
        return;
    L5:
        this.upstream.request(1);
        goto L6
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        this.upstream.request(r5);
    }
}
