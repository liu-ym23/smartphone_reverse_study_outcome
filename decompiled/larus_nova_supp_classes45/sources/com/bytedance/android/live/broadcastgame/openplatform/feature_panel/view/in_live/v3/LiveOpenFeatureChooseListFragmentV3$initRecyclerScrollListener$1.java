package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function0 b;

    public LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1(Function0 r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        if (r3 != 0) goto L6;
        this.a.invoke();
        return;
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        if (r3 != 0) goto L7;
        if (r4 != 0) goto L8;
        this.b.invoke();
        return;
    L8:
        return;
    }
}
