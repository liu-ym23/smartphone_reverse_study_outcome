package eka;

import androidx.core.util.Pools;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final Pools.SynchronizedPool<b> n = null;
    public final double a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final double i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;

    public static final class a {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(Double.valueOf(this.a), Double.valueOf(r9.a)) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(Double.valueOf(this.i), Double.valueOf(r9.i)) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((((((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
        long r4 = Double.doubleToLongBits(this.i);
        return ((((((((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m;
    }

    static {
        n = new Pools.SynchronizedPool(5);
    }

    public final String toString() {
        return "FpsBean(fps=" + this.a + ", duration=" + this.b + ", startX=" + this.c + ", startY=" + this.d + ", endX=" + this.e + ", endY=" + this.f + ", distantX=" + this.g + ", distantY=" + this.h + ", dropRate=" + this.i + ", frameCount=" + this.j + ", drop3=" + this.k + ", drop7=" + this.l + ", drop25=" + this.m + ')';
    }

    public b(int r5) {
        this.a = 0.0d;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0.0d;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
    }
}
