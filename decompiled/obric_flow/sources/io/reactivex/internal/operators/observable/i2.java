package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 extends mt.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17816c;

    public /* synthetic */ i2(int r5, Object r10, Object r11) {
        this.f17814a = r5;
        this.f17815b = r10;
        this.f17816c = r11;
    }

    @Override // mt.a0
    public final void c(mt.b0 r5) {
        switch(this.f17814a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ym.p r10 = new ym.p(11, r5, (com.lynx.tasm.behavior.ui.utils.n) this.f17816c);
        ((mt.a0) this.f17815b).b(r10);
        return;
    L6:
        c0 r11 = new c0(r5, this.f17816c);
        ((mt.n) this.f17815b).subscribe(r11);
        return;
    L8:
        io.reactivex.internal.observers.e r12 = new io.reactivex.internal.observers.e(r5, this.f17816c);
        ((mt.n) this.f17815b).subscribe(r12);
    }
}
