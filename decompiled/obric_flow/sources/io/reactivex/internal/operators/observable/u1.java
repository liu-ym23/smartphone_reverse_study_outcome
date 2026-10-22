package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17983b;

    public u1(mt.n r5, int r10) {
        this.f17982a = r5;
        this.f17983b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f17982a.replay(this.f17983b);
    }
}
