package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTimeout$TimeoutConsumer extends AtomicReference<tc.d> implements xb.g<Object>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final l parent;

    FlowableTimeout$TimeoutConsumer(long r10, l r11) {
        this.idx = r10;
        this.parent = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // tc.c
    public void onComplete() {
        tc.d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        tc.d r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L5;
        lazySet(r12);
        this.parent.onTimeoutError(this.idx, r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        tc.d r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L6;
        r11.cancel();
        lazySet(r12);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
