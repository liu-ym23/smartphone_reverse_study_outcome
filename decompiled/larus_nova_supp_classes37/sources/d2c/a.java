package d2c;

import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements Cloneable {
    public int[] a;
    public int b;

    public final Object clone() throws CloneNotSupportedException {
        return new a((int[]) this.a.clone(), this.b);
    }

    public final int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder(this.b);
        int r1 = 0;
    L4:
        if (r1 >= this.b) goto L14;
        if ((r1 & 7) != 0) goto L9;
        r0.append(' ');
    L9:
        if (d(r1) == false) goto L11;
        char r2 = 'X';
    L12:
        r0.append(r2);
        r1 = r1 + 1;
        goto L4
    L11:
        r2 = '.';
        goto L12
    L14:
        return r0.toString();
    }

    public a() {
        this.b = 0;
        this.a = new int[1];
    }

    public final void a(boolean r5) {
        c(this.b + 1);
        if (r5 == false) goto L5;
        int[] r6 = this.a;
        int r0 = this.b;
        int r2 = r0 / 32;
        r6[r2] = (1 << (r0 & 31)) | r6[r2];
    L5:
        this.b++;
    }

    public final void c(int r4) {
        int[] r0 = this.a;
        if (r4 <= (r0.length * 32)) goto L6;
        int[] r5 = new int[(r4 + 31) / 32];
        System.arraycopy(r0, 0, r5, 0, r0.length);
        this.a = r5;
        return;
    }

    public final boolean d(int r3) {
        int r0 = this.a[r3 / 32];
        if (((1 << (r3 & 31)) & r0) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof a) == true) goto L5;
        return false;
    L5:
        a r5 = (a) r4;
        if (this.b == r5.b) goto L8;
        return false;
    L8:
        if (Arrays.equals(this.a, r5.a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public a(int[] r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(int r3, int r4) {
        if (r4 < 0) goto L14;
        if (r4 > 32) goto L14;
        c(this.b + r4);
    L6:
        if (r4 <= 0) goto L12;
        boolean r1 = true;
        if (((r3 >> (r4 - 1)) & 1) == 1) goto L11;
        r1 = false;
    L11:
        a(r1);
        r4 = r4 - 1;
        goto L6
    L12:
        return;
    L14:
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
}
