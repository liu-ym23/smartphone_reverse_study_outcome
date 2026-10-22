package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveTaskOperationResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ib;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n3<P extends ib, R extends LiveTaskOperationResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public n3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
