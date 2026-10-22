package pw0;

import com.bytedance.android.live.recharge.jsbridge.LiveCloseRechargeBannerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import pw0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a<P extends c, R extends LiveCloseRechargeBannerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
