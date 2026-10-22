package com.bytedance.android.live.recharge.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ RechargeNoPasswordWidget a;

    public l(RechargeNoPasswordWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        RechargeNoPasswordWidget.Fq(this.a, false);
    }
}
