package io.reactivex.internal.operators.mixed;

import bc.e;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.a;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;
import xb.r;
import xb.s;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableConcatMapSingle$ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements o<T>, b {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    volatile boolean done;
    final o<? super R> downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapSingleObserver<R> inner;
    R item;
    final h<? super T, ? extends s<? extends R>> mapper;
    final e<T> queue;
    volatile int state;
    b upstream;

    static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements r<R> {
        private static final long serialVersionUID = -3051469169682093892L;
        final ObservableConcatMapSingle$ConcatMapSingleMainObserver<?, R> parent;

        ConcatMapSingleObserver(ObservableConcatMapSingle$ConcatMapSingleMainObserver<?, R> r10) {
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

    ObservableConcatMapSingle$ConcatMapSingleMainObserver(o<? super R> r10, h<? super T, ? extends s<? extends R>> r11, int r12, ErrorMode r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.errorMode = r13;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapSingleObserver(this);
        this.queue = new a(r12);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
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
        o<? super R> r10 = this.downstream;
        ErrorMode r11 = this.errorMode;
        e<T> r12 = this.queue;
        AtomicThrowable r13 = this.errors;
        int r14 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        int r15 = this.state;
        if (r13.get() != null) goto L12;
    L19:
        boolean r16 = false;
        if (r15 == 0) goto L21;
        if (r15 != 2) goto L40;
        R r17 = this.item;
        this.item = null;
        r10.onNext(r17);
        this.state = 0;
    L40:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L7;
        return;
    L21:
        boolean r18 = this.done;
        T r19 = r12.poll();
        if (r19 != null) goto L24;
        r16 = true;
    L24:
        if (r18 == false) goto L31;
        if (r16 == false) goto L31;
        Throwable r110 = r13.terminate();
        if (r110 != null) goto L29;
        r10.onComplete();
        return;
    L29:
        r10.onError(r110);
        return;
    L31:
        if (r16 == true) goto L40;
        s r20 = (s) io.reactivex.internal.functions.a.d(this.mapper.apply(r19), "The mapper returned a null SingleSource");     // Catch: Throwable -> L35
        this.state = 1;
        r20.a(this.inner);
    L35:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        r12.clear();
        r13.addThrowable(th);
    L17:
        r10.onError(r13.terminate());
        return;
    L12:
        if (r11 == ErrorMode.IMMEDIATE) goto L16;
        if (r11 != ErrorMode.BOUNDARY) goto L19;
        if (r15 != 0) goto L19;
    L16:
        r12.clear();
        this.item = null;
        goto L17
    L8:
        r12.clear();
        this.item = null;
        goto L40
    }

    void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.dispose();
    L7:
        this.state = 0;
        drain();
    }

    void innerSuccess(R r10) {
        this.item = r10;
        this.state = 2;
        drain();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // xb.o
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

    @Override // xb.o
    public void onNext(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // xb.o
    public void onSubscribe(b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
