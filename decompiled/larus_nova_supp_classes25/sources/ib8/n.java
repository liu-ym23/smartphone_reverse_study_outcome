package ib8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public final int A;
    public final int B;
    public final boolean C;
    public final boolean a;
    public final boolean b;
    public final kc8.o c;
    public final w0 d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final c j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final Function0<Integer> n;
    public final boolean o;
    public final boolean p;
    public final so8.r q;
    public final Integer r;
    public final Integer s;
    public final Integer t;
    public final String u;
    public final boolean v;
    public final boolean w;
    public final int x;
    public final int y;
    public final boolean z;

    public n() {
        this(false, false, null, null, false, false, false, false, false, null, false, false, false, null, false, false, null, null, null, null, null, false, false, 0, 0, false, 0, false, 1073741823);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(null, null) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L75;
        return false;
    L75:
        if (this.v == r6.v) goto L78;
        return false;
    L78:
        if (this.w == r6.w) goto L81;
        return false;
    L81:
        if (this.x == r6.x) goto L84;
        return false;
    L84:
        if (this.y == r6.y) goto L87;
        return false;
    L87:
        if (this.z == r6.z) goto L90;
        return false;
    L90:
        if (this.A == r6.A) goto L93;
        return false;
    L93:
        if (this.B == r6.B) goto L96;
        return false;
    L96:
        if (this.C == r6.C) goto L98;
        return false;
    L98:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        kc8.o r5 = this.c;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r4 + r7) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.g == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (r12 + r13) * 31;
        if (this.h == false) goto L29;
        int r15 = 1231;
    L30:
        int r16 = (r14 + r15) * 31;
        if (this.i == false) goto L33;
        int r17 = 1231;
    L34:
        int r18 = (((r16 + r17) * 31) + this.j.hashCode()) * 31;
        if (this.k == false) goto L37;
        int r19 = 1231;
    L38:
        int r20 = (r18 + r19) * 31;
        if (this.l == false) goto L41;
        int r21 = 1231;
    L42:
        int r22 = (r20 + r21) * 31;
        if (this.m == false) goto L45;
        int r23 = 1231;
    L46:
        int r24 = (((r22 + r23) * 31) + this.n.hashCode()) * 31;
        if (this.o == false) goto L49;
        int r25 = 1231;
    L50:
        int r26 = (r24 + r25) * 31;
        if (this.p == false) goto L53;
        int r27 = 1231;
    L54:
        int r28 = (((r26 + r27) * 31) + 0) * 31;
        so8.r r29 = this.q;
        if (r29 != null) goto L57;
        int r30 = 0;
    L58:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.r;
        if (r32 != null) goto L61;
        int r33 = 0;
    L62:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.s;
        if (r35 != null) goto L65;
        int r36 = 0;
    L66:
        int r37 = (r34 + r36) * 31;
        Integer r38 = this.t;
        if (r38 == null) goto L70;
        r6 = r38.hashCode();
    L70:
        int r39 = (((r37 + r6) * 31) + this.u.hashCode()) * 31;
        if (this.v == false) goto L73;
        int r40 = 1231;
    L74:
        int r41 = (r39 + r40) * 31;
        if (this.w == false) goto L77;
        int r42 = 1231;
    L78:
        int r43 = (((((r41 + r42) * 31) + this.x) * 31) + this.y) * 31;
        if (this.z == false) goto L81;
        int r44 = 1231;
    L82:
        int r45 = (((((r43 + r44) * 31) + this.A) * 31) + this.B) * 31;
        if (this.C == true) goto L87;
        r1 = 1237;
    L87:
        return r45 + r1;
    L81:
        r44 = 1237;
        goto L82
    L77:
        r42 = 1237;
        goto L78
    L73:
        r40 = 1237;
        goto L74
    L65:
        r36 = r35.hashCode();
        goto L66
    L61:
        r33 = r32.hashCode();
        goto L62
    L57:
        r30 = r29.hashCode();
        goto L58
    L53:
        r27 = 1237;
        goto L54
    L49:
        r25 = 1237;
        goto L50
    L45:
        r23 = 1237;
        goto L46
    L41:
        r21 = 1237;
        goto L42
    L37:
        r19 = 1237;
        goto L38
    L33:
        r17 = 1237;
        goto L34
    L29:
        r15 = 1237;
        goto L30
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FoldContainerViewInput(showBottom=" + this.a + ", showDivider=" + this.b + ", containerVmConfig=" + this.c + ", headTitleInfo=" + this.d + ", headerVisible=" + this.e + ", needShowExpandAll=" + this.f + ", hideExpandAllThinkTitle=" + this.g + ", shouldScrollToTopFromHalfHoldToExpand=" + this.h + ", deepThinkStreamEnd=" + this.i + ", foldAnimationData=" + this.j + ", cancelZoomAnimation=" + this.k + ", needReleaseVideoStreamEnd=" + this.l + ", needShowBottomMargin=" + this.m + ", getAttachItemTopMargin=" + this.n + ", hasReference=" + this.o + ", showBottomSplitLine=" + this.p + ", providerBindContext=null, zoomInAnimationManager=" + this.q + ", expandAllDividerColor=" + this.r + ", expandAllMaskRes=" + this.s + ", halfFoldExpandHeight=" + this.t + ", headerClickPosition=" + this.u + ", headerClickable=" + this.v + ", headerStickyEnabled=" + this.w + ", headerContentStartInset=" + this.x + ", headerContentTopInset=" + this.y + ", showHeaderSplitLine=" + this.z + ", headerSplitLineTopMargin=" + this.A + ", headerSplitLineBottomMargin=" + this.B + ", hideReferenceTitleBackground=" + this.C + ')';
    }

    public n(boolean r33, boolean r34, kc8.o r35, w0 r36, boolean r37, boolean r38, boolean r39, boolean r40, boolean r41, c r42, boolean r43, boolean r44, boolean r45, Function0 r46, boolean r47, boolean r48, so8.r r49, Integer r50, Integer r51, Integer r52, String r53, boolean r54, boolean r55, int r56, int r57, boolean r58, int r59, boolean r60, int r61) {
        if ((r61 & 1) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r61 & 2) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r61 & 4) == 0) goto L13;
        kc8.o r5 = null;
    L15:
        if ((r61 & 8) == 0) goto L17;
        w0 r7 = new w0(false, false, null, null, null, 0.0f, false, false, 511);
    L19:
        if ((r61 & 16) == 0) goto L21;
        boolean r8 = true;
    L23:
        if ((r61 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r61 & 64) == 0) goto L29;
        boolean r11 = false;
    L31:
        if ((r61 & 128) == 0) goto L33;
        boolean r12 = false;
    L35:
        if ((r61 & 256) == 0) goto L37;
        boolean r13 = false;
    L39:
        if ((r61 & 512) == 0) goto L41;
        c r14 = new c(false, null, null, 15);
    L43:
        if ((r61 & 1024) == 0) goto L45;
        boolean r15 = false;
    L47:
        if ((r61 & 2048) == 0) goto L49;
        boolean r3 = false;
    L51:
        if ((r61 & 4096) == 0) goto L53;
        boolean r6 = false;
    L55:
        if ((r61 & 8192) == 0) goto L57;
        Function0 r10 = new gw5.d();
    L58:
        boolean r17 = r6;
        if ((r61 & 16384) == 0) goto L61;
        boolean r16 = false;
    L63:
        if ((r61 & 32768) == 0) goto L65;
        boolean r19 = false;
    L67:
        if ((r61 & 131072) == 0) goto L69;
        so8.r r20 = null;
    L71:
        if ((r61 & 262144) == 0) goto L73;
        Integer r21 = null;
    L75:
        if ((r61 & 524288) == 0) goto L77;
        Integer r22 = null;
    L79:
        if ((r61 & 1048576) == 0) goto L81;
        Integer r23 = null;
    L83:
        if ((r61 & 2097152) == 0) goto L85;
        String r18 = "thinking_title";
    L87:
        if ((r61 & 4194304) == 0) goto L89;
        boolean r25 = true;
    L91:
        if ((r61 & 8388608) == 0) goto L93;
        boolean r26 = true;
    L95:
        if ((r61 & 16777216) == 0) goto L97;
        int r27 = 0;
    L99:
        if ((r61 & 33554432) == 0) goto L101;
        int r28 = 0;
    L103:
        if ((r61 & 67108864) == 0) goto L105;
        boolean r29 = false;
    L107:
        if ((r61 & 268435456) == 0) goto L109;
        int r30 = 0;
    L111:
        if ((r61 & 536870912) == 0) goto L113;
        boolean r110 = false;
    L114:
        Intrinsics.checkNotNullParameter(r7, "headTitleInfo");
        Intrinsics.checkNotNullParameter(r14, "foldAnimationData");
        Intrinsics.checkNotNullParameter(r10, "getAttachItemTopMargin");
        Intrinsics.checkNotNullParameter(r18, "headerClickPosition");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r3;
        this.m = r17;
        this.n = r10;
        this.o = r16;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r18;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = 0;
        this.B = r30;
        this.C = r110;
        return;
    L113:
        r110 = r60;
        goto L114
    L109:
        r30 = r59;
        goto L111
    L105:
        r29 = r58;
        goto L107
    L101:
        r28 = r57;
        goto L103
    L97:
        r27 = r56;
        goto L99
    L93:
        r26 = r55;
        goto L95
    L89:
        r25 = r54;
        goto L91
    L85:
        r18 = r53;
        goto L87
    L81:
        r23 = r52;
        goto L83
    L77:
        r22 = r51;
        goto L79
    L73:
        r21 = r50;
        goto L75
    L69:
        r20 = r49;
        goto L71
    L65:
        r19 = r48;
        goto L67
    L61:
        r16 = r47;
        goto L63
    L57:
        r10 = r46;
        goto L58
    L53:
        r6 = r45;
        goto L55
    L49:
        r3 = r44;
        goto L51
    L45:
        r15 = r43;
        goto L47
    L41:
        r14 = r42;
        goto L43
    L37:
        r13 = r41;
        goto L39
    L33:
        r12 = r40;
        goto L35
    L29:
        r11 = r39;
        goto L31
    L25:
        r9 = r38;
        goto L27
    L21:
        r8 = r37;
        goto L23
    L17:
        r7 = r36;
        goto L19
    L13:
        r5 = r35;
        goto L15
    L9:
        r4 = r34;
        goto L11
    L5:
        r2 = r33;
        goto L7
    }
}
