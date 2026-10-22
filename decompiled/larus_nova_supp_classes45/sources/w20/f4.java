package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenChooseGuestPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class f4<P extends ec, R extends OpenChooseGuestPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public f4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
