package rw0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final com.bytedance.android.live.recharge.deal.f a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((g) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        com.bytedance.android.live.recharge.deal.f r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "RechargeSelectedDealLog(deal=" + this.a + ")";
    }

    public g(com.bytedance.android.live.recharge.deal.f r2) {
        Intrinsics.checkNotNullParameter(r2, "deal");
        this.a = r2;
    }
}
