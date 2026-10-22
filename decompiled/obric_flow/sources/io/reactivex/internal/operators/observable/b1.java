package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends mt.h implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17727b;

    public b1(mt.n r5, long r10) {
        this.f17726a = r5;
        this.f17727b = r10;
    }

    @Override // rt.b
    public final mt.n a() {
        return new z0(this.f17726a, this.f17727b, null, false);
    }

    @Override // mt.h
    public final void c(mt.j r5) {
        a1 r10 = new a1(r5, this.f17727b);
        this.f17726a.subscribe(r10);
    }
}
