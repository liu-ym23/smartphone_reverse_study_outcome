package okio;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g0 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public g0 f;
    public g0 g;

    public static final class a {
    }

    static {
    }

    public final g0 c() {
        this.d = true;
        return new g0(this.a, this.b, this.c, true, false);
    }

    public final g0 a() {
        g0 r0 = this.f;
        if (r0 != this) goto L6;
        r0 = null;
    L6:
        g0 r2 = this.g;
        Intrinsics.checkNotNull(r2);
        r2.f = this.f;
        g0 r3 = this.f;
        Intrinsics.checkNotNull(r3);
        r3.g = this.g;
        this.f = null;
        this.g = null;
        return r0;
    }

    public g0() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final void b(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "segment");
        r2.g = this;
        r2.f = this.f;
        g0 r0 = this.f;
        Intrinsics.checkNotNull(r0);
        r0.g = r2;
        this.f = r2;
    }

    public final void d(g0 r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "sink");
        if (r9.e == false) goto L18;
        int r5 = r9.c;
        if ((r5 + r10) > 8192) goto L7;
    L15:
        byte[] r0 = this.a;
        byte[] r1 = r9.a;
        int r2 = r9.c;
        int r3 = this.b;
        ArraysKt.copyInto(r0, r1, r2, r3, r3 + r10);
        r9.c += r10;
        this.b += r10;
        return;
    L7:
        if (r9.d == true) goto L14;
        int r4 = r9.b;
        if (((r5 + r10) - r4) > 8192) goto L12;
        byte[] r6 = r9.a;
        ArraysKt.copyInto$default(r6, r6, 0, r4, r5, 2, null);
        r9.c -= r9.b;
        r9.b = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write".toString());
    }

    public g0(byte[] r2, int r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
