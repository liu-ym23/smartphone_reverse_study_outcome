package u70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final String a;
    public final String b;

    public final String toString() {
        return "MutexPair(identify1=" + this.a + ", identify2=" + this.b + ")";
    }

    public a() {
        Intrinsics.checkNotNullParameter("LiveHotSpotWidget", "identify1");
        Intrinsics.checkNotNullParameter("VerticalRankEntranceWidget", "identify2");
        this.a = "LiveHotSpotWidget";
        this.b = "VerticalRankEntranceWidget";
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final boolean equals(Object r4) {
        a r5 = (a) r4;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r5.a, this.a) == false) goto L9;
        if (Intrinsics.areEqual(r5.b, this.b) == false) goto L9;
    L12:
        return true;
    L9:
        if (Intrinsics.areEqual(r5.a, this.b) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.b, this.a) == true) goto L12;
        return false;
    }
}
