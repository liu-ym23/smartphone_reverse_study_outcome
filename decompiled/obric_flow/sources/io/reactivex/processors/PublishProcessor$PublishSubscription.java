package io.reactivex.processors;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class PublishProcessor$PublishSubscription<T> extends AtomicLong implements zu.d {
    private static final long serialVersionUID = 3562861878281475070L;
    final zu.c downstream;
    final e parent;

    public PublishProcessor$PublishSubscription(zu.c r5, e r10) {
        this.downstream = r5;
    }

    @Override // zu.d
    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
        return;
    L6:
        throw null;
    }

    public boolean isCancelled() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFull() {
        if (get() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void onComplete() {
        if (get() == Long.MIN_VALUE) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void onError(Throwable r5) {
        if (get() == Long.MIN_VALUE) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        wn.f.k(r5);
    }

    public void onNext(T r5) {
        long r10 = get();
        if (r10 != Long.MIN_VALUE) goto L6;
        return;
    L6:
        if (r10 == 0) goto L8;
        this.downstream.onNext(r5);
        v0.z(this, 1);
        return;
    L8:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.s(this, r5);
        return;
    }
}
