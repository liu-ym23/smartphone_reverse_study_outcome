package w20;

import com.bytedance.android.live.browser.jsbridge.base.StartInteractItemResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.bf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class r6<P extends bf, R extends StartInteractItemResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public r6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
