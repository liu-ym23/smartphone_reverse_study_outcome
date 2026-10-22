package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveAddStickerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ga;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h2<P extends ga, R extends LiveAddStickerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public h2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
