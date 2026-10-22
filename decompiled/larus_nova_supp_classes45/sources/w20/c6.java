package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendQuickInteractResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ie;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c6<P extends ie, R extends SendQuickInteractResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public c6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
