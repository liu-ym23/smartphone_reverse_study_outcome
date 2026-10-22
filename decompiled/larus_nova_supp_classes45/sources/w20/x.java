package w20;

import com.bytedance.android.live.browser.jsbridge.base.CloseGiftWebViewResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.f8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class x<P extends f8, R extends CloseGiftWebViewResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public x() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
