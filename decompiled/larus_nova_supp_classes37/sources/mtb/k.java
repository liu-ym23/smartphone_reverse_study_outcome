package mtb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public final int a;
    public final String b;

    public k() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "OfficeNewFriendBadgeModel(badgeCount=" + this.a + ", requestName=" + this.b + ')';
    }

    public /* synthetic */ k(int r2) {
        this(0, "");
    }

    public k(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "requestName");
        this.a = r2;
        this.b = r3;
    }
}
