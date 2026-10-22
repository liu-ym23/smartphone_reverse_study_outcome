package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ MiniAppChooseSearchFragment a;

    public f(MiniAppChooseSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        lp0.a r2 = this.a.e;
        if (r2 == null) goto L8;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b r3 = r2.getContainer();
        if (r3 == null) goto L9;
        r3.Eq();
        return;
    L9:
        return;
    }
}
