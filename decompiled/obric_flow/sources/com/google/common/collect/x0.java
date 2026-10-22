package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9216c;
    public final /* synthetic */ Object d;

    public /* synthetic */ x0(int r5, int r10, Object r11) {
        this.f9216c = r10;
        this.d = r11;
        super(r5, 0);
    }

    @Override // com.google.common.collect.e
    public final Object a(int r5) {
        switch(this.f9216c) {
            case 0: goto L8;
            case 1: goto L7;
            default: goto L5;
        };
    L8:
        y0 r10 = (y0) this.d;
        com.google.common.base.b0.l(r5, r10.f9227a.size());
        return new w0(r10, r5);
    L5:
        return ((ImmutableList) this.d).get(r5);
    L7:
        return ((Iterable[]) ((r2) this.d).f9144c)[r5].iterator();
    }

    public x0(ImmutableList r5, int r10, int r11) {
        this.f9216c = 2;
        this.d = r5;
        super(r10, r11);
    }
}
