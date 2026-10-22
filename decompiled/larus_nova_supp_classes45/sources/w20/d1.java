package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetAssetsPathResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.k9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class d1<P extends k9, R extends GetAssetsPathResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public d1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
