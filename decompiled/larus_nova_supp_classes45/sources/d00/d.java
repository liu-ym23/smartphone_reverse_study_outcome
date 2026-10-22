package d00;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;

    public d() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L24;
        d r7 = (d) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (((((((r3 + r1) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        long r6 = this.f;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.g;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        boolean r11 = this.h;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L12;
        r13 = 1;
    L12:
        int r14 = (r9 + r13) * 31;
        boolean r15 = this.i;
        if (r15 == true) goto L17;
        r12 = r15;
    L17:
        return r14 + r12;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GameLiveTraceParam(traceId='" + this.a + "', roomId='" + this.b + "', liveSource=" + this.c + ", retryState=" + this.d + ", reconnectState=" + this.e + ", pushStreamTimestamp=" + this.f + ", enterLiveFragmentTimestamp=" + this.g + ", savedStateFromFragment=" + this.h + ", savedStateFromActivity=" + this.i + ')';
    }

    public d(int r3) {
        Intrinsics.checkNotNullParameter("", "traceId");
        Intrinsics.checkNotNullParameter("", "roomId");
        this.a = "";
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
    }

    public static long a(long r3) {
        if (r3 != 0) goto L6;
        return r3;
    L6:
        return System.currentTimeMillis() - r3;
    }
}
