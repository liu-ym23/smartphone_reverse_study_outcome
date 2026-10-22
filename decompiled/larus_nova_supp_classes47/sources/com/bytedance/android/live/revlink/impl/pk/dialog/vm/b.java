package com.bytedance.android.live.revlink.impl.pk.dialog.vm;

import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final int a(IPkSubTabKey r2) {
        if (r2 != null) goto L4;
    L5:
        if (r2 != null) goto L7;
    L9:
        if (r2 != null) goto L11;
    L13:
        IRivalRankRecommendResponse.LoadType r3 = IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals;
    L15:
        return r3.ordinal();
    L11:
        if (r2.getGroupRivalsType() != IGroupRivals.GroupType.GroupFeedFollowed.ordinal()) goto L13;
        r3 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals;
        goto L15
    L7:
        if (r2.getType() != IPkSubTabKey.TabType.CommonPanel.ordinal()) goto L9;
    L16:
        return IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal();
    L4:
        if (r2.getType() == IPkSubTabKey.TabType.FlexActivity.ordinal()) goto L16;
        goto L5
    }
}
