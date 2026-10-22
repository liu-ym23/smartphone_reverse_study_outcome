package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;
import pt.o;
import rt.h;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements u, Disposable {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    volatile boolean disposed;
    volatile boolean done;
    final mt.b downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final o mapper;
    final int prefetch;
    h queue;
    Disposable upstream;

    public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements mt.b {
        private static final long serialVersionUID = 5638352172918776687L;
        final ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> r5) {
            this.parent = r5;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // mt.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // mt.b
        public void onError(Throwable r5) {
            this.parent.innerError(r5);
        }

        @Override // mt.b
        public void onSubscribe(Disposable r5) {
            DisposableHelper.replace(this, r5);
        }
    }

    public ObservableConcatMapCompletable$ConcatMapCompletableObserver(mt.b r5, o r10, ErrorMode r11, int r12) {
        this.downstream = r5;
        this.mapper = r10;
        this.errorMode = r11;
        this.prefetch = r12;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicThrowable r5 = this.errors;
        ErrorMode r10 = this.errorMode;
    L7:
        if (this.disposed == true) goto L8;
        if (this.active == true) goto L38;
        if (r10 == ErrorMode.BOUNDARY) goto L15;
    L18:
        boolean r11 = this.done;
        Object r12 = this.queue.poll();     // Catch: Throwable -> L23
        if (r12 == null) goto L25;
        Object r13 = this.mapper.apply(r12);     // Catch: Throwable -> L23
        io.reactivex.internal.functions.e.d(r13, "The mapper returned a null CompletableSource");     // Catch: Throwable -> L23
        mt.c r14 = (mt.c) r13;     // Catch: Throwable -> L23
        boolean r15 = false;
    L26:
        if (r11 == false) goto L33;
        if (r15 == false) goto L33;
        this.disposed = true;
        Throwable r16 = r5.terminate();
        if (r16 == null) goto L31;
        this.downstream.onError(r16);
        return;
    L31:
        this.downstream.onComplete();
        return;
    L33:
        if (r15 == true) goto L38;
        this.active = true;
        ((mt.a) r14).b(this.inner);
        goto L38
    L25:
        r14 = null;
        r15 = true;
    L23:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.disposed = true;
        this.queue.clear();
        this.upstream.dispose();
        r5.addThrowable(th);
        this.downstream.onError(r5.terminate());
        return;
    L15:
        if (r5.get() == null) goto L18;
        this.disposed = true;
        this.queue.clear();
        this.downstream.onError(r5.terminate());
        return;
    L38:
        if (decrementAndGet() != 0) goto L7;
        return;
    L8:
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.disposed = true;
        this.upstream.dispose();
        Throwable r10 = this.errors.terminate();
        if (r10 == io.reactivex.internal.util.d.f18173a) goto L10;
        this.downstream.onError(r10);
    L10:
        if (getAndIncrement() != 0) goto L15;
        this.queue.clear();
        return;
    L15:
        return;
    L12:
        this.active = false;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
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
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.disposed = true;
        this.inner.dispose();
        Throwable r10 = this.errors.terminate();
        if (r10 == io.reactivex.internal.util.d.f18173a) goto L10;
        this.downstream.onError(r10);
    L10:
        if (getAndIncrement() != 0) goto L15;
        this.queue.clear();
        return;
    L15:
        return;
    L12:
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (r5 == null) goto L4;
        this.queue.offer(r5);
    L4:
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
        this.queue = r10;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.queue = r10;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.b(this.prefetch);
        this.downstream.onSubscribe(this);
        return;
    }
}
