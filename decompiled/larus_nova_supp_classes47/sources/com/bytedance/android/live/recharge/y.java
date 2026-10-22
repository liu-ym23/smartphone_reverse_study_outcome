package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ RechargeDialogFragmentV2 a;

    public y(RechargeDialogFragmentV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        RechargeDialogFragmentV2 r4 = this.a;
        int r0 = RechargeDialogFragmentV2.n;
        r4.T90();
    }
}
