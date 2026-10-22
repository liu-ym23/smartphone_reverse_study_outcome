package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateEffectGameStateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.kb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class q3<P extends kb, R extends LiveUpdateEffectGameStateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public q3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
