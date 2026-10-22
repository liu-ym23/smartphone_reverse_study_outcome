package com.tom_roush.fontbox.b;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class c extends r {
    public c(byte[] r1) {
        super(r1);
    }

    public int a() {
        return h();
    }

    public int a(int r4) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r4) goto L5;
        r1 = (r1 << 8) | h();
        r0 = r0 + 1;
        goto L3
    L5:
        return r1;
    }

    public int b() {
        return j();
    }

    public int c() {
        int r0 = h();
        if (r0 < 1) goto L8;
        if (r0 > 4) goto L8;
        return r0;
    L8:
        throw new IOException("Illegal (< 1 or > 4) offSize value " + r0 + " in CFF font at position " + (f() - 1));
    }

    public int d() {
        return j();
    }
}
