package e7;

import com.bytedance.android.annie.bridge.method.abs.AppInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<P extends JSONObject, R extends AppInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
