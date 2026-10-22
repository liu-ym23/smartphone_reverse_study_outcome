package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenMvSelectPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.oc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class p4<P extends oc, R extends OpenMvSelectPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public p4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
