package fm8;

import android.graphics.RectF;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final Integer f;
    public final int g;
    public final int h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final String l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final Boolean q;
    public final String r;
    public final Block s;
    public final lw8.d t;
    public final fh8.f u;
    public final RectF v;

    public q() {
        this(0, -1, -1, false, false, null, 0, -1, false, false, "markdown_text_container_default", null, false, false, false, false, null, "", null, null, new fh8.g().a(), null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
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
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        Integer r6 = this.f;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r5 + r8) * 31) + this.g) * 31) + this.h) * 31;
        if (this.i == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.j == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (((r11 + r12) * 31) + this.k.hashCode()) * 31;
        String r14 = this.l;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        if (this.m == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (r16 + r17) * 31;
        if (this.n == false) goto L33;
        int r19 = 1231;
    L34:
        int r20 = (r18 + r19) * 31;
        if (this.o == false) goto L37;
        int r21 = 1231;
    L38:
        int r22 = (r20 + r21) * 31;
        if (this.p == true) goto L42;
        r2 = 1237;
    L42:
        int r23 = (r22 + r2) * 31;
        Boolean r24 = this.q;
        if (r24 != null) goto L45;
        int r25 = 0;
    L46:
        int r26 = (((r23 + r25) * 31) + this.r.hashCode()) * 31;
        Block r27 = this.s;
        if (r27 != null) goto L49;
        int r28 = 0;
    L50:
        int r29 = (r26 + r28) * 31;
        lw8.d r30 = this.t;
        if (r30 != null) goto L53;
        int r31 = 0;
    L54:
        int r32 = (((r29 + r31) * 31) + this.u.hashCode()) * 31;
        RectF r33 = this.v;
        if (r33 == null) goto L59;
        r7 = r33.hashCode();
    L59:
        return r32 + r7;
    L53:
        r31 = r30.hashCode();
        goto L54
    L49:
        r28 = r27.hashCode();
        goto L50
    L45:
        r25 = r24.hashCode();
        goto L46
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
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownTextContainerInput(textColor=" + this.a + ", textSize=" + this.b + ", lineHeight=" + this.c + ", isImmerse=" + this.d + ", isSelectMode=" + this.e + ", boxType=" + this.f + ", maxContentWidth=" + this.g + ", marginHorizontal=" + this.h + ", failOrInterrupt=" + this.i + ", isStreaming=" + this.j + ", viewAlphaTag=" + this.k + ", forceRefreshId=" + this.l + ", isDeepThinkArea=" + this.m + ", useSubscribedColor=" + this.n + ", enableCodeBlockStroke=" + this.o + ", enableCodeBlockHeaderBackground=" + this.p + ", enableTableHeader=" + this.q + ", content=" + this.r + ", block=" + this.s + ", customMarkdownInfo=" + this.t + ", commonInputData=" + this.u + ", marginRectF=" + this.v + ')';
    }

    public q(int r6, int r7, int r8, boolean r9, boolean r10, Integer r11, int r12, int r13, boolean r14, boolean r15, String r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, Boolean r22, String r23, Block r24, lw8.d r25, fh8.f r26, RectF r27) {
        Intrinsics.checkNotNullParameter(r16, "viewAlphaTag");
        Intrinsics.checkNotNullParameter(r23, "content");
        Intrinsics.checkNotNullParameter(r26, "commonInputData");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
        this.q = r22;
        this.r = r23;
        this.s = r24;
        this.t = r25;
        this.u = r26;
        this.v = r27;
    }
}
