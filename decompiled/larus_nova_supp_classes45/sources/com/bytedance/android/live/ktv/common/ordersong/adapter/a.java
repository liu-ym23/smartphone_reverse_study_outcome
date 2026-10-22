package com.bytedance.android.live.ktv.common.ordersong.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends ka0.a {
    public final /* synthetic */ KtvLabelBannerViewBinder.VH c;

    @Override // ka0.b
    public final void a(HybridCard r1, String r2) {
    }

    @Override // ka0.b
    public final void b(HybridCard r1, View r2, int r3) {
        ViewGroup r4 = this.c.a;
        if (r4 == null) goto L5;
        r4.removeAllViews();
    L5:
        ViewGroup r5 = this.c.a;
        if (r5 == null) goto L8;
        r5.addView(r1);
    L8:
        KtvLabelBannerViewBinder.VH r6 = this.c;
        r6.d = true;
        r6.e = false;
    }

    public a(KtvLabelBannerViewBinder.VH r1, Context r2, Uri r3, int r4) {
        this.c = r1;
        super(r2, r3, r4);
    }
}
