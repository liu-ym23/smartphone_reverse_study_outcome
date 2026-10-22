package com.bytedance.android.live.recharge.widget;

import android.widget.ToggleButton;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ RechargeBottomWidget a;

    public f(RechargeBottomWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        ToggleButton r0 = this.a.r;
        if (r0 != null) goto L5;
    L9:
        this.a.h.isAcceptAgreement().a(Boolean.valueOf(!r4.booleanValue()));
        return;
    L5:
        if (r4.booleanValue() == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        goto L9
    L7:
        r1 = 8;
        goto L8
    }
}
