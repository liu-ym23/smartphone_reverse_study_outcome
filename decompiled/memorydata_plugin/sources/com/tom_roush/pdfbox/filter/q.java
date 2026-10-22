package com.tom_roush.pdfbox.filter;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
final class q extends j {
    q() {
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r5, OutputStream r6, com.tom_roush.pdfbox.a.d r7, int r8) {
        byte[] r9 = new byte[128];
    L3:
        int r0 = r5.read();
        if (r0 == (-1)) goto L21;
        if (r0 == 128) goto L21;
        int r3 = 0;
        if (r0 <= 127) goto L8;
        int r2 = r5.read();
        if (r2 == (-1)) goto L21;
    L18:
        if (r3 >= (257 - r0)) goto L3;
        r6.write(r2);
        r3 = r3 + 1;
        goto L18
    L8:
        int r1 = r0 + 1;
    L9:
        if (r1 <= 0) goto L3;
        int r4 = r5.read(r9, 0, r1);
        if (r4 == (-1)) goto L3;
        r6.write(r9, 0, r4);
        r1 = r1 - r4;
    L21:
        return new i(r7);
    }
}
