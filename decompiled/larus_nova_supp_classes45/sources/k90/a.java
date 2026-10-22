package k90;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public float a;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
        r4.getClass();
        r4.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L20;
        r4.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L21;
        r4.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L22;
        r4.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        if (Float.compare(this.a, r4.a) == 0) goto L25;
        return false;
    L25:
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L16:
        return false;
    }

    public final int getType() {
        return 0;
    }

    public final int hashCode() {
        return (((((((((0 * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + Float.floatToIntBits(this.a);
    }

    public final String toString() {
        return "LensData(type=0, sticker=null, icon=null, name=null, LensTabDatas=null, defaultValue=" + this.a + ")";
    }
}
