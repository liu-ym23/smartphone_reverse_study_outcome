package e7;

import com.bytedance.android.annie.bridge.method.abs.RequestPermissionParamModel;
import com.bytedance.android.annie.bridge.method.abs.RequestPermissionResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class w<P extends RequestPermissionParamModel, R extends RequestPermissionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public w() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
