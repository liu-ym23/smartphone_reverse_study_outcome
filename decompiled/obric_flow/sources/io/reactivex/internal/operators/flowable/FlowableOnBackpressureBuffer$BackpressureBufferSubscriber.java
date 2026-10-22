package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableOnBackpressureBuffer$BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements mt.g {
    private static final long serialVersionUID = -2514538129242366402L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final zu.c downstream;
    Throwable error;
    final pt.a onOverflow;
    boolean outputFused;
    final rt.g queue;
    final AtomicLong requested;
    zu.d upstream;

    public FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(zu.c r5, int r10, boolean r11, boolean r12, pt.a r13) {
        this.requested = new AtomicLong();
        this.downstream = r5;
        this.onOverflow = r13;
        this.delayError = r12;
        if (r11 == false) goto L5;
        rt.g r14 = new io.reactivex.internal.queue.b(r10);
    L6:
        this.queue = r14;
        return;
    L5:
        r14 = new SpscArrayQueue(r10);
        goto L6
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
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

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11) {
        if (this.cancelled == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r5 == true) goto L8;
        return false;
    L8:
        if (this.delayError == false) goto L15;
        if (r10 == false) goto L24;
        Throwable r12 = this.error;
        if (r12 == null) goto L13;
        r11.onError(r12);
    L14:
        return true;
    L13:
        r11.onComplete();
        goto L14
    L24:
        return false;
    L15:
        Throwable r13 = this.error;
        if (r13 == null) goto L19;
        this.queue.clear();
        r11.onError(r13);
        return true;
    L19:
        if (r10 == false) goto L25;
        r11.onComplete();
        return true;
    L25:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L32;
        rt.g r5 = this.queue;
        zu.c r10 = this.downstream;
        int r11 = 1;
    L6:
        if (checkTerminated(this.done, r5.isEmpty(), r10) == true) goto L7;
        long r12 = this.requested.get();
        long r13 = 0;
    L10:
        if (r13 == r12) goto L21;
        boolean r14 = this.done;
        Object r15 = r5.poll();
        if (r15 != null) goto L14;
        boolean r16 = true;
    L16:
        if (checkTerminated(r14, r16, r10) == true) goto L17;
        if (r16 == true) goto L21;
        r10.onNext(r15);
        r13 = r13 + 1;
        goto L10
    L17:
        return;
    L14:
        r16 = false;
    L21:
        if (r13 != r12) goto L26;
        if (checkTerminated(this.done, r5.isEmpty(), r10) == false) goto L26;
        return;
    L26:
        if (r13 != 0) goto L28;
    L30:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L6;
        return;
    L28:
        if (r12 == Long.MAX_VALUE) goto L30;
        this.requested.addAndGet(-r13);
        goto L30
    L7:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        if (this.outputFused == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        if (this.outputFused == false) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.queue.offer(r5) == true) goto L12;
        this.upstream.cancel();
        MissingBackpressureException r10 = new MissingBackpressureException("Buffer is full");
        this.onOverflow.run();     // Catch: Throwable -> L7
    L9:
        onError(r10);
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r10.initCause(th);
        goto L9
    L12:
        if (this.outputFused == false) goto L14;
        this.downstream.onNext(null);
        return;
    L14:
        drain();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public T poll() throws Exception {
        return (T) this.queue.poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void request(long r5) {
        if (this.outputFused == false) goto L5;
        return;
    L5:
        if (SubscriptionHelper.validate(r5) == false) goto L9;
        v0.r(this.requested, r5);
        drain();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.d
    public int requestFusion(int r5) {
        if ((r5 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
