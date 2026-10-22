package w20;

import com.bytedance.android.live.browser.jsbridge.base.RevenueRechargeCheckResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.qd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n5<P extends qd, R extends RevenueRechargeCheckResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public n5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
