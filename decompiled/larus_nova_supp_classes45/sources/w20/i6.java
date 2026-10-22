package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShareImageUrlToPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.qe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class i6<P extends qe, R extends ShareImageUrlToPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public i6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
