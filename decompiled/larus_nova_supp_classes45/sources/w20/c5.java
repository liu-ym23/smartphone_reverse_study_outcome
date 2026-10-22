package w20;

import com.bytedance.android.live.browser.jsbridge.base.RedEnvelopeUpdateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.dd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c5<P extends dd, R extends RedEnvelopeUpdateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public c5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
