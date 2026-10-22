package w20;

import com.bytedance.android.live.browser.jsbridge.base.BaseInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class j<P extends JsonObject, R extends BaseInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public j() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
