package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends mt.a0 implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17837a;

    public k0(mt.n r5) {
        this.f17837a = r5;
    }

    @Override // rt.b
    public final mt.n a() {
        return new j0(this.f17837a, 0);
    }

    @Override // mt.a0
    public final void c(mt.b0 r5) {
        i0 r10 = new i0(r5, 2);
        this.f17837a.subscribe(r10);
    }
}
