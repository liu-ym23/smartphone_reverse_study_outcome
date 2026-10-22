package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends l {
    public final com.bytedance.android.live.incentive.balance.b.e b;

    public c() {
        this.b = com.bytedance.android.live.incentive.balance.b.e.a;
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final com.bytedance.android.live.incentive.balance.b a() {
        return this.b;
    }

    @Override // pa0.l
    public final Long d(e r6) {
        Intrinsics.checkNotNullParameter(r6, "incomeInfo");
        Integer r7 = Integer.valueOf(r6.a().getExchangeBalance());
        if (r7.intValue() < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r7 = null;
    L10:
        if (r7 != null) goto L12;
        return null;
    L12:
        return Long.valueOf(r7.intValue());
    L5:
        r0 = false;
        goto L7
    }
}
