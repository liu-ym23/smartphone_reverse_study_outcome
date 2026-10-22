package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class a2 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17708a;

    public a2(mt.n r5) {
        this.f17708a = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f17708a.replay();
    }
}
