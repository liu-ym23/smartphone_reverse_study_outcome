package w20;

import com.bytedance.android.live.browser.jsbridge.base.ChangeGroupLiveContainerStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.w7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n<P extends w7, R extends ChangeGroupLiveContainerStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public n() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
