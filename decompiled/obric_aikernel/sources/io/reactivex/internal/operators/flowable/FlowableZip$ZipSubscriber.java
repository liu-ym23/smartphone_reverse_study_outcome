package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableZip$ZipSubscriber<T, R> extends AtomicReference<tc.d> implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -4627193790118206028L;
    volatile boolean done;
    final int limit;
    final FlowableZip$ZipCoordinator<T, R> parent;
    final int prefetch;
    long produced;
    bc.f<T> queue;
    int sourceMode;

    FlowableZip$ZipSubscriber(FlowableZip$ZipCoordinator<T, R> r10, int r11) {
        this.parent = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.error(this, r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.sourceMode == 2) goto L5;
        this.queue.offer(r10);
    L5:
        this.parent.drain();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(7);
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

    @Override // tc.d
    public void request(long r10) {
        if (this.sourceMode == 1) goto L9;
        long r11 = this.produced + r10;
        if (r11 < this.limit) goto L7;
        this.produced = 0;
        get().request(r11);
        return;
    L7:
        this.produced = r11;
        return;
    }
}
