package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements xb.g<T>, tc.d, io.reactivex.internal.subscribers.a<R> {
    private static final long serialVersionUID = -4255299542215038287L;
    volatile boolean cancelled;
    volatile InnerQueuedSubscriber<R> current;
    volatile boolean done;
    final tc.c<? super R> downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final zb.h<? super T, ? extends tc.b<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final AtomicLong requested;
    final io.reactivex.internal.queue.a<InnerQueuedSubscriber<R>> subscribers;
    tc.d upstream;

    FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(tc.c<? super R> r10, zb.h<? super T, ? extends tc.b<? extends R>> r11, int r12, int r13, ErrorMode r14) {
        this.downstream = r10;
        this.mapper = r11;
        this.maxConcurrency = r12;
        this.prefetch = r13;
        this.errorMode = r14;
        this.subscribers = new io.reactivex.internal.queue.a(Math.min(r13, r12));
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        this.upstream.cancel();
        drainAndCancel();
    }

    void cancelAll() {
    L2:
        InnerQueuedSubscriber<R> r10 = this.subscribers.poll();
        if (r10 == null) goto L5;
        r10.cancel();
        goto L2
    }

    @Override // io.reactivex.internal.subscribers.a
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        InnerQueuedSubscriber<R> r10 = this.current;
        tc.c<? super R> r11 = this.downstream;
        ErrorMode r12 = this.errorMode;
        int r13 = 1;
    L6:
        long r14 = this.requested.get();
        if (r10 == null) goto L9;
        r10 = r10;
    L26:
        if (r10 == null) goto L73;
        bc.f<R> r15 = r10.queue();
        if (r15 == null) goto L73;
        long r16 = 0;
    L30:
        int r17 = r13;
        if (r16 == r14) goto L56;
        if (this.cancelled == true) goto L34;
        if (r12 == ErrorMode.IMMEDIATE) goto L39;
    L42:
        boolean r18 = r10.isDone();
        R r19 = r15.poll();     // Catch: Throwable -> L53
        if (r19 != null) goto L46;
        boolean r110 = true;
    L47:
        if (r18 == false) goto L50;
        if (r110 == false) goto L50;
        this.current = null;
        this.upstream.request(1);
        r10 = null;
        boolean r20 = true;
    L57:
        if (r16 == r14) goto L59;
    L72:
        long r21 = 0;
    L75:
        if (r16 != r21) goto L77;
    L79:
        if (r20 == true) goto L80;
        r13 = addAndGet(-r17);
        if (r13 != 0) goto L6;
        return;
    L80:
        r13 = r17;
        goto L6
    L77:
        if (r14 == Long.MAX_VALUE) goto L79;
        this.requested.addAndGet(-r16);
        goto L79
    L59:
        if (this.cancelled == true) goto L60;
        if (r12 == ErrorMode.IMMEDIATE) goto L65;
    L68:
        boolean r22 = r10.isDone();
        boolean r111 = r15.isEmpty();
        if (r22 == false) goto L72;
        if (r111 == false) goto L72;
        this.current = null;
        this.upstream.request(1);
        r10 = null;
        r20 = true;
        goto L72
    L65:
        if (this.errors.get() == null) goto L68;
        this.current = null;
        r10.cancel();
        cancelAll();
        r11.onError(this.errors.terminate());
        return;
    L60:
        cancelAll();
        return;
    L50:
        if (r110 == true) goto L56;
        r11.onNext(r19);
        r16 = r16 + 1;
        r10.requestOne();
        r13 = r17;
        goto L30
    L46:
        r110 = false;
    L53:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.current = null;
        r10.cancel();
        cancelAll();
        r11.onError(th);
        return;
    L39:
        if (this.errors.get() == null) goto L42;
        this.current = null;
        r10.cancel();
        cancelAll();
        r11.onError(this.errors.terminate());
        return;
    L34:
        cancelAll();
        return;
    L56:
        r20 = false;
    L73:
        r17 = r13;
        r20 = false;
        r21 = 0;
        r16 = 0;
        goto L75
    L9:
        if (r12 != ErrorMode.END) goto L11;
    L14:
        boolean r23 = this.done;
        r10 = this.subscribers.poll();
        if (r23 == false) goto L22;
        if (r10 != null) goto L22;
        Throwable r24 = this.errors.terminate();
        if (r24 == null) goto L20;
        r11.onError(r24);
        return;
    L20:
        r11.onComplete();
        return;
    L22:
        if (r10 == null) goto L26;
        this.current = r10;
        goto L26
    L11:
        if (this.errors.get() == null) goto L14;
        cancelAll();
        r11.onError(this.errors.terminate());
    }

    void drainAndCancel() {
        if (getAndIncrement() != 0) goto L6;
    L4:
        cancelAll();
        if (decrementAndGet() != 0) goto L4;
        return;
    }

    @Override // io.reactivex.internal.subscribers.a
    public void innerComplete(InnerQueuedSubscriber<R> r10) {
        r10.setDone();
        drain();
    }

    @Override // io.reactivex.internal.subscribers.a
    public void innerError(InnerQueuedSubscriber<R> r10, Throwable r11) {
        if (this.errors.addThrowable(r11) == false) goto L8;
        r10.setDone();
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.cancel();
    L7:
        drain();
        return;
    L8:
        dc.a.n(r11);
    }

    @Override // io.reactivex.internal.subscribers.a
    public void innerNext(InnerQueuedSubscriber<R> r10, R r11) {
        if (r10.queue().offer(r11) == false) goto L5;
        drain();
        return;
    L5:
        r10.cancel();
        innerError(r10, new MissingBackpressureException());
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        tc.b r11 = (tc.b) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null Publisher");     // Catch: Throwable -> L10
        InnerQueuedSubscriber<R> r12 = new InnerQueuedSubscriber(this, this.prefetch);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        this.subscribers.offer(r12);
        r11.subscribe(r12);
        if (this.cancelled == false) goto L15;
        r12.cancel();
        drainAndCancel();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L10;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        int r11 = this.maxConcurrency;
        if (r11 != Integer.MAX_VALUE) goto L7;
        long r12 = Long.MAX_VALUE;
    L8:
        r10.request(r12);
        return;
    L7:
        r12 = r11;
        goto L8
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }
}
