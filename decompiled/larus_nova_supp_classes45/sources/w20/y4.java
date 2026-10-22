package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;
import w20.zc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class y4<P extends JsonObject, R extends zc> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public y4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
