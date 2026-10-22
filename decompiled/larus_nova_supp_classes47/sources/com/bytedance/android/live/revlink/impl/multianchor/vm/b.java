package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.revenuelink.i;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    k<a> getAnchorLeave();

    j<com.bytedance.android.live.revlink.impl.control.launchcontext.b> getAudienceLaunchContext();

    m<Long> getChannelId();

    n<? extends f21.a> getConnectionContext();

    m<String> getConnectionSource();

    m<String> getConnectionSubType();

    m<Integer> getInviteType();

    m<String> getInviteeList();

    n<p0> getLaunchBattleAttachInfo();

    m<String> getLinkerId();

    m<Integer> getMatchType();

    n<b7> getMultiChannelInfo();

    p21.c getMultiLinkLogger();

    m<i> getUnloadSource();
}
