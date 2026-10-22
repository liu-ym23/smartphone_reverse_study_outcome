package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ PkWithAudienceFeedbackDialog a;

    public x(PkWithAudienceFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        PkWithAudienceFeedbackDialog r3 = this.a;
        int r0 = PkWithAudienceFeedbackDialog.m;
        r3.initData();
    }
}
