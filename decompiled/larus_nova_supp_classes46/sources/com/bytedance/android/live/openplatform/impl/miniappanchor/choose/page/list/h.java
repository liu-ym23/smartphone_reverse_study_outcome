package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a.T90(2131385224).setVisibility(0);
        MiniAppChooseListViewModel r3 = this.a.a.h;
        if (r3 == null) goto L6;
        r3.fetchMiniAppGroupedList();
        return;
    }
}
