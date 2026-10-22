package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f0 {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final String f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final l0 k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final String o;
    public final String p;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r11 = (f0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (this.h == r11.h) goto L33;
        return false;
    L33:
        if (this.i == r11.i) goto L36;
        return false;
    L36:
        if (this.j == r11.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r11.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r11.l) goto L45;
        return false;
    L45:
        if (this.m == r11.m) goto L48;
        return false;
    L48:
        if (this.n == r11.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r11.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        long r1 = this.g;
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r11 = this.h;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = this.i;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        long r15 = this.j;
        int r16 = (((r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31) + this.k.hashCode()) * 31;
        int r17 = 1231;
        if (this.l == false) goto L5;
        int r18 = 1231;
    L6:
        int r19 = (r16 + r18) * 31;
        if (this.m == false) goto L9;
        int r20 = 1231;
    L10:
        int r21 = (r19 + r20) * 31;
        if (this.n == true) goto L15;
        r17 = 1237;
    L15:
        return ((((r21 + r17) * 31) + this.o.hashCode()) * 31) + this.p.hashCode();
    L9:
        r20 = 1237;
        goto L10
    L5:
        r18 = 1237;
        goto L6
    }

    public final String toString() {
        return "HomepageDocData(token=" + this.a + ", icon=" + this.b + ", title=" + this.c + ", bizType=" + this.d + ", objBizType=" + this.e + ", objToken=" + this.f + ", openTime=" + this.g + ", starTime=" + this.h + ", createTime=" + this.i + ", editTime=" + this.j + ", tag=" + this.k + ", isOwner=" + this.l + ", isStared=" + this.m + ", isMyLibrary=" + this.n + ", wikiSpaceName=" + this.o + ", url=" + this.p + ')';
    }

    public f0(String r10, String r11, String r12, int r13, int r14, String r15, long r16, long r18, long r20, long r22, l0 r24, boolean r25, boolean r26, boolean r27, String r28, String r29) {
        Intrinsics.checkNotNullParameter(r10, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r11, "icon");
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r15, "objToken");
        Intrinsics.checkNotNullParameter(r24, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r28, "wikiSpaceName");
        Intrinsics.checkNotNullParameter(r29, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r18;
        this.i = r20;
        this.j = r22;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
    }
}
