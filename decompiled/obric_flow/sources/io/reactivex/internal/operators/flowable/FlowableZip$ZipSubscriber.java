package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableZip$ZipSubscriber<T, R> extends AtomicReference<zu.d> implements mt.g, zu.d {
    private static final long serialVersionUID = -4627193790118206028L;
    volatile boolean done;
    final int limit;
    final FlowableZip$ZipCoordinator<T, R> parent;
    final int prefetch;
    long produced;
    rt.h queue;
    int sourceMode;

    public FlowableZip$ZipSubscriber(FlowableZip$ZipCoordinator<T, R> r5, int r10) {
        this.parent = r5;
        this.prefetch = r10;
        this.limit = r10 - (r10 >> 2);
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.error(this, r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.sourceMode == 2) goto L5;
        this.queue.offer(r5);
    L5:
        this.parent.drain();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(7);
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

    @Override // zu.d
    public void request(long r5) {
        if (this.sourceMode == 1) goto L9;
        long r10 = this.produced + r5;
        if (r10 < this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
        return;
    L7:
        this.produced = r10;
        return;
    }
}
