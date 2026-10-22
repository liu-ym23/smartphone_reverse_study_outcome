package js;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends f8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18466a;

    public h(float r5) {
        this.f18466a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(Float.valueOf(this.f18466a), Float.valueOf(((h) r5).f18466a)) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.f18466a);
    }

    public final String toString() {
        return "FloatValue(value=" + this.f18466a + ')';
    }
}
