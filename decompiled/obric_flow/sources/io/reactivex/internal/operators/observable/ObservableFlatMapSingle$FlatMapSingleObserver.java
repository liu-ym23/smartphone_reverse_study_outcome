package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableFlatMapSingle$FlatMapSingleObserver<T, R> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final mt.u downstream;
    final AtomicThrowable errors;
    final pt.o mapper;
    final AtomicReference<io.reactivex.internal.queue.b> queue;
    final io.reactivex.disposables.a set;
    Disposable upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements mt.b0, Disposable {
        private static final long serialVersionUID = -502562646270949838L;
        final /* synthetic */ ObservableFlatMapSingle$FlatMapSingleObserver this$0;

        public InnerObserver(ObservableFlatMapSingle$FlatMapSingleObserver r5) {
            this.this$0 = r5;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // mt.b0, mt.j
        public void onError(Throwable r5) {
            this.this$0.innerError(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSuccess(R r5) {
            this.this$0.innerSuccess(this, r5);
        }
    }

    public ObservableFlatMapSingle$FlatMapSingleObserver(mt.u r5, pt.o r10, boolean r11) {
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.set = new io.reactivex.disposables.a();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    public void clear() {
        io.reactivex.internal.queue.b r5 = this.queue.get();
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    public void drainLoop() {
        mt.u r5 = this.downstream;
        AtomicInteger r10 = this.active;
        AtomicReference<io.reactivex.internal.queue.b> r11 = this.queue;
        int r12 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        if (this.delayErrors == false) goto L10;
    L13:
        boolean r13 = false;
        if (r10.get() != 0) goto L16;
        boolean r14 = true;
    L17:
        io.reactivex.internal.queue.b r15 = r11.get();
        if (r15 == null) goto L20;
        Object r16 = r15.poll();
    L21:
        if (r16 != null) goto L23;
        r13 = true;
    L23:
        if (r14 == false) goto L30;
        if (r13 == false) goto L30;
        Throwable r17 = this.errors.terminate();
        if (r17 == null) goto L28;
        r5.onError(r17);
        return;
    L28:
        r5.onComplete();
        return;
    L30:
        if (r13 == true) goto L31;
        r5.onNext(r16);
        goto L4
    L31:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L20:
        r16 = null;
        goto L21
    L16:
        r14 = false;
        goto L17
    L10:
        if (this.errors.get() == null) goto L13;
        Throwable r18 = this.errors.terminate();
        clear();
        r5.onError(r18);
        return;
    L5:
        clear();
    }

    public io.reactivex.internal.queue.b getOrCreateQueue() {
    L2:
        io.reactivex.internal.queue.b r5 = this.queue.get();
        if (r5 != null) goto L4;
        io.reactivex.internal.queue.b r10 = new io.reactivex.internal.queue.b(mt.n.bufferSize());
        AtomicReference<io.reactivex.internal.queue.b> r11 = this.queue;
    L7:
        if (r11.compareAndSet(null, r10) == true) goto L8;
        if (r11.get() == null) goto L7;
    L8:
        return r10;
    L4:
        return r5;
    }

    public void innerError(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver r5, Throwable r10) {
        this.set.c(r5);
        if (this.errors.addThrowable(r10) == true) goto L5;
        wn.f.k(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.upstream.dispose();
        this.set.dispose();
    L7:
        this.active.decrementAndGet();
        drain();
    }

    public void innerSuccess(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver r5, R r10) {
        this.set.c(r5);
        if (get() != 0) goto L22;
        boolean r11 = false;
        if (compareAndSet(0, 1) == false) goto L22;
        this.downstream.onNext(r10);
        if (this.active.decrementAndGet() != 0) goto L9;
        r11 = true;
    L9:
        io.reactivex.internal.queue.b r12 = this.queue.get();
        if (r11 == false) goto L20;
        if (r12 != null) goto L13;
    L14:
        Throwable r13 = this.errors.terminate();
        if (r13 == null) goto L17;
        this.downstream.onError(r13);
        return;
    L17:
        this.downstream.onComplete();
        return;
    L13:
        if (r12.isEmpty() == true) goto L14;
    L20:
        if (decrementAndGet() != 0) goto L29;
        return;
    L29:
        drainLoop();
        return;
    L22:
        io.reactivex.internal.queue.b r14 = getOrCreateQueue();
        monitor-enter(r14);
        r14.offer(r10);     // Catch: Throwable -> L31
        monitor-exit(r14);     // Catch: Throwable -> L31
        this.active.decrementAndGet();
        if (getAndIncrement() == 0) goto L29;
        return;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.set.dispose();
    L7:
        drain();
    }

    @Override // mt.u
    public void onNext(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null SingleSource");     // Catch: Throwable -> L9
        mt.c0 r11 = (mt.c0) r10;     // Catch: Throwable -> L9
        this.active.getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        if (this.set.b(r12) == false) goto L15;
        ((mt.a0) r11).b(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
