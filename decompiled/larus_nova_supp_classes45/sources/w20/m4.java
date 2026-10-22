package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenLiveMicroAppResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.lc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class m4<P extends lc, R extends OpenLiveMicroAppResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public m4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
