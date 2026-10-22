package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncSubscription extends AtomicLong implements d, b {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<d> actual;
    final AtomicReference<b> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference();
        this.actual = new AtomicReference();
    }

    public AsyncSubscription(b r10) {
        this();
        this.resource.lazySet(r10);
    }

    @Override // tc.d
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.actual.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean replaceResource(b r10) {
        return DisposableHelper.replace(this.resource, r10);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.actual, this, r10);
    }

    public boolean setResource(b r10) {
        return DisposableHelper.set(this.resource, r10);
    }

    public void setSubscription(d r10) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, r10);
    }
}
