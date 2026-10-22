package w20;

import com.bytedance.android.live.browser.jsbridge.base.SetMessageBoardDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.oe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h6<P extends oe, R extends SetMessageBoardDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public h6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
