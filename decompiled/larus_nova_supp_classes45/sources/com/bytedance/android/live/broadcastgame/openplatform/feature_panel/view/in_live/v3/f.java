package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;

    public f(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L5;
        LiveOpenFeatureChooseListFragmentV3 r3 = this.a;
        int r0 = LiveOpenFeatureChooseListFragmentV3.F;
        r3.aa0(true);
        return;
    L5:
        LiveOpenFeatureChooseListFragmentV3 r4 = this.a;
        int r1 = LiveOpenFeatureChooseListFragmentV3.F;
        r4.aa0(false);
    }
}
