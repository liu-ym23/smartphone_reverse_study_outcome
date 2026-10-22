package com.bytedance.android.livesdk.commerce;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LiveGoodsDialogFragment.f a;
    public final /* synthetic */ e b;

    public g(LiveGoodsDialogFragment.f r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a.removeBanner(this.b);
    }
}
