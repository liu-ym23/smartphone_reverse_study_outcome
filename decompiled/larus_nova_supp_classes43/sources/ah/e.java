package ah;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final int a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L10;
        e r11 = (e) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 == null) goto L5;
        int r10 = r1.hashCode();
    L7:
        return r0 + r10;
    L5:
        r10 = 0;
        goto L7
    }

    public final String toString() {
        return "ECStoreHeightChangeEvent(height=" + this.a + ", targetContainer=" + this.b + ")";
    }

    public e(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "targetContainer");
        this.a = r10;
        this.b = r11;
    }
}
