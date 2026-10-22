package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    volatile boolean cancelled;
    final zb.h<? super Object[], ? extends R> combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final xb.o<? super R> downstream;
    final AtomicThrowable errors;
    Object[] latest;
    final ObservableCombineLatest$CombinerObserver<T, R>[] observers;
    final io.reactivex.internal.queue.a<Object[]> queue;

    ObservableCombineLatest$LatestCoordinator(xb.o<? super R> r10, zb.h<? super Object[], ? extends R> r11, int r12, int r13, boolean r14) {
        this.errors = new AtomicThrowable();
        this.downstream = r10;
        this.combiner = r11;
        this.delayError = r14;
        this.latest = new Object[r12];
        ObservableCombineLatest$CombinerObserver<T, R>[] r15 = new ObservableCombineLatest$CombinerObserver[r12];
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L5;
        r15[r16] = new ObservableCombineLatest$CombinerObserver(this, r16);
        r16 = r16 + 1;
        goto L3
    L5:
        this.observers = r15;
        this.queue = new io.reactivex.internal.queue.a(r13);
    }

    void cancelSources() {
        ObservableCombineLatest$CombinerObserver<T, R>[] r10 = this.observers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].dispose();
        r12 = r12 + 1;
        goto L3
    }

    void clear(io.reactivex.internal.queue.a<?> r10) {
        monitor-enter(this);
        this.latest = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        r10.clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() != 0) goto L9;
        clear(this.queue);
        return;
    L9:
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a<Object[]> r10 = this.queue;
        xb.o<? super R> r11 = this.downstream;
        boolean r12 = this.delayError;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r12 == false) goto L12;
    L15:
        boolean r14 = this.done;
        Object[] r15 = r10.poll();
        if (r15 != null) goto L18;
        boolean r16 = true;
    L19:
        if (r14 == false) goto L26;
        if (r16 == false) goto L26;
        clear(r10);
        Throwable r17 = this.errors.terminate();
        if (r17 != null) goto L24;
        r11.onComplete();
        return;
    L24:
        r11.onError(r17);
        return;
    L26:
        if (r16 == true) goto L27;
        r11.onNext((Object) io.reactivex.internal.functions.a.d(this.combiner.apply(r15), "The combiner returned a null value"));
    L32:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
    L13:
        cancelSources();
        clear(r10);
        r11.onError(this.errors.terminate());
        return;
    L27:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L18:
        r16 = false;
        goto L19
    L12:
        if (this.errors.get() == null) goto L15;
    L8:
        clear(r10);
    }

    void innerComplete(int r10) {
        monitor-enter(this);
        Object[] r11 = this.latest;     // Catch: Throwable -> L20
        if (r11 != null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L8:
        if (r11[r10] != null) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L14;
        int r13 = this.complete + 1;     // Catch: Throwable -> L20
        this.complete = r13;     // Catch: Throwable -> L20
        if (r13 == r11.length) goto L14;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r12 == false) goto L18;
        cancelSources();
    L18:
        drain();
        return;
    L14:
        this.done = true;     // Catch: Throwable -> L20
        goto L15
    L10:
        r12 = false;
    L20:
        th = move-exception;
        throw th;
    }

    void innerError(int r10, Throwable r11) {
        if (this.errors.addThrowable(r11) == false) goto L27;
        boolean r12 = true;
        if (this.delayError == false) goto L24;
        monitor-enter(this);
        Object[] r13 = this.latest;     // Catch: Throwable -> L21
        if (r13 != null) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L12:
        if (r13[r10] != null) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == true) goto L18;
        int r15 = this.complete + 1;     // Catch: Throwable -> L21
        this.complete = r15;     // Catch: Throwable -> L21
        if (r15 == r13.length) goto L18;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        r12 = r14;
    L18:
        this.done = true;     // Catch: Throwable -> L21
        goto L19
    L14:
        r14 = false;
    L21:
        th = move-exception;
        throw th;
    L24:
        if (r12 == false) goto L26;
        cancelSources();
    L26:
        drain();
        return;
    L27:
        dc.a.n(r11);
    }

    void innerNext(int r10, T r11) {
        monitor-enter(this);
        Object[] r12 = this.latest;     // Catch: Throwable -> L18
        if (r12 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L7:
        Object r13 = r12[r10];     // Catch: Throwable -> L18
        int r14 = this.active;     // Catch: Throwable -> L18
        if (r13 != null) goto L10;
        r14 = r14 + 1;     // Catch: Throwable -> L18
        this.active = r14;     // Catch: Throwable -> L18
    L10:
        r12[r10] = r11;     // Catch: Throwable -> L18
        if (r14 != r12.length) goto L13;
        this.queue.offer((Object[]) r12.clone());     // Catch: Throwable -> L18
        boolean r15 = true;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L18
        if (r15 == false) goto L22;
        drain();
        return;
    L22:
        return;
    L13:
        r15 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(ObservableSource<? extends T>[] r10) {
        ObservableCombineLatest$CombinerObserver<T, R>[] r11 = this.observers;
        int r12 = r11.length;
        this.downstream.onSubscribe(this);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        if (this.done == true) goto L14;
        if (this.cancelled == true) goto L15;
        r10[r13].subscribe(r11[r13]);
        r13 = r13 + 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }
}
