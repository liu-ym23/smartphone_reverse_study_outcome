package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableGroupJoin$LeftRightSubscriber extends AtomicReference<tc.d> implements xb.g<Object>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final f parent;

    FlowableGroupJoin$LeftRightSubscriber(f r10, boolean r11) {
        this.parent = r10;
        this.isLeft = r11;
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
        this.parent.innerComplete(this);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.parent.innerError(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        this.parent.innerValue(this.isLeft, r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
