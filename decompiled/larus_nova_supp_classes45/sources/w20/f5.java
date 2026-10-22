package w20;

import com.bytedance.android.live.browser.jsbridge.base.RegisterMessageLatchResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.gd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class f5<P extends gd, R extends RegisterMessageLatchResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public f5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
