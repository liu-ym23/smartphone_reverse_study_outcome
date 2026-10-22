package vea;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n {
    public final boolean a;
    public final List<String> b;
    public final Integer c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
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
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        Integer r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.d;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricRestoreImageResult(success=" + this.a + ", failUris=" + this.b + ", errorCode=" + this.c + ", errorMsg=" + this.d + ')';
    }

    public /* synthetic */ n(boolean r4, Integer r5, String r6, int r7) {
        if ((r7 & 2) == 0) goto L5;
        List r0 = CollectionsKt.emptyList();
    L7:
        if ((r7 & 4) == 0) goto L10;
        r5 = null;
    L10:
        if ((r7 & 8) == 0) goto L12;
        r6 = null;
    L12:
        this(r4, r0, r5, r6);
        return;
    L5:
        r0 = null;
        goto L7
    }

    public n(boolean r2, List<String> r3, Integer r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "failUris");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
