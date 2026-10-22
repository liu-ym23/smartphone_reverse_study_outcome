package io.reactivex.internal.operators.mixed;

import bc.e;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;
import xb.g;
import xb.r;
import xb.s;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatMapSingle$ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements g<T>, d {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final c<? super R> downstream;
    long emitted;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapSingleObserver<R> inner;
    R item;
    final h<? super T, ? extends s<? extends R>> mapper;
    final int prefetch;
    final e<T> queue;
    final AtomicLong requested;
    volatile int state;
    d upstream;

    static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements r<R> {
        private static final long serialVersionUID = -3051469169682093892L;
        final FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> parent;

        ConcatMapSingleObserver(FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> r10) {
            this.parent = r10;
        }

        void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xb.r
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // xb.r
        public void onSubscribe(b r10) {
            DisposableHelper.replace(this, r10);
        }

        @Override // xb.r
        public void onSuccess(R r10) {
            this.parent.innerSuccess(r10);
        }
    }

    FlowableConcatMapSingle$ConcatMapSingleSubscriber(c<? super R> r10, h<? super T, ? extends s<? extends R>> r11, int r12, ErrorMode r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.prefetch = r12;
        this.errorMode = r13;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapSingleObserver(this);
        this.queue = new SpscArrayQueue(r12);
    }

    @Override // tc.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        this.item = null;
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        c<? super R> r10 = this.downstream;
        ErrorMode r11 = this.errorMode;
        e<T> r12 = this.queue;
        AtomicThrowable r13 = this.errors;
        AtomicLong r14 = this.requested;
        int r15 = this.prefetch;
        int r16 = r15 - (r15 >> 1);
        int r17 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        int r18 = this.state;
        if (r13.get() == null) goto L20;
        if (r11 == ErrorMode.IMMEDIATE) goto L16;
        if (r11 != ErrorMode.BOUNDARY) goto L20;
        if (r18 != 0) goto L20;
    L16:
        r12.clear();
        this.item = null;
    L17:
        r10.onError(r13.terminate());
        return;
    L20:
        if (r18 == 0) goto L21;
        if (r18 != 2) goto L47;
        long r19 = this.emitted;
        if (r19 == r14.get()) goto L47;
        R r20 = this.item;
        this.item = null;
        r10.onNext(r20);
        this.emitted = r19 + 1;
        this.state = 0;
    L47:
        r17 = addAndGet(-r17);
        if (r17 != 0) goto L7;
        return;
    L21:
        boolean r21 = this.done;
        T r22 = r12.poll();
        if (r22 != null) goto L24;
        boolean r110 = true;
    L25:
        if (r21 == false) goto L32;
        if (r110 == false) goto L32;
        Throwable r111 = r13.terminate();
        if (r111 != null) goto L30;
        r10.onComplete();
        return;
    L30:
        r10.onError(r111);
        return;
    L32:
        if (r110 == true) goto L47;
        int r23 = this.consumed + 1;
        if (r23 != r16) goto L37;
        this.consumed = 0;
        this.upstream.request(r16);
    L50:
        s r24 = (s) a.d(this.mapper.apply(r22), "The mapper returned a null SingleSource");     // Catch: Throwable -> L40
        this.state = 1;
        r24.a(this.inner);
    L40:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        r12.clear();
        r13.addThrowable(th);
        goto L17
    L37:
        this.consumed = r23;
        goto L50
    L24:
        r110 = false;
        goto L25
    L8:
        r12.clear();
        this.item = null;
        goto L47
    }

    void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.cancel();
    L7:
        this.state = 0;
        drain();
    }

    void innerSuccess(R r10) {
        this.item = r10;
        this.state = 2;
        drain();
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
        this.inner.dispose();
    L7:
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.queue.offer(r10) == true) goto L6;
        this.upstream.cancel();
        onError(new MissingBackpressureException("queue full?!"));
        return;
    L6:
        drain();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
    }
}
