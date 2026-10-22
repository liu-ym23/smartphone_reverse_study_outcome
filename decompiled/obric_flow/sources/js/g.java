package js;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18465a;

    public g(float r5) {
        this.f18465a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(Float.valueOf(this.f18465a), Float.valueOf(((g) r5).f18465a)) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.f18465a);
    }

    public final String toString() {
        return "DimensionDp(value=" + this.f18465a + ')';
    }
}
