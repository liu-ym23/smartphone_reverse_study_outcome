package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeDelayOtherPublisher$OtherSubscriber<T> extends AtomicReference<zu.d> implements g {
    private static final long serialVersionUID = -1215060610805418006L;
    final j downstream;
    Throwable error;
    T value;

    public MaybeDelayOtherPublisher$OtherSubscriber(j r5) {
        this.downstream = r5;
    }

    @Override // zu.c
    public void onComplete() {
        Throwable r5 = this.error;
        if (r5 == null) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        T r10 = this.value;
        if (r10 == null) goto L8;
        this.downstream.onSuccess(r10);
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        Throwable r10 = this.error;
        if (r10 != null) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        this.downstream.onError(new CompositeException(new Throwable[]{r10, r5}));
    }

    @Override // zu.c
    public void onNext(Object r5) {
        zu.d r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        r10.cancel();
        onComplete();
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
    }
}
