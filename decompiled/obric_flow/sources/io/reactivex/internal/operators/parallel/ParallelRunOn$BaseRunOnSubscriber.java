package io.reactivex.internal.operators.parallel;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mt.g;
import mt.y;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements g, d, Runnable {
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
    final y worker;

    public ParallelRunOn$BaseRunOnSubscriber(int r5, SpscArrayQueue<T> r10, y r11) {
        this.requested = new AtomicLong();
        this.prefetch = r5;
        this.queue = r10;
        this.limit = r5 - (r5 >> 2);
        this.worker = r11;
    }

    @Override // zu.d
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

    @Override // zu.c
    public final void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        schedule();
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        if (this.done == false) goto L6;
        f.k(r5);
        return;
    L6:
        this.error = r5;
        this.done = true;
        schedule();
    }

    @Override // zu.c
    public final void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.queue.offer(r5) == true) goto L9;
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?!"));
        return;
    L9:
        schedule();
    }

    @Override // zu.c
    public abstract /* synthetic */ void onSubscribe(d r5);

    @Override // zu.d
    public final void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        schedule();
        return;
    }

    public final void schedule() {
        if (getAndIncrement() != 0) goto L6;
        this.worker.a(this);
        return;
    }
}
