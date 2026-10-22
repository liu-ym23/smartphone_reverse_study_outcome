package w20;

import com.bytedance.android.live.browser.jsbridge.base.ChangeVsCameraViewResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.z7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class q<P extends z7, R extends ChangeVsCameraViewResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public q() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PUBLIC;
    }
}
