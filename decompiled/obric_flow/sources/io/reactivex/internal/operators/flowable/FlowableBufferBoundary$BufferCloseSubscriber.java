package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableBufferBoundary$BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<zu.d> implements mt.g, Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final FlowableBufferBoundary$BufferBoundarySubscriber<T, C, ?, ?> parent;

    public FlowableBufferBoundary$BufferCloseSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<T, C, ?, ?> r5, long r10) {
        this.parent = r5;
        this.index = r10;
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
        zu.d r5 = get();
        SubscriptionHelper r10 = SubscriptionHelper.CANCELLED;
        if (r5 == r10) goto L6;
        lazySet(r10);
        this.parent.close(this, this.index);
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        zu.d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L5;
        lazySet(r11);
        this.parent.boundaryError(this, r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        zu.d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        r10.cancel();
        this.parent.close(this, this.index);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
