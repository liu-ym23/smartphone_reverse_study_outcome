package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;

    public l(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LinearLayout r3 = this.a.o;
        if (r3 == null) goto L5;
        UtilityKotlinExtentionsKt.v(r3, false);
    L5:
        AbsOpenFeaturePanelViewModel r4 = this.a.E;
        if (r4 == null) goto L11;
        a20.i r5 = r4.getFeatureListHandler();
        if (r5 == null) goto L12;
        r5.d();
        return;
    L12:
        return;
    }
}
