package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final xb.o<? super R> downstream;
    final AtomicThrowable error;
    final zb.h<? super T, ? extends xb.n<? extends R>> mapper;
    final DelayErrorInnerObserver<R> observer;
    bc.f<T> queue;
    int sourceMode;
    final boolean tillTheEnd;
    io.reactivex.disposables.b upstream;

    static final class DelayErrorInnerObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<R> {
        private static final long serialVersionUID = 2620149119579502636L;
        final xb.o<? super R> downstream;
        final ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> parent;

        DelayErrorInnerObserver(xb.o<? super R> r10, ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r11) {
            this.downstream = r10;
            this.parent = r11;
        }

        void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xb.o
        public void onComplete() {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r10 = this.parent;
            r10.active = false;
            r10.drain();
        }

        @Override // xb.o
        public void onError(Throwable r10) {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r11 = this.parent;
            if (r11.error.addThrowable(r10) == true) goto L5;
            dc.a.n(r10);
            return;
        L5:
            if (r11.tillTheEnd == true) goto L7;
            r11.upstream.dispose();
        L7:
            r11.active = false;
            r11.drain();
        }

        @Override // xb.o
        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // xb.o
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.replace(this, r10);
        }
    }

    ObservableConcatMap$ConcatMapDelayErrorObserver(xb.o<? super R> r10, zb.h<? super T, ? extends xb.n<? extends R>> r11, int r12, boolean r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.bufferSize = r12;
        this.tillTheEnd = r13;
        this.error = new AtomicThrowable();
        this.observer = new DelayErrorInnerObserver(r10, this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.observer.dispose();
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        xb.o<? super R> r10 = this.downstream;
        bc.f<T> r11 = this.queue;
        AtomicThrowable r12 = this.error;
    L7:
        if (this.active == true) goto L48;
        if (this.cancelled == true) goto L10;
        if (this.tillTheEnd == false) goto L15;
    L19:
        boolean r13 = this.done;
        T r14 = r11.poll();     // Catch: Throwable -> L45
        if (r14 != null) goto L23;
        boolean r15 = true;
    L24:
        if (r13 == false) goto L31;
        if (r15 == false) goto L31;
        this.cancelled = true;
        Throwable r16 = r12.terminate();
        if (r16 == null) goto L29;
        r10.onError(r16);
        return;
    L29:
        r10.onComplete();
        return;
    L31:
        if (r15 == true) goto L48;
        xb.n r17 = (xb.n) io.reactivex.internal.functions.a.d(this.mapper.apply(r14), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L43
        if ((r17 instanceof Callable) == false) goto L42;
        a1.b r18 = (Object) ((Callable) r17).call();
        if (r18 == null) goto L7;
        if (this.cancelled == true) goto L7;
        r10.onNext(r18);
    L40:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r12.addThrowable(th);
        goto L7
    L42:
        this.active = true;
        r17.subscribe(this.observer);
    L43:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.dispose();
        r11.clear();
        r12.addThrowable(th);
    L17:
        r10.onError(r12.terminate());
        return;
    L23:
        r15 = false;
    L45:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.dispose();
        r12.addThrowable(th);
        goto L17
    L15:
        if (r12.get() == null) goto L19;
        r11.clear();
        this.cancelled = true;
        goto L17
    L10:
        r11.clear();
        return;
    L48:
        if (decrementAndGet() != 0) goto L7;
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
        if (this.error.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.sourceMode != 0) goto L5;
        this.queue.offer(r10);
    L5:
        drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof bc.b) == false) goto L14;
        bc.b r11 = (bc.b) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
        this.downstream.onSubscribe(this);
        return;
    }
}
