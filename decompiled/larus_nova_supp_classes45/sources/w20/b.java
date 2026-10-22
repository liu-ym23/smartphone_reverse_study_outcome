package w20;

import com.bytedance.android.live.browser.jsbridge.base.AdLiveUpdateFeedResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.h7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b<P extends h7, R extends AdLiveUpdateFeedResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public b() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
