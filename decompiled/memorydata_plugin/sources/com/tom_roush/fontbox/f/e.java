package com.tom_roush.fontbox.f;

/* JADX INFO: loaded from: classes6.dex */
public class e extends af {
    private d[] c;

    e(ah r1) {
        super(r1);
    }

    public d a(int r5, int r6) {
        d[] r4 = this.c;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        d r2 = r4[r1];
        if (r2.b() != r5) goto L9;
        if (r2.a() != r6) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r6, ad r7) {
        r7.d();
        int r0 = r7.d();
        this.c = new d[r0];
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        d r3 = new d();
        r3.a(r7);
        this.c[r2] = r3;
        r2 = r2 + 1;
        goto L3
    L5:
        int r8 = r6.u();
    L6:
        if (r1 >= r0) goto L8;
        this.c[r1].a(this, r8, r7);
        r1 = r1 + 1;
        goto L6
    L8:
        this.f15974a = true;
    }

    public d[] a() {
        return this.c;
    }
}
