package ib8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 {
    public final List<jc8.a> a;
    public final d0 b;
    public final m c;
    public final Message d;
    public final boolean e;
    public final DeepThinkFoldStatus f;
    public final Function0<Boolean> g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final Function0<Integer> l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final Integer q;
    public final Integer r;
    public final Integer s;
    public final boolean t;
    public final boolean u;

    public c0() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r6 = (c0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L24;
        return false;
    L24:
        if (this.e == r6.e) goto L27;
        return false;
    L27:
        if (this.f == r6.f) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L33;
        return false;
    L33:
        if (this.h == r6.h) goto L36;
        return false;
    L36:
        if (this.i == r6.i) goto L39;
        return false;
    L39:
        if (this.j == r6.j) goto L42;
        return false;
    L42:
        if (this.k == r6.k) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L48;
        return false;
    L48:
        if (this.m == r6.m) goto L51;
        return false;
    L51:
        if (this.n == r6.n) goto L54;
        return false;
    L54:
        if (this.o == r6.o) goto L57;
        return false;
    L57:
        if (this.p == r6.p) goto L60;
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
        if (this.t == r6.t) goto L72;
        return false;
    L72:
        if (this.u == r6.u) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        List<jc8.a> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + 0) * 31;
        d0 r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((r3 + r5) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r7 = 1231;
        if (this.e == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (((r6 + r8) * 31) + this.f.hashCode()) * 31;
        Function0<Boolean> r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.h == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        if (this.i == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.j == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (r16 + r17) * 31;
        if (this.k == false) goto L33;
        int r19 = 1231;
    L34:
        int r20 = (((r18 + r19) * 31) + this.l.hashCode()) * 31;
        if (this.m == false) goto L37;
        int r21 = 1231;
    L38:
        int r22 = (r20 + r21) * 31;
        if (this.n == false) goto L41;
        int r23 = 1231;
    L42:
        int r24 = (r22 + r23) * 31;
        if (this.o == false) goto L45;
        int r25 = 1231;
    L46:
        int r26 = (r24 + r25) * 31;
        if (this.p == false) goto L49;
        int r27 = 1231;
    L50:
        int r28 = (r26 + r27) * 31;
        Integer r29 = this.q;
        if (r29 != null) goto L53;
        int r30 = 0;
    L54:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.r;
        if (r32 != null) goto L57;
        int r33 = 0;
    L58:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.s;
        if (r35 == null) goto L62;
        r1 = r35.hashCode();
    L62:
        int r36 = (r34 + r1) * 31;
        if (this.t == false) goto L65;
        int r37 = 1231;
    L66:
        int r38 = (r36 + r37) * 31;
        if (this.u == true) goto L71;
        r7 = 1237;
    L71:
        return r38 + r7;
    L65:
        r37 = 1237;
        goto L66
    L57:
        r33 = r32.hashCode();
        goto L58
    L53:
        r30 = r29.hashCode();
        goto L54
    L49:
        r27 = 1237;
        goto L50
    L45:
        r25 = 1237;
        goto L46
    L41:
        r23 = 1237;
        goto L42
    L37:
        r21 = 1237;
        goto L38
    L33:
        r19 = 1237;
        goto L34
    L29:
        r17 = 1237;
        goto L30
    L25:
        r15 = 1237;
        goto L26
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FoldContainerVmData(animationBlockList=" + this.a + ", providerBindContext=null, foldOrExpandAnimation=" + this.b + ", headerInfo=" + this.c + ", message=" + this.d + ", isDeepThinkingTyping=" + this.e + ", targetDeepThinkFoldStatus=" + this.f + ", interceptClickCard=" + this.g + ", disableFoldExpandClick=" + this.h + ", thinkContentEmpty=" + this.i + ", needTitleBottomMargin=" + this.j + ", hideReferenceTitleBackground=" + this.k + ", getAttachItemTopMargin=" + this.l + ", forceRefreshContent=" + this.m + ", hasReference=" + this.n + ", showBottomSplitLine=" + this.o + ", headerVisible=" + this.p + ", expandAllDividerColor=" + this.q + ", expandAllMaskRes=" + this.r + ", halfFoldExpandHeight=" + this.s + ", hideExpandAllDivider=" + this.t + ", isCollectionMode=" + this.u + ')';
    }

    public c0(List r24, d0 r25, m r26, Message r27, boolean r28, DeepThinkFoldStatus r29, eb8.v r30, boolean r31, boolean r32, boolean r33, boolean r34, Function0 r35, boolean r36, boolean r37, boolean r38, Integer r39, Integer r40, Integer r41, boolean r42, boolean r43, int r44) {
        if ((r44 & 1) == 0) goto L5;
        List r5 = null;
    L7:
        if ((r44 & 4) == 0) goto L9;
        d0 r7 = null;
    L11:
        if ((r44 & 128) == 0) goto L13;
        eb8.v r8 = null;
    L15:
        if ((r44 & 256) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r44 & 512) == 0) goto L21;
        boolean r11 = true;
    L23:
        if ((r44 & 1024) == 0) goto L25;
        boolean r13 = false;
    L27:
        if ((r44 & 2048) == 0) goto L29;
        boolean r14 = false;
    L31:
        if ((r44 & 4096) == 0) goto L33;
        Function0 r15 = new gw5.d();
    L35:
        if ((r44 & 16384) == 0) goto L37;
        boolean r6 = false;
    L39:
        if ((r44 & 32768) == 0) goto L41;
        boolean r12 = false;
    L43:
        if ((r44 & 65536) == 0) goto L45;
        boolean r18 = true;
    L47:
        if ((r44 & 131072) == 0) goto L49;
        Integer r19 = null;
    L51:
        if ((r44 & 262144) == 0) goto L53;
        Integer r20 = null;
    L55:
        if ((r44 & 524288) == 0) goto L57;
        Integer r21 = null;
    L59:
        if ((r44 & 1048576) == 0) goto L61;
        boolean r22 = false;
    L63:
        if ((r44 & 2097152) == 0) goto L65;
        boolean r4 = false;
    L66:
        Intrinsics.checkNotNullParameter(r26, "headerInfo");
        Intrinsics.checkNotNullParameter(r27, "message");
        Intrinsics.checkNotNullParameter(r29, "targetDeepThinkFoldStatus");
        Intrinsics.checkNotNullParameter(r15, "getAttachItemTopMargin");
        this.a = r5;
        this.b = r7;
        this.c = r26;
        this.d = r27;
        this.e = r28;
        this.f = r29;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = false;
        this.n = r6;
        this.o = r12;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r4;
        return;
    L65:
        r4 = r43;
        goto L66
    L61:
        r22 = r42;
        goto L63
    L57:
        r21 = r41;
        goto L59
    L53:
        r20 = r40;
        goto L55
    L49:
        r19 = r39;
        goto L51
    L45:
        r18 = r38;
        goto L47
    L41:
        r12 = r37;
        goto L43
    L37:
        r6 = r36;
        goto L39
    L33:
        r15 = r35;
        goto L35
    L29:
        r14 = r34;
        goto L31
    L25:
        r13 = r33;
        goto L27
    L21:
        r11 = r32;
        goto L23
    L17:
        r9 = r31;
        goto L19
    L13:
        r8 = r30;
        goto L15
    L9:
        r7 = r25;
        goto L11
    L5:
        r5 = r24;
        goto L7
    }
}
