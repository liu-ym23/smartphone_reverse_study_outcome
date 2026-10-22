package com.bytedance.android.live.recharge.widget;

import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ RechargeNoPasswordWidget a;

    public m(RechargeNoPasswordWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(((Widget) this.a).context, (String) com.bytedance.android.live.recharge.utils.j.h.getValue(null, com.bytedance.android.live.recharge.utils.j.a[6]));
    }
}
