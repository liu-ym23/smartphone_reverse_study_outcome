package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableConcatMapEager$ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b, io.reactivex.internal.observers.a<R> {
    private static final long serialVersionUID = 8080567949447303262L;
    int activeCount;
    volatile boolean cancelled;
    InnerQueuedObserver<R> current;
    volatile boolean done;
    final xb.o<? super R> downstream;
    final AtomicThrowable error;
    final ErrorMode errorMode;
    final zb.h<? super T, ? extends xb.n<? extends R>> mapper;
    final int maxConcurrency;
    final ArrayDeque<InnerQueuedObserver<R>> observers;
    final int prefetch;
    bc.f<T> queue;
    int sourceMode;
    io.reactivex.disposables.b upstream;

    ObservableConcatMapEager$ConcatMapEagerMainObserver(xb.o<? super R> r10, zb.h<? super T, ? extends xb.n<? extends R>> r11, int r12, int r13, ErrorMode r14) {
        this.downstream = r10;
        this.mapper = r11;
        this.maxConcurrency = r12;
        this.prefetch = r13;
        this.errorMode = r14;
        this.error = new AtomicThrowable();
        this.observers = new ArrayDeque();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        disposeAll();
        return;
    }

    void disposeAll() {
        InnerQueuedObserver<R> r10 = this.current;
        if (r10 == null) goto L5;
        r10.dispose();
    L5:
        InnerQueuedObserver<R> r11 = this.observers.poll();
        if (r11 == null) goto L7;
        r11.dispose();
        goto L5
    }

    @Override // io.reactivex.internal.observers.a
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        bc.f<T> r10 = this.queue;
        ArrayDeque<InnerQueuedObserver<R>> r11 = this.observers;
        xb.o<? super R> r12 = this.downstream;
        ErrorMode r13 = this.errorMode;
        int r14 = 1;
    L6:
        int r15 = this.activeCount;
    L8:
        if (r15 == this.maxConcurrency) goto L27;
        if (this.cancelled == true) goto L11;
        if (r13 == ErrorMode.IMMEDIATE) goto L16;
    L88:
        T r16 = r10.poll();     // Catch: Throwable -> L24
        if (r16 == null) goto L27;
        xb.n r17 = (xb.n) io.reactivex.internal.functions.a.d(this.mapper.apply(r16), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
        InnerQueuedObserver<R> r18 = new InnerQueuedObserver(this, this.prefetch);
        r11.offer(r18);
        r17.subscribe(r18);
        r15 = r15 + 1;
    L24:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        r10.clear();
        disposeAll();
        this.error.addThrowable(th);
        r12.onError(this.error.terminate());
        return;
    L16:
        if (this.error.get() == null) goto L88;
        r10.clear();
        disposeAll();
        r12.onError(this.error.terminate());
        return;
    L11:
        r10.clear();
        disposeAll();
        return;
    L27:
        this.activeCount = r15;
        if (this.cancelled == true) goto L29;
        if (r13 == ErrorMode.IMMEDIATE) goto L34;
    L37:
        InnerQueuedObserver<R> r19 = this.current;
        if (r19 == null) goto L40;
    L59:
        if (r19 == null) goto L85;
        bc.f<R> r20 = r19.queue();
    L62:
        if (this.cancelled == true) goto L63;
        boolean r21 = r19.isDone();
        if (r13 != ErrorMode.IMMEDIATE) goto L90;
        if (this.error.get() == null) goto L90;
        r10.clear();
        disposeAll();
        r12.onError(this.error.terminate());
        return;
    L90:
        R r110 = r20.poll();     // Catch: Throwable -> L82
        if (r110 != null) goto L75;
        boolean r111 = true;
    L76:
        if (r21 == false) goto L79;
        if (r111 == false) goto L79;
    L84:
        this.current = null;
        this.activeCount--;
    L79:
        if (r111 == true) goto L85;
        r12.onNext(r110);
        goto L62
    L75:
        r111 = false;
    L82:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.error.addThrowable(th);
        goto L84
    L63:
        r10.clear();
        disposeAll();
        return;
    L85:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L6;
        return;
    L40:
        if (r13 == ErrorMode.BOUNDARY) goto L42;
    L45:
        boolean r22 = this.done;
        InnerQueuedObserver<R> r23 = r11.poll();
        if (r23 != null) goto L48;
        boolean r24 = true;
    L49:
        if (r22 == false) goto L56;
        if (r24 == false) goto L56;
        if (this.error.get() == null) goto L54;
        r10.clear();
        disposeAll();
        r12.onError(this.error.terminate());
        return;
    L54:
        r12.onComplete();
        return;
    L56:
        if (r24 == true) goto L58;
        this.current = r23;
    L58:
        r19 = r23;
        goto L59
    L48:
        r24 = false;
        goto L49
    L42:
        if (this.error.get() == null) goto L45;
        r10.clear();
        disposeAll();
        r12.onError(this.error.terminate());
        return;
    L34:
        if (this.error.get() == null) goto L37;
        r10.clear();
        disposeAll();
        r12.onError(this.error.terminate());
        return;
    L29:
        r10.clear();
        disposeAll();
    }

    @Override // io.reactivex.internal.observers.a
    public void innerComplete(InnerQueuedObserver<R> r10) {
        r10.setDone();
        drain();
    }

    @Override // io.reactivex.internal.observers.a
    public void innerError(InnerQueuedObserver<R> r10, Throwable r11) {
        if (this.error.addThrowable(r11) == true) goto L5;
        dc.a.n(r11);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
        this.upstream.dispose();
    L7:
        r10.setDone();
        drain();
    }

    @Override // io.reactivex.internal.observers.a
    public void innerNext(InnerQueuedObserver<R> r10, R r11) {
        r10.queue().offer(r11);
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
        this.queue = new io.reactivex.internal.queue.a(this.prefetch);
        this.downstream.onSubscribe(this);
        return;
    }
}
