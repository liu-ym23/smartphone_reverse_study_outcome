package xc2;

import com.bytedance.android.livesdk.jsbridge.methods.account.LiveCanSwitchAccountResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.web.jsbridge2.f;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<P extends JsonObject, R extends LiveCanSwitchAccountResultModel> extends f<P, R> {
    public final void onTerminate() {
    }

    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
