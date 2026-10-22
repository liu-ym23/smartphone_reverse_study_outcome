package w20;

import com.bytedance.android.live.browser.jsbridge.base.PaidLinkMicApplyResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class x4<P extends xc, R extends PaidLinkMicApplyResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public x4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
