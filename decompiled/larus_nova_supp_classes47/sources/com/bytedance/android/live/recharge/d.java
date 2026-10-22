package com.bytedance.android.live.recharge;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ CustomRechargeDialogFragment a;

    public d(CustomRechargeDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        CustomRechargeDialogFragment r0 = this.a;
        int r1 = CustomRechargeDialogFragment.G;
        r0.W90((List) r3);
    }
}
