package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.c;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableMerge$CompletableMergeSubscriber extends AtomicInteger implements g<c>, b {
    private static final long serialVersionUID = -2108443387387077490L;
    final boolean delayErrors;
    final xb.b downstream;
    final AtomicThrowable error;
    final int maxConcurrency;
    final io.reactivex.disposables.a set;
    d upstream;

    final class MergeInnerObserver extends AtomicReference<b> implements xb.b, b {
        private static final long serialVersionUID = 251330541679988317L;
        final /* synthetic */ CompletableMerge$CompletableMergeSubscriber this$0;

        MergeInnerObserver(CompletableMerge$CompletableMergeSubscriber r10) {
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

        @Override // xb.b
        public void onComplete() {
            this.this$0.innerComplete(this);
        }

        @Override // xb.b
        public void onError(Throwable r10) {
            this.this$0.innerError(this, r10);
        }

        @Override // xb.b
        public void onSubscribe(b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    CompletableMerge$CompletableMergeSubscriber(xb.b r10, int r11, boolean r12) {
        this.downstream = r10;
        this.maxConcurrency = r11;
        this.delayErrors = r12;
        this.set = new io.reactivex.disposables.a();
        this.error = new AtomicThrowable();
        lazySet(1);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.cancel();
        this.set.dispose();
    }

    void innerComplete(MergeInnerObserver r10) {
        this.set.c(r10);
        if (decrementAndGet() != 0) goto L9;
        Throwable r11 = this.error.get();
        xb.b r12 = this.downstream;
        if (r11 == null) goto L7;
        r12.onError(r11);
        return;
    L7:
        r12.onComplete();
        return;
    L9:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
        this.upstream.request(1);
        return;
    }

    void innerError(MergeInnerObserver r10, Throwable r11) {
        this.set.c(r10);
        if (this.delayErrors == true) goto L10;
        this.upstream.cancel();
        this.set.dispose();
        if (this.error.addThrowable(r11) == true) goto L7;
    L17:
        dc.a.n(r11);
        return;
    L7:
        if (getAndSet(0) <= 0) goto L19;
    L13:
        this.downstream.onError(this.error.terminate());
        return;
    L19:
        return;
    L10:
        if (this.error.addThrowable(r11) == false) goto L17;
        if (decrementAndGet() == 0) goto L13;
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L21;
        this.upstream.request(1);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    @Override // tc.c
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

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.delayErrors == true) goto L10;
        this.set.dispose();
        if (this.error.addThrowable(r10) == true) goto L7;
    L14:
        dc.a.n(r10);
        return;
    L7:
        if (getAndSet(0) <= 0) goto L16;
    L13:
        this.downstream.onError(this.error.terminate());
        return;
    L16:
        return;
    L10:
        if (this.error.addThrowable(r10) == false) goto L14;
        if (decrementAndGet() == 0) goto L13;
    }

    @Override // tc.c
    public /* bridge */ /* synthetic */ void onNext(Object r10) {
        onNext((c) r10);
    }

    public void onNext(c r10) {
        getAndIncrement();
        MergeInnerObserver r11 = new MergeInnerObserver(this);
        this.set.b(r11);
        r10.a(r11);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L10;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        int r11 = this.maxConcurrency;
        if (r11 != Integer.MAX_VALUE) goto L7;
        long r12 = Long.MAX_VALUE;
    L8:
        r10.request(r12);
        return;
    L7:
        r12 = r11;
        goto L8
    }
}
