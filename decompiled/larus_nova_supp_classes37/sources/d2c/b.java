package d2c;

import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Cloneable {
    public final int a;
    public final int b;
    public final int c;
    public final int[] d;

    public final Object clone() throws CloneNotSupportedException {
        return new b(this.a, this.b, this.c, (int[]) this.d.clone());
    }

    public final int hashCode() {
        int r0 = this.a;
        return (((((((r0 * 31) + r0) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder(this.b * (this.a + 1));
        int r2 = 0;
    L4:
        if (r2 >= this.b) goto L15;
        int r3 = 0;
    L7:
        if (r3 >= this.a) goto L13;
        if (a(r3, r2) == false) goto L11;
        String r4 = "X ";
    L12:
        r0.append(r4);
        r3 = r3 + 1;
        goto L7
    L11:
        r4 = "  ";
        goto L12
    L13:
        r0.append("\n");
        r2 = r2 + 1;
        goto L4
    L15:
        return r0.toString();
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof b) == true) goto L5;
        return false;
    L5:
        b r5 = (b) r4;
        if (this.a == r5.a) goto L8;
        return false;
    L8:
        if (this.b == r5.b) goto L10;
        return false;
    L10:
        if (this.c == r5.c) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.d, r5.d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public b(int r2, int r3) {
        if (r2 < 1) goto L8;
        if (r3 < 1) goto L8;
        this.a = r2;
        this.b = r3;
        int r4 = (r2 + 31) / 32;
        this.c = r4;
        this.d = new int[r4 * r3];
        return;
    L8:
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public final boolean a(int r2, int r3) {
        int r4 = (r3 * this.c) + (r2 / 32);
        if (((this.d[r4] >>> (r2 & 31)) & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public b(int r1, int r2, int r3, int[] r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
