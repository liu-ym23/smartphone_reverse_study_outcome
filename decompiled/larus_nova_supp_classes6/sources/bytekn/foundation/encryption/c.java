package bytekn.foundation.encryption;

import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class c {
    public final byte[] a;
    public int b;
    public long c;
    public final int d;
    public final int e;

    public abstract void a(byte[] r1);

    public abstract byte[] b(long r1);

    public abstract void c();

    public abstract void d(byte[] r1);

    public final byte[] e() {
        byte[] r0 = new byte[this.e];
        byte[] r1 = b(this.c);
        int r3 = 0;
    L4:
        if (r3 >= r1.length) goto L6;
        int r4 = this.d;
        int r5 = this.b;
        int r6 = (r4 - r5) + r3;
        ArraysKt.copyInto(r1, this.a, r5, r3, r6);
        d(this.a);
        this.b = 0;
        r3 = r6;
        goto L4
    L6:
        a(r0);
        c();
        int r2 = b.a;
        return r0;
    }

    public c() {
        this.d = 64;
        this.e = 16;
        this.a = new byte[64];
    }

    public final c update(byte[] r3) {
        return update(r3, 0, r3.length);
    }

    public final c update(byte[] r6, int r7, int r8) {
        int r0 = r8;
    L3:
        if (r0 <= 0) goto L8;
        int r1 = Math.min(this.d - this.b, r0);
        int r4 = r1 + r7;
        ArraysKt.copyInto(r6, this.a, this.b, r7, r4);
        r0 = r0 - r1;
        int r9 = this.b + r1;
        this.b = r9;
        int r2 = this.d;
        if (r9 < r2) goto L7;
        this.b = r9 - r2;
        d(this.a);
    L7:
        r7 = r4;
        goto L3
    L8:
        this.c += (long) r8;
        return this;
    }
}
