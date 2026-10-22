package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTimeout$TimeoutConsumer extends AtomicReference<zu.d> implements mt.g, Disposable {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final u parent;

    public FlowableTimeout$TimeoutConsumer(long r5, u r10) {
        this.idx = r5;
        this.parent = r10;
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
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        zu.d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L5;
        lazySet(r11);
        this.parent.onTimeoutError(this.idx, r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        zu.d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        r10.cancel();
        lazySet(r11);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
