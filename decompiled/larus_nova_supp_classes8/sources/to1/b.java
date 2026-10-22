package to1;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ActivityTopBannerViewIntent.LifeCycle.values().length];
        a = r0;
        r0[ActivityTopBannerViewIntent.LifeCycle.ON_PAUSE.ordinal()] = 1;
        r0[ActivityTopBannerViewIntent.LifeCycle.ON_RESUME.ordinal()] = 2;
        int[] r1 = new int[IBaseUser.Status.values().length];
        b = r1;
        r1[IBaseUser.Status.Login.ordinal()] = 1;
        r1[IBaseUser.Status.Logout.ordinal()] = 2;
        r1[IBaseUser.Status.Update.ordinal()] = 3;
    }
}
