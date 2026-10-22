package e7;

import com.bytedance.android.annie.bridge.method.abs.PrerenderParamModel;
import com.bytedance.android.annie.bridge.method.abs.PrerenderResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class r<P extends PrerenderParamModel, R extends PrerenderResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public r() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
