package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShareViewToPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class m6<P extends ue, R extends ShareViewToPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public m6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
