package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.se;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k6<P extends se, R extends ShareLiveResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public k6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
