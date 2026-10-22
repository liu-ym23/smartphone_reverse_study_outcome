package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import mt.g;
import rt.e;
import rt.h;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelFromPublisher$ParallelDispatcher<T> extends AtomicInteger implements g {
    private static final long serialVersionUID = -4470634016609963609L;
    volatile boolean cancelled;
    volatile boolean done;
    final long[] emissions;
    Throwable error;
    int index;
    final int limit;
    final int prefetch;
    int produced;
    h queue;
    final AtomicLongArray requests;
    int sourceMode;
    final AtomicInteger subscriberCount;
    final c[] subscribers;
    d upstream;

    public ParallelFromPublisher$ParallelDispatcher(c[] r5, int r10) {
        this.subscriberCount = new AtomicInteger();
        this.subscribers = r5;
        this.prefetch = r10;
        this.limit = r10 - (r10 >> 2);
        int r11 = r5.length;
        int r12 = r11 + r11;
        AtomicLongArray r13 = new AtomicLongArray(r12 + 1);
        this.requests = r13;
        r13.lazySet(r12, r11);
        this.emissions = new long[r11];
    }

    public void cancel(int r5) {
        if (this.requests.decrementAndGet(r5) != 0) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.sourceMode != 1) goto L8;
        drainSync();
        return;
    L8:
        drainAsync();
    }

    public void drainAsync() {
        h r5 = this.queue;
        c[] r10 = this.subscribers;
        AtomicLongArray r11 = this.requests;
        long[] r12 = this.emissions;
        int r13 = r12.length;
        int r14 = this.index;
        int r15 = this.produced;
        int r16 = 1;
    L3:
        int r17 = 0;
        int r18 = 0;
    L5:
        if (this.cancelled == true) goto L6;
        boolean r19 = this.done;
        if (r19 == false) goto L16;
        Throwable r110 = this.error;
        if (r110 == null) goto L16;
        r5.clear();
        int r20 = r10.length;
    L13:
        if (r17 >= r20) goto L15;
        r10[r17].onError(r110);
        r17 = r17 + 1;
        goto L13
    L15:
        return;
    L16:
        boolean r111 = r5.isEmpty();
        if (r19 == false) goto L23;
        if (r111 == false) goto L23;
        int r21 = r10.length;
    L20:
        if (r17 >= r21) goto L22;
        r10[r17].onComplete();
        r17 = r17 + 1;
        goto L20
    L22:
        return;
    L23:
        if (r111 == true) goto L46;
        long r112 = r11.get(r14);
        long r113 = r12[r14];
        if (r112 != r113) goto L28;
    L41:
        r18 = r18 + 1;
    L42:
        r14 = r14 + 1;
        if (r14 != r13) goto L45;
        r14 = 0;
    L45:
        if (r18 != r13) goto L5;
    L28:
        if (r11.get(r13 + r14) != 0) goto L41;
        Object r114 = r5.poll();     // Catch: Throwable -> L36
        if (r114 == null) goto L46;
        r10[r14].onNext(r114);
        r12[r14] = r113 + 1;
        r15 = r15 + 1;
        if (r15 != this.limit) goto L35;
        this.upstream.request(r15);
        r15 = 0;
    L35:
        r18 = 0;
    L36:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        int r22 = r10.length;
    L38:
        if (r17 >= r22) goto L40;
        r10[r17].onError(th);
        r17 = r17 + 1;
        goto L38
    L40:
        return;
    L46:
        int r115 = get();
        if (r115 == r16) goto L48;
        r16 = r115;
        goto L3
    L48:
        this.index = r14;
        this.produced = r15;
        r16 = addAndGet(-r16);
        if (r16 != 0) goto L3;
        return;
    L6:
        r5.clear();
    }

    public void drainSync() {
        h r5 = this.queue;
        c[] r10 = this.subscribers;
        AtomicLongArray r11 = this.requests;
        long[] r12 = this.emissions;
        int r13 = r12.length;
        int r14 = this.index;
        int r15 = 1;
    L3:
        int r16 = 0;
        int r17 = 0;
    L5:
        if (this.cancelled == true) goto L6;
        if (r5.isEmpty() == true) goto L10;
        long r18 = r11.get(r14);
        long r19 = r12[r14];
        if (r18 != r19) goto L17;
    L30:
        r17 = r17 + 1;
    L31:
        r14 = r14 + 1;
        if (r14 != r13) goto L34;
        r14 = 0;
    L34:
        if (r17 != r13) goto L5;
        int r20 = get();
        if (r20 == r15) goto L37;
        r15 = r20;
        goto L3
    L37:
        this.index = r14;
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L3;
        return;
    L17:
        if (r11.get(r13 + r14) != 0) goto L30;
        Object r110 = r5.poll();     // Catch: Throwable -> L25
        if (r110 == null) goto L20;
        r10[r14].onNext(r110);
        r12[r14] = r19 + 1;
        r17 = 0;
        goto L31
    L20:
        int r21 = r10.length;
    L21:
        if (r16 >= r21) goto L23;
        r10[r16].onComplete();
        r16 = r16 + 1;
        goto L21
    L23:
        return;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        int r22 = r10.length;
    L27:
        if (r16 >= r22) goto L29;
        r10[r16].onError(th);
        r16 = r16 + 1;
        goto L27
    L29:
        return;
    L10:
        int r23 = r10.length;
    L11:
        if (r16 >= r23) goto L13;
        r10[r16].onComplete();
        r16 = r16 + 1;
        goto L11
    L13:
        return;
    L6:
        r5.clear();
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
        if (this.sourceMode == 0) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r5) == true) goto L8;
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?"));
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
        this.upstream = r5;
        if ((r5 instanceof e) == false) goto L14;
        e r10 = (e) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.sourceMode = r11;
        this.queue = r10;
        this.done = true;
        setupSubscribers();
        drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = r11;
        this.queue = r10;
        setupSubscribers();
        r5.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        setupSubscribers();
        r5.request(this.prefetch);
        return;
    }

    public void setupSubscribers() {
        c[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (this.cancelled == true) goto L6;
        int r12 = r11 + 1;
        this.subscriberCount.lazySet(r12);
        r5[r11].onSubscribe(new a(this, r11, r10));
        r11 = r12;
        goto L3
    L6:
        return;
    }
}
