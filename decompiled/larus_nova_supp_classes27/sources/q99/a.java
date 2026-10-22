package q99;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final boolean a;
    public final List<Integer> b;
    public final List<b> c;
    public final String d;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        boolean r2 = false;
        Object[] r0 = 0 == true ? 1 : 0;
        this(r2, null, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r2 = this.d;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowDislikeFeedbackResult(isSubmit=" + this.a + ", selectedCodeList=" + this.b + ", selectedOptions=" + this.c + ", inputText=" + this.d + ')';
    }

    public /* synthetic */ a(boolean r3, List r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = CollectionsKt.emptyList();
    L9:
        if ((r6 & 4) == 0) goto L11;
        List r0 = CollectionsKt.emptyList();
    L13:
        if ((r6 & 8) == 0) goto L15;
        r5 = null;
    L15:
        this(r3, r4, r0, r5);
        return;
    L11:
        r0 = null;
        goto L13
    }

    public a(boolean r2, List<Integer> r3, List<b> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "selectedCodeList");
        Intrinsics.checkNotNullParameter(r4, "selectedOptions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
