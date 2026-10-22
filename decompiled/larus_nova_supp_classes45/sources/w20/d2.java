package w20;

import com.bytedance.android.live.browser.jsbridge.base.ImageToastResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ba;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class d2<P extends ba, R extends ImageToastResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public d2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
