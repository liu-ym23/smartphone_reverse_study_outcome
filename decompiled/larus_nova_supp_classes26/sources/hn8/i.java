package hn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final k a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SearchListContainerOutput(callBackData=" + this.a + ')';
    }

    public i(k r2) {
        Intrinsics.checkNotNullParameter(r2, "callBackData");
        this.a = r2;
    }
}
