package w20;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfLoadResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.g9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a1<P extends g9, R extends GcpLoadPerfLoadResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
