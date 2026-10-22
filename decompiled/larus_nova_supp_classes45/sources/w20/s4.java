package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenPlayModePanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.rc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class s4<P extends rc, R extends OpenPlayModePanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public s4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
