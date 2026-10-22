package com.bytedance.android.livesdk.feed.squarefeed;

import com.bytedance.android.live.uikit.refresh.I18nSwipeRefreshLayout;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.feed.openui.view.HorizontalLiveListView;
import com.bytedance.android.livesdk.feed.squarefeed.vm.OpenRankViewModel;
import com.bytedance.common.utility.NetworkUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements I18nSwipeRefreshLayout.f {
    public final /* synthetic */ OpenRankFragment a;

    public k(OpenRankFragment r1) {
        this.a = r1;
    }

    public final void onRefresh() {
        OpenRankViewModel r0 = this.a.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
    L5:
        if (r0 == null) goto L7;
        r0.refresh("feed_refresh");
    L7:
        OpenRankFragment r1 = this.a;
        HorizontalLiveListView r2 = r1.g;
        if (r2 == null) goto L10;
        r1.f = true;
    L10:
        if (r2 == null) goto L13;
        r2.refresh();
    L13:
        if (NetworkUtils.isNetworkAvailable(this.a.getContext()) == true) goto L16;
        IESUIUtils.displayToast(this.a.getContext(), 2131916613);
        return;
    }
}
