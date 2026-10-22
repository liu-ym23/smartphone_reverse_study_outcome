package w20;

import com.bytedance.android.live.browser.jsbridge.base.CheckWidgetInstallationResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.d8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class t<P extends d8, R extends CheckWidgetInstallationResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public t() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
