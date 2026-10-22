package io.reactivex.disposables;

import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class SubscriptionDisposable extends ReferenceDisposable<d> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(d r5) {
        super(r5);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(d r5) {
        onDisposed2(r5);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(d r5) {
        r5.cancel();
    }
}
