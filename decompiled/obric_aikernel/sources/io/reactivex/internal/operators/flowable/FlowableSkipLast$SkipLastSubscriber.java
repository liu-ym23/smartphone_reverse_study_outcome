package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSkipLast$SkipLastSubscriber<T> extends ArrayDeque<T> implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -3807491841935125653L;
    final tc.c<? super T> downstream;
    final int skip;
    tc.d upstream;

    FlowableSkipLast$SkipLastSubscriber(tc.c<? super T> r10, int r11) {
        super(r11);
        this.downstream = r10;
        this.skip = r11;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.skip != size()) goto L5;
        this.downstream.onNext(poll());
    L6:
        offer(r10);
        return;
    L5:
        this.upstream.request(1);
        goto L6
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        this.upstream.request(r10);
    }
}
