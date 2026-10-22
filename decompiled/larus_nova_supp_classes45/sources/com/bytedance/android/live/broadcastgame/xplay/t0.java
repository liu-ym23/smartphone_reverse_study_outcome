package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t0 implements View.OnClickListener {
    public final /* synthetic */ XplayPanelService.g a;

    public t0(XplayPanelService.g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.l.onNext(2);
    }
}
