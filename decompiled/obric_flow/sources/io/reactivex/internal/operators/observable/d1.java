package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends mt.a0 implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17756c;

    public d1(mt.n r5, long r10, Object r11) {
        this.f17754a = r5;
        this.f17755b = r10;
        this.f17756c = r11;
    }

    @Override // rt.b
    public final mt.n a() {
        return new z0(this.f17754a, this.f17755b, this.f17756c, true);
    }

    @Override // mt.a0
    public final void c(mt.b0 r5) {
        c1 r10 = new c1(r5, this.f17755b, this.f17756c);
        this.f17754a.subscribe(r10);
    }
}
