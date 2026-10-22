package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, xb.o<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    final boolean delayErrors;
    volatile boolean disposed;
    final xb.b downstream;
    final AtomicThrowable errors;
    final zb.h<? super T, ? extends xb.c> mapper;
    final io.reactivex.disposables.a set;
    io.reactivex.disposables.b upstream;

    final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.b, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8606673141535671828L;
        final /* synthetic */ ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver this$0;

        InnerObserver(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xb.b
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // xb.b
        public void onError(Throwable r10) {
            this.this$0.innerError(this, r10);
        }

        @Override // xb.b
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver(xb.b r10, zb.h<? super T, ? extends xb.c> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.set = new io.reactivex.disposables.a();
        lazySet(1);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    void innerComplete(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T>.InnerObserver r10) {
        this.set.c(r10);
        onComplete();
    }

    void innerError(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver<T>.InnerObserver r10, Throwable r11) {
        this.set.c(r10);
        onError(r11);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // xb.o
    public void onComplete() {
        if (decrementAndGet() != 0) goto L9;
        Throwable r10 = this.errors.terminate();
        xb.b r11 = this.downstream;
        if (r10 == null) goto L7;
        r11.onError(r10);
        return;
    L7:
        r11.onComplete();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        dispose();
        if (getAndSet(0) <= 0) goto L15;
    L11:
        Throwable r11 = this.errors.terminate();
        this.downstream.onError(r11);
        return;
    L15:
        return;
    L7:
        if (decrementAndGet() == 0) goto L11;
    }

    @Override // xb.o
    public void onNext(T r10) {
        xb.c r11 = (xb.c) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
        getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.disposed == false) goto L6;
        return;
    L6:
        if (this.set.b(r12) == false) goto L15;
        r11.a(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
