package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCreate$SerializedEmitter<T> extends AtomicInteger implements xb.f<T> {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final FlowableCreate$BaseEmitter<T> emitter;
    final AtomicThrowable error;
    final bc.e<T> queue;

    FlowableCreate$SerializedEmitter(FlowableCreate$BaseEmitter<T> r10) {
        this.emitter = r10;
        this.error = new AtomicThrowable();
        this.queue = new io.reactivex.internal.queue.a(16);
    }

    void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    void drainLoop() {
        FlowableCreate$BaseEmitter<T> r10 = this.emitter;
        bc.e<T> r11 = this.queue;
        AtomicThrowable r12 = this.error;
        int r13 = 1;
    L4:
        if (r10.isCancelled() == true) goto L5;
        if (r12.get() != null) goto L9;
        boolean r14 = this.done;
        T r15 = r11.poll();
        if (r15 != null) goto L14;
        boolean r16 = true;
    L15:
        if (r14 == false) goto L19;
        if (r16 == false) goto L19;
        r10.onComplete();
        return;
    L19:
        if (r16 == true) goto L20;
        r10.onNext(r15);
        goto L4
    L20:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L4;
        return;
    L14:
        r16 = false;
        goto L15
    L9:
        r11.clear();
        r10.onError(r12.terminate());
        return;
    L5:
        r11.clear();
    }

    public boolean isCancelled() {
        return this.emitter.isCancelled();
    }

    @Override // xb.d
    public void onComplete() {
        if (this.emitter.isCancelled() == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L10;
        this.done = true;
        drain();
        return;
    }

    @Override // xb.d
    public void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        dc.a.n(r10);
        return;
    }

    @Override // xb.d
    public void onNext(T r10) {
        if (this.emitter.isCancelled() == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L32;
        if (r10 != null) goto L11;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L11:
        if (get() == 0) goto L13;
    L17:
        bc.e<T> r11 = this.queue;
        monitor-enter(r11);
        r11.offer(r10);     // Catch: Throwable -> L26
        monitor-exit(r11);     // Catch: Throwable -> L26
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
        this.emitter.onNext(r10);
        if (decrementAndGet() != 0) goto L24;
        return;
    }

    public long requested() {
        return this.emitter.requested();
    }

    public xb.f<T> serialize() {
        return this;
    }

    public void setCancellable(zb.f r10) {
        this.emitter.setCancellable(r10);
    }

    public void setDisposable(io.reactivex.disposables.b r10) {
        this.emitter.setDisposable(r10);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.emitter.toString();
    }

    public boolean tryOnError(Throwable r10) {
        if (this.emitter.isCancelled() == false) goto L5;
    L13:
        return false;
    L5:
        if (this.done == true) goto L13;
        if (r10 != null) goto L10;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L10:
        if (this.error.addThrowable(r10) == false) goto L13;
        this.done = true;
        drain();
        return true;
    }
}
