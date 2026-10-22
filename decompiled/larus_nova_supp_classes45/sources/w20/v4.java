package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenVSMessageBoardInputPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.vc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class v4<P extends vc, R extends OpenVSMessageBoardInputPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public v4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
