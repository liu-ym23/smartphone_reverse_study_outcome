package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e3 {
    public final boolean a;
    public final List<String> b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final String h;
    public final List<String> i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    public e3() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e3) == true) goto L8;
        return false;
    L8:
        e3 r6 = (e3) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
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
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        List<String> r3 = this.b;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((((((((r6 + r7) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        String r9 = this.h;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        List<String> r12 = this.i;
        if (r12 == null) goto L22;
        r4 = r12.hashCode();
    L22:
        int r13 = (r11 + r4) * 31;
        if (this.j == false) goto L25;
        int r14 = 1231;
    L26:
        int r15 = (r13 + r14) * 31;
        if (this.k == false) goto L29;
        int r16 = 1231;
    L30:
        int r17 = (r15 + r16) * 31;
        if (this.l == false) goto L33;
        int r18 = 1231;
    L34:
        int r19 = (r17 + r18) * 31;
        if (this.m == false) goto L37;
        int r20 = 1231;
    L38:
        int r21 = (r19 + r20) * 31;
        if (this.n == false) goto L41;
        int r22 = 1231;
    L42:
        int r23 = (r21 + r22) * 31;
        if (this.o == true) goto L47;
        r1 = 1237;
    L47:
        return r23 + r1;
    L41:
        r22 = 1237;
        goto L42
    L37:
        r20 = 1237;
        goto L38
    L33:
        r18 = 1237;
        goto L34
    L29:
        r16 = 1237;
        goto L30
    L25:
        r14 = 1237;
        goto L26
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownCodeRenderConfig(enableMarkdownCodeRender=" + this.a + ", canPreviewLanguage=" + this.b + ", enableCodeRenderWebviewPreload=" + this.c + ", appPreviewImageWidth=" + this.d + ", appPreviewImageHeight=" + this.e + ", padPreviewImageWidth=" + this.f + ", padPreviewImageHeight=" + this.g + ", previewLynxviewTemplateUrl=" + this.h + ", canPreviewInLynxviewLanguage=" + this.i + ", normalHtmlCodeOptimize=" + this.j + ", renderHtmlCodeOptimize=" + this.k + ", mindmapCodeOptimize=" + this.l + ", mermaidCodeOptimize=" + this.m + ", svgCodeOptimize=" + this.n + ", echartCodeOptimize=" + this.o + ')';
    }

    public /* synthetic */ e3(int r17) {
        this(false, null, false, 480, 480, 800, 800, null, null, false, false, false, false, false, false);
    }

    public e3(boolean r1, List<String> r2, boolean r3, int r4, int r5, int r6, int r7, String r8, List<String> r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
    }
}
