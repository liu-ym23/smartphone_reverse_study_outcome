package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ ShelfManagementCardListAdapterV2.ShelfManagementCardItemViewHolder a;
    public final /* synthetic */ int b;

    public i(ShelfManagementCardListAdapterV2.ShelfManagementCardItemViewHolder r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.b.isChecked() == false) goto L7;
        ShelfManagementCardListAdapterV2.d r3 = this.a.n.b;
        if (r3 == null) goto L11;
        r3.a(this.b);
        return;
    L11:
        return;
    L7:
        ShelfManagementCardListAdapterV2.d r4 = this.a.n.b;
        if (r4 == null) goto L13;
        r4.b(this.b);
        return;
    }
}
