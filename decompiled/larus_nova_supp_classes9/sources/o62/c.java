package o62;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;
import com.bytedance.bdlocation.BuildConfig;
import jc1.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(int r1, IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r2) {
        Intrinsics.checkNotNullParameter(r2, "volumeLevel");
        if (r1 == 0) goto L7;
        return 2131252872;
    L7:
        switch(b.a[r2.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L9;
        };
    L10:
        return 2131252878;
    L11:
        return 2131252877;
    L12:
        return 2131252876;
    L13:
        return 2131252875;
    L14:
        return 2131252874;
    L15:
        return 2131252873;
    L9:
        throw new NoWhenBranchMatchedException();
    }

    public static String b(int r2, IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r3) {
        Intrinsics.checkNotNullParameter(r3, "volumeLevel");
        if (r2 != 0) goto L5;
        int r4 = r3.ordinal();
        if (r4 == IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.SILENT.ordinal()) goto L16;
        int r5 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.LEVEL_1.ordinal();
        int r1 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.LEVEL_5.ordinal();
        if (r5 > r4) goto L14;
        if (r1 < r4) goto L14;
        return s1.B(2131915720) + s1.B(2131915726);
    L14:
        return BuildConfig.FLAVOR;
    L16:
        return s1.B(2131915720) + s1.B(2131915723);
    L5:
        return s1.B(2131915720) + s1.B(2131915719);
    }

    public static String c(ChannelLinkUserInfo r5, s22.a r6) {
        Intrinsics.checkNotNullParameter(r5, "userInfo");
        Intrinsics.checkNotNullParameter(r6, "chatChannel");
        String r0 = r5.a.getNickName();
        ChannelLinkUserInfo.ChannelUserRole r1 = r5.b.a;
        ChannelLinkUserInfo.ChannelUserRole r2 = ChannelLinkUserInfo.ChannelUserRole.Manager;
        String r3 = BuildConfig.FLAVOR;
        if (r1 != r2) goto L5;
        String r4 = s1.B(2131915721);
    L7:
        if ((!Intrinsics.areEqual(r5.a.getIdStr(), k.n(IUserService.class).user().n())) == false) goto L19;
        if (((Boolean) r6.v().a).booleanValue() == false) goto L19;
        int r7 = b.c[r5.b.a.ordinal()];
        if (r7 != 1) goto L13;
        String r8 = s1.B(2131922260);
    L17:
        r3 = r8;
        goto L19
    L13:
        if (r7 != 2) goto L19;
        r8 = s1.B(2131922262);
    L19:
        return r0 + ", " + r4 + ", " + r3;
    L5:
        r4 = BuildConfig.FLAVOR;
        goto L7
    }
}
