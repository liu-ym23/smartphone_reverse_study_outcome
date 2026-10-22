package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder a;
    public final /* synthetic */ int b;

    public d(ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.a.isChecked() == false) goto L7;
        ShelfManagementCardListAdapter r5 = this.a.l;
        Boolean[] r0 = r5.g;
        int r1 = this.b;
        r0[r1] = Boolean.TRUE;
        ShelfManagementCardListAdapter.c r6 = r5.b;
        if (r6 == null) goto L11;
        r6.a(r1);
        return;
    L11:
        return;
    L7:
        ShelfManagementCardListAdapter r7 = this.a.l;
        Boolean[] r2 = r7.g;
        int r3 = this.b;
        r2[r3] = Boolean.FALSE;
        ShelfManagementCardListAdapter.c r8 = r7.b;
        if (r8 == null) goto L13;
        r8.b(r3);
        return;
    }
}
