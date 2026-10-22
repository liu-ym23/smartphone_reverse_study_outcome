package w20;

import com.bytedance.android.live.browser.jsbridge.base.UploadTraceMonitorResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.nf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c7<P extends nf, R extends UploadTraceMonitorResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public c7() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
