package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 3240706908776709697L;
    final long bufferSize;
    volatile boolean cancelled;
    final Deque<T> deque;
    volatile boolean done;
    final tc.c<? super T> downstream;
    Throwable error;
    final zb.a onOverflow;
    final AtomicLong requested;
    final BackpressureOverflowStrategy strategy;
    tc.d upstream;

    FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber(tc.c<? super T> r10, zb.a r11, BackpressureOverflowStrategy r12, long r13) {
        this.downstream = r10;
        this.onOverflow = r11;
        this.strategy = r12;
        this.bufferSize = r13;
        this.requested = new AtomicLong();
        this.deque = new ArrayDeque();
    }

    @Override // tc.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L6;
        clear(this.deque);
        return;
    }

    void clear(Deque<T> r10) {
        monitor-enter(r10);
        r10.clear();     // Catch: Throwable -> L6
        monitor-exit(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Deque<T> r10 = this.deque;
        tc.c<? super T> r11 = this.downstream;
        int r12 = 1;
    L6:
        long r13 = this.requested.get();
        long r14 = 0;
    L8:
        if (r14 == r13) goto L34;
        if (this.cancelled == true) goto L11;
        boolean r15 = this.done;
        monitor-enter(r10);
        T r16 = r10.poll();     // Catch: Throwable -> L31
        monitor-exit(r10);     // Catch: Throwable -> L31
        if (r16 != null) goto L19;
        boolean r17 = true;
    L20:
        if (r15 == false) goto L28;
        Throwable r18 = this.error;
        if (r18 != null) goto L23;
        if (r17 == false) goto L28;
        r11.onComplete();
        return;
    L23:
        clear(r10);
        r11.onError(r18);
        return;
    L28:
        if (r17 == true) goto L34;
        r11.onNext(r16);
        r14 = r14 + 1;
        goto L8
    L19:
        r17 = false;
    L31:
        th = move-exception;
        throw th;
    L11:
        clear(r10);
        return;
    L34:
        if (r14 != r13) goto L55;
        if (this.cancelled == true) goto L37;
        boolean r19 = this.done;
        monitor-enter(r10);
        boolean r20 = r10.isEmpty();     // Catch: Throwable -> L51
        monitor-exit(r10);     // Catch: Throwable -> L51
        if (r19 == false) goto L55;
        Throwable r21 = this.error;
        if (r21 != null) goto L46;
        if (r20 == false) goto L55;
        r11.onComplete();
        return;
    L46:
        clear(r10);
        r11.onError(r21);
        return;
    L51:
        th = move-exception;
        throw th;
    L37:
        clear(r10);
        return;
    L55:
        if (r14 == 0) goto L57;
        io.reactivex.internal.util.b.e(this.requested, r14);
    L57:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L6;
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        Deque<T> r11 = this.deque;
        monitor-enter(r11);
        boolean r12 = false;
        boolean r13 = true;
        if (r11.size() != this.bufferSize) goto L17;
        int r14 = g.f9515a[this.strategy.ordinal()];     // Catch: Throwable -> L31
        if (r14 != 1) goto L12;
        r11.pollLast();     // Catch: Throwable -> L31
    L16:
        r11.offer(r10);     // Catch: Throwable -> L31
        r13 = false;
        r12 = true;
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L31
        if (r12 == false) goto L26;
        zb.a r15 = this.onOverflow;
        if (r15 == null) goto L38;
        r15.run();     // Catch: Throwable -> L24
        return;
    L24:
        MissingBackpressureException th = th;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
    L28:
        onError(th);
        return;
    L38:
        return;
    L26:
        if (r13 == false) goto L29;
        this.upstream.cancel();
        th = new MissingBackpressureException();
        goto L28
    L29:
        drain();
        return;
    L12:
        if (r14 != 2) goto L18;
        r11.poll();     // Catch: Throwable -> L31
        goto L16
    L17:
        r11.offer(r10);     // Catch: Throwable -> L31
        r13 = false;
    L31:
        th = move-exception;
        throw th;
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
