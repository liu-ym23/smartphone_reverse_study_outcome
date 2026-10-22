package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.BaseAnchorShelfDisplayViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ BaseAnchorShelfDisplayDialog a;

    public h(BaseAnchorShelfDisplayDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        BaseAnchorShelfDisplayDialog r4 = this.a;
        int r0 = BaseAnchorShelfDisplayDialog.n;
        BaseAnchorShelfDisplayViewModel r5 = r4.W90();
        Bundle r1 = this.a.getArguments();
        if (r1 == null) goto L6;
        String r2 = r1.getString("click_source");
        if (r2 == null) goto L6;
    L7:
        r5.openShelfManagementPage(r2);
        this.a.ea0();
        return;
    L6:
        r2 = "";
        goto L7
    }
}
