package io.reactivex.internal.operators.mixed;

import bc.f;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xb.c;
import xb.o;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements o<T>, b {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    volatile boolean disposed;
    volatile boolean done;
    final xb.b downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final h<? super T, ? extends c> mapper;
    final int prefetch;
    f<T> queue;
    b upstream;

    static final class ConcatMapInnerObserver extends AtomicReference<b> implements xb.b {
        private static final long serialVersionUID = 5638352172918776687L;
        final ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        ConcatMapInnerObserver(ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> r10) {
            this.parent = r10;
        }

        void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xb.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // xb.b
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // xb.b
        public void onSubscribe(b r10) {
            DisposableHelper.replace(this, r10);
        }
    }

    ObservableConcatMapCompletable$ConcatMapCompletableObserver(xb.b r10, h<? super T, ? extends c> r11, ErrorMode r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.errorMode = r12;
        this.prefetch = r13;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicThrowable r10 = this.errors;
        ErrorMode r11 = this.errorMode;
    L7:
        if (this.disposed == true) goto L8;
        if (this.active == true) goto L37;
        if (r11 == ErrorMode.BOUNDARY) goto L15;
    L18:
        boolean r12 = this.done;
        c r13 = null;
        T r14 = this.queue.poll();     // Catch: Throwable -> L33
        if (r14 == null) goto L23;
        r13 = (c) a.d(this.mapper.apply(r14), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L33
        boolean r15 = false;
    L24:
        if (r12 == false) goto L31;
        if (r15 == false) goto L31;
        this.disposed = true;
        Throwable r16 = r10.terminate();
        xb.b r17 = this.downstream;
        if (r16 == null) goto L29;
        r17.onError(r16);
        return;
    L29:
        r17.onComplete();
        return;
    L31:
        if (r15 == true) goto L37;
        this.active = true;
        r13.a(this.inner);
        goto L37
    L23:
        r15 = true;
    L33:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.disposed = true;
        this.queue.clear();
        this.upstream.dispose();
        r10.addThrowable(th);
        this.downstream.onError(r10.terminate());
        return;
    L15:
        if (r10.get() == null) goto L18;
        this.disposed = true;
        this.queue.clear();
        this.downstream.onError(r10.terminate());
        return;
    L37:
        if (decrementAndGet() != 0) goto L7;
        return;
    L8:
        this.queue.clear();
    }

    void innerComplete() {
        this.active = false;
        drain();
    }

    void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.disposed = true;
        this.upstream.dispose();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f9683a) goto L10;
        this.downstream.onError(r11);
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

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposed;
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
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.disposed = true;
        this.inner.dispose();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f9683a) goto L10;
        this.downstream.onError(r11);
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

    @Override // xb.o
    public void onNext(T r10) {
        if (r10 == null) goto L4;
        this.queue.offer(r10);
    L4:
        drain();
    }

    @Override // xb.o
    public void onSubscribe(b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof bc.b) == false) goto L14;
        bc.b r11 = (bc.b) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.prefetch);
        this.downstream.onSubscribe(this);
        return;
    }
}
