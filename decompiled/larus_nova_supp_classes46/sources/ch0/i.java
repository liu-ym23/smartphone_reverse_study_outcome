package ch0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public final String a;
    public final List<tf0.d> b;
    public final List<tf0.d> c;
    public final List<tf0.d> d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L14;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<tf0.d> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<tf0.d> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<tf0.d> r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SeatDynamicData(bizId=" + this.a + ", updateByUidList=" + this.b + ", updateByPosList=" + this.c + ", updateAllList=" + this.d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(String r2, List<? extends tf0.d> r3, List<? extends tf0.d> r4, List<? extends tf0.d> r5) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        Intrinsics.checkNotNullParameter(r3, "updateByUidList");
        Intrinsics.checkNotNullParameter(r4, "updateByPosList");
        Intrinsics.checkNotNullParameter(r5, "updateAllList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
