package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;

    public c(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L14;
        LiveOpenFeatureChooseListFragmentV3 r4 = this.a;
        int r0 = LiveOpenFeatureChooseListFragmentV3.F;
        if (r4.isAdded() == false) goto L15;
        LinearLayout r1 = r4.o;
        if (r1 == null) goto L9;
        UtilityKotlinExtentionsKt.v(r1, false);
    L9:
        RecyclerView r2 = r4.q;
        if (r2 == null) goto L12;
        UtilityKotlinExtentionsKt.v(r2, false);
    L12:
        r4.Z90();
        return;
    L15:
        return;
    }
}
