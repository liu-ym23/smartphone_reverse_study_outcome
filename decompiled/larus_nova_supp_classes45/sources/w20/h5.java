package w20;

import com.bytedance.android.live.browser.jsbridge.base.RegisterWrdsResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.hd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h5<P extends hd, R extends RegisterWrdsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public h5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
