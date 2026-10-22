package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b b(Runnable r10) {
        io.reactivex.internal.functions.a.d(r10, "run is null");
        return new RunnableDisposable(r10);
    }
}
