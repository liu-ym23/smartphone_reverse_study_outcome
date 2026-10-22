package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendJoinMatrixInvitationResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.fe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class z5<P extends fe, R extends SendJoinMatrixInvitationResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public z5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
