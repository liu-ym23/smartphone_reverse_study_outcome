package w20;

import com.bytedance.android.live.browser.jsbridge.base.NotifyClearMountDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.wb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a4<P extends wb, R extends NotifyClearMountDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
