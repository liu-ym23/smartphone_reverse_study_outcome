package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.platform.model.DiamondExtraListResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ a0 a;

    public f0(a0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        DiamondExtraListResult r4 = (DiamondExtraListResult) r3;
        if (r4 == null) goto L5;
        this.a.I.onNext(r4);
        return;
    L5:
        int r5 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "diamond extra empty.", null);
    }
}
