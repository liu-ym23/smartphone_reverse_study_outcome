package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends l {
    public final com.bytedance.android.live.incentive.balance.b.a b;

    public a() {
        this.b = com.bytedance.android.live.incentive.balance.b.a.a;
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final com.bytedance.android.live.incentive.balance.b a() {
        return this.b;
    }

    @Override // pa0.l
    public final Long d(e r2) {
        Intrinsics.checkNotNullParameter(r2, "incomeInfo");
        k r3 = g.b(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return g.a(r3);
    }
}
