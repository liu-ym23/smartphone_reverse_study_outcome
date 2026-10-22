package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k4 {
    public final Integer a;

    public k4() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof k4) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((k4) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "SendEntityConfig(maxParallelUploadEntityCount=" + this.a + ')';
    }

    public /* synthetic */ k4(int r1) {
        this(10);
    }

    public k4(Integer r1) {
        this.a = r1;
    }
}
