package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import rt.e;
import zu.c;

/* JADX INFO: loaded from: classes3.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements e {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final c subscriber;
    final T value;

    public ScalarSubscription(c r5, T r10) {
        this.subscriber = r5;
        this.value = r10;
    }

    @Override // zu.d
    public void cancel() {
        lazySet(2);
    }

    @Override // rt.h
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        if (get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rt.h
    public boolean isEmpty() {
        if (get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rt.h
    public boolean offer(T r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // rt.h
    public T poll() {
        if (get() != 0) goto L6;
        lazySet(1);
        return this.value;
    L6:
        return null;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == true) goto L6;
        return;
    L6:
        if (compareAndSet(0, 1) == false) goto L11;
        c r10 = this.subscriber;
        r10.onNext(this.value);
        if (get() == 2) goto L12;
        r10.onComplete();
        return;
    L12:
        return;
    }

    @Override // rt.d
    public int requestFusion(int r5) {
        return r5 & 1;
    }

    public boolean offer(T r5, T r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
