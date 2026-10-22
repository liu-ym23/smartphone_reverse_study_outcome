package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public g(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L8;
        LiveOpenFeatureChooseListFragment r4 = this.a;
        int r0 = LiveOpenFeatureChooseListFragment.p;
        if (r4.isAdded() == false) goto L9;
        UtilityKotlinExtentionsKt.v(r4.T90(2131371747), false);
        UtilityKotlinExtentionsKt.v(r4.T90(2131372184), false);
        r4.X90();
        return;
    L9:
        return;
    }
}
