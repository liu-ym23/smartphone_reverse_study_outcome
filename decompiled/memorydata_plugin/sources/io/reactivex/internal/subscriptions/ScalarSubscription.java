package io.reactivex.internal.subscriptions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.d;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.c;

/* JADX INFO: loaded from: classes6.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements d<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final c<? super T> subscriber;
    final T value;

    public ScalarSubscription(c<? super T> r3, T r4) {
        this.subscriber = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.value = r4;
    }

    @Override // org.a.d
    public void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        if (get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        if (get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T r1, T r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.a.f
    public T poll() {
        if (get() != 0) goto L6;
        lazySet(1);
        return this.value;
    L6:
        return null;
    }

    @Override // org.a.d
    public void request(long r1) {
        if (SubscriptionHelper.validate(r1) == true) goto L6;
        return;
    L6:
        if (compareAndSet(0, 1) == false) goto L11;
        c<? super T> r2 = this.subscriber;
        r2.onNext(this.value);
        if (get() == 2) goto L12;
        r2.onComplete();
        return;
    L12:
        return;
    }

    @Override // io.reactivex.internal.a.c
    public int requestFusion(int r1) {
        return r1 & 1;
    }
}
