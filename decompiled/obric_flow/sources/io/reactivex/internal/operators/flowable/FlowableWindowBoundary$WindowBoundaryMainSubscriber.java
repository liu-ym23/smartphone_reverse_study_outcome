package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements mt.g, zu.d, Runnable {
    static final Object NEXT_WINDOW = null;
    private static final long serialVersionUID = 2233020065421370272L;
    final y boundarySubscriber;
    final int capacityHint;
    volatile boolean done;
    final zu.c downstream;
    long emitted;
    final AtomicThrowable errors;
    final io.reactivex.internal.queue.a queue;
    final AtomicLong requested;
    final AtomicBoolean stopWindows;
    final AtomicReference<zu.d> upstream;
    io.reactivex.processors.g window;
    final AtomicInteger windows;

    static {
        NEXT_WINDOW = new Object();
    }

    public FlowableWindowBoundary$WindowBoundaryMainSubscriber(zu.c r5, int r10) {
        this.downstream = r5;
        this.capacityHint = r10;
        this.boundarySubscriber = new y(this);
        this.upstream = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new io.reactivex.internal.queue.a();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
        this.boundarySubscriber.dispose();
        if (this.windows.decrementAndGet() != 0) goto L9;
        SubscriptionHelper.cancel(this.upstream);
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        io.reactivex.internal.queue.a r10 = this.queue;
        AtomicThrowable r11 = this.errors;
        long r12 = this.emitted;
        int r13 = 1;
    L7:
        if (this.windows.get() == 0) goto L8;
        io.reactivex.processors.g r14 = this.window;
        boolean r15 = this.done;
        if (r15 == true) goto L13;
    L19:
        Object r16 = r10.poll();
        if (r16 != null) goto L22;
        boolean r17 = true;
    L23:
        if (r15 == false) goto L34;
        if (r17 == false) goto L34;
        Throwable r18 = r11.terminate();
        if (r18 != null) goto L30;
        if (r14 == null) goto L29;
        this.window = null;
        r14.onComplete();
    L29:
        r5.onComplete();
        return;
    L30:
        if (r14 == null) goto L32;
        this.window = null;
        r14.onError(r18);
    L32:
        r5.onError(r18);
        return;
    L34:
        if (r17 == true) goto L35;
        if (r16 != NEXT_WINDOW) goto L40;
        if (r14 == null) goto L44;
        this.window = null;
        r14.onComplete();
    L44:
        if (this.stopWindows.get() == true) goto L7;
        io.reactivex.processors.g r19 = new io.reactivex.processors.g(this, this.capacityHint);
        this.window = r19;
        this.windows.getAndIncrement();
        if (r12 != this.requested.get()) goto L47;
        SubscriptionHelper.cancel(this.upstream);
        this.boundarySubscriber.dispose();
        r11.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
        this.done = true;
        goto L7
    L47:
        r12 = r12 + 1;
        r5.onNext(r19);
        goto L7
    L40:
        r14.onNext(r16);
        goto L7
    L35:
        this.emitted = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L22:
        r17 = false;
        goto L23
    L13:
        if (r11.get() == null) goto L19;
        r10.clear();
        Throwable r20 = r11.terminate();
        if (r14 == null) goto L17;
        this.window = null;
        r14.onError(r20);
    L17:
        r5.onError(r20);
        return;
    L8:
        r10.clear();
        this.window = null;
    }

    public void innerComplete() {
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
    }

    public void innerError(Throwable r5) {
        SubscriptionHelper.cancel(this.upstream);
        if (this.errors.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    public void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // zu.c
    public void onComplete() {
        this.boundarySubscriber.dispose();
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.boundarySubscriber.dispose();
        if (this.errors.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.queue.offer(r5);
        drain();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this.upstream, r5, Long.MAX_VALUE);
    }

    @Override // zu.d
    public void request(long r5) {
        v0.r(this.requested, r5);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() != 0) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }
}
