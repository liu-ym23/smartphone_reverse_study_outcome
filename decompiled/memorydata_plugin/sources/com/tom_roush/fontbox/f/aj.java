package com.tom_roush.fontbox.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class aj extends af {
    private int[] c;
    private short[] d;
    private short[] e;
    private int f;

    aj(ah r1) {
        super(r1);
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r8, ad r9) {
        ai r0 = r8.r();
        if (r0 == null) goto L23;
        this.f = r0.a();
        int r10 = r8.u();
        int r1 = this.f;
        this.c = new int[r1];
        this.d = new short[r1];
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r3 >= this.f) goto L9;
        this.c[r3] = r9.d();
        this.d[r3] = r9.e();
        r4 = r4 + 4;
        r3 = r3 + 1;
        goto L6
    L9:
        if (r4 >= h()) goto L20;
        int r5 = r10 - this.f;
        if (r5 < 0) goto L14;
        r10 = r5;
    L14:
        this.e = new short[r10];
    L15:
        if (r2 >= r10) goto L20;
        if (r4 >= h()) goto L19;
        this.e[r2] = r9.e();
        r4 = r4 + 2;
    L19:
        r2 = r2 + 1;
    L20:
        this.f15974a = true;
        return;
    L23:
        throw new IOException("Could not get vhea table");
    }
}
