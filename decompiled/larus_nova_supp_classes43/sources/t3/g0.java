package t3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g0 {
    public final String a;
    public final boolean b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r11 = (g0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "BluetoothServiceSnapshot(uuid=" + this.a + ", isPrimary=" + this.b + ')';
    }

    public g0(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "uuid");
        this.a = r10;
        this.b = r11;
    }
}
