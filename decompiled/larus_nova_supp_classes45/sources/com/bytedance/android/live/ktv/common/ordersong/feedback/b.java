package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ KtvFeedbackDialog a;

    public b(KtvFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ((TextView) this.a.X90(2131390610)).setVisibility(4);
        ((LinearLayout) this.a.X90(2131372277)).setVisibility(0);
    }
}
