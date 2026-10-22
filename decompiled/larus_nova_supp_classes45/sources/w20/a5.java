package w20;

import com.bytedance.android.live.browser.jsbridge.base.PreloadReplayResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.bd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a5<P extends bd, R extends PreloadReplayResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
