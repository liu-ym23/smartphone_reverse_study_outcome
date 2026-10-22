package gm8;

import android.graphics.RectF;
import com.larus.im.bean.message.block.Block;
import fh8.f;
import fh8.g;
import kotlin.jvm.internal.Intrinsics;
import lw8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Block a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final Boolean j;
    public final Boolean k;
    public final Boolean l;
    public final Boolean m;
    public final String n;
    public final String o;
    public final boolean p;
    public final RectF q;
    public final d r;
    public final f s;

    public a() {
        this(null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, false, null, null, 524287);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        Block r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        int r4 = 1231;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        Integer r11 = this.f;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.g;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.h;
        if (r17 != null) goto L29;
        int r18 = 0;
    L30:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.i;
        if (r20 != null) goto L33;
        int r21 = 0;
    L34:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.j;
        if (r23 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (r22 + r24) * 31;
        Boolean r26 = this.k;
        if (r26 != null) goto L41;
        int r27 = 0;
    L42:
        int r28 = (r25 + r27) * 31;
        Boolean r29 = this.l;
        if (r29 != null) goto L45;
        int r30 = 0;
    L46:
        int r31 = (r28 + r30) * 31;
        Boolean r32 = this.m;
        if (r32 != null) goto L49;
        int r33 = 0;
    L50:
        int r34 = (r31 + r33) * 31;
        String r35 = this.n;
        if (r35 != null) goto L53;
        int r36 = 0;
    L54:
        int r37 = (r34 + r36) * 31;
        String r38 = this.o;
        if (r38 != null) goto L57;
        int r39 = 0;
    L58:
        int r40 = (r37 + r39) * 31;
        if (this.p == true) goto L62;
        r4 = 1237;
    L62:
        int r41 = (r40 + r4) * 31;
        RectF r42 = this.q;
        if (r42 != null) goto L65;
        int r43 = 0;
    L66:
        int r44 = (r41 + r43) * 31;
        d r45 = this.r;
        if (r45 == null) goto L71;
        r1 = r45.hashCode();
    L71:
        return ((r44 + r1) * 31) + this.s.hashCode();
    L65:
        r43 = r42.hashCode();
        goto L66
    L57:
        r39 = r38.hashCode();
        goto L58
    L53:
        r36 = r35.hashCode();
        goto L54
    L49:
        r33 = r32.hashCode();
        goto L50
    L45:
        r30 = r29.hashCode();
        goto L46
    L41:
        r27 = r26.hashCode();
        goto L42
    L37:
        r24 = r23.hashCode();
        goto L38
    L33:
        r21 = r20.hashCode();
        goto L34
    L29:
        r18 = r17.hashCode();
        goto L30
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MarkdownContainerVMData(block=" + this.a + ", content=" + this.b + ", isLastBlock=" + this.c + ", failOrInterrupt=" + this.d + ", finished=" + this.e + ", textColor=" + this.f + ", textSize=" + this.g + ", lineHeight=" + this.h + ", maxContentWidth=" + this.i + ", disableMargin=" + this.j + ", enableCodeBlockStroke=" + this.k + ", enableCodeBlockHeaderBackground=" + this.l + ", enableTableHeader=" + this.m + ", messageId=" + this.n + ", blockId=" + this.o + ", isDeepThinkArea=" + this.p + ", marginRectF=" + this.q + ", customMarkdownInfo=" + this.r + ", commonInputData=" + this.s + ')';
    }

    public a(Block r22, String r23, boolean r24, boolean r25, boolean r26, Integer r27, Integer r28, Integer r29, Integer r30, Boolean r31, Boolean r32, Boolean r33, Boolean r34, String r35, String r36, boolean r37, RectF r38, d r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        Block r2 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r4 = "";
    L10:
        boolean r6 = true;
        if ((r40 & 4) == 0) goto L13;
        boolean r5 = true;
    L15:
        if ((r40 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r40 & 16) != 0) goto L23;
        r6 = r26;
    L23:
        if ((r40 & 32) == 0) goto L25;
        Integer r9 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        Integer r10 = null;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r40 & 256) == 0) goto L37;
        Integer r12 = 0;
    L39:
        if ((r40 & 512) == 0) goto L41;
        Boolean r13 = null;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        Boolean r14 = Boolean.FALSE;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        Boolean r15 = Boolean.FALSE;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        Boolean r3 = null;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        String r8 = null;
    L58:
        String r210 = r8;
        if ((r40 & 16384) == 0) goto L61;
        String r16 = null;
    L63:
        if ((r40 & 32768) == 0) goto L65;
        boolean r18 = false;
    L67:
        if ((r40 & 65536) == 0) goto L69;
        RectF r19 = null;
    L71:
        if ((r40 & 131072) == 0) goto L73;
        d r20 = null;
    L75:
        if ((r40 & 262144) == 0) goto L77;
        f r1 = new g().a();
    L78:
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r1, "commonInputData");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r6;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r3;
        this.n = r210;
        this.o = r16;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r1;
        return;
    L77:
        r1 = null;
        goto L78
    L73:
        r20 = r39;
        goto L75
    L69:
        r19 = r38;
        goto L71
    L65:
        r18 = r37;
        goto L67
    L61:
        r16 = r36;
        goto L63
    L57:
        r8 = r35;
        goto L58
    L53:
        r3 = r34;
        goto L55
    L49:
        r15 = r33;
        goto L51
    L45:
        r14 = r32;
        goto L47
    L41:
        r13 = r31;
        goto L43
    L37:
        r12 = r30;
        goto L39
    L33:
        r11 = r29;
        goto L35
    L29:
        r10 = r28;
        goto L31
    L25:
        r9 = r27;
        goto L27
    L17:
        r7 = r25;
        goto L19
    L13:
        r5 = r24;
        goto L15
    L9:
        r4 = r23;
        goto L10
    L5:
        r2 = r22;
        goto L7
    }
}
