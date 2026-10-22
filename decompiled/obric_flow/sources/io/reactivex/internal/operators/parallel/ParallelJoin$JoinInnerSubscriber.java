package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelJoin$JoinInnerSubscriber<T> extends AtomicReference<d> implements g {
    private static final long serialVersionUID = 8410034718427740355L;
    final int limit;
    final ParallelJoin$JoinSubscriptionBase<T> parent;
    final int prefetch;
    long produced;
    volatile rt.g queue;

    public ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase<T> r5, int r10) {
        this.parent = r5;
        this.prefetch = r10;
        this.limit = r10 - (r10 >> 2);
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    public rt.g getQueue() {
        rt.g r5 = this.queue;
        if (r5 != null) goto L6;
        SpscArrayQueue r10 = new SpscArrayQueue(this.prefetch);
        this.queue = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // zu.c
    public void onComplete() {
        this.parent.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.parent.onNext(this, r5);
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        SubscriptionHelper.setOnce(this, r5, this.prefetch);
    }

    public void request(long r5) {
        long r10 = this.produced + r5;
        if (r10 < this.limit) goto L5;
        this.produced = 0;
        get().request(r10);
        return;
    L5:
        this.produced = r10;
    }

    public void requestOne() {
        long r5 = this.produced + 1;
        if (r5 != this.limit) goto L5;
        this.produced = 0;
        get().request(r5);
        return;
    L5:
        this.produced = r5;
    }
}
