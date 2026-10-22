package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableOnBackpressureLatest$BackpressureLatestSubscriber<T> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = 163080509307634843L;
    volatile boolean cancelled;
    final AtomicReference<T> current;
    volatile boolean done;
    final zu.c downstream;
    Throwable error;
    final AtomicLong requested;
    zu.d upstream;

    public FlowableOnBackpressureLatest$BackpressureLatestSubscriber(zu.c r5) {
        this.requested = new AtomicLong();
        this.current = new AtomicReference();
        this.downstream = r5;
    }

    @Override // zu.d
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

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11, AtomicReference<T> r12) {
        if (this.cancelled == false) goto L6;
        r12.lazySet(null);
        return true;
    L6:
        if (r5 == false) goto L14;
        Throwable r13 = this.error;
        if (r13 == null) goto L11;
        r12.lazySet(null);
        r11.onError(r13);
        return true;
    L11:
        if (r10 == false) goto L16;
        r11.onComplete();
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        AtomicLong r10 = this.requested;
        AtomicReference<T> r11 = this.current;
        int r12 = 1;
    L6:
        long r13 = 0;
    L7:
        boolean r14 = false;
        if (r13 == r10.get()) goto L20;
        boolean r15 = this.done;
        T r16 = r11.getAndSet(null);
        if (r16 != null) goto L12;
        boolean r17 = true;
    L14:
        if (checkTerminated(r15, r17, r5, r11) == true) goto L15;
        if (r17 == true) goto L20;
        r5.onNext(r16);
        r13 = r13 + 1;
        goto L7
    L15:
        return;
    L12:
        r17 = false;
    L20:
        if (r13 != r10.get()) goto L28;
        boolean r18 = this.done;
        if (r11.get() != null) goto L25;
        r14 = true;
    L25:
        if (checkTerminated(r18, r14, r5, r11) == false) goto L28;
        return;
    L28:
        if (r13 == 0) goto L30;
        v0.y(r10, r13);
    L30:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L6;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.current.lazySet(r5);
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

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }
}
