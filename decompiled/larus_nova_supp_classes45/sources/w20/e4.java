package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenAnchorShowAddDialogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.dc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e4<P extends dc, R extends OpenAnchorShowAddDialogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public e4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
