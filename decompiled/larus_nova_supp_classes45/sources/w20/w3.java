package w20;

import com.bytedance.android.live.browser.jsbridge.base.LoadShortTouchResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class w3<P extends JsonObject, R extends LoadShortTouchResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public w3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PUBLIC;
    }
}
