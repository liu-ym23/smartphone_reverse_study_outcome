package w20;

import com.bytedance.android.live.browser.jsbridge.base.DownloadGiftAssetResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.t8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n0<P extends t8, R extends DownloadGiftAssetResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public n0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
