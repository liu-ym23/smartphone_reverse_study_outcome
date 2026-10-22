package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableWindow$WindowSkipSubscriber<T> extends AtomicInteger implements mt.g, zu.d, Runnable {
    private static final long serialVersionUID = -8792836352386833856L;
    final int bufferSize;
    final zu.c downstream;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    final long size;
    final long skip;
    zu.d upstream;
    io.reactivex.processors.g window;

    public FlowableWindow$WindowSkipSubscriber(zu.c r5, long r10, long r11, int r12) {
        super(1);
        this.downstream = r5;
        this.size = r10;
        this.skip = r11;
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.bufferSize = r12;
    }

    @Override // zu.d
    public void cancel() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        run();
        return;
    }

    @Override // zu.c
    public void onComplete() {
        io.reactivex.processors.g r5 = this.window;
        if (r5 == null) goto L5;
        this.window = null;
        r5.onComplete();
    L5:
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        io.reactivex.processors.g r10 = this.window;
        if (r10 == null) goto L5;
        this.window = null;
        r10.onError(r5);
    L5:
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r10) {
        long r5 = this.index;
        io.reactivex.processors.g r11 = this.window;
        if (r5 != 0) goto L5;
        getAndIncrement();
        io.reactivex.processors.g r12 = new io.reactivex.processors.g(this, this.bufferSize);
        this.window = r12;
        this.downstream.onNext(r12);
        r11 = r12;
    L5:
        long r13 = r5 + 1;
        if (r11 == null) goto L9;
        r11.onNext(r10);
    L9:
        if (r13 != this.size) goto L12;
        this.window = null;
        r11.onComplete();
    L12:
        if (r13 != this.skip) goto L14;
        this.index = 0;
        return;
    L14:
        this.index = r13;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (this.firstRequest.get() == false) goto L7;
    L9:
        long r11 = v0.x(this.skip, r10);
        this.upstream.request(r11);
        return;
    L7:
        if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
        long r12 = v0.t(v0.x(this.size, r10), v0.x(this.skip - this.size, r10 - 1));
        this.upstream.request(r12);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() != 0) goto L6;
        this.upstream.cancel();
        return;
    }
}
