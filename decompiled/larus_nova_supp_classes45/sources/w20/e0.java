package w20;

import com.bytedance.android.live.browser.jsbridge.base.CommunityLiveAppointmentStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.k8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e0<P extends k8, R extends CommunityLiveAppointmentStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public e0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
