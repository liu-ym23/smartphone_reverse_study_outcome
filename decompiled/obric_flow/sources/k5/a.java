package k5;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18596b;

    public a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "source");
        this.f18595a = r5;
        this.f18596b = r10;
    }

    public final boolean a() {
        String r5 = this.f18595a;
        if (r5.length() != 0) goto L6;
    L7:
        boolean r10 = true;
    L10:
        return !r10;
    L6:
        if (Intrinsics.areEqual(r5, "__hybrid_default") == true) goto L7;
        r10 = false;
        goto L10
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f18595a;
        if (Intrinsics.areEqual(this.f18595a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18596b, r10.f18596b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f18595a.hashCode() * 31;
        return this.f18596b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("BidMatchResult(bid=");
        r5.append(this.f18595a);
        r5.append(", source=");
        return j0.p(r5, this.f18596b, ')');
    }
}
