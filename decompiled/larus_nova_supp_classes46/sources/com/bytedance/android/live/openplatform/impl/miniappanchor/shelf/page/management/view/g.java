package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder a;
    public final /* synthetic */ ShelfCardInfo b;

    public g(ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder r1, ShelfCardInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ShelfManagementCardListAdapter.a r3 = this.a.l.a;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }
}
