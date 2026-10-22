package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = 3240706908776709697L;
    final long bufferSize;
    volatile boolean cancelled;
    final Deque<T> deque;
    volatile boolean done;
    final zu.c downstream;
    Throwable error;
    final pt.a onOverflow;
    final AtomicLong requested;
    final BackpressureOverflowStrategy strategy;
    zu.d upstream;

    public FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber(zu.c r5, pt.a r10, BackpressureOverflowStrategy r11, long r12) {
        this.downstream = r5;
        this.onOverflow = r10;
        this.strategy = r11;
        this.bufferSize = r12;
        this.requested = new AtomicLong();
        this.deque = new ArrayDeque();
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L6;
        clear(this.deque);
        return;
    }

    public void clear(Deque<T> r5) {
        monitor-enter(r5);
        r5.clear();     // Catch: Throwable -> L6
        monitor-exit(r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Deque<T> r5 = this.deque;
        zu.c r10 = this.downstream;
        int r11 = 1;
    L6:
        long r12 = this.requested.get();
        long r13 = 0;
    L8:
        if (r13 == r12) goto L34;
        if (this.cancelled == true) goto L11;
        boolean r14 = this.done;
        monitor-enter(r5);
        T r15 = r5.poll();     // Catch: Throwable -> L31
        monitor-exit(r5);     // Catch: Throwable -> L31
        if (r15 != null) goto L19;
        boolean r16 = true;
    L20:
        if (r14 == false) goto L28;
        Throwable r17 = this.error;
        if (r17 != null) goto L23;
        if (r16 == false) goto L28;
        r10.onComplete();
        return;
    L23:
        clear(r5);
        r10.onError(r17);
        return;
    L28:
        if (r16 == true) goto L34;
        r10.onNext(r15);
        r13 = r13 + 1;
        goto L8
    L19:
        r16 = false;
    L31:
        th = move-exception;
        throw th;
    L11:
        clear(r5);
        return;
    L34:
        if (r13 != r12) goto L55;
        if (this.cancelled == true) goto L37;
        boolean r18 = this.done;
        monitor-enter(r5);
        boolean r19 = r5.isEmpty();     // Catch: Throwable -> L51
        monitor-exit(r5);     // Catch: Throwable -> L51
        if (r18 == false) goto L55;
        Throwable r20 = this.error;
        if (r20 != null) goto L46;
        if (r19 == false) goto L55;
        r10.onComplete();
        return;
    L46:
        clear(r5);
        r10.onError(r20);
        return;
    L51:
        th = move-exception;
        throw th;
    L37:
        clear(r5);
        return;
    L55:
        if (r13 == 0) goto L57;
        v0.y(this.requested, r13);
    L57:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L6;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        Deque<T> r5 = this.deque;
        monitor-enter(r5);
        boolean r11 = false;
        if (r5.size() != this.bufferSize) goto L19;
        int r12 = m.f17665a[this.strategy.ordinal()];     // Catch: Throwable -> L16
        boolean r13 = true;
        if (r12 != 1) goto L12;
        r5.pollLast();     // Catch: Throwable -> L16
        r5.offer(r10);     // Catch: Throwable -> L16
    L15:
        r13 = false;
        r11 = true;
    L20:
        monitor-exit(r5);     // Catch: Throwable -> L16
        if (r11 == false) goto L28;
        pt.a r14 = this.onOverflow;
        if (r14 == null) goto L38;
        r14.run();     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
        return;
    L38:
        return;
    L28:
        if (r13 == false) goto L30;
        this.upstream.cancel();
        onError(new MissingBackpressureException());
        return;
    L30:
        drain();
        return;
    L12:
        if (r12 != 2) goto L20;
        r5.poll();     // Catch: Throwable -> L16
        r5.offer(r10);     // Catch: Throwable -> L16
        goto L15
    L19:
        r5.offer(r10);     // Catch: Throwable -> L16
        r13 = false;
    L16:
        th = move-exception;
        throw th;
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
