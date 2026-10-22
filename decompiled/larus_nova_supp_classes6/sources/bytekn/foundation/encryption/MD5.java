package bytekn.foundation.encryption;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MD5 extends c {
    public static final int[] i = null;
    public static final int[] j = null;
    public static final Companion k = null;
    public final int[] f;
    public final int[] g;
    public final int[] h;

    public static final class Companion extends HasherFactory {
        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    static {
        k = new Companion();
        i = new int[]{7, 12, 17, 22, 5, 9, 14, 20, 4, 11, 16, 23, 6, 10, 15, 21};
        int[] r1 = new int[64];
        int r2 = 0;
    L3:
        if (r2 >= 64) goto L5;
        r1[r2] = (int) (4294967296L * Math.abs(Math.sin(((double) r2) + 1.0d)));
        r2 = r2 + 1;
        goto L3
    L5:
        j = r1;
    }

    @Override // bytekn.foundation.encryption.c
    public final void c() {
        int[] r0 = this.f;
        r0[0] = 1732584193;
        r0[1] = (int) 4023233417L;
        r0[2] = (int) 2562383102L;
        r0[3] = 271733878;
    }

    public MD5() {
        this.f = new int[4];
        this.g = new int[4];
        this.h = new int[16];
        c();
    }

    @Override // bytekn.foundation.encryption.c
    public final void a(byte[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= 16) goto L6;
        r4[r0] = (byte) (this.f[r0 / 4] >>> ((r0 % 4) * 8));
        r0 = r0 + 1;
        goto L4
    }

    @Override // bytekn.foundation.encryption.c
    public final byte[] b(long r9) {
        long r1 = 8;
        int r5 = this.d;
        long r3 = ((r9 + r1) / ((long) r5)) + 1;
        long r2 = r1 * r9;
        int r10 = (int) ((r3 * ((long) r5)) - r9);
        byte[] r11 = new byte[r10];
        int r4 = 0;
        r11[0] = (byte) 128;
    L3:
        if (r4 >= 8) goto L5;
        r11[(r10 - 8) + r4] = (byte) (r2 >>> (r4 * 8));
        r4 = r4 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // bytekn.foundation.encryption.c
    public final void d(byte[] r13) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= 64) goto L6;
        int[] r2 = this.h;
        int r3 = r1 >>> 2;
        r2[r3] = (r13[r1] << 24) | (r2[r3] >>> 8);
        r1 = r1 + 1;
        goto L4
    L6:
        int r14 = 0;
    L8:
        if (r14 >= 4) goto L10;
        this.g[r14] = this.f[r14];
        r14 = r14 + 1;
        goto L8
    L10:
        int r15 = 0;
    L11:
        if (r15 >= 64) goto L34;
        int r4 = r15 / 16;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L19;
        if (r4 == 3) goto L18;
        int r7 = 0;
    L23:
        if (r4 == 0) goto L32;
        if (r4 == 1) goto L30;
        if (r4 == 2) goto L29;
        if (r4 == 3) goto L28;
        int r8 = 0;
    L33:
        int[] r9 = this.f;
        int r10 = r9[1];
        int r11 = ((r9[0] + r7) + this.h[r8]) + j[r15];
        int r5 = i[(r4 << 2) | (r15 & 3)];
        int r12 = r11 << r5;
        int r6 = ((r11 >>> (32 - r5)) | r12) + r10;
        r9[0] = r9[3];
        r9[3] = r9[2];
        r9[2] = r10;
        r9[1] = r6;
        r15 = r15 + 1;
        goto L11
    L28:
        int r16 = r15 * 7;
    L31:
        r8 = r16 & 15;
        goto L33
    L29:
        r16 = (r15 * 3) + 5;
        goto L31
    L30:
        r16 = (r15 * 5) + 1;
        goto L31
    L32:
        r8 = r15;
        goto L33
    L18:
        int[] r17 = this.f;
        int r18 = r17[2];
        int r19 = r17[1];
        int r20 = (~r17[3]) | r19;
    L20:
        r7 = r20 ^ r18;
        goto L23
    L19:
        int[] r21 = this.f;
        r18 = r21[1] ^ r21[2];
        r20 = r21[3];
        goto L20
    L21:
        int[] r22 = this.f;
        int r23 = r22[1];
        int r24 = r22[3];
        int r25 = r23 & r24;
        r7 = (r22[2] & (~r24)) | r25;
        goto L23
    L22:
        int[] r26 = this.f;
        int r27 = r26[1];
        int r28 = r26[2] & r27;
        int r29 = ~r27;
        r7 = (r26[3] & r29) | r28;
    L34:
        if (r0 >= 4) goto L36;
        int[] r110 = this.f;
        r110[r0] = r110[r0] + this.g[r0];
        r0 = r0 + 1;
        goto L34
    }
}
