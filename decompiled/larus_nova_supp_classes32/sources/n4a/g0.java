package n4a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g0 {
    public static byte[] a(byte[] r13, byte[] r14) {
        if (r13.length != 0) goto L5;
        return r13;
    L5:
        int r0 = r13.length;
        int r1 = 4 - (r0 % 4);
        int r3 = ((r0 / 4) + 1) * 4;
        byte[] r4 = new byte[r3];
        int r6 = 0;
        System.arraycopy(r13, 0, r4, 0, r13.length);
    L6:
        if (r0 >= r3) goto L8;
        r4[r0] = (byte) r1;
        r0 = r0 + 1;
        goto L6
    L8:
        int[] r15 = b(r4);
        int[] r16 = b(r14);
        int r2 = r15.length - 1;
        if (r2 > 0) goto L11;
    L20:
        int r17 = r15.length << 2;
        byte[] r5 = new byte[r17];
    L21:
        if (r6 >= r17) goto L23;
        r5[r6] = (byte) ((r15[r6 >>> 2] >>> ((r6 & 3) << 3)) & 255);
        r6 = r6 + 1;
        goto L21
    L23:
        return r5;
    L11:
        if (r16.length >= 4) goto L13;
        int[] r7 = new int[4];
        System.arraycopy(r16, 0, r7, 0, r16.length);
        r16 = r7;
    L13:
        int r8 = r15[r2];
        int r9 = (52 / (r2 + 1)) + 6;
        int r10 = 0;
    L14:
        int r11 = r9 - 1;
        if (r9 <= 0) goto L20;
        r10 = r10 - 1640531527;
        int r12 = (r10 >>> 2) & 3;
        int r18 = 0;
    L17:
        if (r18 >= r2) goto L19;
        int r19 = r18 + 1;
        int r20 = r15[r19];
        r8 = ((((r8 >>> 5) ^ (r20 << 2)) + ((r20 >>> 3) ^ (r8 << 4))) ^ ((r20 ^ r10) + (r8 ^ r16[(r18 & 3) ^ r12]))) + r15[r18];
        r15[r18] = r8;
        r18 = r19;
        goto L17
    L19:
        int r21 = r15[0];
        r8 = ((((r8 >>> 5) ^ (r21 << 2)) + ((r21 >>> 3) ^ (r8 << 4))) ^ ((r21 ^ r10) + (r8 ^ r16[r12 ^ (r18 & 3)]))) + r15[r2];
        r15[r2] = r8;
        r9 = r11;
        goto L14
    }

    public static int[] b(byte[] r7) {
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
