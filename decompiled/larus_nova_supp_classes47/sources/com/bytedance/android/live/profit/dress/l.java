package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends d {
    public final long a;
    public final py.k b;
    public final long c;
    public final a5 d;
    public final py.k e;
    public final long f;
    public final py.k g;
    public final long h;
    public final py.k i;
    public final long j;
    public final long k;
    public final long l;
    public final a5 m;
    public final com.bytedance.android.live.profit.dress.config.h n;
    public final String o;
    public final TextAlignType p;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l) == false) goto L38;
        l r7 = (l) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r7.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r7.p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        py.k r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        long r5 = this.c;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        a5 r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        py.k r10 = this.e;
        if (r10 == null) goto L13;
        int r12 = r10.hashCode();
    L14:
        long r13 = this.f;
        int r14 = (((r9 + r12) * 31) + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        py.k r15 = this.g;
        if (r15 == null) goto L17;
        int r16 = r15.hashCode();
    L18:
        long r17 = this.h;
        int r18 = (((r14 + r16) * 31) + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        py.k r19 = this.i;
        if (r19 == null) goto L21;
        int r20 = r19.hashCode();
    L22:
        long r22 = this.j;
        int r23 = (((r18 + r20) * 31) + ((int) (r22 ^ (r22 >>> 32)))) * 31;
        long r24 = this.k;
        int r25 = (r23 + ((int) (r24 ^ (r24 >>> 32)))) * 31;
        long r26 = this.l;
        int r27 = (r25 + ((int) (r26 ^ (r26 >>> 32)))) * 31;
        a5 r28 = this.m;
        if (r28 == null) goto L25;
        int r29 = r28.hashCode();
    L26:
        int r30 = (r27 + r29) * 31;
        com.bytedance.android.live.profit.dress.config.h r32 = this.n;
        if (r32 == null) goto L29;
        int r33 = r32.hashCode();
    L30:
        int r34 = (r30 + r33) * 31;
        String r35 = this.o;
        if (r35 == null) goto L33;
        int r36 = r35.hashCode();
    L34:
        int r37 = (r34 + r36) * 31;
        TextAlignType r38 = this.p;
        if (r38 == null) goto L38;
        r3 = r38.hashCode();
    L38:
        return r37 + r3;
    L33:
        r36 = 0;
        goto L34
    L29:
        r33 = 0;
        goto L30
    L25:
        r29 = 0;
        goto L26
    L21:
        r20 = 0;
        goto L22
    L17:
        r16 = 0;
        goto L18
    L13:
        r12 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "EnterEffectDress(type=" + this.a + ", icon=" + this.b + ", avatarPos=" + this.c + ", text=" + this.d + ", textIcon=" + this.e + ", animAssetId=" + this.f + ", textIconOverlay=" + this.g + ", centerAnimAssetId=" + this.h + ", dynamicImage=" + this.i + ", mp4AnimAssetId=" + this.j + ", alignment=" + this.k + ", alignmentOffset=" + this.l + ", template=" + this.m + ", profilePreviewConfig=" + this.n + ", avatarBorderDressId=" + this.o + ", textAlignType=" + this.p + ")";
    }

    public final long getType() {
        return this.a;
    }

    public l(long r5, py.k r7, long r8, a5 r10, py.k r12, long r13, py.k r14, long r15, py.k r17, long r18, long r20, long r22, a5 r24, com.bytedance.android.live.profit.dress.config.h r25, String r26, TextAlignType r27) {
        Intrinsics.checkNotNullParameter(r27, "textAlignType");
        this.a = r5;
        this.b = r7;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r17;
        this.j = r18;
        this.k = r20;
        this.l = r22;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r27;
    }
}
