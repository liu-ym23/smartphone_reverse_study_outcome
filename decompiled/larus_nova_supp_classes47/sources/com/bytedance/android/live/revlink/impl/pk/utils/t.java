package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t {
    public static final String b(IRivalRankRecommendResponse r3) {
        if (r3 == null) goto L11;
        s2 r0 = r3.getTabRivals();
        if (r0 == null) goto L11;
        Map r1 = r0.getGroupRivals();
        if (r1 == null) goto L11;
        IGroupRivals r2 = (IGroupRivals) r1.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r2 == null) goto L11;
        String r4 = r2.getImprId();
        if (r4 == null) goto L11;
        return r4;
    L11:
        if (r3 == null) goto L19;
        s2 r5 = r3.getTabRivals();
        if (r5 == null) goto L19;
        Map r6 = r5.getGroupRivals();
        if (r6 == null) goto L19;
        IGroupRivals r7 = (IGroupRivals) r6.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()));
        if (r7 == null) goto L19;
        return r7.getImprId();
    L19:
        return null;
    }

    public static final int c(IRivalRankRecommendResponse r2) {
        if (r2 == null) goto L12;
        s2 r3 = r2.getTabRivals();
        if (r3 == null) goto L12;
        Map r4 = r3.getGroupRivals();
        if (r4 == null) goto L12;
        IGroupRivals r5 = (IGroupRivals) r4.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r5 == null) goto L12;
        List r6 = r5.getRivals();
        if (r6 == null) goto L12;
        return r6.size();
    L12:
        return 0;
    }

    public static final void a(mz0.n r4, com.bytedance.android.live.revlink.impl.global.c r5, int r6, int r7, String r8, String r9) {
        mz0.o r0 = new mz0.o(r4.a);
        Long r1 = null;
        if (r5 == null) goto L7;
        LinkCrossRoomDataHolder r2 = r5.getLinkCrossRoomDataHolder();
        if (r2 == null) goto L7;
        Long r3 = Long.valueOf(r2.c());
    L8:
        r0.a("channel_id", String.valueOf(r3));
        if (r5 == null) goto L13;
        w31.c r10 = r5.getPkLinkUtils();
        if (r10 == null) goto L13;
        r1 = Long.valueOf(r10.i());
    L13:
        r0.a("pk_id", String.valueOf(r1));
        r0.a("request_id", r8);
        r0.a("tab_type", r9);
        r0.a("friends_cnt", String.valueOf(r6));
        r0.a("total_friends_num", String.valueOf(r7));
        mz0.m r12 = new mz0.m();
        r12.b(LogCommon.ROOM);
        ((ArrayList) r4.b).addAll(r12.a);
        return;
    L7:
        r3 = null;
        goto L8
    }
}
