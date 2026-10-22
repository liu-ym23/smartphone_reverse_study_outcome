package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenMultiSelectPhotoLibraryResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.nc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class o4<P extends nc, R extends OpenMultiSelectPhotoLibraryResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public o4() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
