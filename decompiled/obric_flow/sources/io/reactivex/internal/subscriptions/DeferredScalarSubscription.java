package io.reactivex.internal.subscriptions;

import zu.c;

/* JADX INFO: loaded from: classes3.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final c downstream;
    protected T value;

    public DeferredScalarSubscription(c r5) {
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T r5) {
        int r10 = get();
    L4:
        if (r10 == 8) goto L5;
        if ((r10 & (-3)) != 0) goto L11;
        if (r10 == 2) goto L14;
        this.value = r5;
        if (compareAndSet(0, 1) == true) goto L20;
        r10 = get();
        if (r10 != 4) goto L4;
        this.value = null;
        return;
    L20:
        return;
    L14:
        lazySet(3);
        c r11 = this.downstream;
        r11.onNext(r5);
        if (get() == 4) goto L32;
        r11.onComplete();
        return;
    L32:
        return;
    L11:
        return;
    L5:
        this.value = r5;
        lazySet(16);
        c r12 = this.downstream;
        r12.onNext(r5);
        if (get() == 4) goto L31;
        r12.onComplete();
        return;
    }

    public final boolean isCancelled() {
        if (get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public final boolean isEmpty() {
        if (get() == 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public final T poll() {
        if (get() != 16) goto L6;
        lazySet(32);
        T r5 = this.value;
        this.value = null;
        return r5;
    L6:
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public final void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L19;
    L4:
        int r10 = get();
        if ((r10 & (-2)) != 0) goto L6;
        if (r10 == 1) goto L10;
        if (compareAndSet(0, 2) == false) goto L4;
        return;
    L10:
        if (compareAndSet(1, 3) == false) goto L24;
        T r11 = this.value;
        if (r11 == null) goto L25;
        this.value = null;
        c r12 = this.downstream;
        r12.onNext(r11);
        if (get() == 4) goto L26;
        r12.onComplete();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L6:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.d
    public final int requestFusion(int r5) {
        if ((r5 & 2) == 0) goto L6;
        lazySet(8);
        return 2;
    L6:
        return 0;
    }

    public final boolean tryCancel() {
        if (getAndSet(4) == 4) goto L5;
        return true;
    L5:
        return false;
    }
}
