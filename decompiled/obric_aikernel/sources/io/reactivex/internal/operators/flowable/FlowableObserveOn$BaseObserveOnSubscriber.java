package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableObserveOn$BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements xb.g<T>, Runnable {
    private static final long serialVersionUID = -8241002408341274697L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final int limit;
    boolean outputFused;
    final int prefetch;
    long produced;
    bc.f<T> queue;
    final AtomicLong requested;
    int sourceMode;
    tc.d upstream;
    final xb.p.c worker;

    FlowableObserveOn$BaseObserveOnSubscriber(xb.p.c r10, boolean r11, int r12) {
        this.worker = r10;
        this.delayError = r11;
        this.prefetch = r12;
        this.requested = new AtomicLong();
        this.limit = r12 - (r12 >> 2);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public final void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    }

    final boolean checkTerminated(boolean r10, boolean r11, tc.c<?> r12) {
        if (this.cancelled == false) goto L6;
        clear();
        return true;
    L6:
        if (r10 == true) goto L8;
        return false;
    L8:
        if (this.delayError == false) goto L15;
        if (r11 == false) goto L24;
        this.cancelled = true;
        Throwable r13 = this.error;
        if (r13 != null) goto L18;
    L21:
        r12.onComplete();
    L13:
        this.worker.dispose();
        return true;
    L18:
        r12.onError(r13);
        goto L13
    L24:
        return false;
    L15:
        r13 = this.error;
        if (r13 == null) goto L19;
        this.cancelled = true;
        clear();
        goto L18
    L19:
        if (r11 == false) goto L25;
        this.cancelled = true;
        goto L21
    L25:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public final void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // tc.c
    public final void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        trySchedule();
        return;
    }

    @Override // tc.c
    public final void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.error = r10;
        this.done = true;
        trySchedule();
    }

    @Override // tc.c
    public final void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.sourceMode != 2) goto L10;
        trySchedule();
        return;
    L10:
        if (this.queue.offer(r10) == true) goto L12;
        this.upstream.cancel();
        this.error = new MissingBackpressureException("Queue is full?!");
        this.done = true;
    L12:
        trySchedule();
    }

    @Override // xb.g, tc.c
    public abstract /* synthetic */ void onSubscribe(tc.d r10);

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public abstract /* synthetic */ T poll();

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        trySchedule();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
    public final int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.outputFused == false) goto L6;
        runBackfused();
        return;
    L6:
        if (this.sourceMode != 1) goto L8;
        runSync();
        return;
    L8:
        runAsync();
    }

    abstract void runAsync();

    abstract void runBackfused();

    abstract void runSync();

    final void trySchedule() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        this.worker.b(this);
    }
}
