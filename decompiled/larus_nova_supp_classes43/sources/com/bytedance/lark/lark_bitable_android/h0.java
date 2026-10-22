package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h0 {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final String h;
    public final String i;
    public final String j;
    public final boolean k;
    public final int l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final long q;
    public final boolean r;
    public final boolean s;
    public final String t;
    public final int u;
    public final int v;
    public final String w;
    public final String x;
    public final String y;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r11 = (h0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r11.k) goto L42;
        return false;
    L42:
        if (this.l == r11.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r11.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r11.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r11.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r11.q) goto L60;
        return false;
    L60:
        if (this.r == r11.r) goto L63;
        return false;
    L63:
        if (this.s == r11.s) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r11.t) == true) goto L69;
        return false;
    L69:
        if (this.u == r11.u) goto L72;
        return false;
    L72:
        if (this.v == r11.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r11.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r11.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r11.y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r10 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r11 = (r0 + r1) * 31;
        if (this.d == false) goto L9;
        int r12 = 1231;
    L10:
        int r13 = (r11 + r12) * 31;
        if (this.e == false) goto L13;
        int r14 = 1231;
    L14:
        int r15 = (r13 + r14) * 31;
        if (this.f == false) goto L17;
        int r16 = 1231;
    L18:
        int r17 = (((((((((r15 + r16) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        if (this.k == false) goto L21;
        int r18 = 1231;
    L22:
        int r19 = (((((((((((r17 + r18) * 31) + this.l) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31;
        long r20 = this.q;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        if (this.r == false) goto L25;
        int r22 = 1231;
    L26:
        int r23 = (r21 + r22) * 31;
        if (this.s == true) goto L31;
        r10 = 1237;
    L31:
        return ((((((((((((r23 + r10) * 31) + this.t.hashCode()) * 31) + this.u) * 31) + this.v) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31) + this.y.hashCode();
    L25:
        r22 = 1237;
        goto L26
    L21:
        r18 = 1237;
        goto L22
    L17:
        r16 = 1237;
        goto L18
    L13:
        r14 = 1237;
        goto L14
    L9:
        r12 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "HomepageInnerDocExtraData(iconKey=" + this.a + ", spaceId=" + this.b + ", isVisited=" + this.c + ", hasPerm=" + this.d + ", copiable=" + this.e + ", isShareRoot=" + this.f + ", iconEncryptedType=" + this.g + ", iconNonce=" + this.h + ", icon=" + this.i + ", appId=" + this.j + ", notWikiObj=" + this.k + ", templateType=" + this.l + ", wikiSpaceId=" + this.m + ", wikiSpaceName=" + this.n + ", wikiSubToken=" + this.o + ", wikiVersion=" + this.p + ", bizType=" + this.q + ", fileRiskTag=" + this.r + ", isExternal=" + this.s + ", wikiSpaceCreateUid=" + this.t + ", wikiSpaceType=" + this.u + ", wikiSubtype=" + this.v + ", wikiHomepage=" + this.w + ", complaint=" + this.x + ", docDescription=" + this.y + ')';
    }

    public h0(String r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, int r22, String r23, String r24, String r25, boolean r26, int r27, String r28, String r29, String r30, String r31, long r32, boolean r34, boolean r35, String r36, int r37, int r38, String r39, String r40, String r41) {
        Intrinsics.checkNotNullParameter(r16, "iconKey");
        Intrinsics.checkNotNullParameter(r17, "spaceId");
        Intrinsics.checkNotNullParameter(r23, "iconNonce");
        Intrinsics.checkNotNullParameter(r24, "icon");
        Intrinsics.checkNotNullParameter(r25, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r28, "wikiSpaceId");
        Intrinsics.checkNotNullParameter(r29, "wikiSpaceName");
        Intrinsics.checkNotNullParameter(r30, "wikiSubToken");
        Intrinsics.checkNotNullParameter(r31, "wikiVersion");
        Intrinsics.checkNotNullParameter(r36, "wikiSpaceCreateUid");
        Intrinsics.checkNotNullParameter(r39, "wikiHomepage");
        Intrinsics.checkNotNullParameter(r40, "complaint");
        Intrinsics.checkNotNullParameter(r41, "docDescription");
        this.a = r16;
        this.b = r17;
        this.c = r18;
        this.d = r19;
        this.e = r20;
        this.f = r21;
        this.g = r22;
        this.h = r23;
        this.i = r24;
        this.j = r25;
        this.k = r26;
        this.l = r27;
        this.m = r28;
        this.n = r29;
        this.o = r30;
        this.p = r31;
        this.q = r32;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        this.w = r39;
        this.x = r40;
        this.y = r41;
    }
}
