package w20;

import com.bytedance.android.live.browser.jsbridge.base.TogetherSlotMethodResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ff;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class w6<P extends ff, R extends TogetherSlotMethodResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public w6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
