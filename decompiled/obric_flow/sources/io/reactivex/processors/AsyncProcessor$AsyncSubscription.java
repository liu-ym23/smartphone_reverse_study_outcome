package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

/* JADX INFO: loaded from: classes3.dex */
final class AsyncProcessor$AsyncSubscription<T> extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = 5629876084736248016L;
    final a parent;

    public AsyncProcessor$AsyncSubscription(zu.c r5, a r10) {
        super(r5);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        if (tryCancel() == true) goto L6;
        return;
    L6:
        throw null;
    }

    public void onComplete() {
        if (isCancelled() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void onError(Throwable r5) {
        if (isCancelled() == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        this.downstream.onError(r5);
    }
}
