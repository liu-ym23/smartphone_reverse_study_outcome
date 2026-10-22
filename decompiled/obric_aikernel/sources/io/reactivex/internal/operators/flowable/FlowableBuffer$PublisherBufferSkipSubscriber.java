package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableBuffer$PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -5616169793639412593L;
    C buffer;
    final Callable<C> bufferSupplier;
    boolean done;
    final tc.c<? super C> downstream;
    int index;
    final int size;
    final int skip;
    tc.d upstream;

    FlowableBuffer$PublisherBufferSkipSubscriber(tc.c<? super C> r10, int r11, int r12, Callable<C> r13) {
        this.downstream = r10;
        this.size = r11;
        this.skip = r12;
        this.bufferSupplier = r13;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        C r10 = this.buffer;
        this.buffer = null;
        if (r10 == null) goto L8;
        this.downstream.onNext(r10);
    L8:
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        this.buffer = null;
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        C r11 = this.buffer;
        int r12 = this.index;
        int r13 = r12 + 1;
        if (r12 == 0) goto L21;
    L12:
        if (r11 == null) goto L17;
        r11.add(r10);
        if (r11.size() != this.size) goto L17;
        this.buffer = null;
        this.downstream.onNext(r11);
    L17:
        if (r13 != this.skip) goto L19;
        r13 = 0;
    L19:
        this.index = r13;
        return;
    L21:
        r11 = (C) io.reactivex.internal.functions.a.d(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L9
        this.buffer = r11;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
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
        if (get() == 0) goto L7;
    L9:
        this.upstream.request(io.reactivex.internal.util.b.d(this.skip, r10));
        return;
    L7:
        if (compareAndSet(0, 1) == false) goto L9;
        this.upstream.request(io.reactivex.internal.util.b.c(io.reactivex.internal.util.b.d(r10, this.size), io.reactivex.internal.util.b.d(this.skip - this.size, r10 - 1)));
    }
}
