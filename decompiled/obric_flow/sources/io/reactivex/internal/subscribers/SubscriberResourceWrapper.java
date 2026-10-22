package io.reactivex.internal.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements g, Disposable, d {
    private static final long serialVersionUID = -8612022020200669122L;
    final c downstream;
    final AtomicReference<d> upstream;

    public SubscriberResourceWrapper(c r5) {
        this.upstream = new AtomicReference();
        this.downstream = r5;
    }

    @Override // zu.d
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this);
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.setOnce(this.upstream, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        this.upstream.get().request(r5);
        return;
    }

    public void setResource(Disposable r5) {
        DisposableHelper.set(this, r5);
    }
}
