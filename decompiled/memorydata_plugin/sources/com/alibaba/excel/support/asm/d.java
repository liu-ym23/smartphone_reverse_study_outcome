package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f309b;

    public d() {
        this.f308a = new byte[64];
    }

    public d(int r1) {
        this.f308a = new byte[r1];
    }

    d(byte[] r1) {
        this.f308a = r1;
        this.f309b = r1.length;
    }

    private void d(int r4) {
        int r0 = this.f309b;
        byte[] r1 = this.f308a;
        if (r0 > r1.length) goto L11;
        int r2 = r1.length * 2;
        int r5 = r4 + r0;
        if (r2 > r5) goto L8;
        r2 = r5;
    L8:
        byte[] r6 = new byte[r2];
        System.arraycopy(r1, 0, r6, 0, r0);
        this.f308a = r6;
        return;
    L11:
        throw new AssertionError("Internal error");
    }

    public d a(int r4) {
        int r0 = this.f309b;
        int r1 = r0 + 1;
        if (r1 <= this.f308a.length) goto L5;
        d(1);
    L5:
        this.f308a[r0] = (byte) r4;
        this.f309b = r1;
        return this;
    }

    final d a(int r4, int r5) {
        int r0 = this.f309b;
        if ((r0 + 2) <= this.f308a.length) goto L5;
        d(2);
    L5:
        byte[] r1 = this.f308a;
        int r2 = r0 + 1;
        r1[r0] = (byte) r4;
        r1[r2] = (byte) r5;
        this.f309b = r2 + 1;
        return this;
    }

    final d a(int r4, int r5, int r6) {
        int r0 = this.f309b;
        if ((r0 + 4) <= this.f308a.length) goto L5;
        d(4);
    L5:
        byte[] r1 = this.f308a;
        int r2 = r0 + 1;
        r1[r0] = (byte) r4;
        int r7 = r2 + 1;
        r1[r2] = (byte) r5;
        int r8 = r7 + 1;
        r1[r7] = (byte) (r6 >>> 8);
        r1[r8] = (byte) r6;
        this.f309b = r8 + 1;
        return this;
    }

    public d a(long r6) {
        int r0 = this.f309b;
        if ((r0 + 8) <= this.f308a.length) goto L5;
        d(8);
    L5:
        byte[] r1 = this.f308a;
        int r2 = (int) (r6 >>> 32);
        int r3 = r0 + 1;
        r1[r0] = (byte) (r2 >>> 24);
        int r4 = r3 + 1;
        r1[r3] = (byte) (r2 >>> 16);
        int r5 = r4 + 1;
        r1[r4] = (byte) (r2 >>> 8);
        int r7 = r5 + 1;
        r1[r5] = (byte) r2;
        int r8 = (int) r6;
        int r9 = r7 + 1;
        r1[r7] = (byte) (r8 >>> 24);
        int r10 = r9 + 1;
        r1[r9] = (byte) (r8 >>> 16);
        int r11 = r10 + 1;
        r1[r10] = (byte) (r8 >>> 8);
        r1[r11] = (byte) r8;
        this.f309b = r11 + 1;
        return this;
    }

    public d a(String r8) {
        int r0 = r8.length();
        if (r0 > 65535) goto L19;
        int r2 = this.f309b;
        if (((r2 + 2) + r0) <= this.f308a.length) goto L7;
        d(r0 + 2);
    L7:
        byte[] r3 = this.f308a;
        int r4 = r2 + 1;
        r3[r2] = (byte) (r0 >>> 8);
        int r5 = r4 + 1;
        r3[r4] = (byte) r0;
        int r6 = 0;
    L8:
        if (r6 >= r0) goto L16;
        char r7 = r8.charAt(r6);
        if (r7 < 1) goto L14;
        if (r7 > 127) goto L14;
        r3[r5] = (byte) r7;
        r6 = r6 + 1;
        r5 = r5 + 1;
    L14:
        this.f309b = r5;
        return a(r8, r6, 65535);
    L16:
        this.f309b = r5;
        return this;
    L19:
        throw new IllegalArgumentException("UTF8 string too large");
    }

    final d a(String r9, int r10, int r11) {
        int r0 = r9.length();
        int r1 = r10;
        int r2 = r1;
    L4:
        if (r1 >= r0) goto L13;
        char r6 = r9.charAt(r1);
        if (r6 < 1) goto L9;
        if (r6 > 127) goto L9;
        r2 = r2 + 1;
    L12:
        r1 = r1 + 1;
    L9:
        if (r6 > 2047) goto L11;
        r2 = r2 + 2;
        goto L12
    L11:
        r2 = r2 + 3;
        goto L12
    L13:
        if (r2 > r11) goto L35;
        int r12 = this.f309b;
        int r3 = (r12 - r10) - 2;
        if (r3 < 0) goto L18;
        byte[] r7 = this.f308a;
        r7[r3] = (byte) (r2 >>> 8);
        r7[r3 + 1] = (byte) r2;
    L18:
        if (((r12 + r2) - r10) <= this.f308a.length) goto L20;
        d(r2 - r10);
    L20:
        int r13 = this.f309b;
    L21:
        if (r10 >= r0) goto L32;
        char r4 = r9.charAt(r10);
        if (r4 < 1) goto L26;
        if (r4 > 127) goto L26;
        int r8 = r13 + 1;
        this.f308a[r13] = (byte) r4;
    L30:
        r13 = r8;
    L31:
        r10 = r10 + 1;
    L26:
        byte[] r5 = this.f308a;
        int r14 = r13 + 1;
        if (r4 > 2047) goto L29;
        r5[r13] = (byte) (((r4 >> 6) & 31) | 192);
        r13 = r14 + 1;
        r5[r14] = (byte) ((r4 & '?') | 128);
        goto L31
    L29:
        r5[r13] = (byte) (((r4 >> '\f') & 15) | 224);
        int r15 = r14 + 1;
        r5[r14] = (byte) (((r4 >> 6) & 63) | 128);
        r8 = r15 + 1;
        r5[r15] = (byte) ((r4 & '?') | 128);
        goto L30
    L32:
        this.f309b = r13;
        return this;
    L35:
        throw new IllegalArgumentException("UTF8 string too large");
    }

    public d a(byte[] r3, int r4, int r5) {
        if ((this.f309b + r5) <= this.f308a.length) goto L5;
        d(r5);
    L5:
        if (r3 == null) goto L7;
        System.arraycopy(r3, r4, this.f308a, this.f309b, r5);
    L7:
        this.f309b += r5;
        return this;
    }

    public d b(int r5) {
        int r0 = this.f309b;
        if ((r0 + 2) <= this.f308a.length) goto L5;
        d(2);
    L5:
        byte[] r1 = this.f308a;
        int r2 = r0 + 1;
        r1[r0] = (byte) (r5 >>> 8);
        r1[r2] = (byte) r5;
        this.f309b = r2 + 1;
        return this;
    }

    final d b(int r4, int r5) {
        int r0 = this.f309b;
        if ((r0 + 3) <= this.f308a.length) goto L5;
        d(3);
    L5:
        byte[] r1 = this.f308a;
        int r2 = r0 + 1;
        r1[r0] = (byte) r4;
        int r6 = r2 + 1;
        r1[r2] = (byte) (r5 >>> 8);
        r1[r6] = (byte) r5;
        this.f309b = r6 + 1;
        return this;
    }

    final d b(int r4, int r5, int r6) {
        int r0 = this.f309b;
        if ((r0 + 5) <= this.f308a.length) goto L5;
        d(5);
    L5:
        byte[] r1 = this.f308a;
        int r2 = r0 + 1;
        r1[r0] = (byte) r4;
        int r7 = r2 + 1;
        r1[r2] = (byte) (r5 >>> 8);
        int r3 = r7 + 1;
        r1[r7] = (byte) r5;
        int r8 = r3 + 1;
        r1[r3] = (byte) (r6 >>> 8);
        r1[r8] = (byte) r6;
        this.f309b = r8 + 1;
        return this;
    }

    public d c(int r5) {
        int r0 = this.f309b;
        if ((r0 + 4) <= this.f308a.length) goto L5;
        d(4);
    L5:
        byte[] r1 = this.f308a;
        int r2 = r0 + 1;
        r1[r0] = (byte) (r5 >>> 24);
        int r3 = r2 + 1;
        r1[r2] = (byte) (r5 >>> 16);
        int r4 = r3 + 1;
        r1[r3] = (byte) (r5 >>> 8);
        r1[r4] = (byte) r5;
        this.f309b = r4 + 1;
        return this;
    }
}
