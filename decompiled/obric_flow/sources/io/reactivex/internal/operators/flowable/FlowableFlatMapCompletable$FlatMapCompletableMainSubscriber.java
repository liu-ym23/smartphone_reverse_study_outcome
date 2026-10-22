package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements mt.g {
    private static final long serialVersionUID = 8443155186132538303L;
    volatile boolean cancelled;
    final boolean delayErrors;
    final zu.c downstream;
    final AtomicThrowable errors;
    final pt.o mapper;
    final int maxConcurrency;
    final io.reactivex.disposables.a set;
    zu.d upstream;

    public final class InnerConsumer extends AtomicReference<Disposable> implements mt.b, Disposable {
        private static final long serialVersionUID = 8606673141535671828L;
        final /* synthetic */ FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber this$0;

        public InnerConsumer(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber r5) {
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

        @Override // mt.b
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // mt.b
        public void onError(Throwable r5) {
            this.this$0.innerError(this, r5);
        }

        @Override // mt.b
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }
    }

    public FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber(zu.c r5, pt.o r10, boolean r11, int r12) {
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.errors = new AtomicThrowable();
        this.set = new io.reactivex.disposables.a();
        this.maxConcurrency = r12;
        lazySet(1);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public void clear() {
    }

    public void innerComplete(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer r5) {
        this.set.c(r5);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer r5, Throwable r10) {
        this.set.c(r5);
        onError(r10);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        return true;
    }

    @Override // zu.c
    public void onComplete() {
        if (decrementAndGet() != 0) goto L9;
        Throwable r5 = this.errors.terminate();
        if (r5 == null) goto L7;
        this.downstream.onError(r5);
        return;
    L7:
        this.downstream.onComplete();
        return;
    L9:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
        this.upstream.request(1);
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        cancel();
        if (getAndSet(0) <= 0) goto L20;
        Throwable r10 = this.errors.terminate();
        this.downstream.onError(r10);
        return;
    L20:
        return;
    L7:
        if (decrementAndGet() != 0) goto L10;
        Throwable r11 = this.errors.terminate();
        this.downstream.onError(r11);
        return;
    L10:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L18;
        this.upstream.request(1);
        return;
    }

    @Override // zu.c
    public void onNext(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
        mt.c r11 = (mt.c) r10;     // Catch: Throwable -> L9
        getAndIncrement();
        InnerConsumer r12 = new InnerConsumer(this);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        if (this.set.b(r12) == false) goto L15;
        ((mt.a) r11).b(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L9;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        int r10 = this.maxConcurrency;
        if (r10 != Integer.MAX_VALUE) goto L7;
        r5.request(Long.MAX_VALUE);
        return;
    L7:
        r5.request(r10);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public T poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void request(long r5) {
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.d
    public int requestFusion(int r5) {
        return r5 & 2;
    }
}
