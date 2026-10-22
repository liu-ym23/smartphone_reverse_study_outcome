package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetGiftDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.m9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class i1<P extends m9, R extends GetGiftDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public i1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
