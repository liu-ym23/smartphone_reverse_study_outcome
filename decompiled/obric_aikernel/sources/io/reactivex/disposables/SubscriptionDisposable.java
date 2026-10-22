package io.reactivex.disposables;

import tc.d;

/* JADX INFO: loaded from: classes2.dex */
final class SubscriptionDisposable extends ReferenceDisposable<d> {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(d r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    protected /* bridge */ /* synthetic */ void onDisposed(d r10) {
        onDisposed2(r10);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    protected void onDisposed2(d r10) {
        r10.cancel();
    }
}
