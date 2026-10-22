package q8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public final h<? super String> a;
    public final h<? super String> b;
    public final h<? super Integer> c;

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
        return "FilterRule(actionName=" + this.a + ", policyType=" + this.b + ", challengeType=" + this.c + ')';
    }

    public i(h<? super String> r2, h<? super String> r3, h<? super Integer> r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "policyType");
        Intrinsics.checkNotNullParameter(r4, "challengeType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public /* synthetic */ i(h r2, h r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r3 = d.c;
    L6:
        if ((r4 & 4) == 0) goto L8;
        d r5 = d.c;
    L9:
        this(r2, r3, r5);
        return;
    L8:
        r5 = null;
        goto L9
    }
}
