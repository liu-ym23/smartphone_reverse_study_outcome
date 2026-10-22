package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public i(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        List r5 = (List) r4;
        if (r5 == null) goto L12;
        LiveOpenFeatureChooseListFragment r0 = this.a;
        int r1 = LiveOpenFeatureChooseListFragment.p;
        if (r0.isAdded() == false) goto L13;
        UtilityKotlinExtentionsKt.v(r0.T90(2131372184), true);
        MultiTypeAdapter r2 = r0.i;
        if (r2 == null) goto L9;
        r2.a = r5;
    L9:
        if (r2 == null) goto L14;
        r2.notifyDataSetChanged();
        return;
    L14:
        return;
    L13:
        return;
    }
}
