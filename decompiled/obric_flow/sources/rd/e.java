package rd;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21723a;

    public e(b r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaData");
        this.f21723a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f21723a, ((e) r5).f21723a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f21723a.hashCode();
    }

    public final String toString() {
        return "SchemaModelUnion(schemaData=" + this.f21723a + ')';
    }
}
