package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Context r4 = this.a.a.getContext();
        if (r4 == null) goto L5;
        BaseAnchorShelfDisplayDialog r0 = this.a.a;
        int r1 = BaseAnchorShelfDisplayDialog.n;
        r0.W90().openCouponPage(r4);
    L5:
        BaseAnchorShelfDisplayDialog r5 = this.a.a;
        int r2 = BaseAnchorShelfDisplayDialog.n;
        r5.ea0();
    }
}
