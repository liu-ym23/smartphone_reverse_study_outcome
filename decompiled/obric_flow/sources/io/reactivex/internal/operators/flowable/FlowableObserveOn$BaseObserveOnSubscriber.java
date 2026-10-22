package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableObserveOn$BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements mt.g, Runnable {
    private static final long serialVersionUID = -8241002408341274697L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final int limit;
    boolean outputFused;
    final int prefetch;
    long produced;
    rt.h queue;
    final AtomicLong requested;
    int sourceMode;
    zu.d upstream;
    final mt.y worker;

    public FlowableObserveOn$BaseObserveOnSubscriber(mt.y r5, boolean r10, int r11) {
        this.worker = r5;
        this.delayError = r10;
        this.prefetch = r11;
        this.requested = new AtomicLong();
        this.limit = r11 - (r11 >> 2);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
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

    public final boolean checkTerminated(boolean r5, boolean r10, zu.c r11) {
        if (this.cancelled == false) goto L6;
        clear();
        return true;
    L6:
        if (r5 == true) goto L8;
        return false;
    L8:
        if (this.delayError == false) goto L16;
        if (r10 == false) goto L25;
        this.cancelled = true;
        Throwable r12 = this.error;
        if (r12 == null) goto L13;
        r11.onError(r12);
    L14:
        this.worker.dispose();
        return true;
    L13:
        r11.onComplete();
        goto L14
    L25:
        return false;
    L16:
        Throwable r13 = this.error;
        if (r13 == null) goto L20;
        this.cancelled = true;
        clear();
        r11.onError(r13);
        this.worker.dispose();
        return true;
    L20:
        if (r10 == false) goto L26;
        this.cancelled = true;
        r11.onComplete();
        this.worker.dispose();
        return true;
    L26:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public final void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // zu.c
    public final void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        trySchedule();
        return;
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.error = r5;
        this.done = true;
        trySchedule();
    }

    @Override // zu.c
    public final void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.sourceMode != 2) goto L10;
        trySchedule();
        return;
    L10:
        if (this.queue.offer(r5) == true) goto L12;
        this.upstream.cancel();
        this.error = new MissingBackpressureException("Queue is full?!");
        this.done = true;
    L12:
        trySchedule();
    }

    @Override // zu.c
    public abstract /* synthetic */ void onSubscribe(zu.d r5);

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public abstract /* synthetic */ Object poll() throws Exception;

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public final void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        trySchedule();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.d
    public final int requestFusion(int r5) {
        if ((r5 & 2) == 0) goto L6;
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

    public abstract void runAsync();

    public abstract void runBackfused();

    public abstract void runSync();

    public final void trySchedule() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        this.worker.a(this);
    }
}
