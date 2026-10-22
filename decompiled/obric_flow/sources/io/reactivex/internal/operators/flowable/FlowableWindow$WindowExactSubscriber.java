package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableWindow$WindowExactSubscriber<T> extends AtomicInteger implements mt.g, zu.d, Runnable {
    private static final long serialVersionUID = -2365647875069161133L;
    final int bufferSize;
    final zu.c downstream;
    long index;
    final AtomicBoolean once;
    final long size;
    zu.d upstream;
    io.reactivex.processors.g window;

    public FlowableWindow$WindowExactSubscriber(zu.c r5, long r10, int r11) {
        super(1);
        this.downstream = r5;
        this.size = r10;
        this.once = new AtomicBoolean();
        this.bufferSize = r11;
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
        r11.onNext(r10);
        if (r13 != this.size) goto L8;
        this.index = 0;
        this.window = null;
        r11.onComplete();
        return;
    L8:
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
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        long r10 = v0.x(this.size, r5);
        this.upstream.request(r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() != 0) goto L6;
        this.upstream.cancel();
        return;
    }
}
