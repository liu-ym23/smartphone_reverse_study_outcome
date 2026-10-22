package com.bytedance.android.live.fifa.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/fifa/core/IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState", "", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState;", "CLOSE", "OPEN", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState extends Enum<IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState> {
    public static final IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState CLOSE = null;
    public static final IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState OPEN = null;
    public static final /* synthetic */ IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState[] a = null;

    static {
        IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState r1 = new IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState("CLOSE", 0);
        CLOSE = r1;
        IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState r2 = new IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState("OPEN", 1);
        OPEN = r2;
        a = new IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState[]{r1, r2};
    }

    public static IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState valueOf(String r1) {
        return (IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState) a.a(IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState.class, r1);
    }

    public static IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState[] values() {
        return (IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState[]) a.clone();
    }

    public IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState(String r1, int r2) {
        super(r1, r2);
    }
}
