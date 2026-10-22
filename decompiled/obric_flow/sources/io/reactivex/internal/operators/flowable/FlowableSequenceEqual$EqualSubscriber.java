package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSequenceEqual$EqualSubscriber<T> extends AtomicReference<zu.d> implements mt.g {
    private static final long serialVersionUID = 4804128302091633067L;
    volatile boolean done;
    final int limit;
    final t parent;
    final int prefetch;
    long produced;
    volatile rt.h queue;
    int sourceMode;

    public FlowableSequenceEqual$EqualSubscriber(t r5, int r10) {
        this.parent = r5;
        this.limit = r10 - (r10 >> 2);
        this.prefetch = r10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void clear() {
        rt.h r5 = this.queue;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.innerError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.sourceMode == 0) goto L5;
    L8:
        this.parent.drain();
        return;
    L5:
        if (this.queue.offer(r5) == true) goto L8;
        onError(new MissingBackpressureException());
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(3);
        if (r11 != 1) goto L11;
        this.sourceMode = r11;
        this.queue = r10;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = r11;
        this.queue = r10;
        r5.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        r5.request(this.prefetch);
    }

    public void request() {
        if (this.sourceMode == 1) goto L9;
        long r5 = this.produced + 1;
        if (r5 < this.limit) goto L7;
        this.produced = 0;
        get().request(r5);
        return;
    L7:
        this.produced = r5;
        return;
    }
}
