package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 extends mt.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.n f17803b;

    public /* synthetic */ h2(mt.n r5, int r10) {
        this.f17802a = r10;
        this.f17803b = r5;
    }

    @Override // mt.h
    public final void c(mt.j r5) {
        switch(this.f17802a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        s0 r10 = new s0(r5);
        this.f17803b.subscribe(r10);
        return;
    L6:
        g2 r11 = new g2(r5, 0);
        this.f17803b.subscribe(r11);
    }
}
