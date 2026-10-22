package io.reactivex.disposables;

import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes2.dex */
final class ActionDisposable extends ReferenceDisposable<zb.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    ActionDisposable(zb.a r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    protected /* bridge */ /* synthetic */ void onDisposed(zb.a r10) {
        onDisposed2(r10);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    protected void onDisposed2(zb.a r10) {
        r10.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }
}
