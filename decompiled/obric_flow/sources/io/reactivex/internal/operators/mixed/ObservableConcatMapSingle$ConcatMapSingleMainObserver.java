package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import mt.u;
import pt.o;
import rt.g;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableConcatMapSingle$ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements u, Disposable {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    volatile boolean done;
    final u downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapSingleObserver<R> inner;
    R item;
    final o mapper;
    final g queue;
    volatile int state;
    Disposable upstream;

    public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements b0 {
        private static final long serialVersionUID = -3051469169682093892L;
        final ObservableConcatMapSingle$ConcatMapSingleMainObserver<?, R> parent;

        public ConcatMapSingleObserver(ObservableConcatMapSingle$ConcatMapSingleMainObserver<?, R> r5) {
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

    public ObservableConcatMapSingle$ConcatMapSingleMainObserver(u r5, o r10, int r11, ErrorMode r12) {
        this.downstream = r5;
        this.mapper = r10;
        this.errorMode = r12;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapSingleObserver(this);
        this.queue = new io.reactivex.internal.queue.b(r11);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
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
        u r5 = this.downstream;
        ErrorMode r10 = this.errorMode;
        g r11 = this.queue;
        AtomicThrowable r12 = this.errors;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        int r14 = this.state;
        if (r12.get() != null) goto L12;
    L18:
        boolean r15 = false;
        if (r14 == 0) goto L20;
        if (r14 != 2) goto L40;
        R r16 = this.item;
        this.item = null;
        r5.onNext(r16);
        this.state = 0;
    L40:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L20:
        boolean r17 = this.done;
        Object r18 = r11.poll();
        if (r18 != null) goto L23;
        r15 = true;
    L23:
        if (r17 == false) goto L30;
        if (r15 == false) goto L30;
        Throwable r19 = r12.terminate();
        if (r19 != null) goto L28;
        r5.onComplete();
        return;
    L28:
        r5.onError(r19);
        return;
    L30:
        if (r15 == true) goto L40;
        Object r20 = this.mapper.apply(r18);     // Catch: Throwable -> L34
        io.reactivex.internal.functions.e.d(r20, "The mapper returned a null SingleSource");     // Catch: Throwable -> L34
        c0 r21 = (c0) r20;     // Catch: Throwable -> L34
        this.state = 1;
        ((a0) r21).b(this.inner);
    L34:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
        r11.clear();
        r12.addThrowable(th);
        r5.onError(r12.terminate());
        return;
    L12:
        if (r10 == ErrorMode.IMMEDIATE) goto L16;
        if (r10 != ErrorMode.BOUNDARY) goto L18;
        if (r14 != 0) goto L18;
    L16:
        r11.clear();
        this.item = null;
        r5.onError(r12.terminate());
        return;
    L8:
        r11.clear();
        this.item = null;
        goto L40
    }

    public void innerError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.dispose();
    L7:
        this.state = 0;
        drain();
    }

    public void innerSuccess(R r5) {
        this.item = r5;
        this.state = 2;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // mt.u
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

    @Override // mt.u
    public void onNext(T r5) {
        this.queue.offer(r5);
        drain();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
