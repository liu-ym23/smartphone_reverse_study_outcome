package io.reactivex.disposables;

import io.reactivex.internal.util.d;

/* JADX INFO: loaded from: classes3.dex */
final class ActionDisposable extends ReferenceDisposable<pt.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(pt.a r5) {
        super(r5);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(pt.a r5) {
        onDisposed2(r5);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(pt.a r5) {
        r5.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw d.d(th);
    }
}
