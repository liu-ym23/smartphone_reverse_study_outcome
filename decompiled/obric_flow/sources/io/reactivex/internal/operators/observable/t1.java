package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 extends mt.a implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17972a;

    public t1(mt.n r5) {
        this.f17972a = r5;
    }

    @Override // rt.b
    public final mt.n a() {
        return new j0(this.f17972a, 3);
    }

    @Override // mt.a
    public final void c(mt.b r5) {
        t0 r10 = new t0(r5, 4);
        this.f17972a.subscribe(r10);
    }
}
