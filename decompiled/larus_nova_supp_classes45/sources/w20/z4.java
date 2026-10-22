package w20;

import com.bytedance.android.live.browser.jsbridge.base.PlayAlphaVideoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ad;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class z4<P extends ad, R extends PlayAlphaVideoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public z4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
