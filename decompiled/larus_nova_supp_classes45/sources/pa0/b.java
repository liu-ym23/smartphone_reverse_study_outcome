package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends l {
    public final com.bytedance.android.live.incentive.balance.b.C0199b b;

    public b() {
        this.b = com.bytedance.android.live.incentive.balance.b.C0199b.a;
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final com.bytedance.android.live.incentive.balance.b a() {
        return this.b;
    }

    @Override // pa0.l
    public final Long d(e r6) {
        Intrinsics.checkNotNullParameter(r6, "incomeInfo");
        k r7 = g.b(r6);
        if (r7 == null) goto L16;
        Intrinsics.checkNotNullParameter(r7, "$this$getEquivalentCashValue");
        long r2 = 0;
        if (r7.a.getEquivalentCashValue() < 0) goto L7;
        long r0 = r7.a.getEquivalentCashValue();
    L18:
        return Long.valueOf(r0);
    L7:
        Intrinsics.checkNotNullParameter(r7, "$this$cashBalanceOrZero");
        Long r1 = g.a(r7);
        if (r1 == null) goto L10;
        long r3 = r1.longValue();
    L11:
        long r4 = r3 + 0;
        Intrinsics.checkNotNullParameter(r7, "$this$goldBalanceOrZero");
        Long r8 = g.c(r7);
        if (r8 == null) goto L14;
        r2 = r8.longValue();
    L14:
        r0 = r4 + r2;
        goto L18
    L10:
        r3 = 0;
        goto L11
    L16:
        return null;
    }
}
