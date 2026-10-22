package com.bytedance.android.live.fifa.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel", "", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;", "SILENT", "LEVEL_1", "LEVEL_2", "LEVEL_3", "LEVEL_4", "LEVEL_5", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel extends Enum<IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel> {
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_1 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_2 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_3 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_4 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_5 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel SILENT = null;
    public static final /* synthetic */ IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[] a = null;

    static {
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r1 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("SILENT", 0);
        SILENT = r1;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r2 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_1", 1);
        LEVEL_1 = r2;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r3 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_2", 2);
        LEVEL_2 = r3;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r4 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_3", 3);
        LEVEL_3 = r4;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r5 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_4", 4);
        LEVEL_4 = r5;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r6 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_5", 5);
        LEVEL_5 = r6;
        a = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[]{r1, r2, r3, r4, r5, r6};
    }

    public static IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel valueOf(String r1) {
        return (IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel) a.a(IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.class, r1);
    }

    public static IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[] values() {
        return (IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[]) a.clone();
    }

    public IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel(String r1, int r2) {
        super(r1, r2);
    }
}
