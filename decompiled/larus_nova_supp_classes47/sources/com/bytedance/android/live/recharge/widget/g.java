package com.bytedance.android.live.recharge.widget;

import android.widget.ToggleButton;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ RechargeBottomWidget a;

    public g(RechargeBottomWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        ToggleButton r0 = this.a.r;
        if (r0 == null) goto L6;
        r0.setChecked(r3.booleanValue());
        return;
    }
}
