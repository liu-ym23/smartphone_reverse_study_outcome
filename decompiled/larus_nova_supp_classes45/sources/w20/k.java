package w20;

import com.bytedance.android.live.browser.jsbridge.base.CanIUseResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.s7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k<P extends s7, R extends CanIUseResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public k() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
