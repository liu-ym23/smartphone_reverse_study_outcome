package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureSearchFragment a;

    public q(LiveOpenFeatureSearchFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        LiveOpenFeatureSearchFragment r0 = this.a;
        LiveOpenFeatureSearchFragment.T90(r0, (List) r2);
    }
}
