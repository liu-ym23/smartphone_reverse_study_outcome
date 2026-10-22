package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShareItemResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.re;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class j6<P extends re, R extends ShareItemResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public j6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
