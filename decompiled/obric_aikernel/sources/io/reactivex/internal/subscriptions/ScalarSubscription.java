package io.reactivex.internal.subscriptions;

import bc.d;
import java.util.concurrent.atomic.AtomicInteger;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements d<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final c<? super T> subscriber;
    final T value;

    public ScalarSubscription(c<? super T> r10, T r11) {
        this.subscriber = r10;
        this.value = r11;
    }

    @Override // tc.d
    public void cancel() {
        lazySet(2);
    }

    @Override // bc.f
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        if (get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bc.f
    public boolean isEmpty() {
        if (get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bc.f
    public boolean offer(T r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T r10, T r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // bc.f
    public T poll() {
        if (get() != 0) goto L6;
        lazySet(1);
        return this.value;
    L6:
        return null;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L6;
        return;
    L6:
        if (compareAndSet(0, 1) == false) goto L11;
        c<? super T> r11 = this.subscriber;
        r11.onNext(this.value);
        if (get() == 2) goto L12;
        r11.onComplete();
        return;
    L12:
        return;
    }

    @Override // bc.c
    public int requestFusion(int r10) {
        return r10 & 1;
    }
}
