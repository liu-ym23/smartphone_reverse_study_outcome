package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f5275a = 4;

    static {
    }

    public static byte[] a(byte[] r13, byte[] r14) {
        if (r13.length != 0) goto L5;
        return r13;
    L5:
        int r0 = r13.length;
        int r1 = f5275a;
        int r2 = r1 - (r0 % r1);
        int r3 = ((r0 / r1) + 1) * r1;
        byte[] r4 = new byte[r3];
        int r5 = 0;
        System.arraycopy(r13, 0, r4, 0, r13.length);
    L6:
        if (r0 >= r3) goto L8;
        r4[r0] = (byte) r2;
        r0 = r0 + 1;
        goto L6
    L8:
        int[] r15 = a(r4);
        int[] r16 = a(r14);
        int r6 = r15.length - 1;
        if (r6 > 0) goto L11;
    L20:
        int r17 = r15.length << 2;
        byte[] r7 = new byte[r17];
    L21:
        if (r5 >= r17) goto L23;
        r7[r5] = (byte) ((r15[r5 >>> 2] >>> ((r5 & 3) << 3)) & 255);
        r5 = r5 + 1;
        goto L21
    L23:
        return r7;
    L11:
        if (r16.length >= 4) goto L13;
        int[] r8 = new int[4];
        System.arraycopy(r16, 0, r8, 0, r16.length);
        r16 = r8;
    L13:
        int r9 = r15[r6];
        int r10 = (52 / (r6 + 1)) + 6;
        int r11 = 0;
    L14:
        int r12 = r10 - 1;
        if (r10 <= 0) goto L20;
        r11 = r11 - 1640531527;
        int r18 = (r11 >>> 2) & 3;
        int r19 = 0;
    L17:
        if (r19 >= r6) goto L19;
        int r20 = r19 + 1;
        int r21 = r15[r20];
        r9 = ((((r9 >>> 5) ^ (r21 << 2)) + ((r21 >>> 3) ^ (r9 << 4))) ^ ((r21 ^ r11) + (r9 ^ r16[(r19 & 3) ^ r18]))) + r15[r19];
        r15[r19] = r9;
        r19 = r20;
        goto L17
    L19:
        int r22 = r15[0];
        r9 = ((((r9 >>> 5) ^ (r22 << 2)) + ((r22 >>> 3) ^ (r9 << 4))) ^ ((r22 ^ r11) + (r9 ^ r16[r18 ^ (r19 & 3)]))) + r15[r6];
        r15[r6] = r9;
        r10 = r12;
        goto L14
    }

    private static int[] a(byte[] r7) {
        int[] r0 = new int[r7.length >>> 2];
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r3 = r2 >>> 2;
        r0[r3] = r0[r3] | ((r7[r2] & 255) << ((r2 & 3) << 3));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
