package e7;

import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsParamModel;
import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class o<P extends OpenPermissionSettingsParamModel, R extends OpenPermissionSettingsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public o() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
