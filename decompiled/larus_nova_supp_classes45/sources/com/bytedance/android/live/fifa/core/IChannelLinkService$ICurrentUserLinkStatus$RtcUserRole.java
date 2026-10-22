package com.bytedance.android.live.fifa.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/android/live/fifa/core/IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole", "", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole;", "Unknown", "ChannelUser", "RtcGoneUser", "RtcVisibleUser", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole extends Enum<IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole> {
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole ChannelUser = null;
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole RtcGoneUser = null;
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole RtcVisibleUser = null;
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole Unknown = null;
    public static final /* synthetic */ IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[] a = null;

    static {
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r1 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("Unknown", 0);
        Unknown = r1;
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r2 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("ChannelUser", 1);
        ChannelUser = r2;
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r3 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("RtcGoneUser", 2);
        RtcGoneUser = r3;
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r4 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("RtcVisibleUser", 3);
        RtcVisibleUser = r4;
        a = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[]{r1, r2, r3, r4};
    }

    public static IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole valueOf(String r1) {
        return (IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole) a.a(IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole.class, r1);
    }

    public static IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[] values() {
        return (IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[]) a.clone();
    }

    public IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole(String r1, int r2) {
        super(r1, r2);
    }
}
