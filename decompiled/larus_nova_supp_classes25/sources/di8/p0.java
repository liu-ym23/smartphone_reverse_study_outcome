package di8;

import com.larus.bmhome.taskskill.model.PcDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 implements a0 {
    public final f0 a;
    public final boolean b;
    public final PcDevice c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;

    public p0() {
        this(null, false, null, null, null, null, false, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r6 = (p0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        f0 r0 = this.a;
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
        PcDevice r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        if (this.g == true) goto L31;
        r4 = 1237;
    L31:
        return r17 + r4;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeTaskComputerPayload(originSourcePayload=" + this.a + ", isCloudComputer=" + this.b + ", pcDevice=" + this.c + ", foldMenuSelectedName=" + this.d + ", selectedName=" + this.e + ", selectedIconUrl=" + this.f + ", isConnectGuide=" + this.g + ')';
    }

    @Override // di8.a0
    public final String a() {
        return this.e;
    }

    @Override // di8.a0
    public final String b() {
        return this.f;
    }

    public p0(f0 r4, boolean r5, PcDevice r6, String r7, String r8, String r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r9 = null;
    L21:
        if ((r11 & 64) == 0) goto L23;
        r10 = false;
    L23:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
    }
}
