package eba;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public final jba.e a;
    public final jba.c b;
    public final m c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ObricListeningChildWindowAppearance(layoutSpec=" + this.a + ", cornerRadii=" + this.b + ", geometryTrace=" + this.c + ')';
    }

    public k(jba.e r2, jba.c r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutSpec");
        Intrinsics.checkNotNullParameter(r3, "cornerRadii");
        Intrinsics.checkNotNullParameter(r4, "geometryTrace");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
