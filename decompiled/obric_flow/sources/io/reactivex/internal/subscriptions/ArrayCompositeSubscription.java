package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<d> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int r5) {
        super(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r5 = 0;
        if (get(0) == SubscriptionHelper.CANCELLED) goto L13;
        int r10 = length();
    L5:
        if (r5 >= r10) goto L19;
        d r11 = get(r5);
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L12;
        d r13 = getAndSet(r5, r12);
        if (r13 == r12) goto L12;
        if (r13 == null) goto L12;
        r13.cancel();
    L12:
        r5 = r5 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != SubscriptionHelper.CANCELLED) goto L6;
        return true;
    L6:
        return false;
    }

    public d replaceResource(int r5, d r10) {
    L2:
        d r11 = get(r5);
        if (r11 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r5, r11, r10) == false) goto L2;
        return r11;
    L4:
        if (r10 == null) goto L14;
        r10.cancel();
        return null;
    L14:
        return null;
    }

    public boolean setResource(int r5, d r10) {
    L2:
        d r11 = get(r5);
        if (r11 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r5, r11, r10) == false) goto L2;
        if (r11 == null) goto L18;
        r11.cancel();
        return true;
    L18:
        return true;
    L4:
        if (r10 == null) goto L17;
        r10.cancel();
        return false;
    L17:
        return false;
    }
}
