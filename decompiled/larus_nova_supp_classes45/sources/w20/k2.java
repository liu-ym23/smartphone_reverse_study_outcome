package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveCEPEventUpdateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.la;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k2<P extends la, R extends LiveCEPEventUpdateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public k2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
