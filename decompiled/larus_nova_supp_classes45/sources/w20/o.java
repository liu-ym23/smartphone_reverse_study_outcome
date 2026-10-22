package w20;

import com.bytedance.android.live.browser.jsbridge.base.ChangePpeEnvResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.x7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class o<P extends x7, R extends ChangePpeEnvResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public o() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
