package w20;

import com.bytedance.android.live.browser.jsbridge.base.AlertCheckDialogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.l7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class g<P extends l7, R extends AlertCheckDialogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public g() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
