package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements xb.g<T>, tc.d, Runnable {
    static final q<Object, Object> BOUNDARY_DISPOSED = null;
    static final Object NEXT_WINDOW = null;
    private static final long serialVersionUID = 2233020065421370272L;
    final AtomicReference<q<T, B>> boundarySubscriber;
    final int capacityHint;
    volatile boolean done;
    final tc.c<? super xb.e<T>> downstream;
    long emitted;
    final AtomicThrowable errors;
    final Callable<? extends tc.b<B>> other;
    final MpscLinkedQueue<Object> queue;
    final AtomicLong requested;
    final AtomicBoolean stopWindows;
    tc.d upstream;
    UnicastProcessor<T> window;
    final AtomicInteger windows;

    static {
        BOUNDARY_DISPOSED = new q(null);
        NEXT_WINDOW = new Object();
    }

    FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber(tc.c<? super xb.e<T>> r10, int r11, Callable<? extends tc.b<B>> r12) {
        this.downstream = r10;
        this.capacityHint = r11;
        this.boundarySubscriber = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.other = r12;
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
        disposeBoundary();
        if (this.windows.decrementAndGet() != 0) goto L9;
        this.upstream.cancel();
        return;
    L9:
        return;
    }

    void disposeBoundary() {
        AtomicReference<q<T, B>> r10 = this.boundarySubscriber;
        q<Object, Object> r11 = BOUNDARY_DISPOSED;
        q<T, B> r12 = r10.getAndSet((q<T, B>) r11);
        if (r12 == null) goto L7;
        if (r12 == r11) goto L8;
        r12.dispose();
        return;
    L8:
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
        if (r13 == this.requested.get()) goto L55;
        UnicastProcessor<T> r20 = UnicastProcessor.f(this.capacityHint, this);
        this.window = r20;
        this.windows.getAndIncrement();
        tc.b r21 = (tc.b) io.reactivex.internal.functions.a.d(this.other.call(), "The other Callable returned a null Publisher");     // Catch: Throwable -> L52
        q<T, B> r110 = new q(this);
        if (this.boundarySubscriber.compareAndSet(null, r110) == false) goto L7;
        r21.subscribe(r110);
        r13 = r13 + 1;
        r10.onNext(r20);
    L52:
        MissingBackpressureException th = th;
        io.reactivex.exceptions.a.a(th);
    L54:
        r12.addThrowable(th);
        this.done = true;
        goto L7
    L55:
        this.upstream.cancel();
        disposeBoundary();
        th = new MissingBackpressureException("Could not deliver a window due to lack of requests");
        goto L54
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
        Throwable r22 = r12.terminate();
        if (r15 == null) goto L17;
        this.window = null;
        r15.onError(r22);
    L17:
        r10.onError(r22);
        return;
    L8:
        r11.clear();
        this.window = null;
    }

    void innerComplete() {
        this.upstream.cancel();
        this.done = true;
        drain();
    }

    void innerError(Throwable r10) {
        this.upstream.cancel();
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    void innerNext(q<T, B> r10) {
        this.boundarySubscriber.compareAndSet(r10, null);
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // tc.c
    public void onComplete() {
        disposeBoundary();
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        disposeBoundary();
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
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        this.queue.offer(NEXT_WINDOW);
        drain();
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        io.reactivex.internal.util.b.a(this.requested, r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() != 0) goto L6;
        this.upstream.cancel();
        return;
    }
}
