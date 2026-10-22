package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes3.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5075b;

    b(a r5, int[] r6) {
        if (r6.length == 0) goto L19;
        this.f5074a = r5;
        int r7 = r6.length;
        if (r7 > 1) goto L7;
    L16:
        this.f5075b = r6;
        return;
    L7:
        if (r6[0] != 0) goto L16;
        int r2 = 1;
    L9:
        if (r2 >= r7) goto L13;
        if (r6[r2] != 0) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 != r7) goto L15;
        this.f5075b = new int[]{0};
        return;
    L15:
        int[] r8 = new int[r7 - r2];
        this.f5075b = r8;
        System.arraycopy(r6, r2, r8, 0, r8.length);
        return;
    L19:
        throw new IllegalArgumentException();
    }

    int a(int r2) {
        int[] r1 = this.f5075b;
        return r1[(r1.length - 1) - r2];
    }

    b a(int r5, int r6) {
        if (r5 < 0) goto L12;
        if (r6 == 0) goto L5;
        int r0 = this.f5075b.length;
        int[] r7 = new int[r5 + r0];
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L10;
        r7[r1] = this.f5074a.c(this.f5075b[r1], r6);
        r1 = r1 + 1;
        goto L7
    L10:
        return new b(this.f5074a, r7);
    L5:
        return this.f5074a.a();
    L12:
        throw new IllegalArgumentException();
    }

    b a(b r8) {
        if (this.f5074a.equals(r8.f5074a) == false) goto L21;
        if (c() == false) goto L8;
        return r8;
    L8:
        if (r8.c() == false) goto L10;
        return this;
    L10:
        int[] r0 = this.f5075b;
        int[] r9 = r8.f5075b;
        if (r0.length > r9.length) goto L14;
        r0 = r9;
        r9 = r0;
    L14:
        int[] r1 = new int[r0.length];
        int r2 = r0.length - r9.length;
        System.arraycopy(r0, 0, r1, 0, r2);
        int r3 = r2;
    L16:
        if (r3 >= r0.length) goto L19;
        r1[r3] = a.b(r9[r3 - r2], r0[r3]);
        r3 = r3 + 1;
        goto L16
    L19:
        return new b(this.f5074a, r1);
    L21:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    int[] a() {
        return this.f5075b;
    }

    int b() {
        return this.f5075b.length - 1;
    }

    b b(b r13) {
        if (this.f5074a.equals(r13.f5074a) == false) goto L20;
        if (c() == true) goto L18;
        if (r13.c() == true) goto L18;
        int[] r0 = this.f5075b;
        int r1 = r0.length;
        int[] r14 = r13.f5075b;
        int r2 = r14.length;
        int[] r3 = new int[(r1 + r2) - 1];
        int r5 = 0;
    L10:
        if (r5 >= r1) goto L16;
        int r6 = r0[r5];
        int r7 = 0;
    L12:
        if (r7 >= r2) goto L14;
        int r8 = r5 + r7;
        r3[r8] = a.b(r3[r8], this.f5074a.c(r6, r14[r7]));
        r7 = r7 + 1;
        goto L12
    L14:
        r5 = r5 + 1;
        goto L10
    L16:
        return new b(this.f5074a, r3);
    L18:
        return this.f5074a.a();
    L20:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    boolean c() {
        if (this.f5075b[0] != 0) goto L6;
        return true;
    L6:
        return false;
    }

    b[] c(b r8) {
        if (this.f5074a.equals(r8.f5074a) == false) goto L17;
        if (r8.c() == true) goto L15;
        b r0 = this.f5074a.a();
        int r1 = this.f5074a.c(r8.a(r8.b()));
        b r2 = this;
    L8:
        if (r2.b() < r8.b()) goto L13;
        if (r2.c() == true) goto L13;
        int r3 = r2.b() - r8.b();
        int r4 = this.f5074a.c(r2.a(r2.b()), r1);
        b r5 = r8.a(r3, r4);
        r0 = r0.a(this.f5074a.a(r3, r4));
        r2 = r2.a(r5);
    L13:
        return new b[]{r0, r2};
    L15:
        throw new IllegalArgumentException("Divide by 0");
    L17:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public String toString() {
        if (c() == false) goto L6;
        return "0";
    L6:
        StringBuilder r0 = new StringBuilder(b() * 8);
        int r1 = b();
    L7:
        if (r1 < 0) goto L35;
        int r2 = a(r1);
        if (r2 == 0) goto L33;
        if (r2 >= 0) goto L17;
        if (r1 != b()) goto L14;
        String r3 = "-";
    L15:
        r0.append(r3);
        r2 = -r2;
    L20:
        if (r1 == 0) goto L22;
        if (r2 != 1) goto L22;
    L29:
        if (r1 == 0) goto L33;
        if (r1 != 1) goto L32;
        r0.append('x');
        goto L33
    L32:
        r0.append("x^");
        r0.append(r1);
    L22:
        int r4 = this.f5074a.b(r2);
        if (r4 != 0) goto L26;
        char r5 = '1';
    L25:
        r0.append(r5);
        goto L29
    L26:
        if (r4 != 1) goto L28;
        r5 = 'a';
        goto L25
    L28:
        r0.append("a^");
        r0.append(r4);
        goto L29
    L14:
        r3 = " - ";
        goto L15
    L17:
        if (r0.length() <= 0) goto L20;
        r0.append(" + ");
    L33:
        r1 = r1 - 1;
        goto L7
    L35:
        return r0.toString();
    }
}
