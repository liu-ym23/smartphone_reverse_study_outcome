package i5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements com.bytedance.assem.arch.viewModel.h {
    public final Object a;

    public g() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((g) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Object r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "RenderState(currentState=" + this.a + ')';
    }

    public g(Object r1) {
        this.a = r1;
    }
}
