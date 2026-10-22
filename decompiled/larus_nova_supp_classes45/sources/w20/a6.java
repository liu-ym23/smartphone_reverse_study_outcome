package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendLiveMicroAppLogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a6<P extends ge, R extends SendLiveMicroAppLogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
