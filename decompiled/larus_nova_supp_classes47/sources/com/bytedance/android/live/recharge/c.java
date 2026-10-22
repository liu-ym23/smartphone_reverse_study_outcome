package com.bytedance.android.live.recharge;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ CustomRechargeDialogFragment a;

    public c(CustomRechargeDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        CustomRechargeDialogFragment r0 = this.a;
        r0.U90((com.bytedance.android.live.recharge.deal.d) r3, r0.D);
    }
}
