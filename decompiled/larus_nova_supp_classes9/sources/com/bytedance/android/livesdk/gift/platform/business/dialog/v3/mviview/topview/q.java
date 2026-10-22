package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.text.Spannable;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ GiftMVIDetailTopView a;
    public final /* synthetic */ Spannable b;

    public q(GiftMVIDetailTopView r1, Spannable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        GiftMVIDetailTopView.u(this.a, 0);
        this.a.y("click", this.b);
        yo2.e r4 = this.a.u;
        if (r4 == null) goto L6;
        r4.d();
        return;
    }
}
