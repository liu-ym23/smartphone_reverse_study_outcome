package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableGroupJoin$LeftRightEndSubscriber extends AtomicReference<zu.d> implements mt.g, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final k parent;

    public FlowableGroupJoin$LeftRightEndSubscriber(k r5, boolean r10, int r11) {
        this.parent = r5;
        this.isLeft = r10;
        this.index = r11;
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
        this.parent.innerClose(this.isLeft, this);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.parent.innerCloseError(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        if (SubscriptionHelper.cancel(this) == false) goto L6;
        this.parent.innerClose(this.isLeft, this);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
