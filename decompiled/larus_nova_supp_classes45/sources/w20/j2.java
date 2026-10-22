package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveAudiencePageCloseAndJumpResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ka;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class j2<P extends ka, R extends LiveAudiencePageCloseAndJumpResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public j2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
