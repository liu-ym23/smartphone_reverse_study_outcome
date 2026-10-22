package z68;

import da9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public String a;
    public final long b;
    public final String c;
    public final e d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public int j;
    public int k;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
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
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.b;
        int r3 = ((((((((((((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        if (this.h == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        long r6 = this.i;
        return ((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.j) * 31) + this.k;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActiveScreenShareMetrics(sessionId=" + this.a + ", startElapsedMs=" + this.b + ", startSource=" + this.c + ", policy=" + this.d + ", width=" + this.e + ", height=" + this.f + ", targetFps=" + this.g + ", firstFrameReported=" + this.h + ", fpsWindowStartElapsedMs=" + this.i + ", captureFrameCount=" + this.j + ", outputFrameCount=" + this.k + ')';
    }

    public a(String r2, long r3, String r5, e r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, "startSource");
        Intrinsics.checkNotNullParameter(r6, "policy");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }
}
