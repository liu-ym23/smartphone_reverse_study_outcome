package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable error;
    final pt.o mapper;
    final DelayErrorInnerObserver<R> observer;
    rt.h queue;
    int sourceMode;
    final boolean tillTheEnd;
    Disposable upstream;

    public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements mt.u {
        private static final long serialVersionUID = 2620149119579502636L;
        final mt.u downstream;
        final ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> parent;

        public DelayErrorInnerObserver(mt.u r5, ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r10) {
            this.downstream = r5;
            this.parent = r10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // mt.u
        public void onComplete() {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r5 = this.parent;
            r5.active = false;
            r5.drain();
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r10 = this.parent;
            if (r10.error.addThrowable(r5) == true) goto L5;
            wn.f.k(r5);
            return;
        L5:
            if (r10.tillTheEnd == true) goto L7;
            r10.upstream.dispose();
        L7:
            r10.active = false;
            r10.drain();
        }

        @Override // mt.u
        public void onNext(R r5) {
            this.downstream.onNext(r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
            DisposableHelper.replace(this, r5);
        }
    }

    public ObservableConcatMap$ConcatMapDelayErrorObserver(mt.u r5, pt.o r10, int r11, boolean r12) {
        this.downstream = r5;
        this.mapper = r10;
        this.bufferSize = r11;
        this.tillTheEnd = r12;
        this.error = new AtomicThrowable();
        this.observer = new DelayErrorInnerObserver(r5, this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.observer.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        mt.u r5 = this.downstream;
        rt.h r10 = this.queue;
        AtomicThrowable r11 = this.error;
    L7:
        if (this.active == true) goto L49;
        if (this.cancelled == true) goto L10;
        if (this.tillTheEnd == false) goto L15;
    L18:
        boolean r12 = this.done;
        Object r13 = r10.poll();     // Catch: Throwable -> L45
        if (r13 != null) goto L22;
        boolean r14 = true;
    L23:
        if (r12 == false) goto L30;
        if (r14 == false) goto L30;
        this.cancelled = true;
        Throwable r15 = r11.terminate();
        if (r15 == null) goto L28;
        r5.onError(r15);
        return;
    L28:
        r5.onComplete();
        return;
    L30:
        if (r14 == true) goto L49;
        Object r16 = this.mapper.apply(r13);     // Catch: Throwable -> L42
        io.reactivex.internal.functions.e.d(r16, "The mapper returned a null ObservableSource");     // Catch: Throwable -> L42
        mt.s r17 = (mt.s) r16;     // Catch: Throwable -> L42
        if ((r17 instanceof Callable) == false) goto L41;
        Object r18 = ((Callable) r17).call();     // Catch: Throwable -> L39
        if (r18 == null) goto L7;
        if (this.cancelled == true) goto L7;
        r5.onNext(r18);
    L39:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r11.addThrowable(th);
        goto L7
    L41:
        this.active = true;
        r17.subscribe(this.observer);
    L42:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.cancelled = true;
        this.upstream.dispose();
        r10.clear();
        r11.addThrowable(th);
        r5.onError(r11.terminate());
        return;
    L22:
        r14 = false;
    L45:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.cancelled = true;
        this.upstream.dispose();
        r11.addThrowable(th);
        r5.onError(r11.terminate());
        return;
    L15:
        if (r11.get() == null) goto L18;
        r10.clear();
        this.cancelled = true;
        r5.onError(r11.terminate());
        return;
    L10:
        r10.clear();
        return;
    L49:
        if (decrementAndGet() != 0) goto L7;
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
        if (this.error.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.sourceMode != 0) goto L5;
        this.queue.offer(r5);
    L5:
        drain();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L16;
        this.upstream = r5;
        if ((r5 instanceof rt.c) == false) goto L14;
        rt.c r10 = (rt.c) r5;
        int r11 = r10.requestFusion(3);
        if (r11 != 1) goto L11;
        this.sourceMode = r11;
        this.queue = r10;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = r11;
        this.queue = r10;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
        this.downstream.onSubscribe(this);
        return;
    }
}
