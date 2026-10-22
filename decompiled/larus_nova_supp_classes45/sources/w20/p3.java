package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateConcertStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.jb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class p3<P extends jb, R extends LiveUpdateConcertStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public p3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
