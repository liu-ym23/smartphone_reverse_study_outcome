package obric.flow;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20435a;

    public d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "cardID");
        this.f20435a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f20435a, ((d) r5).f20435a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f20435a.hashCode();
    }

    public final String toString() {
        return j0.q(new StringBuilder("removeCard(cardID="), this.f20435a, ")");
    }
}
