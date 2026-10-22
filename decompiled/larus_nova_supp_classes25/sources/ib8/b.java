package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final c0 a;
    public final kb8.a b;
    public final mb8.a c;
    public final nb8.m d;
    public final do8.k e;
    public final kc8.o f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        int r0 = this.a.hashCode() * 31;
        kb8.a r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        mb8.a r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        nb8.m r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        do8.k r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        kc8.o r14 = this.f;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerVmData(foldContainerVmData=" + this.a + ", queryKeywordReferencesVMData=" + this.b + ", blockListVMData=" + this.c + ", deepThinkContentVMData=" + this.d + ", vlmVmData=" + this.e + ", containerVmConfig=" + this.f + ')';
    }

    public b(c0 r3, kb8.a r4, mb8.a r5, nb8.m r6, do8.k r7, kc8.o r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r9 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r9 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r9 & 32) == 0) goto L17;
        r8 = null;
    L17:
        Intrinsics.checkNotNullParameter(r3, "foldContainerVmData");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
