package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements mt.u {
    private static final long serialVersionUID = 8443155186132538303L;
    final boolean delayErrors;
    volatile boolean disposed;
    final mt.u downstream;
    final AtomicThrowable errors;
    final pt.o mapper;
    final io.reactivex.disposables.a set;
    Disposable upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements mt.b, Disposable {
        private static final long serialVersionUID = 8606673141535671828L;
        final /* synthetic */ ObservableFlatMapCompletable$FlatMapCompletableMainObserver this$0;

        public InnerObserver(ObservableFlatMapCompletable$FlatMapCompletableMainObserver r5) {
            this.this$0 = r5;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // mt.b
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // mt.b
        public void onError(Throwable r5) {
            this.this$0.innerError(this, r5);
        }

        @Override // mt.b
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }
    }

    public ObservableFlatMapCompletable$FlatMapCompletableMainObserver(mt.u r5, pt.o r10, boolean r11) {
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.errors = new AtomicThrowable();
        this.set = new io.reactivex.disposables.a();
        lazySet(1);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    public void innerComplete(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver r5) {
        this.set.c(r5);
        onComplete();
    }

    public void innerError(ObservableFlatMapCompletable$FlatMapCompletableMainObserver<T>.InnerObserver r5, Throwable r10) {
        this.set.c(r5);
        onError(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public boolean isEmpty() {
        return true;
    }

    @Override // mt.u
    public void onComplete() {
        if (decrementAndGet() != 0) goto L9;
        Throwable r5 = this.errors.terminate();
        if (r5 == null) goto L7;
        this.downstream.onError(r5);
        return;
    L7:
        this.downstream.onComplete();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        dispose();
        if (getAndSet(0) <= 0) goto L16;
        Throwable r10 = this.errors.terminate();
        this.downstream.onError(r10);
        return;
    L16:
        return;
    L7:
        if (decrementAndGet() != 0) goto L14;
        Throwable r11 = this.errors.terminate();
        this.downstream.onError(r11);
        return;
    }

    @Override // mt.u
    public void onNext(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
        mt.c r11 = (mt.c) r10;     // Catch: Throwable -> L9
        getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.disposed == false) goto L6;
        return;
    L6:
        if (this.set.b(r12) == false) goto L15;
        ((mt.a) r11).b(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public T poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.d
    public int requestFusion(int r5) {
        return r5 & 2;
    }
}
