package js;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends f8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18470a;

    public j(float r5) {
        this.f18470a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(Float.valueOf(this.f18470a), Float.valueOf(((j) r5).f18470a)) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.f18470a);
    }

    public final String toString() {
        return "TextWidthRatio(ratio=" + this.f18470a + ')';
    }
}
