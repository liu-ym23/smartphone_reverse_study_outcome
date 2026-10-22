package fh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public final boolean a;
    public boolean b;
    public final String c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Boolean k;
    public final lw8.d l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
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
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
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
        int r4 = (((r2 + r3) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (((r4 + r5) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.g == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.h == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.i == false) goto L29;
        int r13 = 1231;
    L30:
        int r14 = (r12 + r13) * 31;
        if (this.j == true) goto L34;
        r1 = 1237;
    L34:
        int r15 = (r14 + r1) * 31;
        Boolean r16 = this.k;
        int r17 = 0;
        if (r16 != null) goto L37;
        int r18 = 0;
    L38:
        int r19 = (r15 + r18) * 31;
        lw8.d r20 = this.l;
        if (r20 == null) goto L43;
        r17 = r20.hashCode();
    L43:
        return r19 + r17;
    L37:
        r18 = r16.hashCode();
        goto L38
    L29:
        r13 = 1237;
        goto L30
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownRenderConfig(failOrInterrupt=" + this.a + ", isStreaming=" + this.b + ", viewAlphaTag=" + this.c + ", isDeepThinkArea=" + this.d + ", forceRefreshId=" + this.e + ", useSubscribedColor=" + this.f + ", useCodeStyle=" + this.g + ", isDeepResearchArea=" + this.h + ", enableCodeBlockStroke=" + this.i + ", enableCodeBlockHeaderBackground=" + this.j + ", enableTableHeader=" + this.k + ", customMarkdownInfo=" + this.l + ')';
    }

    public l(boolean r4, boolean r5, String r6, boolean r7, String r8, boolean r9, boolean r10, boolean r11, boolean r12, Boolean r13, lw8.d r14, int r15) {
        if ((r15 & 16) == 0) goto L6;
        r8 = r6;
    L6:
        if ((r15 & 32) == 0) goto L9;
        r9 = false;
    L9:
        if ((r15 & 128) == 0) goto L12;
        r10 = false;
    L12:
        if ((r15 & 256) == 0) goto L15;
        r11 = false;
    L15:
        if ((r15 & 512) == 0) goto L18;
        r12 = false;
    L18:
        if ((r15 & 1024) == 0) goto L21;
        r13 = null;
    L21:
        if ((r15 & 2048) == 0) goto L23;
        r14 = null;
    L23:
        Intrinsics.checkNotNullParameter(r6, "viewAlphaTag");
        Intrinsics.checkNotNullParameter(r8, "forceRefreshId");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = false;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
