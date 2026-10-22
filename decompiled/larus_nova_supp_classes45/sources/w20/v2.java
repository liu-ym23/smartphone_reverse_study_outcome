package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetLiveEffectInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.sa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class v2<P extends sa, R extends LiveGetLiveEffectInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public v2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
