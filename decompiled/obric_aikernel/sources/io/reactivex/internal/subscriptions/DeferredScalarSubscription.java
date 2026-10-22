package io.reactivex.internal.subscriptions;

import tc.c;

/* JADX INFO: loaded from: classes2.dex */
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
    protected final c<? super T> downstream;
    protected T value;

    public DeferredScalarSubscription(c<? super T> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T r10) {
        int r11 = get();
    L4:
        if (r11 == 8) goto L5;
        if ((r11 & (-3)) != 0) goto L11;
        if (r11 == 2) goto L14;
        this.value = r10;
        if (compareAndSet(0, 1) == true) goto L20;
        r11 = get();
        if (r11 != 4) goto L4;
        this.value = null;
        return;
    L20:
        return;
    L14:
        lazySet(3);
        c<? super T> r12 = this.downstream;
        r12.onNext(r10);
        if (get() == 4) goto L32;
        r12.onComplete();
        return;
    L32:
        return;
    L11:
        return;
    L5:
        this.value = r10;
        lazySet(16);
        c<? super T> r13 = this.downstream;
        r13.onNext(r10);
        if (get() == 4) goto L31;
        r13.onComplete();
        return;
    }

    public final boolean isCancelled() {
        if (get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public final boolean isEmpty() {
        if (get() == 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public final T poll() {
        if (get() != 16) goto L6;
        lazySet(32);
        T r10 = this.value;
        this.value = null;
        return r10;
    L6:
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L19;
    L4:
        int r11 = get();
        if ((r11 & (-2)) != 0) goto L6;
        if (r11 == 1) goto L10;
        if (compareAndSet(0, 2) == false) goto L4;
        return;
    L10:
        if (compareAndSet(1, 3) == false) goto L24;
        T r12 = this.value;
        if (r12 == null) goto L25;
        this.value = null;
        c<? super T> r13 = this.downstream;
        r13.onNext(r12);
        if (get() == 4) goto L26;
        r13.onComplete();
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

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
    public final int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
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
