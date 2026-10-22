package gga;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final boolean a;
    public final Set<Integer> b;
    public final Integer c;

    public a() {
        this(0);
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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        Integer r2 = this.c;
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
        return "ObricActionBarModelMenuPolicy(enabled=" + this.a + ", blockedItemIds=" + this.b + ", defaultItemId=" + this.c + ')';
    }

    public /* synthetic */ a(int r3) {
        this(false, SetsKt.emptySet(), null);
    }

    public final boolean a(Integer r2) {
        if (this.a == false) goto L9;
        if (r2 == null) goto L9;
        if (this.b.contains(r2) == false) goto L9;
        return false;
    L9:
        return true;
    }

    public final int b(int r4) {
        if (this.a == true) goto L5;
        return r4;
    L5:
        if (this.b.contains(Integer.valueOf(r4)) == false) goto L19;
        Integer r0 = this.c;
        if (r0 != null) goto L10;
        return r4;
    L10:
        if ((!this.b.contains(Integer.valueOf(r0.intValue()))) == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L15;
        return r4;
    L15:
        return r0.intValue();
    L19:
        return r4;
    }

    public a(boolean r2, Set<Integer> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "blockedItemIds");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
