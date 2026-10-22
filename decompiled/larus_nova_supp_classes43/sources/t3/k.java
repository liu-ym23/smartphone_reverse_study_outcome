package t3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public final String a;
    public final j b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k) == true) goto L8;
        return false;
    L8:
        k r11 = (k) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "BluetoothCharacteristicSnapshot(uuid=" + this.a + ", properties=" + this.b + ')';
    }

    public k(String r10, j r11) {
        Intrinsics.checkNotNullParameter(r10, "uuid");
        Intrinsics.checkNotNullParameter(r11, "properties");
        this.a = r10;
        this.b = r11;
    }
}
