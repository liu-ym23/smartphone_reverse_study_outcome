package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableMergeWithMaybe$MergeWithObserver<T> extends AtomicInteger implements mt.u, Disposable {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    volatile boolean disposed;
    final mt.u downstream;
    final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    volatile boolean mainDone;
    final OtherObserver<T> otherObserver;
    volatile int otherState;
    volatile rt.g queue;
    T singleItem;

    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements mt.j {
        private static final long serialVersionUID = -2935427570954647017L;
        final ObservableMergeWithMaybe$MergeWithObserver<T> parent;

        public OtherObserver(ObservableMergeWithMaybe$MergeWithObserver<T> r5) {
            this.parent = r5;
        }

        @Override // mt.j
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // mt.j
        public void onError(Throwable r5) {
            this.parent.otherError(r5);
        }

        @Override // mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }

        @Override // mt.j
        public void onSuccess(T r5) {
            this.parent.otherSuccess(r5);
        }
    }

    public ObservableMergeWithMaybe$MergeWithObserver(mt.u r5) {
        this.downstream = r5;
        this.mainDisposable = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
        if (getAndIncrement() != 0) goto L6;
        this.queue = null;
        this.singleItem = null;
        return;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    public void drainLoop() {
        mt.u r5 = this.downstream;
        int r10 = 1;
    L4:
        if (this.disposed == true) goto L5;
        if (this.error.get() != null) goto L9;
        int r11 = this.otherState;
        if (r11 != 1) goto L14;
        T r12 = this.singleItem;
        this.singleItem = null;
        this.otherState = 2;
        r5.onNext(r12);
        r11 = 2;
    L14:
        boolean r13 = this.mainDone;
        rt.g r14 = this.queue;
        if (r14 == null) goto L17;
        Object r15 = r14.poll();
    L18:
        if (r15 != null) goto L20;
        boolean r16 = true;
    L21:
        if (r13 == false) goto L26;
        if (r16 == false) goto L26;
        if (r11 != 2) goto L26;
        this.queue = null;
        r5.onComplete();
        return;
    L26:
        if (r16 == true) goto L27;
        r5.onNext(r15);
        goto L4
    L27:
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L4;
        return;
    L20:
        r16 = false;
        goto L21
    L17:
        r15 = null;
        goto L18
    L9:
        this.singleItem = null;
        this.queue = null;
        r5.onError(this.error.terminate());
        return;
    L5:
        this.singleItem = null;
        this.queue = null;
    }

    public rt.g getOrCreateQueue() {
        rt.g r5 = this.queue;
        if (r5 != null) goto L6;
        io.reactivex.internal.queue.b r10 = new io.reactivex.internal.queue.b(mt.n.bufferSize());
        this.queue = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    @Override // mt.u
    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.error.addThrowable(r5) == false) goto L5;
        DisposableHelper.dispose(this.mainDisposable);
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (compareAndSet(0, 1) == false) goto L7;
        this.downstream.onNext(r5);
        if (decrementAndGet() != 0) goto L10;
        return;
    L10:
        drainLoop();
        return;
    L7:
        getOrCreateQueue().offer(r5);
        if (getAndIncrement() == 0) goto L10;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.mainDisposable, r5);
    }

    public void otherComplete() {
        this.otherState = 2;
        drain();
    }

    public void otherError(Throwable r5) {
        if (this.error.addThrowable(r5) == false) goto L5;
        DisposableHelper.dispose(this.mainDisposable);
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    public void otherSuccess(T r5) {
        if (compareAndSet(0, 1) == false) goto L5;
        this.downstream.onNext(r5);
        this.otherState = 2;
    L8:
        drainLoop();
        return;
    L5:
        this.singleItem = r5;
        this.otherState = 1;
        if (getAndIncrement() == 0) goto L8;
    }
}
