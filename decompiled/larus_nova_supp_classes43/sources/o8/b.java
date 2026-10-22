package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public String b;
    public boolean c;
    public boolean d;
    public final boolean e;

    public b() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        int r13 = (r11 + r1) * 31;
        int r14 = 1231;
        if (this.c == false) goto L13;
        int r15 = 1231;
    L14:
        int r16 = (r13 + r15) * 31;
        if (this.d == false) goto L17;
        int r17 = 1231;
    L18:
        int r18 = (r16 + r17) * 31;
        if (this.e == true) goto L23;
        r14 = 1237;
    L23:
        return r18 + r14;
    L17:
        r17 = 1237;
        goto L18
    L13:
        r15 = 1237;
        goto L14
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeviceInfo(carrier=" + this.a + ", deviceId=" + this.b + ", isPad=" + this.c + ", isFoldScreen=" + this.d + ", isDigHoleScreen=" + this.e + ')';
    }

    public b(int r1) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = false;
    }
}
