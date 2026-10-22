package w20;

import com.bytedance.android.live.browser.jsbridge.base.FormatOpenSchemaResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.v8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class q0<P extends v8, R extends FormatOpenSchemaResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public q0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
