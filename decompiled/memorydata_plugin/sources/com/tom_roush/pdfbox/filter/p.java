package com.tom_roush.pdfbox.filter;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    private static final class a extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f16112b;
        private final int c;
        private final int d;
        private final int e;
        private final boolean f;
        private byte[] g;
        private byte[] h;
        private int i;
        private boolean j;

        a(OutputStream r1, int r2, int r3, int r4, int r5) {
            super(r1);
            boolean r6 = false;
            this.i = 0;
            this.j = false;
            this.f16111a = r2;
            this.f16112b = r3;
            this.c = r4;
            this.d = r5;
            int r7 = p.a(r3, r4, r5);
            this.e = r7;
            if (r2 < 10) goto L5;
            r6 = true;
        L5:
            this.f = r6;
            this.g = new byte[r7];
            this.h = new byte[r7];
        }

        private void a() {
            p.a(this.f16111a, this.f16112b, this.c, this.d, this.g, this.h);
            this.out.write(this.g);
            b();
        }

        private void b() {
            byte[] r0 = this.h;
            this.h = this.g;
            this.g = r0;
            this.i = 0;
            this.j = false;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() {
            int r0 = this.i;
            if (r0 <= 0) goto L5;
            Arrays.fill(this.g, r0, this.e, (byte) 0);
            a();
        L5:
            super.flush();
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int r1) {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r3) {
            write(r3, 0, r3.length);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] r4, int r5, int r6) {
            int r7 = r6 + r5;
        L3:
            if (r5 >= r7) goto L14;
            if (this.f == false) goto L11;
            if (this.i != 0) goto L11;
            if (this.j == true) goto L11;
            this.f16111a = r4[r5] + 10;
            r5 = r5 + 1;
            this.j = true;
        L11:
            int r0 = Math.min(this.e - this.i, r7 - r5);
            System.arraycopy(r4, r5, this.g, this.i, r0);
            int r1 = this.i + r0;
            this.i = r1;
            r5 = r5 + r0;
            if (r1 != this.g.length) goto L3;
            a();
            goto L3
        }
    }

    static int a(int r0, int r1, int r2) {
        return ((r2 * (r0 * r1)) + 7) / 8;
    }

    static int a(int r1, int r2, int r3, int r4) {
        int r5 = (1 << r3) - 1;
        int r6 = r4 & r5;
        return (r1 & (~(r5 << r2))) | (r6 << r2);
    }

    static OutputStream a(OutputStream r7, com.tom_roush.pdfbox.a.d r8) {
        int r3 = r8.i(com.tom_roush.pdfbox.a.i.gr);
        if (r3 > 1) goto L5;
        return r7;
    L5:
        return new a(r7, r3, Math.min(r8.b(com.tom_roush.pdfbox.a.i.bc, 1), 32), r8.b(com.tom_roush.pdfbox.a.i.X, 8), r8.b(com.tom_roush.pdfbox.a.i.be, 1));
    }

    static void a(int r7, int r8, int r9, int r10, byte[] r11, byte[] r12) {
        if (r7 != 1) goto L5;
        return;
    L5:
        int r1 = ((r8 * r9) + 7) / 8;
        int r4 = r11.length;
        int r6 = 0;
        if (r7 == 2) goto L39;
        switch(r7) {
            case 11: goto L36;
            case 12: goto L34;
            case 13: goto L27;
            case 14: goto L9;
            default: goto L70;
        };
    L9:
        int r13 = 0;
    L10:
        if (r13 >= r4) goto L88;
        int r14 = r11[r13] & 255;
        int r15 = r13 - r1;
        if (r15 < 0) goto L14;
        int r16 = r11[r15] & 255;
    L15:
        int r0 = r12[r13] & 255;
        if (r15 < 0) goto L18;
        int r17 = r12[r15] & 255;
    L19:
        int r2 = (r16 + r0) - r17;
        int r3 = Math.abs(r2 - r16);
        int r5 = Math.abs(r2 - r0);
        int r18 = Math.abs(r2 - r17);
        if (r3 > r5) goto L23;
        if (r3 > r18) goto L23;
        r11[r13] = (byte) ((r14 + r16) & 255);
    L26:
        r13 = r13 + 1;
    L23:
        if (r5 > r18) goto L25;
        r11[r13] = (byte) ((r14 + r0) & 255);
        goto L26
    L25:
        r11[r13] = (byte) ((r14 + r17) & 255);
        goto L26
    L18:
        r17 = 0;
        goto L19
    L14:
        r16 = 0;
        goto L15
    L88:
        return;
    L27:
        int r19 = 0;
    L28:
        if (r19 >= r4) goto L89;
        int r20 = r11[r19] & 255;
        int r21 = r19 - r1;
        if (r21 < 0) goto L32;
        int r22 = r11[r21] & 255;
    L33:
        r11[r19] = (byte) ((r20 + ((r22 + (r12[r19] & 255)) / 2)) & 255);
        r19 = r19 + 1;
        goto L28
    L32:
        r22 = 0;
        goto L33
    L89:
        return;
    L34:
        if (r6 >= r4) goto L90;
        r11[r6] = (byte) (((r11[r6] & 255) + (r12[r6] & 255)) & 255);
        r6 = r6 + 1;
        goto L34
    L90:
        return;
    L36:
        int r23 = r1;
    L37:
        if (r23 >= r4) goto L91;
        r11[r23] = (byte) (r11[r23] + r11[r23 - r1]);
        r23 = r23 + 1;
        goto L37
    L91:
        return;
    L70:
        return;
    L39:
        if (r9 != 8) goto L44;
        int r24 = r1;
    L41:
        if (r24 >= r4) goto L92;
        r11[r24] = (byte) ((r11[r24] & 255) + (r11[r24 - r1] & 255));
        r24 = r24 + 1;
        goto L41
    L92:
        return;
    L44:
        if (r9 != 16) goto L49;
        int r25 = r1;
    L47:
        if (r25 >= (r4 - 1)) goto L93;
        int r26 = r25 + 1;
        int r110 = r25 - r1;
        int r27 = (((r11[r25] & 255) << 8) + (r11[r26] & 255)) + (((r11[r110] & 255) << 8) + (r11[r110 + 1] & 255));
        r11[r25] = (byte) ((r27 >> 8) & 255);
        r11[r26] = (byte) (r27 & 255);
        r25 = r25 + 2;
        goto L47
    L93:
        return;
    L49:
        if (r9 != 1) goto L67;
        if (r8 != 1) goto L67;
    L51:
        if (r6 >= r4) goto L94;
        int r28 = 7;
    L53:
        if (r28 < 0) goto L66;
        int r29 = (r11[r6] >> r28) & 1;
        if (r6 != 0) goto L58;
        if (r28 != 7) goto L58;
    L65:
        r28 = r28 - 1;
    L58:
        if (r28 != 7) goto L60;
        int r30 = r11[r6 - 1];
    L62:
        if (((r29 + (r30 & 1)) & 1) != 0) goto L64;
        r11[r6] = (byte) (r11[r6] & (~(1 << r28)));
        goto L65
    L64:
        r11[r6] = (byte) (r11[r6] | (1 << r28));
        goto L65
    L60:
        r30 = r11[r6] >> (r28 + 1);
        goto L62
    L66:
        r6 = r6 + 1;
        goto L51
    L94:
        return;
    L67:
        int r111 = r10 * r8;
        int r31 = r8;
    L68:
        if (r31 >= r111) goto L95;
        int r112 = r31 * r9;
        int r32 = r112 / 8;
        int r113 = (8 - (r112 % 8)) - r9;
        int r33 = (r31 - r8) * r9;
        r11[r32] = (byte) a(r11[r32], r113, r9, b(r11[r32], r113, r9) + b(r11[r33 / 8], (8 - (r33 % 8)) - r9, r9));
        r31 = r31 + 1;
        goto L68
    }

    static int b(int r1, int r2, int r3) {
        int r4 = r1 >>> r2;
        return r4 & ((1 << r3) - 1);
    }
}
