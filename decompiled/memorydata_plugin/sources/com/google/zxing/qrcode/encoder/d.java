package com.google.zxing.qrcode.encoder;

/* JADX INFO: loaded from: classes3.dex */
final class d {
    static int a(b r2) {
        return a(r2, true) + a(r2, false);
    }

    private static int a(b r10, boolean r11) {
        if (r11 == false) goto L4;
        int r0 = r10.a();
    L5:
        if (r11 == false) goto L7;
        int r1 = r10.b();
    L8:
        byte[][] r12 = r10.c();
        int r3 = 0;
        int r4 = 0;
    L9:
        if (r3 >= r0) goto L25;
        byte r5 = -1;
        int r6 = 0;
        int r7 = 0;
    L12:
        if (r6 >= r1) goto L22;
        if (r11 == false) goto L15;
        byte r9 = r12[r3][r6];
    L16:
        if (r9 != r5) goto L18;
        r7 = r7 + 1;
    L21:
        r6 = r6 + 1;
        goto L12
    L18:
        if (r7 < 5) goto L20;
        r4 = r4 + ((r7 - 5) + 3);
    L20:
        r7 = 1;
        r5 = r9;
        goto L21
    L15:
        r9 = r12[r6][r3];
        goto L16
    L22:
        if (r7 < 5) goto L24;
        r4 = r4 + ((r7 - 5) + 3);
    L24:
        r3 = r3 + 1;
        goto L9
    L25:
        return r4;
    L7:
        r1 = r10.a();
        goto L8
    L4:
        r0 = r10.b();
        goto L5
    }

    static boolean a(int r1, int r2, int r3) {
        switch(r1) {
            case 0: goto L13;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        int r4 = ((r3 * r2) % 3) + ((r3 + r2) & 1);
    L8:
        int r5 = r4 & 1;
    L15:
        if (r5 == 0) goto L19;
        return false;
    L19:
        return true;
    L7:
        int r6 = r3 * r2;
        r4 = (r6 & 1) + (r6 % 3);
        goto L8
    L9:
        int r7 = r3 * r2;
        r5 = (r7 & 1) + (r7 % 3);
        goto L15
    L10:
        r3 = r3 / 2;
        r2 = r2 / 3;
        goto L13
    L11:
        r5 = (r3 + r2) % 3;
        goto L15
    L12:
        r5 = r2 % 3;
    L13:
        r3 = r3 + r2;
    L14:
        r5 = r3 & 1;
        goto L15
    L5:
        throw new IllegalArgumentException("Invalid mask pattern: " + r1);
    }

    private static boolean a(byte[] r3, int r4, int r5) {
        if (r4 >= 0) goto L5;
    L14:
        return false;
    L5:
        if (r3.length < r5) goto L14;
    L8:
        if (r4 >= r5) goto L13;
        if (r3[r4] == 1) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    private static boolean a(byte[][] r3, int r4, int r5, int r6) {
        if (r5 >= 0) goto L5;
    L14:
        return false;
    L5:
        if (r3.length < r6) goto L14;
    L8:
        if (r5 >= r6) goto L13;
        if (r3[r5][r4] == 1) goto L11;
        r5 = r5 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    static int b(b r11) {
        byte[][] r0 = r11.c();
        int r1 = r11.b();
        int r12 = r11.a();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= (r12 - 1)) goto L18;
        byte[] r5 = r0[r3];
        int r6 = 0;
    L7:
        if (r6 >= (r1 - 1)) goto L16;
        byte r7 = r5[r6];
        int r8 = r6 + 1;
        if (r7 != r5[r8]) goto L15;
        int r9 = r3 + 1;
        if (r7 != r0[r9][r6]) goto L15;
        if (r7 != r0[r9][r8]) goto L15;
        r4 = r4 + 1;
    L15:
        r6 = r8;
        goto L7
    L16:
        r3 = r3 + 1;
        goto L4
    L18:
        return r4 * 3;
    }

    static int c(b r10) {
        byte[][] r0 = r10.c();
        int r1 = r10.b();
        int r11 = r10.a();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r11) goto L51;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L49;
        byte[] r6 = r0[r3];
        int r7 = r5 + 6;
        if (r7 < r1) goto L9;
    L27:
        int r8 = r3 + 6;
        if (r8 >= r11) goto L48;
        if (r0[r3][r5] != 1) goto L48;
        if (r0[r3 + 1][r5] != 0) goto L48;
        if (r0[r3 + 2][r5] != 1) goto L48;
        if (r0[r3 + 3][r5] != 1) goto L48;
        if (r0[r3 + 4][r5] != 1) goto L48;
        if (r0[r3 + 5][r5] != 0) goto L48;
        if (r0[r8][r5] != 1) goto L48;
        if (a(r0, r5, r3 - 4, r3) == false) goto L46;
    L47:
        r4 = r4 + 1;
        goto L48
    L46:
        if (a(r0, r5, r3 + 7, r3 + 11) == true) goto L47;
    L48:
        r5 = r5 + 1;
        goto L5
    L9:
        if (r6[r5] != 1) goto L27;
        if (r6[r5 + 1] != 0) goto L27;
        if (r6[r5 + 2] != 1) goto L27;
        if (r6[r5 + 3] != 1) goto L27;
        if (r6[r5 + 4] != 1) goto L27;
        if (r6[r5 + 5] != 0) goto L27;
        if (r6[r7] != 1) goto L27;
        if (a(r6, r5 - 4, r5) == false) goto L25;
    L26:
        r4 = r4 + 1;
        goto L27
    L25:
        if (a(r6, r5 + 7, r5 + 11) == false) goto L27;
    L49:
        r3 = r3 + 1;
        goto L3
    L51:
        return r4 * 40;
    }

    static int d(b r10) {
        byte[][] r0 = r10.c();
        int r1 = r10.b();
        int r2 = r10.a();
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r2) goto L11;
        byte[] r6 = r0[r4];
        int r7 = 0;
    L5:
        if (r7 >= r1) goto L10;
        if (r6[r7] != 1) goto L9;
        r5 = r5 + 1;
    L9:
        r7 = r7 + 1;
        goto L5
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        int r3 = r10.a() * r10.b();
        return ((Math.abs((r5 * 2) - r3) * 10) / r3) * 10;
    }
}
