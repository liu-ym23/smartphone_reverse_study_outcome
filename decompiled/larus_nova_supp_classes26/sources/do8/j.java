package do8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Function0<Integer> f;

    public j() {
        this(false, false, false, false, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
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
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.e == true) goto L22;
        r1 = 1237;
    L22:
        int r9 = (r8 + r1) * 31;
        Function0<Integer> r10 = this.f;
        if (r10 != null) goto L25;
        int r11 = 0;
    L27:
        return r9 + r11;
    L25:
        r11 = r10.hashCode();
        goto L27
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
        return "VLMContainerUIConfig(reduceMarginStart=" + this.a + ", useNewHeightPadding=" + this.b + ", isHead=" + this.c + ", isTail=" + this.d + ", isVideoGroup=" + this.e + ", maxWidthProvider=" + this.f + ')';
    }

    public /* synthetic */ j(boolean r10, boolean r11, boolean r12, boolean r13, Function0 r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r15 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r15 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r15 & 8) == 0) goto L17;
        boolean r6 = false;
    L19:
        if ((r15 & 32) == 0) goto L21;
        r14 = null;
    L21:
        this(r3, r4, r5, r6, false, r14);
        return;
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public j(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, Function0<Integer> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
