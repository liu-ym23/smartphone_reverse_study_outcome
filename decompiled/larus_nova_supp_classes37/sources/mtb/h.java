package mtb;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final List<c> a;
    public final int b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeDepartmentPageModel(items=" + this.a + ", nextOffset=" + this.b + ", hasMore=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends c> r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
