package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SeatUpdateType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l {
    public final String a;
    public final SeatUpdateType b;
    public final List<tf0.d> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L12;
        l r4 = (l) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        SeatUpdateType r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<tf0.d> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SeatExtraObject(bizId=" + this.a + ", type=" + this.b + ", itemList=" + this.c + ")";
    }

    public final SeatUpdateType getType() {
        return this.b;
    }

    public l(String r2, SeatUpdateType r3, List<tf0.d> r4) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "itemList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
