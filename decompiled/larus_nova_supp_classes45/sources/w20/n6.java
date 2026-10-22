package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShowAnchorColumnPosterDialogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ve;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n6<P extends ve, R extends ShowAnchorColumnPosterDialogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public n6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
