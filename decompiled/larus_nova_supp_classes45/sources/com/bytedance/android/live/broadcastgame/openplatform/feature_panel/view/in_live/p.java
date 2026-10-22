package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public p(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        UtilityKotlinExtentionsKt.v(this.a.T90(2131371747), false);
        AbsOpenFeaturePanelViewModel r3 = this.a.o;
        if (r3 == null) goto L8;
        a20.i r4 = r3.getFeatureListHandler();
        if (r4 == null) goto L9;
        r4.d();
        return;
    L9:
        return;
    }
}
