package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class y2 extends mt.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f18079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.c f18080b;

    public y2(mt.n r5, pt.c r10) {
        this.f18079a = r5;
        this.f18080b = r10;
    }

    @Override // mt.h
    public final void c(mt.j r5) {
        c0 r10 = new c0(r5, this.f18080b);
        this.f18079a.subscribe(r10);
    }
}
