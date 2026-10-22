package io.reactivex.processors;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class MulticastProcessor$MulticastSubscription<T> extends AtomicLong implements zu.d {
    private static final long serialVersionUID = -363282618957264509L;
    final zu.c downstream;
    long emitted;
    final d parent;

    public MulticastProcessor$MulticastSubscription(zu.c r5, d r10) {
        this.downstream = r5;
    }

    @Override // zu.d
    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
        return;
    L6:
        throw null;
    }

    public void onComplete() {
        if (get() == Long.MIN_VALUE) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void onError(Throwable r5) {
        if (get() == Long.MIN_VALUE) goto L6;
        this.downstream.onError(r5);
        return;
    }

    public void onNext(T r5) {
        if (get() == Long.MIN_VALUE) goto L6;
        this.emitted++;
        this.downstream.onNext(r5);
        return;
    }

    @Override // zu.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L18;
    L4:
        long r5 = get();
        if (r5 == Long.MIN_VALUE) goto L23;
        long r11 = Long.MAX_VALUE;
        if (r5 == Long.MAX_VALUE) goto L24;
        long r12 = r5 + r10;
        if (r12 < 0) goto L14;
        r11 = r12;
    L14:
        if (compareAndSet(r5, r11) == false) goto L4;
        throw null;
    L24:
        return;
    L23:
        return;
    }
}
