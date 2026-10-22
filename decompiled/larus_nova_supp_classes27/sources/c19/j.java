package c19;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j {
    public final float a;
    public final String b;
    public final float c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + this.b.hashCode()) * 31) + Float.floatToIntBits(this.c);
    }

    public final String toString() {
        return "DbxStop(o=" + this.a + ", hex=" + this.b + ", a=" + this.c + ')';
    }

    public j(float r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "hex");
        this.a = r2;
        this.b = r3;
        this.c = 1.0f;
    }
}
