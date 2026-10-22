package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableConcatMap$SourceObserver<T, U> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = 8828587559905699186L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean disposed;
    volatile boolean done;
    final mt.u downstream;
    int fusionMode;
    final InnerObserver<U> inner;
    final pt.o mapper;
    rt.h queue;
    Disposable upstream;

    public static final class InnerObserver<U> extends AtomicReference<Disposable> implements mt.u {
        private static final long serialVersionUID = -7449079488798789337L;
        final mt.u downstream;
        final ObservableConcatMap$SourceObserver<?, ?> parent;

        public InnerObserver(mt.u r5, ObservableConcatMap$SourceObserver<?, ?> r10) {
            this.downstream = r5;
            this.parent = r10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // mt.u
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            this.parent.dispose();
            this.downstream.onError(r5);
        }

        @Override // mt.u
        public void onNext(U r5) {
            this.downstream.onNext(r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
            DisposableHelper.replace(this, r5);
        }
    }

    public ObservableConcatMap$SourceObserver(mt.u r5, pt.o r10, int r11) {
        this.downstream = r5;
        this.mapper = r10;
        this.bufferSize = r11;
        this.inner = new InnerObserver(r5, this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        this.upstream.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.disposed == true) goto L7;
        if (this.active == true) goto L31;
        boolean r5 = this.done;
        Object r10 = this.queue.poll();     // Catch: Throwable -> L27
        if (r10 != null) goto L16;
        boolean r11 = true;
    L17:
        if (r5 == false) goto L21;
        if (r11 == false) goto L21;
        this.disposed = true;
        this.downstream.onComplete();
        return;
    L21:
        if (r11 == true) goto L31;
        Object r12 = this.mapper.apply(r10);     // Catch: Throwable -> L24
        io.reactivex.internal.functions.e.d(r12, "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
        mt.s r13 = (mt.s) r12;     // Catch: Throwable -> L24
        this.active = true;
        r13.subscribe(this.inner);
    L24:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        this.queue.clear();
        this.downstream.onError(th);
        return;
    L16:
        r11 = false;
    L27:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        dispose();
        this.queue.clear();
        this.downstream.onError(th);
        return;
    L31:
        if (decrementAndGet() != 0) goto L6;
        return;
    L7:
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        dispose();
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.fusionMode != 0) goto L8;
        this.queue.offer(r5);
    L8:
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
        this.fusionMode = r11;
        this.queue = r10;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.fusionMode = r11;
        this.queue = r10;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
        this.downstream.onSubscribe(this);
        return;
    }
}
