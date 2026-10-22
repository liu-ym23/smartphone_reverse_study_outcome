package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetBatchClientSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.l9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e1<P extends l9, R extends GetBatchClientSettingsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public e1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
