package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveRemoveStickerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ab;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class g3<P extends ab, R extends LiveRemoveStickerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public g3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
