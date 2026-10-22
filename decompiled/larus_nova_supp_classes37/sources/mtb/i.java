package mtb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i extends c implements m {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "OfficeFeishuDepartmentItem(displayName=" + this.a + ", id=" + this.b + ')';
    }

    public i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "displayName");
        Intrinsics.checkNotNullParameter(r3, "id");
        this.a = r2;
        this.b = r3;
    }
}
