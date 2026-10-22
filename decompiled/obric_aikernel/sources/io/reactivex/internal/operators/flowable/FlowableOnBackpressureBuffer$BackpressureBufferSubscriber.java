package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableOnBackpressureBuffer$BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements xb.g<T> {
    private static final long serialVersionUID = -2514538129242366402L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final tc.c<? super T> downstream;
    Throwable error;
    final zb.a onOverflow;
    boolean outputFused;
    final bc.e<T> queue;
    final AtomicLong requested;
    tc.d upstream;

    FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(tc.c<? super T> r10, int r11, boolean r12, boolean r13, zb.a r14) {
        this.requested = new AtomicLong();
        this.downstream = r10;
        this.onOverflow = r14;
        this.delayError = r13;
        if (r12 == false) goto L5;
        bc.e<T> r15 = new io.reactivex.internal.queue.a(r11);
    L6:
        this.queue = r15;
        return;
    L5:
        r15 = new SpscArrayQueue(r11);
        goto L6
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    boolean checkTerminated(boolean r10, boolean r11, tc.c<? super T> r12) {
        if (this.cancelled == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r10 == true) goto L8;
        return false;
    L8:
        if (this.delayError == false) goto L15;
        if (r11 == false) goto L24;
        Throwable r13 = this.error;
        if (r13 == null) goto L13;
        r12.onError(r13);
    L14:
        return true;
    L13:
        r12.onComplete();
        goto L14
    L24:
        return false;
    L15:
        Throwable r14 = this.error;
        if (r14 == null) goto L19;
        this.queue.clear();
        r12.onError(r14);
        return true;
    L19:
        if (r11 == false) goto L25;
        r12.onComplete();
        return true;
    L25:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public void clear() {
        this.queue.clear();
    }

    void drain() {
        if (getAndIncrement() != 0) goto L32;
        bc.e<T> r10 = this.queue;
        tc.c<? super T> r11 = this.downstream;
        int r12 = 1;
    L6:
        if (checkTerminated(this.done, r10.isEmpty(), r11) == true) goto L7;
        long r13 = this.requested.get();
        long r14 = 0;
    L10:
        if (r14 == r13) goto L21;
        boolean r15 = this.done;
        T r16 = r10.poll();
        if (r16 != null) goto L14;
        boolean r17 = true;
    L16:
        if (checkTerminated(r15, r17, r11) == true) goto L17;
        if (r17 == true) goto L21;
        r11.onNext(r16);
        r14 = r14 + 1;
        goto L10
    L17:
        return;
    L14:
        r17 = false;
    L21:
        if (r14 != r13) goto L26;
        if (checkTerminated(this.done, r10.isEmpty(), r11) == false) goto L26;
        return;
    L26:
        if (r14 != 0) goto L28;
    L30:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L6;
        return;
    L28:
        if (r13 == Long.MAX_VALUE) goto L30;
        this.requested.addAndGet(-r14);
        goto L30
    L7:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        if (this.outputFused == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        if (this.outputFused == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.queue.offer(r10) == true) goto L12;
        this.upstream.cancel();
        MissingBackpressureException r11 = new MissingBackpressureException("Buffer is full");
        this.onOverflow.run();     // Catch: Throwable -> L7
    L9:
        onError(r11);
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.initCause(th);
        goto L9
    L12:
        if (this.outputFused == false) goto L14;
        this.downstream.onNext(null);
        return;
    L14:
        drain();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public T poll() {
        return this.queue.poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void request(long r10) {
        if (this.outputFused == false) goto L5;
        return;
    L5:
        if (SubscriptionHelper.validate(r10) == false) goto L9;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
