package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f18014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18016c;
    public final TimeUnit d;
    public final mt.z e;

    public v1(int r5, long r10, TimeUnit r11, mt.n r12, mt.z r13) {
        this.f18014a = r12;
        this.f18015b = r5;
        this.f18016c = r10;
        this.d = r11;
        this.e = r13;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int r5 = this.f18015b;
        long r10 = this.f18016c;
        return this.f18014a.replay(r5, r10, this.d, this.e);
    }
}
