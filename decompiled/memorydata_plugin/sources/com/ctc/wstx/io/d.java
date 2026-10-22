package com.ctc.wstx.io;

import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends p {
    com.ctc.wstx.util.l j;
    int k;
    boolean l;
    boolean m;

    public d(com.ctc.wstx.a.b r9, String r10, r r11, Reader r12, boolean r13) {
        super(r9, null, null, r10, r11, r12, r13);
        this.j = null;
        this.k = 0;
        this.l = false;
        this.m = false;
    }

    private void a(int r7, int r8) {
        if (this.l == false) goto L24;
        char[] r0 = this.c;
        char[] r1 = this.j.j();
        int r2 = this.j.k();
        if (this.m == false) goto L9;
        if (r0[r7] != '\n') goto L9;
        r7 = r7 + 1;
    L9:
        if (r7 >= r8) goto L23;
        int r3 = r7 + 1;
        char r9 = r0[r7];
        if (r9 != '\r') goto L18;
        if (r3 < r8) goto L14;
        this.m = true;
    L17:
        r9 = '\n';
        goto L18
    L14:
        if (r0[r3] != '\n') goto L17;
        r3 = r3 + 1;
    L18:
        int r5 = r2 + 1;
        r1[r2] = r9;
        if (r5 < r1.length) goto L21;
        r2 = 0;
        r1 = this.j.l();
    L22:
        r7 = r3;
        goto L9
    L21:
        r2 = r5;
        goto L22
    L23:
        this.j.a(r2);
        return;
    L24:
        this.j.c(this.c, r7, r8 - r7);
    }

    public void a(int r2) {
        if (this.j == null) goto L9;
        int r0 = this.k;
        if (r2 <= r0) goto L7;
        a(r0, r2);
    L7:
        this.j = null;
        return;
    }

    public void a(com.ctc.wstx.util.l r1, int r2, boolean r3) {
        this.j = r1;
        this.k = r2;
        this.l = r3;
        this.m = false;
    }

    @Override // com.ctc.wstx.io.p, com.ctc.wstx.io.v
    public boolean a(u r3, int r4) {
        if (this.j == null) goto L11;
        int r0 = r3.f3547J;
        if ((this.d - r0) <= 0) goto L11;
        int r1 = this.k;
        if (r0 <= r1) goto L9;
        a(r1, r0);
    L9:
        this.k = 0;
    L11:
        return super.a(r3, r4);
    }

    @Override // com.ctc.wstx.io.p, com.ctc.wstx.io.v
    public int c(u r3) {
        if (this.j == null) goto L9;
        int r0 = this.d;
        int r1 = this.k;
        if (r0 <= r1) goto L7;
        a(r1, this.d);
    L7:
        this.k = 0;
    L9:
        return super.c(r3);
    }
}
