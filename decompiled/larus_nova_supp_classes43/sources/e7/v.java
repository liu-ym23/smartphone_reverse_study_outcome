package e7;

import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class v<P extends s0, R extends RequestResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public v() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
