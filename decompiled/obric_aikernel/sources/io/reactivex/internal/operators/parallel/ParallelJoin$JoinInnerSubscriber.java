package io.reactivex.internal.operators.parallel;

import bc.e;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelJoin$JoinInnerSubscriber<T> extends AtomicReference<d> implements g<T> {
    private static final long serialVersionUID = 8410034718427740355L;
    final int limit;
    final ParallelJoin$JoinSubscriptionBase<T> parent;
    final int prefetch;
    long produced;
    volatile e<T> queue;

    ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase<T> r10, int r11) {
        this.parent = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    e<T> getQueue() {
        e<T> r10 = this.queue;
        if (r10 != null) goto L6;
        SpscArrayQueue r11 = new SpscArrayQueue(this.prefetch);
        this.queue = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // tc.c
    public void onComplete() {
        this.parent.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.parent.onNext(this, r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        SubscriptionHelper.setOnce(this, r10, this.prefetch);
    }

    public void request(long r10) {
        long r11 = this.produced + r10;
        if (r11 < this.limit) goto L5;
        this.produced = 0;
        get().request(r11);
        return;
    L5:
        this.produced = r11;
    }

    public void requestOne() {
        long r10 = this.produced + 1;
        if (r10 != this.limit) goto L5;
        this.produced = 0;
        get().request(r10);
        return;
    L5:
        this.produced = r10;
    }
}
