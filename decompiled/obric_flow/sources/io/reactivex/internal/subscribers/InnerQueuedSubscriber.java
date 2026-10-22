package io.reactivex.internal.subscribers;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import rt.e;
import rt.h;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<d> implements g, d {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final a parent;
    final int prefetch;
    long produced;
    volatile h queue;

    public InnerQueuedSubscriber(a r5, int r10) {
        this.parent = r5;
        this.prefetch = r10;
        this.limit = r10 - (r10 >> 2);
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // zu.c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.innerError(this, r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r5);
        return;
    L5:
        this.parent.drain();
    }

    @Override // zu.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == false) goto L28;
        long r5 = Long.MAX_VALUE;
        if ((r10 instanceof e) == false) goto L18;
        e r11 = (e) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r12 != 2) goto L18;
        this.fusionMode = r12;
        this.queue = r11;
        int r13 = this.prefetch;
        if (r13 < 0) goto L16;
        r5 = r13;
    L16:
        r10.request(r5);
        return;
    L18:
        int r14 = this.prefetch;
        if (r14 >= 0) goto L21;
        h r15 = new b(-r14);
    L22:
        this.queue = r15;
        int r16 = this.prefetch;
        if (r16 < 0) goto L26;
        r5 = r16;
    L26:
        r10.request(r5);
        return;
    L21:
        r15 = new SpscArrayQueue(r14);
        goto L22
    }

    public h queue() {
        return this.queue;
    }

    @Override // zu.d
    public void request(long r5) {
        if (this.fusionMode == 1) goto L9;
        long r10 = this.produced + r5;
        if (r10 < this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
        return;
    L7:
        this.produced = r10;
        return;
    }

    public void requestOne() {
        if (this.fusionMode == 1) goto L9;
        long r5 = this.produced + 1;
        if (r5 != this.limit) goto L7;
        this.produced = 0;
        get().request(r5);
        return;
    L7:
        this.produced = r5;
        return;
    }

    public void setDone() {
        this.done = true;
    }
}
