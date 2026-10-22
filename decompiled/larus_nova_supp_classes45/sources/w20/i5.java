package w20;

import com.bytedance.android.live.browser.jsbridge.base.ReportLinkmicStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.id;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class i5<P extends id, R extends ReportLinkmicStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public i5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
