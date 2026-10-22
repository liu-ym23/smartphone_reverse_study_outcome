package io.reactivex.internal.subscribers;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<b> implements g<T>, b, d {
    private static final long serialVersionUID = -8612022020200669122L;
    final c<? super T> downstream;
    final AtomicReference<d> upstream;

    public SubscriberResourceWrapper(c<? super T> r10) {
        this.upstream = new AtomicReference();
        this.downstream = r10;
    }

    @Override // tc.d
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // tc.c
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this);
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        this.upstream.get().request(r10);
        return;
    }

    public void setResource(b r10) {
        DisposableHelper.set(this, r10);
    }
}
