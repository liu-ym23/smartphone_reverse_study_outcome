package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetStrategyFactorResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.s9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class u1<P extends s9, R extends GetStrategyFactorResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public u1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
