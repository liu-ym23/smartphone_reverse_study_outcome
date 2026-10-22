package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements mt.g, zu.d, io.reactivex.internal.subscribers.a {
    private static final long serialVersionUID = -4255299542215038287L;
    volatile boolean cancelled;
    volatile InnerQueuedSubscriber<R> current;
    volatile boolean done;
    final zu.c downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final pt.o mapper;
    final int maxConcurrency;
    final int prefetch;
    final AtomicLong requested;
    final io.reactivex.internal.queue.b subscribers;
    zu.d upstream;

    public FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(zu.c r5, pt.o r10, int r11, int r12, ErrorMode r13) {
        this.downstream = r5;
        this.mapper = r10;
        this.maxConcurrency = r11;
        this.prefetch = r12;
        this.errorMode = r13;
        this.subscribers = new io.reactivex.internal.queue.b(Math.min(r12, r11));
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        this.upstream.cancel();
        drainAndCancel();
    }

    public void cancelAll() {
        InnerQueuedSubscriber<R> r5 = this.current;
        this.current = null;
        if (r5 == null) goto L5;
        r5.cancel();
    L5:
        InnerQueuedSubscriber r10 = (InnerQueuedSubscriber) this.subscribers.poll();
        if (r10 == null) goto L8;
        r10.cancel();
        goto L5
    }

    @Override // io.reactivex.internal.subscribers.a
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        InnerQueuedSubscriber<R> r5 = this.current;
        zu.c r10 = this.downstream;
        ErrorMode r11 = this.errorMode;
        int r12 = 1;
    L6:
        long r13 = this.requested.get();
        if (r5 == null) goto L9;
        r5 = r5;
    L25:
        if (r5 == null) goto L72;
        rt.h r14 = r5.queue();
        if (r14 == null) goto L72;
        long r15 = 0;
    L29:
        int r16 = r12;
        if (r15 == r13) goto L55;
        if (this.cancelled == true) goto L33;
        if (r11 == ErrorMode.IMMEDIATE) goto L38;
    L41:
        boolean r17 = r5.isDone();
        Object r18 = r14.poll();     // Catch: Throwable -> L52
        if (r18 != null) goto L45;
        boolean r19 = true;
    L46:
        if (r17 == false) goto L49;
        if (r19 == false) goto L49;
        this.current = null;
        this.upstream.request(1);
        r5 = null;
        boolean r20 = true;
    L56:
        if (r15 == r13) goto L58;
    L71:
        long r21 = 0;
    L74:
        if (r15 != r21) goto L76;
    L78:
        if (r20 == true) goto L79;
        r12 = addAndGet(-r16);
        if (r12 != 0) goto L6;
        return;
    L79:
        r12 = r16;
        goto L6
    L76:
        if (r13 == Long.MAX_VALUE) goto L78;
        this.requested.addAndGet(-r15);
        goto L78
    L58:
        if (this.cancelled == true) goto L59;
        if (r11 == ErrorMode.IMMEDIATE) goto L64;
    L67:
        boolean r22 = r5.isDone();
        boolean r110 = r14.isEmpty();
        if (r22 == false) goto L71;
        if (r110 == false) goto L71;
        this.current = null;
        this.upstream.request(1);
        r5 = null;
        r20 = true;
        goto L71
    L64:
        if (this.errors.get() == null) goto L67;
        this.current = null;
        r5.cancel();
        cancelAll();
        r10.onError(this.errors.terminate());
        return;
    L59:
        cancelAll();
        return;
    L49:
        if (r19 == true) goto L55;
        r10.onNext(r18);
        r15 = r15 + 1;
        r5.requestOne();
        r12 = r16;
        goto L29
    L45:
        r19 = false;
    L52:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.current = null;
        r5.cancel();
        cancelAll();
        r10.onError(th);
        return;
    L38:
        if (this.errors.get() == null) goto L41;
        this.current = null;
        r5.cancel();
        cancelAll();
        r10.onError(this.errors.terminate());
        return;
    L33:
        cancelAll();
        return;
    L55:
        r20 = false;
    L72:
        r16 = r12;
        r20 = false;
        r21 = 0;
        r15 = 0;
        goto L74
    L9:
        if (r11 != ErrorMode.END) goto L11;
    L14:
        boolean r23 = this.done;
        r5 = (InnerQueuedSubscriber) this.subscribers.poll();
        if (r23 == false) goto L22;
        if (r5 != null) goto L22;
        Throwable r24 = this.errors.terminate();
        if (r24 == null) goto L20;
        r10.onError(r24);
        return;
    L20:
        r10.onComplete();
        return;
    L22:
        if (r5 == null) goto L25;
        this.current = r5;
        goto L25
    L11:
        if (this.errors.get() == null) goto L14;
        cancelAll();
        r10.onError(this.errors.terminate());
    }

    public void drainAndCancel() {
        if (getAndIncrement() != 0) goto L6;
    L4:
        cancelAll();
        if (decrementAndGet() != 0) goto L4;
        return;
    }

    @Override // io.reactivex.internal.subscribers.a
    public void innerComplete(InnerQueuedSubscriber<R> r5) {
        r5.setDone();
        drain();
    }

    @Override // io.reactivex.internal.subscribers.a
    public void innerError(InnerQueuedSubscriber<R> r5, Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L8;
        r5.setDone();
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.cancel();
    L7:
        drain();
        return;
    L8:
        wn.f.k(r10);
    }

    @Override // io.reactivex.internal.subscribers.a
    public void innerNext(InnerQueuedSubscriber<R> r5, R r10) {
        if (r5.queue().offer(r10) == false) goto L5;
        drain();
        return;
    L5:
        r5.cancel();
        innerError(r5, new MissingBackpressureException());
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L10
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null Publisher");     // Catch: Throwable -> L10
        zu.b r11 = (zu.b) r10;     // Catch: Throwable -> L10
        InnerQueuedSubscriber r12 = new InnerQueuedSubscriber(this, this.prefetch);
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
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L10;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        int r10 = this.maxConcurrency;
        if (r10 != Integer.MAX_VALUE) goto L7;
        long r11 = Long.MAX_VALUE;
    L8:
        r5.request(r11);
        return;
    L7:
        r11 = r10;
        goto L8
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }
}
