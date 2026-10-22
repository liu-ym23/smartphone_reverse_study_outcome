package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableConcatMapEager$ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements mt.u, Disposable, io.reactivex.internal.observers.g {
    private static final long serialVersionUID = 8080567949447303262L;
    int activeCount;
    volatile boolean cancelled;
    InnerQueuedObserver<R> current;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable error;
    final ErrorMode errorMode;
    final pt.o mapper;
    final int maxConcurrency;
    final ArrayDeque<InnerQueuedObserver<R>> observers;
    final int prefetch;
    rt.h queue;
    int sourceMode;
    Disposable upstream;

    public ObservableConcatMapEager$ConcatMapEagerMainObserver(mt.u r5, pt.o r10, int r11, int r12, ErrorMode r13) {
        this.downstream = r5;
        this.mapper = r10;
        this.maxConcurrency = r11;
        this.prefetch = r12;
        this.errorMode = r13;
        this.error = new AtomicThrowable();
        this.observers = new ArrayDeque();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        this.upstream.dispose();
        drainAndDispose();
    }

    public void disposeAll() {
        InnerQueuedObserver<R> r5 = this.current;
        if (r5 == null) goto L5;
        r5.dispose();
    L5:
        InnerQueuedObserver<R> r10 = this.observers.poll();
        if (r10 == null) goto L7;
        r10.dispose();
        goto L5
    }

    @Override // io.reactivex.internal.observers.g
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        rt.h r5 = this.queue;
        ArrayDeque<InnerQueuedObserver<R>> r10 = this.observers;
        mt.u r11 = this.downstream;
        ErrorMode r12 = this.errorMode;
        int r13 = 1;
    L6:
        int r14 = this.activeCount;
    L8:
        if (r14 == this.maxConcurrency) goto L27;
        if (this.cancelled == true) goto L11;
        if (r12 == ErrorMode.IMMEDIATE) goto L16;
    L87:
        Object r15 = r5.poll();     // Catch: Throwable -> L24
        if (r15 == null) goto L27;
        Object r16 = this.mapper.apply(r15);     // Catch: Throwable -> L24
        io.reactivex.internal.functions.e.d(r16, "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
        mt.s r17 = (mt.s) r16;     // Catch: Throwable -> L24
        InnerQueuedObserver<R> r18 = new InnerQueuedObserver(this, this.prefetch);
        r10.offer(r18);
        r17.subscribe(r18);
        r14 = r14 + 1;
    L24:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
        r5.clear();
        disposeAll();
        this.error.addThrowable(th);
        r11.onError(this.error.terminate());
        return;
    L16:
        if (this.error.get() == null) goto L87;
        r5.clear();
        disposeAll();
        r11.onError(this.error.terminate());
        return;
    L11:
        r5.clear();
        disposeAll();
        return;
    L27:
        this.activeCount = r14;
        if (this.cancelled == true) goto L29;
        if (r12 == ErrorMode.IMMEDIATE) goto L34;
    L37:
        InnerQueuedObserver<R> r19 = this.current;
        if (r19 == null) goto L40;
    L59:
        if (r19 == null) goto L84;
        rt.h r20 = r19.queue();
    L62:
        if (this.cancelled == true) goto L63;
        boolean r21 = r19.isDone();
        if (r12 != ErrorMode.IMMEDIATE) goto L89;
        if (this.error.get() == null) goto L89;
        r5.clear();
        disposeAll();
        r11.onError(this.error.terminate());
        return;
    L89:
        Object r110 = r20.poll();     // Catch: Throwable -> L82
        if (r110 != null) goto L75;
        boolean r111 = true;
    L76:
        if (r21 == false) goto L79;
        if (r111 == false) goto L79;
        this.current = null;
        this.activeCount--;
    L79:
        if (r111 == true) goto L84;
        r11.onNext(r110);
        goto L62
    L75:
        r111 = false;
    L82:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.error.addThrowable(th);
        this.current = null;
        this.activeCount--;
        goto L6
    L63:
        r5.clear();
        disposeAll();
        return;
    L84:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
        return;
    L40:
        if (r12 == ErrorMode.BOUNDARY) goto L42;
    L45:
        boolean r22 = this.done;
        InnerQueuedObserver<R> r23 = r10.poll();
        if (r23 != null) goto L48;
        boolean r24 = true;
    L49:
        if (r22 == false) goto L56;
        if (r24 == false) goto L56;
        if (this.error.get() == null) goto L54;
        r5.clear();
        disposeAll();
        r11.onError(this.error.terminate());
        return;
    L54:
        r11.onComplete();
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
        r5.clear();
        disposeAll();
        r11.onError(this.error.terminate());
        return;
    L34:
        if (this.error.get() == null) goto L37;
        r5.clear();
        disposeAll();
        r11.onError(this.error.terminate());
        return;
    L29:
        r5.clear();
        disposeAll();
    }

    public void drainAndDispose() {
        if (getAndIncrement() != 0) goto L6;
    L4:
        this.queue.clear();
        disposeAll();
        if (decrementAndGet() != 0) goto L4;
        return;
    }

    @Override // io.reactivex.internal.observers.g
    public void innerComplete(InnerQueuedObserver<R> r5) {
        r5.setDone();
        drain();
    }

    @Override // io.reactivex.internal.observers.g
    public void innerError(InnerQueuedObserver<R> r5, Throwable r10) {
        if (this.error.addThrowable(r10) == true) goto L5;
        wn.f.k(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
        this.upstream.dispose();
    L7:
        r5.setDone();
        drain();
    }

    @Override // io.reactivex.internal.observers.g
    public void innerNext(InnerQueuedObserver<R> r5, R r10) {
        r5.queue().offer(r10);
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
        this.queue = new io.reactivex.internal.queue.b(this.prefetch);
        this.downstream.onSubscribe(this);
        return;
    }
}
