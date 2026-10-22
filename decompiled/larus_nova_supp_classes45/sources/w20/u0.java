package w20;

import com.bytedance.android.live.browser.jsbridge.base.GameGetToolbarDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.a9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class u0<P extends a9, R extends GameGetToolbarDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public u0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
