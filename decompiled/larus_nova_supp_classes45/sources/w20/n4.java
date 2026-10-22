package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenMultiPosterSharePanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.mc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n4<P extends mc, R extends OpenMultiPosterSharePanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public n4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
