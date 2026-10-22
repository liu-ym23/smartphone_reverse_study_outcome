package com.tom_roush.fontbox.f;

/* JADX INFO: loaded from: classes6.dex */
public class j extends af {
    private h[] c;
    private ad d;
    private n e;
    private int f;
    private int g;
    private m h;

    j(ah r1) {
        super(r1);
        this.g = 0;
        this.h = null;
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r2, ad r3) {
        this.e = r2.p();
        int r4 = r2.u();
        this.f = r4;
        if (r4 >= 5000) goto L5;
        this.c = new h[r4];
    L5:
        this.d = r3;
        this.h = this.f15975b.o();
        this.f15974a = true;
    }
}
