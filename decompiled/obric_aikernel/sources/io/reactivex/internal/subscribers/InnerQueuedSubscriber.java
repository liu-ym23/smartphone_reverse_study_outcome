package io.reactivex.internal.subscribers;

import bc.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<d> implements g<T>, d {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final a<T> parent;
    final int prefetch;
    long produced;
    volatile f<T> queue;

    public InnerQueuedSubscriber(a<T> r10, int r11) {
        this.parent = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // tc.c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.innerError(this, r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r10);
        return;
    L5:
        this.parent.drain();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r12 != 2) goto L14;
        this.fusionMode = r12;
        this.queue = r11;
        h.f(r10, this.prefetch);
        return;
    L14:
        this.queue = h.a(this.prefetch);
        h.f(r10, this.prefetch);
    }

    public f<T> queue() {
        return this.queue;
    }

    @Override // tc.d
    public void request(long r10) {
        if (this.fusionMode == 1) goto L9;
        long r11 = this.produced + r10;
        if (r11 < this.limit) goto L7;
        this.produced = 0;
        get().request(r11);
        return;
    L7:
        this.produced = r11;
        return;
    }

    public void requestOne() {
        if (this.fusionMode == 1) goto L9;
        long r10 = this.produced + 1;
        if (r10 != this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
        return;
    L7:
        this.produced = r10;
        return;
    }

    public void setDone() {
        this.done = true;
    }
}
