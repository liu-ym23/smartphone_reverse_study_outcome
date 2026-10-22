package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveOperateInteractPluginResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ya;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e3<P extends ya, R extends LiveOperateInteractPluginResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public e3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
