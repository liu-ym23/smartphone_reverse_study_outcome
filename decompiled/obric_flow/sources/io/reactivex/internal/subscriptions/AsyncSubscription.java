package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class AsyncSubscription extends AtomicLong implements d, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<d> actual;
    final AtomicReference<Disposable> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference();
        this.actual = new AtomicReference();
    }

    @Override // zu.d
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.actual.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean replaceResource(Disposable r5) {
        return DisposableHelper.replace(this.resource, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.actual, this, r5);
    }

    public boolean setResource(Disposable r5) {
        return DisposableHelper.set(this.resource, r5);
    }

    public void setSubscription(d r5) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, r5);
    }

    public AsyncSubscription(Disposable r5) {
        this();
        this.resource.lazySet(r5);
    }
}
