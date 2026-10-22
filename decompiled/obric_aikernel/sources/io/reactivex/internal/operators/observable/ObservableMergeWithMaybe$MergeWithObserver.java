package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableMergeWithMaybe$MergeWithObserver<T> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    volatile boolean disposed;
    final xb.o<? super T> downstream;
    final AtomicThrowable error;
    final AtomicReference<io.reactivex.disposables.b> mainDisposable;
    volatile boolean mainDone;
    final OtherObserver<T> otherObserver;
    volatile int otherState;
    volatile bc.e<T> queue;
    T singleItem;

    static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.j<T> {
        private static final long serialVersionUID = -2935427570954647017L;
        final ObservableMergeWithMaybe$MergeWithObserver<T> parent;

        OtherObserver(ObservableMergeWithMaybe$MergeWithObserver<T> r10) {
            this.parent = r10;
        }

        @Override // xb.j
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // xb.j
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // xb.j
        public void onSuccess(T r10) {
            this.parent.otherSuccess(r10);
        }
    }

    ObservableMergeWithMaybe$MergeWithObserver(xb.o<? super T> r10) {
        this.downstream = r10;
        this.mainDisposable = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposed = true;
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
        if (getAndIncrement() != 0) goto L6;
        this.queue = null;
        this.singleItem = null;
        return;
    }

    void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    void drainLoop() {
        xb.o<? super T> r10 = this.downstream;
        int r11 = 1;
    L4:
        if (this.disposed == true) goto L5;
        if (this.error.get() != null) goto L9;
        int r12 = this.otherState;
        if (r12 != 1) goto L14;
        T r13 = this.singleItem;
        this.singleItem = null;
        this.otherState = 2;
        r10.onNext(r13);
        r12 = 2;
    L14:
        boolean r14 = this.mainDone;
        bc.e<T> r15 = this.queue;
        if (r15 == null) goto L17;
        a1.c r16 = r15.poll();
    L18:
        if (r16 != null) goto L20;
        boolean r17 = true;
    L21:
        if (r14 == false) goto L26;
        if (r17 == false) goto L26;
        if (r12 != 2) goto L26;
        this.queue = null;
        r10.onComplete();
        return;
    L26:
        if (r17 == true) goto L27;
        r10.onNext(r16);
        goto L4
    L27:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L4;
        return;
    L20:
        r17 = false;
        goto L21
    L17:
        r16 = null;
        goto L18
    L9:
        this.singleItem = null;
        this.queue = null;
        r10.onError(this.error.terminate());
        return;
    L5:
        this.singleItem = null;
        this.queue = null;
    }

    bc.e<T> getOrCreateQueue() {
        bc.e<T> r10 = this.queue;
        if (r10 != null) goto L6;
        io.reactivex.internal.queue.a r11 = new io.reactivex.internal.queue.a(Observable.a());
        this.queue = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    @Override // xb.o
    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        DisposableHelper.dispose(this.mainDisposable);
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (compareAndSet(0, 1) == false) goto L7;
        this.downstream.onNext(r10);
        if (decrementAndGet() != 0) goto L10;
        return;
    L10:
        drainLoop();
        return;
    L7:
        getOrCreateQueue().offer(r10);
        if (getAndIncrement() == 0) goto L10;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.mainDisposable, r10);
    }

    void otherComplete() {
        this.otherState = 2;
        drain();
    }

    void otherError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        DisposableHelper.dispose(this.mainDisposable);
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    void otherSuccess(T r10) {
        if (compareAndSet(0, 1) == false) goto L5;
        this.downstream.onNext(r10);
        this.otherState = 2;
    L8:
        drainLoop();
        return;
    L5:
        this.singleItem = r10;
        this.otherState = 1;
        if (getAndIncrement() == 0) goto L8;
    }
}
