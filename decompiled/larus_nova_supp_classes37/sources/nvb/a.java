package nvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final String a;

    /* JADX INFO: renamed from: nvb.a$a, reason: collision with other inner class name */
    public static final class C0170a {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    static {
        new a("mm_hardware_placeholder");
    }

    public final String toString() {
        return this.a;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
    }
}
