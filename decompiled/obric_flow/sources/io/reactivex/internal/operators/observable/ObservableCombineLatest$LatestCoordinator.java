package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    volatile boolean cancelled;
    final pt.o combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable errors;
    Object[] latest;
    final ObservableCombineLatest$CombinerObserver<T, R>[] observers;
    final io.reactivex.internal.queue.b queue;

    public ObservableCombineLatest$LatestCoordinator(mt.u r5, pt.o r10, int r11, int r12, boolean r13) {
        this.errors = new AtomicThrowable();
        this.downstream = r5;
        this.combiner = r10;
        this.delayError = r13;
        this.latest = new Object[r11];
        ObservableCombineLatest$CombinerObserver<T, R>[] r14 = new ObservableCombineLatest$CombinerObserver[r11];
        int r15 = 0;
    L3:
        if (r15 >= r11) goto L5;
        r14[r15] = new ObservableCombineLatest$CombinerObserver(this, r15);
        r15 = r15 + 1;
        goto L3
    L5:
        this.observers = r14;
        this.queue = new io.reactivex.internal.queue.b(r12);
    }

    public void cancelSources() {
        ObservableCombineLatest$CombinerObserver<T, R>[] r5 = this.observers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].dispose();
        r11 = r11 + 1;
        goto L3
    }

    public void clear(io.reactivex.internal.queue.b r5) {
        monitor-enter(this);
        this.latest = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        r5.clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
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

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.b r5 = this.queue;
        mt.u r10 = this.downstream;
        boolean r11 = this.delayError;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r11 == false) goto L12;
    L15:
        boolean r13 = this.done;
        Object[] r14 = (Object[]) r5.poll();
        if (r14 != null) goto L18;
        boolean r15 = true;
    L19:
        if (r13 == false) goto L26;
        if (r15 == false) goto L26;
        clear(r5);
        Throwable r16 = this.errors.terminate();
        if (r16 != null) goto L24;
        r10.onComplete();
        return;
    L24:
        r10.onError(r16);
        return;
    L26:
        if (r15 == true) goto L27;
        Object r17 = this.combiner.apply(r14);     // Catch: Throwable -> L32
        io.reactivex.internal.functions.e.d(r17, "The combiner returned a null value");     // Catch: Throwable -> L32
        r10.onNext(r17);
    L32:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.errors.addThrowable(th);
        cancelSources();
        clear(r5);
        r10.onError(this.errors.terminate());
        return;
    L27:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L18:
        r15 = false;
        goto L19
    L12:
        if (this.errors.get() == null) goto L15;
        cancelSources();
        clear(r5);
        r10.onError(this.errors.terminate());
        return;
    L8:
        clear(r5);
    }

    public void innerComplete(int r5) {
        monitor-enter(this);
        Object[] r10 = this.latest;     // Catch: Throwable -> L7
        if (r10 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L10:
        if (r10[r5] != null) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == true) goto L16;
        int r12 = this.complete + 1;     // Catch: Throwable -> L7
        this.complete = r12;     // Catch: Throwable -> L7
        if (r12 == r10.length) goto L16;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r11 == false) goto L20;
        cancelSources();
    L20:
        drain();
        return;
    L16:
        this.done = true;     // Catch: Throwable -> L7
        goto L17
    L12:
        r11 = false;
    L7:
        th = move-exception;
        throw th;
    }

    public void innerError(int r5, Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L28;
        boolean r11 = true;
        if (this.delayError == false) goto L25;
        monitor-enter(this);
        Object[] r12 = this.latest;     // Catch: Throwable -> L11
        if (r12 != null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L14:
        if (r12[r5] != null) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == true) goto L20;
        int r14 = this.complete + 1;     // Catch: Throwable -> L11
        this.complete = r14;     // Catch: Throwable -> L11
        if (r14 == r12.length) goto L20;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L11
        r11 = r13;
    L20:
        this.done = true;     // Catch: Throwable -> L11
        goto L21
    L16:
        r13 = false;
    L11:
        th = move-exception;
        throw th;
    L25:
        if (r11 == false) goto L27;
        cancelSources();
    L27:
        drain();
        return;
    L28:
        wn.f.k(r10);
    }

    public void innerNext(int r5, T r10) {
        monitor-enter(this);
        Object[] r11 = this.latest;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        Object r12 = r11[r5];     // Catch: Throwable -> L7
        int r13 = this.active;     // Catch: Throwable -> L7
        if (r12 != null) goto L12;
        r13 = r13 + 1;     // Catch: Throwable -> L7
        this.active = r13;     // Catch: Throwable -> L7
    L12:
        r11[r5] = r10;     // Catch: Throwable -> L7
        if (r13 != r11.length) goto L15;
        this.queue.offer(r11.clone());     // Catch: Throwable -> L7
        boolean r14 = true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r14 == false) goto L23;
        drain();
        return;
    L23:
        return;
    L15:
        r14 = false;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(mt.s[] r10) {
        ObservableCombineLatest$CombinerObserver<T, R>[] r5 = this.observers;
        int r11 = r5.length;
        this.downstream.onSubscribe(this);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        if (this.done == true) goto L14;
        if (this.cancelled == true) goto L15;
        r10[r12].subscribe(r5[r12]);
        r12 = r12 + 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }
}
