package ntb;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a0 {
    public final String a;
    public final String b;
    public final float c;
    public final float d;
    public final float e;
    public final String f;
    public final String g;
    public final float h;
    public final float i;
    public final float j;
    public final float k;
    public final Function1<String, String> l;
    public final Function1<String, Boolean> m;
    public final Function1<String, Unit> n;
    public final Function0<Unit> o;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Float.compare(this.h, r6.h) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.i, r6.i) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.j, r6.j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.k, r6.k) == 0) goto L42;
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
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((r0 + r3) * 31) + this.g.hashCode()) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k)) * 31) + this.l.hashCode()) * 31;
        Function1<String, Boolean> r5 = this.m;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.n.hashCode()) * 31;
        Function0<Unit> r8 = this.o;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PanelMarkdownRenderConfig(markdown=" + this.a + ", textColor=" + this.b + ", textSizeSp=" + this.c + ", lineHeightDp=" + this.d + ", lineSpacingDp=" + this.e + ", linkTextColor=" + this.f + ", listMarkerColor=" + this.g + ", listMarkerSizeDp=" + this.h + ", paragraphGap=" + this.i + ", listMarkerStartMarginDp=" + this.j + ", listTextStartMarginDp=" + this.k + ", resolveMarkdownLink=" + this.l + ", onLinkClick=" + this.m + ", openUrl=" + this.n + ", onContentLayout=" + this.o + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(String r8, String r9, float r10, float r11, float r12, String r13, String r14, float r15, float r16, float r17, float r18, Function1<? super String, String> r19, Function1<? super String, Boolean> r20, Function1<? super String, Unit> r21, Function0<Unit> r22) {
        Intrinsics.checkNotNullParameter(r8, "markdown");
        Intrinsics.checkNotNullParameter(r9, "textColor");
        Intrinsics.checkNotNullParameter(r14, "listMarkerColor");
        Intrinsics.checkNotNullParameter(r19, "resolveMarkdownLink");
        Intrinsics.checkNotNullParameter(r21, "openUrl");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r22;
    }
}
