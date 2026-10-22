package w20;

import com.bytedance.android.live.browser.jsbridge.base.LynxReportResponseResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.rb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class x3<P extends rb, R extends LynxReportResponseResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public x3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
