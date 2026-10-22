package io.reactivex.internal.operators.mixed;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import mt.g;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatMapSingle$ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements g, zu.d {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final zu.c downstream;
    long emitted;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapSingleObserver<R> inner;
    R item;
    final o mapper;
    final int prefetch;
    final rt.g queue;
    final AtomicLong requested;
    volatile int state;
    zu.d upstream;

    public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements b0 {
        private static final long serialVersionUID = -3051469169682093892L;
        final FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> parent;

        public ConcatMapSingleObserver(FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> r5) {
            this.parent = r5;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // mt.b0, mt.j
        public void onError(Throwable r5) {
            this.parent.innerError(r5);
        }

        @Override // mt.b0, mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.replace(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSuccess(R r5) {
            this.parent.innerSuccess(r5);
        }
    }

    public FlowableConcatMapSingle$ConcatMapSingleSubscriber(zu.c r5, o r10, int r11, ErrorMode r12) {
        this.downstream = r5;
        this.mapper = r10;
        this.prefetch = r11;
        this.errorMode = r12;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapSingleObserver(this);
        this.queue = new SpscArrayQueue(r11);
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        this.item = null;
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        ErrorMode r10 = this.errorMode;
        rt.g r11 = this.queue;
        AtomicThrowable r12 = this.errors;
        AtomicLong r13 = this.requested;
        int r14 = this.prefetch;
        int r15 = r14 - (r14 >> 1);
        int r16 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        int r17 = this.state;
        if (r12.get() == null) goto L19;
        if (r10 == ErrorMode.IMMEDIATE) goto L16;
        if (r10 != ErrorMode.BOUNDARY) goto L19;
        if (r17 != 0) goto L19;
    L16:
        r11.clear();
        this.item = null;
        r5.onError(r12.terminate());
        return;
    L19:
        if (r17 == 0) goto L20;
        if (r17 != 2) goto L47;
        long r18 = this.emitted;
        if (r18 == r13.get()) goto L47;
        R r19 = this.item;
        this.item = null;
        r5.onNext(r19);
        this.emitted = r18 + 1;
        this.state = 0;
    L47:
        r16 = addAndGet(-r16);
        if (r16 != 0) goto L7;
        return;
    L20:
        boolean r20 = this.done;
        Object r21 = r11.poll();
        if (r21 != null) goto L23;
        boolean r110 = true;
    L24:
        if (r20 == false) goto L31;
        if (r110 == false) goto L31;
        Throwable r111 = r12.terminate();
        if (r111 != null) goto L29;
        r5.onComplete();
        return;
    L29:
        r5.onError(r111);
        return;
    L31:
        if (r110 == true) goto L47;
        int r22 = this.consumed + 1;
        if (r22 != r15) goto L36;
        this.consumed = 0;
        this.upstream.request(r15);
    L50:
        Object r23 = this.mapper.apply(r21);     // Catch: Throwable -> L39
        io.reactivex.internal.functions.e.d(r23, "The mapper returned a null SingleSource");     // Catch: Throwable -> L39
        c0 r24 = (c0) r23;     // Catch: Throwable -> L39
        this.state = 1;
        ((a0) r24).b(this.inner);
    L39:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        r11.clear();
        r12.addThrowable(th);
        r5.onError(r12.terminate());
        return;
    L36:
        this.consumed = r22;
        goto L50
    L23:
        r110 = false;
        goto L24
    L8:
        r11.clear();
        this.item = null;
        goto L47
    }

    public void innerError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.cancel();
    L7:
        this.state = 0;
        drain();
    }

    public void innerSuccess(R r5) {
        this.item = r5;
        this.state = 2;
        drain();
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
        this.inner.dispose();
    L7:
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.queue.offer(r5) == true) goto L6;
        this.upstream.cancel();
        onError(new MissingBackpressureException("queue full?!"));
        return;
    L6:
        drain();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        v0.r(this.requested, r5);
        drain();
    }
}
