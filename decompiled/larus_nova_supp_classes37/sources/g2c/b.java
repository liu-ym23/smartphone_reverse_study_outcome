package g2c;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final byte[][] a;
    public final int b;
    public final int c;

    public final String toString() {
        StringBuilder r0 = new StringBuilder(((this.b * 2) * this.c) + 2);
        int r2 = 0;
    L4:
        if (r2 >= this.c) goto L18;
        byte[] r3 = this.a[r2];
        int r4 = 0;
    L7:
        if (r4 >= this.b) goto L16;
        byte r5 = r3[r4];
        if (r5 != 0) goto L11;
        r0.append(" 0");
    L15:
        r4 = r4 + 1;
        goto L7
    L11:
        if (r5 == 1) goto L13;
        r0.append("  ");
        goto L15
    L13:
        r0.append(" 1");
        goto L15
    L16:
        r0.append('\n');
        r2 = r2 + 1;
        goto L4
    L18:
        return r0.toString();
    }

    public b(int r3, int r4) {
        this.a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r4, r3});
        this.b = r3;
        this.c = r4;
    }

    public final byte a(int r2, int r3) {
        return this.a[r3][r2];
    }

    public final void b(int r2, int r3, int r4) {
        this.a[r3][r2] = (byte) r4;
    }

    public final void c(int r2, int r3, boolean r4) {
        this.a[r3][r2] = r4 ? 1 : 0;
    }
}
