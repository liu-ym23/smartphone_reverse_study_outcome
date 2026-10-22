package w20;

import com.bytedance.android.live.browser.jsbridge.base.CloseLiveHistoryPageResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.g8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class y<P extends g8, R extends CloseLiveHistoryPageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final String a;

    public final void onTerminate() {
    }

    public y() {
        this.a = "closeLiveHistoryPage";
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
