package w20;

import com.bytedance.android.live.browser.jsbridge.base.GamePreloadImageResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.c9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class w0<P extends c9, R extends GamePreloadImageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public w0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
