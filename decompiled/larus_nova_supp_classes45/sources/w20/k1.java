package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetLatestWRDSDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.n9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k1<P extends n9, R extends GetLatestWRDSDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public k1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
