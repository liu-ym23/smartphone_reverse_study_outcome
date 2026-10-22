package hh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final Integer d;
    public final Float e;
    public final boolean f;

    public a() {
        this(false, false, false, null, null, false, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
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
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        Integer r7 = this.d;
        int r8 = 0;
        if (r7 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r6 + r9) * 31;
        Float r11 = this.e;
        if (r11 == null) goto L22;
        r8 = r11.hashCode();
    L22:
        int r12 = (r10 + r8) * 31;
        if (this.f == true) goto L27;
        r1 = 1237;
    L27:
        return r12 + r1;
    L17:
        r9 = r7.hashCode();
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
        return "MarkdownCodeViewUIConfig(enableCodeBlockStroke=" + this.a + ", enableCodeBlockHeaderBackground=" + this.b + ", enableTransparentCodeBlockBackground=" + this.c + ", borderColor=" + this.d + ", cornerRadius=" + this.e + ", onlyShowCopyButton=" + this.f + ')';
    }

    public a(boolean r4, boolean r5, boolean r6, Integer r7, Float r8, boolean r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r6 = false;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & 32) == 0) goto L20;
        r9 = false;
    L20:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }
}
