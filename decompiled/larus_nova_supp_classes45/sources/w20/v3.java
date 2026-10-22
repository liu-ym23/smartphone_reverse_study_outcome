package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveVirtualLiveUpdateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.qb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class v3<P extends qb, R extends LiveVirtualLiveUpdateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public v3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
