package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabPageAdapter;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public h(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        if (Intrinsics.areEqual((Boolean) r7, Boolean.TRUE) == false) goto L11;
        LiveOpenFeatureChooseListFragment r8 = this.a;
        int r0 = LiveOpenFeatureChooseListFragment.p;
        if (r8.isAdded() == false) goto L12;
        UtilityKotlinExtentionsKt.v(r8.T90(2131372179), false);
        UtilityKotlinExtentionsKt.v(r8.T90(2131372190), false);
        UtilityKotlinExtentionsKt.v(r8.T90(2131372184), true);
        OpenFeatureTabPageAdapter r1 = r8.f;
        if (r1 == null) goto L9;
        r1.f(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L9:
        r8.aa0(r8.T90(2131391752), 60, 80);
        UtilityKotlinExtentionsKt.v(r8.T90(2131371747), true);
        UtilityKotlinExtentionsKt.v(r8.T90(2131380673), false);
        UtilityKotlinExtentionsKt.v(r8.T90(2131384465), false);
        UtilityKotlinExtentionsKt.v(r8.T90(2131391752), true);
        UtilityKotlinExtentionsKt.v(r8.T90(2131375171), false);
        ((TextView) r8.T90(2131391752)).setText(s1.B(2131921028));
        return;
    L12:
        return;
    }
}
