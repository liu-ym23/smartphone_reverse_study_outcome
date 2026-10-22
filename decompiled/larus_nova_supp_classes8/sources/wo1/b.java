package wo1;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;
import wo1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class b<P extends j, R extends JsonObject> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public b() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
