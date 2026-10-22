package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.view.BalanceExchangeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements BalanceExchangeView.b {
    public final /* synthetic */ CustomRechargeDialogFragment a;

    public e(CustomRechargeDialogFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.recharge.view.BalanceExchangeView.b
    public final void a(boolean r4) {
        CustomRechargeDialogFragment r0 = this.a;
        r0.X90(r0.F, r4);
        xs2.b.a().post(new cx0.a(Boolean.valueOf(r4)));
    }
}
