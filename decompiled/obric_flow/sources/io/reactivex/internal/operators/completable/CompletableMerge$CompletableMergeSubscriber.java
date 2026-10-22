package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import mt.c;
import mt.g;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableMerge$CompletableMergeSubscriber extends AtomicInteger implements g, Disposable {
    private static final long serialVersionUID = -2108443387387077490L;
    final boolean delayErrors;
    final b downstream;
    final AtomicThrowable error;
    final int maxConcurrency;
    final io.reactivex.disposables.a set;
    d upstream;

    public final class MergeInnerObserver extends AtomicReference<Disposable> implements b, Disposable {
        private static final long serialVersionUID = 251330541679988317L;
        final /* synthetic */ CompletableMerge$CompletableMergeSubscriber this$0;

        public MergeInnerObserver(CompletableMerge$CompletableMergeSubscriber r5) {
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

    public CompletableMerge$CompletableMergeSubscriber(b r5, int r10, boolean r11) {
        this.downstream = r5;
        this.maxConcurrency = r10;
        this.delayErrors = r11;
        this.set = new io.reactivex.disposables.a();
        this.error = new AtomicThrowable();
        lazySet(1);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.cancel();
        this.set.dispose();
    }

    public void innerComplete(MergeInnerObserver r5) {
        this.set.c(r5);
        if (decrementAndGet() != 0) goto L9;
        Throwable r10 = this.error.get();
        if (r10 == null) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        this.downstream.onComplete();
        return;
    L9:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
        this.upstream.request(1);
        return;
    }

    public void innerError(MergeInnerObserver r5, Throwable r10) {
        this.set.c(r5);
        if (this.delayErrors == true) goto L11;
        this.upstream.cancel();
        this.set.dispose();
        if (this.error.addThrowable(r10) == true) goto L7;
        f.k(r10);
        return;
    L7:
        if (getAndSet(0) <= 0) goto L20;
        this.downstream.onError(this.error.terminate());
        return;
    L20:
        return;
    L11:
        if (this.error.addThrowable(r10) == true) goto L13;
        f.k(r10);
        return;
    L13:
        if (decrementAndGet() != 0) goto L16;
        this.downstream.onError(this.error.terminate());
        return;
    L16:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
        this.upstream.request(1);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.set.f17606b;
    }

    @Override // zu.c
    public void onComplete() {
        if (decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (this.error.get() == null) goto L7;
        this.downstream.onError(this.error.terminate());
        return;
    L7:
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.delayErrors == true) goto L11;
        this.set.dispose();
        if (this.error.addThrowable(r5) == true) goto L7;
        f.k(r5);
        return;
    L7:
        if (getAndSet(0) <= 0) goto L17;
        this.downstream.onError(this.error.terminate());
        return;
    L17:
        return;
    L11:
        if (this.error.addThrowable(r5) == true) goto L13;
        f.k(r5);
        return;
    L13:
        if (decrementAndGet() != 0) goto L20;
        this.downstream.onError(this.error.terminate());
        return;
    }

    @Override // zu.c
    public /* bridge */ /* synthetic */ void onNext(Object r5) {
        onNext((c) r5);
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
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

    public void onNext(c r5) {
        getAndIncrement();
        MergeInnerObserver r10 = new MergeInnerObserver(this);
        this.set.b(r10);
        ((mt.a) r5).b(r10);
    }
}
