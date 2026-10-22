package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSequenceEqual$EqualSubscriber<T> extends AtomicReference<tc.d> implements xb.g<T> {
    private static final long serialVersionUID = 4804128302091633067L;
    volatile boolean done;
    final int limit;
    final k parent;
    final int prefetch;
    long produced;
    volatile bc.f<T> queue;
    int sourceMode;

    FlowableSequenceEqual$EqualSubscriber(k r10, int r11) {
        this.parent = r10;
        this.limit = r11 - (r11 >> 2);
        this.prefetch = r11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    void clear() {
        bc.f<T> r10 = this.queue;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.innerError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.sourceMode == 0) goto L5;
    L8:
        this.parent.drain();
        return;
    L5:
        if (this.queue.offer(r10) == true) goto L8;
        onError(new MissingBackpressureException());
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        r10.request(this.prefetch);
    }

    public void request() {
        if (this.sourceMode == 1) goto L9;
        long r10 = this.produced + 1;
        if (r10 < this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
        return;
    L7:
        this.produced = r10;
        return;
    }
}
