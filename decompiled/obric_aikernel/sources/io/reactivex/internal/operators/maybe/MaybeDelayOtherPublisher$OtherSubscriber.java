package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.g;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeDelayOtherPublisher$OtherSubscriber<T> extends AtomicReference<tc.d> implements g<Object> {
    private static final long serialVersionUID = -1215060610805418006L;
    final j<? super T> downstream;
    Throwable error;
    T value;

    MaybeDelayOtherPublisher$OtherSubscriber(j<? super T> r10) {
        this.downstream = r10;
    }

    @Override // tc.c
    public void onComplete() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        T r11 = this.value;
        j<? super T> r12 = this.downstream;
        if (r11 == null) goto L8;
        r12.onSuccess(r11);
        return;
    L8:
        r12.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        Throwable r11 = this.error;
        j<? super T> r12 = this.downstream;
        if (r11 != null) goto L5;
        r12.onError(r10);
        return;
    L5:
        r12.onError(new CompositeException(new Throwable[]{r11, r10}));
    }

    @Override // tc.c
    public void onNext(Object r10) {
        tc.d r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L6;
        lazySet(r12);
        r11.cancel();
        onComplete();
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
