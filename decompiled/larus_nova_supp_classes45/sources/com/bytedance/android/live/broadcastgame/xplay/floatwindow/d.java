package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.view.View;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ XplayFloatWindowView.ViewHolder a;

    public d(XplayFloatWindowView.ViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = XplayLog.a;
        XplayLog.a("XplayFloatWindowView", "click to (un)fold, animate=" + this.a.p);
        XplayFloatWindowView.ViewHolder r5 = this.a;
        if (r5.p == false) goto L5;
        return;
    L5:
        XplayFloatWindowView.ViewState r6 = r5.a;
        if (r6 == null) goto L14;
        int r7 = e.a[r6.ordinal()];
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L14;
        this.a.c(XplayFloatWindowView.ViewState.InteractiveExpanded);
        goto L14
    L13:
        this.a.c(XplayFloatWindowView.ViewState.InteractiveCollapsed);
    L14:
        XplayFloatWindowView.S5(this.a.u, 2);
    }
}
