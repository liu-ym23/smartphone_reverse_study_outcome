package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.text.Spannable;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ GiftMVIDetailView a;
    public final /* synthetic */ Spannable b;

    public i(GiftMVIDetailView r1, Spannable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        GiftMVIDetailView.u(this.a, 0);
        this.a.z("click", this.b);
        yo2.e r4 = this.a.u;
        if (r4 == null) goto L6;
        r4.d();
        return;
    }
}
