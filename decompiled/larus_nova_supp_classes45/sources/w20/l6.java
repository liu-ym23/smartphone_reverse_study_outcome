package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShareTicketResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.te;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class l6<P extends te, R extends ShareTicketResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public l6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
