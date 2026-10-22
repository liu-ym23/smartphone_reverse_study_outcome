package w20;

import com.bytedance.android.live.browser.jsbridge.base.HideLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c2<P extends JsonObject, R extends HideLoadingResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public c2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
