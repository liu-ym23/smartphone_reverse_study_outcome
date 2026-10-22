package w20;

import com.bytedance.android.live.browser.jsbridge.base.StartPrivateVIPLiveResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.cf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class s6<P extends cf, R extends StartPrivateVIPLiveResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public s6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
