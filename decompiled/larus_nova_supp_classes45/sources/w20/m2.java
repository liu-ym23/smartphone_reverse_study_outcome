package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveCloudCollaborateActionResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.na;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class m2<P extends na, R extends LiveCloudCollaborateActionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public m2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
