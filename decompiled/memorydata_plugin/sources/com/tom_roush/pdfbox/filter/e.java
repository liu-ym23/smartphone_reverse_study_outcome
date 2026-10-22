package com.tom_roush.pdfbox.filter;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

/* JADX INFO: loaded from: classes6.dex */
final class e extends j {
    e() {
    }

    private void a(byte[] r3) {
        int r2 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L5;
        r3[r0] = (byte) ((~r3[r0]) & 255);
        r0 = r0 + 1;
        goto L3
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r18, OutputStream r19, com.tom_roush.pdfbox.a.d r20, int r21) {
        com.tom_roush.pdfbox.a.d r3 = a(r20, r21);
        int r8 = r3.b(com.tom_roush.pdfbox.a.i.be, 1728);
        int r4 = r3.b(com.tom_roush.pdfbox.a.i.ha, 0);
        int r6 = r20.a(com.tom_roush.pdfbox.a.i.dA, com.tom_roush.pdfbox.a.i.dy, 0);
        if (r4 <= 0) goto L6;
        if (r6 <= 0) goto L6;
    L7:
        int r5 = r3.b(com.tom_roush.pdfbox.a.i.ei, 0);
        boolean r12 = r3.b(com.tom_roush.pdfbox.a.i.cx, false);
        byte[] r13 = new byte[((r8 + 7) / 8) * r6];
        int r9 = 4;
        int r10 = 3;
        if (r5 != 0) goto L24;
        byte[] r11 = new byte[20];
        int r14 = r18.read(r11);
        PushbackInputStream r15 = new PushbackInputStream(r18, 20);
        r15.unread(r11, 0, r14);
        if (r11[0] == 0) goto L12;
    L15:
        short r1 = (short) (((r11[0] << 8) + (r11[1] & 255)) >> 4);
        int r16 = 12;
    L17:
        if (r16 >= (r14 * 8)) goto L22;
        r1 = (short) ((r1 << 1) + ((r11[r16 / 8] >> (7 - (r16 % 8))) & 1));
        if ((r1 & 4095) == 1) goto L23;
        r16 = r16 + 1;
    L23:
        r9 = r10;
        InputStream r7 = r15;
    L27:
        long r17 = 0;
    L28:
        a(new d(r7, r8, r9, r17, r12), r13);
        if (r3.b(com.tom_roush.pdfbox.a.i.ab, false) == true) goto L31;
        a(r13);
    L31:
        r19.write(r13);
        return new i(r20);
    L22:
        r10 = 2;
        goto L23
    L12:
        if ((r11[1] >> 4) == 1) goto L23;
        if (r11[1] == 1) goto L23;
    L24:
        if (r5 <= 0) goto L26;
        r9 = 3;
        r17 = 1;
        r7 = r18;
        goto L28
    L26:
        r7 = r18;
    L6:
        r6 = Math.max(r4, r6);
        goto L7
    }

    void a(d r3, byte[] r4) {
        int r2 = 0;
    L3:
        int r0 = r3.read(r4, r2, r4.length - r2);
        if (r0 <= (-1)) goto L7;
        r2 = r2 + r0;
        if (r2 < r4.length) goto L3;
        return;
    }
}
