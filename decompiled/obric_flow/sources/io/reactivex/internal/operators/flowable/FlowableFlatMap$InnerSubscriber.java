package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableFlatMap$InnerSubscriber<T, U> extends AtomicReference<zu.d> implements mt.g, Disposable {
    private static final long serialVersionUID = -4606175640614850599L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    final long f17646id;
    final int limit;
    final FlowableFlatMap$MergeSubscriber<T, U> parent;
    long produced;
    volatile rt.h queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber<T, U> r5, long r10) {
        this.f17646id = r10;
        this.parent = r5;
        int r11 = r5.bufferSize;
        this.bufferSize = r11;
        this.limit = r11 >> 2;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        lazySet(SubscriptionHelper.CANCELLED);
        this.parent.innerError(this, r5);
    }

    @Override // zu.c
    public void onNext(U r5) {
        if (this.fusionMode == 2) goto L5;
        this.parent.tryEmit(r5, this);
        return;
    L5:
        this.parent.drain();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.e) == false) goto L13;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.fusionMode = r11;
        this.queue = r10;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r11 != 2) goto L13;
        this.fusionMode = r11;
        this.queue = r10;
    L13:
        r5.request(this.bufferSize);
    }

    public void requestMore(long r5) {
        if (this.fusionMode == 1) goto L9;
        long r10 = this.produced + r5;
        if (r10 < this.limit) goto L7;
        this.produced = 0;
        get().request(r10);
        return;
    L7:
        this.produced = r10;
        return;
    }
}
