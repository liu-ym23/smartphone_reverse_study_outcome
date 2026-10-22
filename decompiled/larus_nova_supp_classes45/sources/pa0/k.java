package pa0;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements e {
    public final com.bytedance.android.live.recharge.platform.business.model.income.b a;
    public final com.bytedance.android.live.recharge.platform.business.model.income.d b;

    @Override // pa0.e
    public final ExchangeInfo a() {
        int r2 = (int) this.a.getCashBalance();
        int r3 = (int) (this.a.getCashBalance() / 10);
        boolean r4 = this.b.firstExchange;
        com.bytedance.android.live.recharge.platform.business.model.a r1 = this.a.getRebateData();
        if (r1 == null) goto L5;
        int r7 = (int) r1.getRebateLimit();
    L6:
        com.bytedance.android.live.recharge.platform.business.model.a r5 = this.a.getRebateData();
        if (r5 == null) goto L9;
        int r8 = (int) r5.getGiftAmount();
    L10:
        com.bytedance.android.live.recharge.platform.business.model.a r6 = this.a.getRebateData();
        if (r6 == null) goto L13;
        int r9 = (int) r6.getLeftAmount();
    L14:
        int r11 = (int) this.a.getMaxCash();
        int r12 = (int) this.a.getMaxGoldCount();
        int r13 = (int) this.a.getGoldBalance();
        com.bytedance.android.live.recharge.platform.business.model.income.d r14 = this.b;
        int r15 = r7;
        int r16 = r8;
        int r17 = r9;
        return new ExchangeInfo(r2, r3, r4, null, r15, r16, r17, r11, r12, r13, r14.hideCombineExchange, r14.hideCashExchange, r14.giftPanelType, false, this.a.getEquivalentCashValue(), 8200, null);
    L13:
        r9 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public k(com.bytedance.android.live.recharge.platform.business.model.income.b r2, com.bytedance.android.live.recharge.platform.business.model.income.d r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "extra");
        this.a = r2;
        this.b = r3;
    }
}
