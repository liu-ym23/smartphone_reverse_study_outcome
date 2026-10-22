package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetPersonCardInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.q9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class q1<P extends q9, R extends GetPersonCardInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public q1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
