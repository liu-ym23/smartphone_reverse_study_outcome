package io.reactivex.internal.operators.parallel;

import dc.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tc.d;
import xb.g;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements g<T>, d, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    final SpscArrayQueue<T> queue;
    final AtomicLong requested;
    d upstream;
    final p.c worker;

    ParallelRunOn$BaseRunOnSubscriber(int r10, SpscArrayQueue<T> r11, p.c r12) {
        this.requested = new AtomicLong();
        this.prefetch = r10;
        this.queue = r11;
        this.limit = r10 - (r10 >> 2);
        this.worker = r12;
    }

    @Override // tc.d
    public final void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    @Override // tc.c
    public final void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        schedule();
    }

    @Override // tc.c
    public final void onError(Throwable r10) {
        if (this.done == false) goto L6;
        a.n(r10);
        return;
    L6:
        this.error = r10;
        this.done = true;
        schedule();
    }

    @Override // tc.c
    public final void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.queue.offer(r10) == true) goto L9;
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?!"));
        return;
    L9:
        schedule();
    }

    @Override // xb.g, tc.c
    public abstract /* synthetic */ void onSubscribe(d r10);

    @Override // tc.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        b.a(this.requested, r10);
        schedule();
        return;
    }

    final void schedule() {
        if (getAndIncrement() != 0) goto L6;
        this.worker.b(this);
        return;
    }
}
