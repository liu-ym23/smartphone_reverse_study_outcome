package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder;

import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ChannelLinkUserInfo.ChannelUserRole.values().length];
        a = r0;
        r0[ChannelLinkUserInfo.ChannelUserRole.Audience.ordinal()] = 1;
        r0[ChannelLinkUserInfo.ChannelUserRole.Guest.ordinal()] = 2;
        r0[ChannelLinkUserInfo.ChannelUserRole.LinkApplicant.ordinal()] = 3;
        r0[ChannelLinkUserInfo.ChannelUserRole.LinkInvitee.ordinal()] = 4;
        r0[ChannelLinkUserInfo.ChannelUserRole.GuestApplicant.ordinal()] = 5;
    }
}
