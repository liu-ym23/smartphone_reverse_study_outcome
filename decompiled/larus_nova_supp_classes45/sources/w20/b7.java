package w20;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLivePanelEffectResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.mf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b7<P extends mf, R extends UpdateLivePanelEffectResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public b7() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
