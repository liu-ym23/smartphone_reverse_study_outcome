package e2c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final a a;
    public final int[] b;

    public final boolean b() {
        if (this.b[0] != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder((this.b.length - 1) * 8);
        int r1 = this.b.length;
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L30;
        int[] r2 = this.b;
        int r3 = r2[(r2.length - 1) - r1];
        if (r3 == 0) goto L3;
        if (r3 >= 0) goto L10;
        r0.append(" - ");
        r3 = -r3;
    L13:
        if (r1 == 0) goto L15;
        if (r3 != 1) goto L15;
    L23:
        if (r1 == 0) goto L3;
        if (r1 == 1) goto L25;
        r0.append("x^");
        r0.append(r1);
        goto L3
    L25:
        r0.append('x');
    L15:
        a r4 = this.a;
        if (r3 == 0) goto L27;
        int r5 = r4.b[r3];
        if (r5 != 0) goto L20;
        r0.append('1');
        goto L23
    L20:
        if (r5 != 1) goto L22;
        r0.append('a');
        goto L23
    L22:
        r0.append("a^");
        r0.append(r5);
        goto L23
    L27:
        r4.getClass();
        throw new IllegalArgumentException();
    L10:
        if (r0.length() <= 0) goto L13;
        r0.append(" + ");
        goto L13
    L30:
        return r0.toString();
    }

    public final b a(b r8) {
        if (this.a.equals(r8.a) == false) goto L21;
        if (b() == false) goto L8;
        return r8;
    L8:
        if (r8.b() == false) goto L10;
        return this;
    L10:
        int[] r0 = this.b;
        int[] r9 = r8.b;
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
        r1[r3] = r9[r3 - r2] ^ r0[r3];
        r3 = r3 + 1;
        goto L16
    L19:
        return new b(this.a, r1);
    L21:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public b(a r5, int[] r6) {
        if (r6.length == 0) goto L19;
        this.a = r5;
        int r7 = r6.length;
        if (r7 > 1) goto L7;
    L16:
        this.b = r6;
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
        this.b = new int[]{0};
        return;
    L15:
        int r8 = r7 - r2;
        int[] r0 = new int[r8];
        this.b = r0;
        System.arraycopy(r6, r2, r0, 0, r8);
        return;
    L19:
        throw new IllegalArgumentException();
    }

    public final b c(int r5, int r6) {
        if (r5 < 0) goto L12;
        if (r6 == 0) goto L5;
        int r0 = this.b.length;
        int[] r7 = new int[r5 + r0];
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L10;
        r7[r1] = this.a.a(this.b[r1], r6);
        r1 = r1 + 1;
        goto L7
    L10:
        return new b(this.a, r7);
    L5:
        return this.a.c;
    L12:
        throw new IllegalArgumentException();
    }
}
