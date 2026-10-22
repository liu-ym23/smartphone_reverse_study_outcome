package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenRechargeDialogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.sc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class t4<P extends sc, R extends OpenRechargeDialogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public t4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
