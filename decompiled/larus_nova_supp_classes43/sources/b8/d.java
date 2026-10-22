package b8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final b a;
    public final b b;
    public final b7.a c;
    public final boolean d;
    public final String e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        b r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        b r12 = this.b;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        b7.a r15 = this.c;
        if (r15 == null) goto L14;
        r1 = r15.hashCode();
    L14:
        int r16 = (r14 + r1) * 31;
        if (this.d == false) goto L17;
        int r17 = 1231;
    L19:
        return ((r16 + r17) * 31) + this.e.hashCode();
    L17:
        r17 = 1237;
        goto L19
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LogModel(aLogParam=" + this.a + ", debugLog=" + this.b + ", context=" + this.c + ", allowDelay=" + this.d + ", tag=" + this.e + ')';
    }

    public final b7.a getContext() {
        return this.c;
    }

    public d(b r10, b r11, boolean r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r12 = false;
    L11:
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        this.a = r10;
        this.b = r11;
        this.c = null;
        this.d = r12;
        this.e = r13;
    }
}
