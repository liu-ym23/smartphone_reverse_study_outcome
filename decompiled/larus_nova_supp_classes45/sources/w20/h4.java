package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenEmojiPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.gc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h4<P extends gc, R extends OpenEmojiPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public h4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
