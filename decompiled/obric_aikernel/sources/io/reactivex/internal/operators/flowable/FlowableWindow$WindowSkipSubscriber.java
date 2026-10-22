package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableWindow$WindowSkipSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d, Runnable {
    private static final long serialVersionUID = -8792836352386833856L;
    final int bufferSize;
    final tc.c<? super xb.e<T>> downstream;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    final long size;
    final long skip;
    tc.d upstream;
    UnicastProcessor<T> window;

    FlowableWindow$WindowSkipSubscriber(tc.c<? super xb.e<T>> r10, long r11, long r12, int r13) {
        super(1);
        this.downstream = r10;
        this.size = r11;
        this.skip = r12;
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.bufferSize = r13;
    }

    @Override // tc.d
    public void cancel() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        run();
        return;
    }

    @Override // tc.c
    public void onComplete() {
        UnicastProcessor<T> r10 = this.window;
        if (r10 == null) goto L5;
        this.window = null;
        r10.onComplete();
    L5:
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        UnicastProcessor<T> r11 = this.window;
        if (r11 == null) goto L5;
        this.window = null;
        r11.onError(r10);
    L5:
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        long r11 = this.index;
        UnicastProcessor<T> r12 = this.window;
        if (r11 != 0) goto L5;
        getAndIncrement();
        r12 = UnicastProcessor.f(this.bufferSize, this);
        this.window = r12;
        this.downstream.onNext(r12);
    L5:
        long r13 = r11 + 1;
        if (r12 == null) goto L9;
        r12.onNext(r10);
    L9:
        if (r13 != this.size) goto L12;
        this.window = null;
        r12.onComplete();
    L12:
        if (r13 != this.skip) goto L14;
        this.index = 0;
        return;
    L14:
        this.index = r13;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (this.firstRequest.get() == false) goto L7;
    L9:
        long r11 = io.reactivex.internal.util.b.d(this.skip, r10);
    L10:
        this.upstream.request(r11);
        return;
    L7:
        if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
        r11 = io.reactivex.internal.util.b.c(io.reactivex.internal.util.b.d(this.size, r10), io.reactivex.internal.util.b.d(this.skip - this.size, r10 - 1));
        goto L10
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() != 0) goto L6;
        this.upstream.cancel();
        return;
    }
}
