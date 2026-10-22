package w20;

import com.bytedance.android.live.browser.jsbridge.base.SetAdminPermissionResultResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.le;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e6<P extends le, R extends SetAdminPermissionResultResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public e6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
