package com.tom_roush.fontbox.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class n extends af {
    private long[] c;

    n(ah r1) {
        super(r1);
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r7, ad r8) {
        k r0 = r7.m();
        if (r0 == null) goto L18;
        int r9 = r7.u() + 1;
        this.c = new long[r9];
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L15;
        if (r0.a() != 0) goto L10;
        this.c[r2] = r8.d() * 2;
    L12:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r0.a() != 1) goto L14;
        this.c[r2] = r8.k();
        goto L12
    L14:
        throw new IOException("Error:TTF.loca unknown offset format.");
    L15:
        this.f15974a = true;
        return;
    L18:
        throw new IOException("Could not get head table");
    }
}
