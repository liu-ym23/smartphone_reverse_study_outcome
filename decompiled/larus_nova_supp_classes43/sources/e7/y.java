package e7;

import com.bytedance.android.annie.bridge.method.abs.ScanCodeResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class y<P extends u0, R extends ScanCodeResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public y() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
