package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableOnBackpressureLatest$BackpressureLatestSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 163080509307634843L;
    volatile boolean cancelled;
    final AtomicReference<T> current;
    volatile boolean done;
    final tc.c<? super T> downstream;
    Throwable error;
    final AtomicLong requested;
    tc.d upstream;

    FlowableOnBackpressureLatest$BackpressureLatestSubscriber(tc.c<? super T> r10) {
        this.requested = new AtomicLong();
        this.current = new AtomicReference();
        this.downstream = r10;
    }

    @Override // tc.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.current.lazySet(null);
        return;
    L9:
        return;
    }

    boolean checkTerminated(boolean r10, boolean r11, tc.c<?> r12, AtomicReference<T> r13) {
        if (this.cancelled == false) goto L6;
        r13.lazySet(null);
        return true;
    L6:
        if (r10 == false) goto L14;
        Throwable r14 = this.error;
        if (r14 == null) goto L11;
        r13.lazySet(null);
        r12.onError(r14);
        return true;
    L11:
        if (r11 == false) goto L16;
        r12.onComplete();
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super T> r10 = this.downstream;
        AtomicLong r11 = this.requested;
        AtomicReference<T> r12 = this.current;
        int r13 = 1;
    L6:
        long r14 = 0;
    L7:
        boolean r15 = false;
        if (r14 == r11.get()) goto L20;
        boolean r16 = this.done;
        T r17 = r12.getAndSet(null);
        if (r17 != null) goto L12;
        boolean r18 = true;
    L14:
        if (checkTerminated(r16, r18, r10, r12) == true) goto L15;
        if (r18 == true) goto L20;
        r10.onNext(r17);
        r14 = r14 + 1;
        goto L7
    L15:
        return;
    L12:
        r18 = false;
    L20:
        if (r14 != r11.get()) goto L28;
        boolean r19 = this.done;
        if (r12.get() != null) goto L25;
        r15 = true;
    L25:
        if (checkTerminated(r19, r15, r10, r12) == false) goto L28;
        return;
    L28:
        if (r14 == 0) goto L30;
        io.reactivex.internal.util.b.e(r11, r14);
    L30:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.current.lazySet(r10);
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

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }
}
