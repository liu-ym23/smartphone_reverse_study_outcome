package g2c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static int a(b r10, boolean r11) {
        if (r11 == false) goto L4;
        int r0 = r10.c;
    L5:
        if (r11 == false) goto L7;
        int r1 = r10.b;
    L8:
        byte[][] r12 = r10.a;
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
        r5 = r9;
        r7 = 1;
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
        r1 = r10.c;
        goto L8
    L4:
        r0 = r10.b;
        goto L5
    }
}
