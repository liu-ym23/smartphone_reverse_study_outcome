package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder a;
    public final /* synthetic */ ShelfCardInfo b;

    public h(ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder r1, ShelfCardInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ShelfManagementCardListAdapter.OnItemClickListener r4 = this.a.l.d;
        if (r4 == null) goto L6;
        r4.a(this.b, ShelfManagementCardListAdapter.OnItemClickListener.ClickPosition.REVIEW_REJECTED);
        return;
    }
}
