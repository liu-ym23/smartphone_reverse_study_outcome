package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements xb.g<T>, tc.d, Runnable {
    static final Object NEXT_WINDOW = null;
    private static final long serialVersionUID = 2233020065421370272L;
    final p<T, B> boundarySubscriber;
    final int capacityHint;
    volatile boolean done;
    final tc.c<? super xb.e<T>> downstream;
    long emitted;
    final AtomicThrowable errors;
    final MpscLinkedQueue<Object> queue;
    final AtomicLong requested;
    final AtomicBoolean stopWindows;
    final AtomicReference<tc.d> upstream;
    UnicastProcessor<T> window;
    final AtomicInteger windows;

    static {
        NEXT_WINDOW = new Object();
    }

    FlowableWindowBoundary$WindowBoundaryMainSubscriber(tc.c<? super xb.e<T>> r10, int r11) {
        this.downstream = r10;
        this.capacityHint = r11;
        this.boundarySubscriber = new p(this);
        this.upstream = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
        this.boundarySubscriber.dispose();
        if (this.windows.decrementAndGet() != 0) goto L9;
        SubscriptionHelper.cancel(this.upstream);
        return;
    L9:
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super xb.e<T>> r10 = this.downstream;
        MpscLinkedQueue<Object> r11 = this.queue;
        AtomicThrowable r12 = this.errors;
        long r13 = this.emitted;
        int r14 = 1;
    L7:
        if (this.windows.get() == 0) goto L8;
        UnicastProcessor<T> r15 = this.window;
        boolean r16 = this.done;
        if (r16 == true) goto L13;
    L19:
        Object r17 = r11.poll();
        if (r17 != null) goto L22;
        boolean r18 = true;
    L23:
        if (r16 == false) goto L34;
        if (r18 == false) goto L34;
        Throwable r19 = r12.terminate();
        if (r19 != null) goto L30;
        if (r15 == null) goto L29;
        this.window = null;
        r15.onComplete();
    L29:
        r10.onComplete();
        return;
    L30:
        if (r15 == null) goto L32;
        this.window = null;
        r15.onError(r19);
    L32:
        r10.onError(r19);
        return;
    L34:
        if (r18 == true) goto L35;
        if (r17 != NEXT_WINDOW) goto L40;
        if (r15 == null) goto L44;
        this.window = null;
        r15.onComplete();
    L44:
        if (this.stopWindows.get() == true) goto L7;
        UnicastProcessor<T> r20 = UnicastProcessor.f(this.capacityHint, this);
        this.window = r20;
        this.windows.getAndIncrement();
        if (r13 != this.requested.get()) goto L47;
        SubscriptionHelper.cancel(this.upstream);
        this.boundarySubscriber.dispose();
        r12.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
        this.done = true;
        goto L7
    L47:
        r13 = r13 + 1;
        r10.onNext(r20);
        goto L7
    L40:
        r15.onNext((T) r17);
        goto L7
    L35:
        this.emitted = r13;
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L7;
        return;
    L22:
        r18 = false;
        goto L23
    L13:
        if (r12.get() == null) goto L19;
        r11.clear();
        Throwable r21 = r12.terminate();
        if (r15 == null) goto L17;
        this.window = null;
        r15.onError(r21);
    L17:
        r10.onError(r21);
        return;
    L8:
        r11.clear();
        this.window = null;
    }

    void innerComplete() {
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
    }

    void innerError(Throwable r10) {
        SubscriptionHelper.cancel(this.upstream);
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // tc.c
    public void onComplete() {
        this.boundarySubscriber.dispose();
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.boundarySubscriber.dispose();
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this.upstream, r10, Long.MAX_VALUE);
    }

    @Override // tc.d
    public void request(long r10) {
        io.reactivex.internal.util.b.a(this.requested, r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() != 0) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }
}
