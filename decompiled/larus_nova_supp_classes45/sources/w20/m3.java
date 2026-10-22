package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveSwitchVSMultiTabResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.hb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class m3<P extends hb, R extends LiveSwitchVSMultiTabResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public m3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
