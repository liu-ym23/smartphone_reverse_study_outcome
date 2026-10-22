package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u extends d {
    public final long a;
    public final long b;
    public final long c;
    public final a5 d;
    public final String e;
    public final TextAlignType f;
    public final String g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof u) == false) goto L20;
        u r7 = (u) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
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
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        a5 r6 = this.d;
        int r7 = 0;
        if (r6 == null) goto L5;
        int r8 = r6.hashCode();
    L6:
        int r9 = (r5 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L9;
        int r12 = r10.hashCode();
    L10:
        int r13 = (r9 + r12) * 31;
        TextAlignType r14 = this.f;
        if (r14 == null) goto L13;
        int r15 = r14.hashCode();
    L14:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 == null) goto L18;
        r7 = r17.hashCode();
    L18:
        return r16 + r7;
    L13:
        r15 = 0;
        goto L14
    L9:
        r12 = 0;
        goto L10
    L5:
        r8 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenAssetDress(assetId=" + this.a + ", textWidth=" + this.b + ", textHeight=" + this.c + ", templateText=" + this.d + ", avatarBorderDressId=" + this.e + ", textAlignType=" + this.f + ", schema=" + this.g + ")";
    }

    public u(long r2, long r4, long r6, a5 r8, String r9, TextAlignType r10, String r12) {
        Intrinsics.checkNotNullParameter(r10, "textAlignType");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r12;
    }
}
