package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public j(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L5;
        LiveOpenFeatureChooseListFragment r3 = this.a;
        int r0 = LiveOpenFeatureChooseListFragment.p;
        r3.Y90(true);
        return;
    L5:
        LiveOpenFeatureChooseListFragment r4 = this.a;
        int r1 = LiveOpenFeatureChooseListFragment.p;
        r4.Y90(false);
    }
}
