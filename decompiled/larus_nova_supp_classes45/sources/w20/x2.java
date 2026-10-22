package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetStickerInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ta;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class x2<P extends ta, R extends LiveGetStickerInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public x2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
