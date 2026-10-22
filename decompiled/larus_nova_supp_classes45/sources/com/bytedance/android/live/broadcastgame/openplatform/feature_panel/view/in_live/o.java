package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public o(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        int r2 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.api.interactgame.n.k();
        AbsOpenFeaturePanelViewModel r3 = this.a.o;
        if (r3 == null) goto L6;
        r3.openSearchPage();
        return;
    }
}
