package jy9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final ic8.d a;
    public final ic8.d b;
    public final ic8.d c;
    public final ic8.d d;
    public final ic8.d e;
    public final ic8.d f;

    public e() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "CreationAiEditParams(aiVideoParams=" + this.a + ", aiImageParams=" + this.b + ", aiImageExpandParams=" + this.c + ", aiImageErasePrams=" + this.d + ", aiImageSharepnessParams=" + this.e + ", aiVideoExtendParams=" + this.f + ')';
    }

    public /* synthetic */ e(ic8.d r17, ic8.d r18, ic8.d r19, ic8.d r20, ic8.d r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        ic8.d r10 = new ic8.d(false, null, null, false, null, null, 63);
    L7:
        if ((r22 & 2) == 0) goto L9;
        ic8.d r11 = new ic8.d(false, null, null, false, null, null, 63);
    L11:
        if ((r22 & 4) == 0) goto L13;
        ic8.d r12 = new ic8.d(false, null, null, false, null, null, 63);
    L15:
        if ((r22 & 8) == 0) goto L17;
        ic8.d r13 = new ic8.d(false, null, null, false, null, null, 63);
    L19:
        if ((r22 & 16) == 0) goto L21;
        ic8.d r14 = new ic8.d(false, null, null, false, null, null, 63);
    L23:
        if ((r22 & 32) == 0) goto L25;
        ic8.d r0 = new ic8.d(false, null, null, false, null, null, 63);
    L26:
        this(r10, r11, r12, r13, r14, r0);
        return;
    L25:
        r0 = null;
        goto L26
    L21:
        r14 = r21;
        goto L23
    L17:
        r13 = r20;
        goto L19
    L13:
        r12 = r19;
        goto L15
    L9:
        r11 = r18;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    public e(ic8.d r2, ic8.d r3, ic8.d r4, ic8.d r5, ic8.d r6, ic8.d r7) {
        Intrinsics.checkNotNullParameter(r2, "aiVideoParams");
        Intrinsics.checkNotNullParameter(r3, "aiImageParams");
        Intrinsics.checkNotNullParameter(r4, "aiImageExpandParams");
        Intrinsics.checkNotNullParameter(r5, "aiImageErasePrams");
        Intrinsics.checkNotNullParameter(r6, "aiImageSharepnessParams");
        Intrinsics.checkNotNullParameter(r7, "aiVideoExtendParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
