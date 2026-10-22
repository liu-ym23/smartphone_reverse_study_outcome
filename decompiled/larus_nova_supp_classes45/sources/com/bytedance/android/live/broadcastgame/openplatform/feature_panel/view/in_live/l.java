package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabPageAdapter;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public l(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Boolean r7 = (Boolean) r6;
        if (r7 == null) goto L11;
        r7.booleanValue();
        LiveOpenFeatureChooseListFragment r8 = this.a;
        int r0 = LiveOpenFeatureChooseListFragment.p;
        if (r8.isAdded() == false) goto L12;
        UtilityKotlinExtentionsKt.v(r8.T90(2131372184), false);
        UtilityKotlinExtentionsKt.v(r8.T90(2131372179), false);
        UtilityKotlinExtentionsKt.v(r8.T90(2131372190), false);
        r8.X90();
        OpenFeatureTabPageAdapter r1 = r8.f;
        if (r1 == null) goto L9;
        r1.f(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L9:
        r8.aa0(r8.T90(2131375171), 100, 0);
        UtilityKotlinExtentionsKt.v(r8.T90(2131371747), true);
        String r2 = i2.a;
        i2.e((HSImageView) r8.T90(2131375171), "/broadcastgame/ttlive_open_feature_empty_list.png");
        UtilityKotlinExtentionsKt.v(r8.T90(2131375171), true);
        UtilityKotlinExtentionsKt.v(r8.T90(2131391752), true);
        ((TextView) r8.T90(2131391752)).setText(s1.B(2131921028));
        UtilityKotlinExtentionsKt.v(r8.T90(2131380673), false);
        UtilityKotlinExtentionsKt.v(r8.T90(2131384465), false);
        return;
    L12:
        return;
    }
}
