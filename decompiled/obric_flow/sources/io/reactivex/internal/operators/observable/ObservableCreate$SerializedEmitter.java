package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableCreate$SerializedEmitter<T> extends AtomicInteger implements mt.p {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final mt.p emitter;
    final AtomicThrowable error;
    final io.reactivex.internal.queue.b queue;

    public ObservableCreate$SerializedEmitter(mt.p r5) {
        this.emitter = r5;
        this.error = new AtomicThrowable();
        this.queue = new io.reactivex.internal.queue.b(16);
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    public void drainLoop() {
        mt.p r5 = this.emitter;
        io.reactivex.internal.queue.b r10 = this.queue;
        AtomicThrowable r11 = this.error;
        int r12 = 1;
    L4:
        if (r5.isDisposed() == true) goto L5;
        if (r11.get() != null) goto L9;
        boolean r13 = this.done;
        Object r14 = r10.poll();
        if (r14 != null) goto L14;
        boolean r15 = true;
    L15:
        if (r13 == false) goto L19;
        if (r15 == false) goto L19;
        r5.onComplete();
        return;
    L19:
        if (r15 == true) goto L20;
        r5.onNext(r14);
        goto L4
    L20:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L14:
        r15 = false;
        goto L15
    L9:
        r10.clear();
        r5.onError(r11.terminate());
        return;
    L5:
        r10.clear();
    }

    @Override // mt.p, io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.emitter.isDisposed();
    }

    @Override // mt.d
    public void onComplete() {
        if (this.emitter.isDisposed() == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L10;
        this.done = true;
        drain();
        return;
    }

    @Override // mt.d
    public void onError(Throwable r5) {
        if (tryOnError(r5) == true) goto L6;
        wn.f.k(r5);
        return;
    }

    @Override // mt.d
    public void onNext(T r5) {
        if (this.emitter.isDisposed() == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L32;
        if (r5 != null) goto L11;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L11:
        if (get() == 0) goto L13;
    L17:
        io.reactivex.internal.queue.b r10 = this.queue;
        monitor-enter(r10);
        r10.offer(r5);     // Catch: Throwable -> L26
        monitor-exit(r10);     // Catch: Throwable -> L26
        if (getAndIncrement() == 0) goto L24;
        return;
    L24:
        drainLoop();
        return;
    L26:
        th = move-exception;
        throw th;
    L13:
        if (compareAndSet(0, 1) == false) goto L17;
        this.emitter.onNext(r5);
        if (decrementAndGet() != 0) goto L24;
        return;
    }

    public mt.p serialize() {
        return this;
    }

    @Override // mt.p
    public void setCancellable(pt.f r5) {
        this.emitter.setCancellable(r5);
    }

    @Override // mt.p
    public void setDisposable(Disposable r5) {
        this.emitter.setDisposable(r5);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.emitter.toString();
    }

    public boolean tryOnError(Throwable r5) {
        if (this.emitter.isDisposed() == false) goto L5;
    L13:
        return false;
    L5:
        if (this.done == true) goto L13;
        if (r5 != null) goto L10;
        r5 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L10:
        if (this.error.addThrowable(r5) == false) goto L13;
        this.done = true;
        drain();
        return true;
    }
}
