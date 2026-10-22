package e7;

import com.bytedance.android.annie.bridge.method.abs.ShowLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b0<P extends x0, R extends ShowLoadingResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    private final String methodName;

    public void onTerminate() {
    }

    public b0() {
        this.methodName = "showLoading";
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
