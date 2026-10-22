package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f18090c;
    public final boolean d;

    public z0(mt.n r5, long r10, Object r11, boolean r12) {
        super(r5);
        this.f18089b = r10;
        this.f18090c = r11;
        this.d = r12;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        boolean r5 = this.d;
        y0 r11 = new y0(r10, this.f18089b, this.f18090c, r5);
        this.f17702a.subscribe(r11);
    }
}
