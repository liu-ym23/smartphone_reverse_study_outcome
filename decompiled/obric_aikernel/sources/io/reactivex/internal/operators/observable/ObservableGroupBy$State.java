package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableGroupBy$State<T, K> extends AtomicInteger implements io.reactivex.disposables.b, xb.n<T> {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<xb.o<? super T>> actual;
    final AtomicBoolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once;
    final ObservableGroupBy$GroupByObserver<?, K, T> parent;
    final io.reactivex.internal.queue.a<T> queue;

    ObservableGroupBy$State(int r10, ObservableGroupBy$GroupByObserver<?, K, T> r11, K r12, boolean r13) {
        this.cancelled = new AtomicBoolean();
        this.once = new AtomicBoolean();
        this.actual = new AtomicReference();
        this.queue = new io.reactivex.internal.queue.a(r10);
        this.parent = r11;
        this.key = r12;
        this.delayError = r13;
    }

    boolean checkTerminated(boolean r10, boolean r11, xb.o<? super T> r12, boolean r13) {
        if (this.cancelled.get() == false) goto L6;
        this.queue.clear();
        this.parent.cancel(this.key);
        this.actual.lazySet(null);
        return true;
    L6:
        if (r10 == false) goto L21;
        if (r13 == false) goto L14;
        if (r11 == false) goto L23;
        Throwable r14 = this.error;
        this.actual.lazySet(null);
        if (r14 == null) goto L12;
        r12.onError(r14);
    L13:
        return true;
    L12:
        r12.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r15 = this.error;
        if (r15 == null) goto L18;
        this.queue.clear();
        this.actual.lazySet(null);
        r12.onError(r15);
        return true;
    L18:
        if (r11 == false) goto L24;
        this.actual.lazySet(null);
        r12.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (getAndIncrement() != 0) goto L9;
        this.actual.lazySet(null);
        this.parent.cancel(this.key);
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a<T> r10 = this.queue;
        boolean r11 = this.delayError;
        xb.o<? super T> r12 = this.actual.get();
        int r13 = 1;
    L6:
        if (r12 == null) goto L17;
    L7:
        boolean r14 = this.done;
        T r15 = r10.poll();
        if (r15 != null) goto L10;
        boolean r16 = true;
    L12:
        if (checkTerminated(r14, r16, r12, r11) == true) goto L13;
        if (r16 == true) goto L17;
        r12.onNext(r15);
        goto L7
    L13:
        return;
    L10:
        r16 = false;
    L17:
        r13 = addAndGet(-r13);
        if (r13 == 0) goto L19;
        if (r12 != null) goto L6;
        r12 = this.actual.get();
        goto L6
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    public void onNext(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // xb.n
    public void subscribe(xb.o<? super T> r10) {
        if (this.once.compareAndSet(false, true) == false) goto L8;
        r10.onSubscribe(this);
        this.actual.lazySet(r10);
        if (this.cancelled.get() == false) goto L7;
        this.actual.lazySet(null);
        return;
    L7:
        drain();
        return;
    L8:
        EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), r10);
    }
}
