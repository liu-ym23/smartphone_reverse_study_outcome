package e7;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;
import e7.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c0<P extends y0, R extends JsonObject> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public c0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
