package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendInteractEffectEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ee;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class y5<P extends ee, R extends SendInteractEffectEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public y5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
