package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableBuffer$PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = -5616169793639412593L;
    C buffer;
    final Callable<C> bufferSupplier;
    boolean done;
    final zu.c downstream;
    int index;
    final int size;
    final int skip;
    zu.d upstream;

    public FlowableBuffer$PublisherBufferSkipSubscriber(zu.c r5, int r10, int r11, Callable<C> r12) {
        this.downstream = r5;
        this.size = r10;
        this.skip = r11;
        this.bufferSupplier = r12;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        C r5 = this.buffer;
        this.buffer = null;
        if (r5 == null) goto L8;
        this.downstream.onNext(r5);
    L8:
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        this.buffer = null;
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L5;
        return;
    L5:
        C r10 = this.buffer;
        int r11 = this.index;
        int r12 = r11 + 1;
        if (r11 == 0) goto L21;
    L12:
        if (r10 == null) goto L17;
        r10.add(r5);
        if (r10.size() != this.size) goto L17;
        this.buffer = null;
        this.downstream.onNext(r10);
    L17:
        if (r12 != this.skip) goto L19;
        r12 = 0;
    L19:
        this.index = r12;
        return;
    L21:
        C r13 = this.bufferSupplier.call();     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r13, "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L9
        r10 = r13;     // Catch: Throwable -> L9
        this.buffer = r10;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        onError(th);
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
        if (get() == 0) goto L7;
    L9:
        this.upstream.request(v0.x(this.skip, r10));
        return;
    L7:
        if (compareAndSet(0, 1) == false) goto L9;
        this.upstream.request(v0.t(v0.x(r10, this.size), v0.x(this.skip - this.size, r10 - 1)));
    }
}
