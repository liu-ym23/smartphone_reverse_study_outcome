package o62;

import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.values().length];
        a = r0;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r1 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.SILENT;
        r0[r1.ordinal()] = 1;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r2 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.LEVEL_1;
        r0[r2.ordinal()] = 2;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r4 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.LEVEL_2;
        r0[r4.ordinal()] = 3;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r6 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.LEVEL_3;
        r0[r6.ordinal()] = 4;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r8 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.LEVEL_4;
        r0[r8.ordinal()] = 5;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r10 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.LEVEL_5;
        r0[r10.ordinal()] = 6;
        int[] r3 = new int[IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
        r3[r10.ordinal()] = 6;
        int[] r5 = new int[ChannelLinkUserInfo.ChannelUserRole.values().length];
        c = r5;
        r5[ChannelLinkUserInfo.ChannelUserRole.LinkApplicant.ordinal()] = 1;
        r5[ChannelLinkUserInfo.ChannelUserRole.LinkInvitee.ordinal()] = 2;
    }
}
