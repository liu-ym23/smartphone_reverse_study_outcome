package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 a;

    public n(LiveOpenFeatureSearchFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        LiveOpenFeatureSearchFragmentV3 r0 = this.a;
        LiveOpenFeatureSearchFragmentV3.S90(r0, (List) r2);
    }
}
