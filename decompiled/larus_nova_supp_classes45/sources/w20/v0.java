package w20;

import com.bytedance.android.live.browser.jsbridge.base.GameGetUserProfileResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.b9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class v0<P extends b9, R extends GameGetUserProfileResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public v0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
