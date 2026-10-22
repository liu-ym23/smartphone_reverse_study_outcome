package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ LinkInviteListWidget a;

    public n(LinkInviteListWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LinkInviteListWidget r3 = this.a;
        int r0 = LinkInviteListWidget.R;
        yf0.c r1 = (yf0.c) r3.b;
        if (r3.n == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r1.d(r4);
        return;
    L5:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.I() == true) goto L8;
        r4 = false;
        goto L9
    }
}
