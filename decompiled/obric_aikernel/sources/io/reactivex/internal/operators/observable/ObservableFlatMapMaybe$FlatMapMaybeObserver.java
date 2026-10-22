package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final xb.o<? super R> downstream;
    final AtomicThrowable errors;
    final zb.h<? super T, ? extends xb.k<? extends R>> mapper;
    final AtomicReference<io.reactivex.internal.queue.a<R>> queue;
    final io.reactivex.disposables.a set;
    io.reactivex.disposables.b upstream;

    final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.j<R>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -502562646270949838L;
        final /* synthetic */ ObservableFlatMapMaybe$FlatMapMaybeObserver this$0;

        InnerObserver(ObservableFlatMapMaybe$FlatMapMaybeObserver r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xb.j
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.this$0.innerError(this, r10);
        }

        @Override // xb.j
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // xb.j
        public void onSuccess(R r10) {
            this.this$0.innerSuccess(this, r10);
        }
    }

    ObservableFlatMapMaybe$FlatMapMaybeObserver(xb.o<? super R> r10, zb.h<? super T, ? extends xb.k<? extends R>> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.set = new io.reactivex.disposables.a();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    void clear() {
        io.reactivex.internal.queue.a<R> r10 = this.queue.get();
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    void drainLoop() {
        xb.o<? super R> r10 = this.downstream;
        AtomicInteger r11 = this.active;
        AtomicReference<io.reactivex.internal.queue.a<R>> r12 = this.queue;
        int r13 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        if (this.delayErrors == false) goto L10;
    L13:
        boolean r14 = false;
        if (r11.get() != 0) goto L16;
        boolean r15 = true;
    L17:
        io.reactivex.internal.queue.a<R> r16 = r12.get();
        if (r16 == null) goto L20;
        a1.c r17 = r16.poll();
    L21:
        if (r17 != null) goto L23;
        r14 = true;
    L23:
        if (r15 == false) goto L30;
        if (r14 == false) goto L30;
        Throwable r18 = this.errors.terminate();
        if (r18 == null) goto L28;
        r10.onError(r18);
        return;
    L28:
        r10.onComplete();
        return;
    L30:
        if (r14 == true) goto L31;
        r10.onNext(r17);
        goto L4
    L31:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L4;
        return;
    L20:
        r17 = null;
        goto L21
    L16:
        r15 = false;
        goto L17
    L10:
        if (this.errors.get() == null) goto L13;
        Throwable r19 = this.errors.terminate();
        clear();
        r10.onError(r19);
        return;
    L5:
        clear();
    }

    io.reactivex.internal.queue.a<R> getOrCreateQueue() {
    L2:
        io.reactivex.internal.queue.a<R> r10 = this.queue.get();
        if (r10 != null) goto L4;
        io.reactivex.internal.queue.a<R> r11 = new io.reactivex.internal.queue.a(Observable.a());
        if (this.queue.compareAndSet(null, r11) == false) goto L2;
        return r11;
    L4:
        return r10;
    }

    void innerComplete(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver r10) {
        this.set.c(r10);
        if (get() != 0) goto L23;
        boolean r11 = false;
        if (compareAndSet(0, 1) == false) goto L23;
        if (this.active.decrementAndGet() != 0) goto L9;
        r11 = true;
    L9:
        io.reactivex.internal.queue.a<R> r12 = this.queue.get();
        if (r11 == false) goto L20;
        if (r12 != null) goto L13;
    L14:
        Throwable r13 = this.errors.terminate();
        xb.o<? super R> r14 = this.downstream;
        if (r13 == null) goto L17;
        r14.onError(r13);
        return;
    L17:
        r14.onComplete();
        return;
    L13:
        if (r12.isEmpty() == true) goto L14;
    L20:
        if (decrementAndGet() != 0) goto L22;
        return;
    L22:
        drainLoop();
        return;
    L23:
        this.active.decrementAndGet();
        drain();
    }

    void innerError(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver r10, Throwable r11) {
        this.set.c(r10);
        if (this.errors.addThrowable(r11) == true) goto L5;
        dc.a.n(r11);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.upstream.dispose();
        this.set.dispose();
    L7:
        this.active.decrementAndGet();
        drain();
    }

    void innerSuccess(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver r10, R r11) {
        this.set.c(r10);
        if (get() != 0) goto L22;
        boolean r12 = false;
        if (compareAndSet(0, 1) == false) goto L22;
        this.downstream.onNext(r11);
        if (this.active.decrementAndGet() != 0) goto L9;
        r12 = true;
    L9:
        io.reactivex.internal.queue.a<R> r13 = this.queue.get();
        if (r12 == false) goto L20;
        if (r13 != null) goto L13;
    L14:
        Throwable r14 = this.errors.terminate();
        xb.o<? super R> r15 = this.downstream;
        if (r14 == null) goto L17;
        r15.onError(r14);
        return;
    L17:
        r15.onComplete();
        return;
    L13:
        if (r13.isEmpty() == true) goto L14;
    L20:
        if (decrementAndGet() != 0) goto L29;
        return;
    L29:
        drainLoop();
        return;
    L22:
        io.reactivex.internal.queue.a<R> r16 = getOrCreateQueue();
        monitor-enter(r16);
        r16.offer(r11);     // Catch: Throwable -> L31
        monitor-exit(r16);     // Catch: Throwable -> L31
        this.active.decrementAndGet();
        if (getAndIncrement() == 0) goto L29;
        return;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.set.dispose();
    L7:
        drain();
    }

    @Override // xb.o
    public void onNext(T r10) {
        xb.k r11 = (xb.k) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L9
        this.active.getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        if (this.set.b(r12) == false) goto L15;
        r11.a(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
