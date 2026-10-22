package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableGroupBy$State<T, K> extends AtomicInteger implements Disposable, mt.s {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<mt.u> actual;
    final AtomicBoolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once;
    final ObservableGroupBy$GroupByObserver<?, K, T> parent;
    final io.reactivex.internal.queue.b queue;

    public ObservableGroupBy$State(int r5, ObservableGroupBy$GroupByObserver<?, K, T> r10, K r11, boolean r12) {
        this.cancelled = new AtomicBoolean();
        this.once = new AtomicBoolean();
        this.actual = new AtomicReference();
        this.queue = new io.reactivex.internal.queue.b(r5);
        this.parent = r10;
        this.key = r11;
        this.delayError = r12;
    }

    public boolean checkTerminated(boolean r5, boolean r10, mt.u r11, boolean r12) {
        if (this.cancelled.get() == false) goto L6;
        this.queue.clear();
        this.parent.cancel(this.key);
        this.actual.lazySet(null);
        return true;
    L6:
        if (r5 == false) goto L21;
        if (r12 == false) goto L14;
        if (r10 == false) goto L23;
        Throwable r13 = this.error;
        this.actual.lazySet(null);
        if (r13 == null) goto L12;
        r11.onError(r13);
    L13:
        return true;
    L12:
        r11.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r14 = this.error;
        if (r14 == null) goto L18;
        this.queue.clear();
        this.actual.lazySet(null);
        r11.onError(r14);
        return true;
    L18:
        if (r10 == false) goto L24;
        this.actual.lazySet(null);
        r11.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (getAndIncrement() != 0) goto L9;
        this.actual.lazySet(null);
        this.parent.cancel(this.key);
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.b r5 = this.queue;
        boolean r10 = this.delayError;
        mt.u r11 = this.actual.get();
        int r12 = 1;
    L6:
        if (r11 == null) goto L17;
    L7:
        boolean r13 = this.done;
        Object r14 = r5.poll();
        if (r14 != null) goto L10;
        boolean r15 = true;
    L12:
        if (checkTerminated(r13, r15, r11, r10) == true) goto L13;
        if (r15 == true) goto L17;
        r11.onNext(r14);
        goto L7
    L13:
        return;
    L10:
        r15 = false;
    L17:
        r12 = addAndGet(-r12);
        if (r12 == 0) goto L19;
        if (r11 != null) goto L6;
        r11 = this.actual.get();
        goto L6
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        drain();
    }

    public void onNext(T r5) {
        this.queue.offer(r5);
        drain();
    }

    @Override // mt.s
    public void subscribe(mt.u r5) {
        if (this.once.compareAndSet(false, true) == false) goto L8;
        r5.onSubscribe(this);
        this.actual.lazySet(r5);
        if (this.cancelled.get() == false) goto L7;
        this.actual.lazySet(null);
        return;
    L7:
        drain();
        return;
    L8:
        EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), r5);
    }
}
