package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenFansGroupSettingDirectResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class j4<P extends ic, R extends OpenFansGroupSettingDirectResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public j4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
