package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class n2 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n2 f17879a = null;

    static {
        f17879a = new n2();
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        r5.onSubscribe(EmptyDisposable.NEVER);
    }
}
