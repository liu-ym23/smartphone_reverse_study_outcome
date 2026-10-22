package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveShortTouchFeatureUpdateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.gb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class l3<P extends gb, R extends LiveShortTouchFeatureUpdateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public l3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
