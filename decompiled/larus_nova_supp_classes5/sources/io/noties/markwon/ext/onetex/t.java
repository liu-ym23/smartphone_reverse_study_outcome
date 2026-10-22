package io.noties.markwon.ext.onetex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class t {
    public static final /* synthetic */ int g = 0;
    public final float a;
    public final float b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;

    public static final class a {
        public boolean a;
        public int b;
        public final int c;
        public final int d;
        public final float e;

        public a(float r1) {
            this.e = r1;
            this.a = true;
            int r2 = this.b;
            this.c = r2;
            this.d = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L5;
    L40:
        return true;
    L5:
        if ((r6 instanceof t) == false) goto L39;
        t r7 = (t) r6;
        if (Float.compare(this.a, r7.a) != 0) goto L39;
        if (Float.compare(this.b, r7.b) != 0) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (this.c != r7.c) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L39;
        if (this.d != r7.d) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (this.e != r7.e) goto L31;
        boolean r1 = true;
    L32:
        if (r1 == false) goto L39;
        if (this.f != r7.f) goto L36;
        boolean r8 = true;
    L37:
        if (r8 == false) goto L39;
    L36:
        r8 = false;
        goto L37
    L31:
        r1 = false;
        goto L32
    L22:
        r4 = false;
        goto L23
    L17:
        r3 = false;
    L39:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r0 = ((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + 0) * 31) + 0) * 31;
        boolean r1 = this.c;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((((((((r0 + r2) * 31) + this.d) * 31) + 0) * 31) + 0) * 31) + this.e) * 31) + this.f;
    }

    public final String toString() {
        return "LatexMathTheme(inlineTextSize=" + this.a + ", blockTextSize=" + this.b + ", inlineBackgroundProvider=null, blockBackgroundProvider=null, blockFitCanvas=" + this.c + ", blockHorizontalAlignment=" + this.d + ", inlinePadding=null, blockPadding=null, inlineTextColor=" + this.e + ", blockTextColor=" + this.f + ")";
    }

    public t(a r6) {
        float r0 = 0;
        float r1 = 0.0f;
        if (0.0f <= r0) goto L5;
        float r2 = 0.0f;
    L6:
        if (0.0f > r0) goto L9;
        r1 = r6.e;
    L9:
        boolean r3 = r6.a;
        int r4 = r6.c;
        if (r4 > 0) goto L13;
        r4 = r6.b;
    L13:
        int r5 = r6.d;
        if (r5 > 0) goto L17;
        r5 = r6.b;
    L17:
        this.a = r2;
        this.b = r1;
        this.c = r3;
        this.d = 17;
        this.e = r4;
        this.f = r5;
        return;
    L5:
        r2 = r6.e;
        goto L6
    }
}
