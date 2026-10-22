package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableGroupJoin$LeftRightSubscriber extends AtomicReference<zu.d> implements mt.g, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final k parent;

    public FlowableGroupJoin$LeftRightSubscriber(k r5, boolean r10) {
        this.parent = r5;
        this.isLeft = r10;
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
        this.parent.innerComplete(this);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.innerError(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        this.parent.innerValue(this.isLeft, r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
