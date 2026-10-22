package w20;

import com.bytedance.android.live.browser.jsbridge.base.RevenueHybridHiddenResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.pd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class m5<P extends pd, R extends RevenueHybridHiddenResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public m5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
