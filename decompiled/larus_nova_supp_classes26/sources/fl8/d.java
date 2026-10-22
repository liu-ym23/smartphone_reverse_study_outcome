package fl8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;

    public d() {
        this(null, false, false, false, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.d == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.e == true) goto L22;
        r4 = 1237;
    L22:
        int r11 = (r10 + r4) * 31;
        String r12 = this.f;
        if (r12 == null) goto L27;
        r1 = r12.hashCode();
    L27:
        return r11 + r1;
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
        return "FloatingThinkViewInput(title=" + this.a + ", showArrow=" + this.b + ", showLoadingIndicator=" + this.c + ", showShimmer=" + this.d + ", clickable=" + this.e + ", iconUrl=" + this.f + ')';
    }

    public /* synthetic */ d(String r10, boolean r11, boolean r12, boolean r13, String r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r15 & 8) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r15 & 16) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r15 & 32) == 0) goto L21;
        String r8 = null;
    L22:
        this(r3, r4, false, r6, r7, r8);
        return;
    L21:
        r8 = r14;
        goto L22
    L17:
        r7 = r13;
        goto L19
    L13:
        r6 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public d(String r1, boolean r2, boolean r3, boolean r4, boolean r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
