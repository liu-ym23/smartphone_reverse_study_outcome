package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveGameCommonInvokeResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.pa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class p2<P extends pa, R extends LiveGameCommonInvokeResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public p2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
