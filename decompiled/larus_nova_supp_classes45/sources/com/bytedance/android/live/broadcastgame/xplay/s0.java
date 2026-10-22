package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ XplayPanelService.g a;

    public s0(XplayPanelService.g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.l.onNext(1);
    }
}
