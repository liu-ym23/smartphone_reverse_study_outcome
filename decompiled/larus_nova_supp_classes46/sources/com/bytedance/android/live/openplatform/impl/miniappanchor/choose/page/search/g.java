package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ MiniAppChooseSearchFragment a;

    public g(MiniAppChooseSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        MiniAppChooseSearchViewModel r2 = this.a.f;
        if (r2 == null) goto L6;
        r2.deleteAllHistory();
        return;
    }
}
