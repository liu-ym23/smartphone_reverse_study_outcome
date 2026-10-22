package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ OPMoreDialogAdapter a;
    public final /* synthetic */ i b;

    public h(OPMoreDialogAdapter r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        i r0 = this.b;
        r0.d.a(this.a.a, r4, r0);
    }
}
