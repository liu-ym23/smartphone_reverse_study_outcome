package vz1;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public final k a;
    public final int b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final boolean h;
    public final String i;
    public final String j;
    public final long k;
    public final String l;
    public final String m;

    public h() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L32;
        h r7 = (h) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
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
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v31 */
    public final int hashCode() {
        k r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.d;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.e;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r11 = this.f;
        int r13 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r14 = this.g;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        boolean r16 = this.h;
        ?? r17 = r16;
        if (r16 == false) goto L13;
        r17 = 1;
    L13:
        int r18 = (r15 + r17) * 31;
        String r19 = this.i;
        if (r19 == null) goto L16;
        int r20 = r19.hashCode();
    L17:
        int r21 = (r18 + r20) * 31;
        String r23 = this.j;
        if (r23 == null) goto L20;
        int r24 = r23.hashCode();
    L21:
        int r25 = (r21 + r24) * 31;
        long r26 = this.k;
        int r27 = (r25 + ((int) (r26 ^ (r26 >>> 32)))) * 31;
        String r28 = this.l;
        if (r28 == null) goto L24;
        int r29 = r28.hashCode();
    L25:
        int r30 = (r27 + r29) * 31;
        String r31 = this.m;
        if (r31 == null) goto L29;
        r1 = r31.hashCode();
    L29:
        return r30 + r1;
    L24:
        r29 = 0;
        goto L25
    L20:
        r24 = 0;
        goto L21
    L16:
        r20 = 0;
        goto L17
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PropInfo(diamondLabel=" + this.a + ", count=" + this.b + ", name=" + this.c + ", nextExpire=" + this.d + ", nowTimeDiff=" + this.e + ", propType=" + this.f + ", diamond=" + this.g + ", setGray=" + this.h + ", propDescription=" + this.i + ", expiredException=" + this.j + ", propDefSubType=" + this.k + ", description=" + this.l + ", refId=" + this.m + ")";
    }

    public final String a() {
        return this.m;
    }

    public /* synthetic */ h(int r20) {
        this(null, 0, null, 0, 0, 0, 0, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public h(k r8, int r9, String r10, long r11, long r13, long r15, long r17, boolean r19, String r20, String r21, long r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r20, "propDescription");
        Intrinsics.checkNotNullParameter(r21, "expiredException");
        Intrinsics.checkNotNullParameter(r24, "description");
        Intrinsics.checkNotNullParameter(r25, "refId");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r13;
        this.f = r15;
        this.g = r17;
        this.h = r19;
        this.i = r20;
        this.j = r21;
        this.k = r23;
        this.l = r24;
        this.m = r25;
    }
}
