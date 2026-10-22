package w20;

import com.bytedance.android.live.browser.jsbridge.base.UserInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.rf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e7<P extends rf, R extends UserInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public e7() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
