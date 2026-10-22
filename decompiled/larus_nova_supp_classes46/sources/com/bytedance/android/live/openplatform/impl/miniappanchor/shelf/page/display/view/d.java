package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ AnchorShelfDisplayItemViewHolder a;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a b;

    public d(AnchorShelfDisplayItemViewHolder r1, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.m.l50(2, this.b.getCardId());
    }
}
