package w20;

import com.bytedance.android.live.browser.jsbridge.base.CloseFeedbackPageResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.e8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class w<P extends e8, R extends CloseFeedbackPageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final String a;

    public final void onTerminate() {
    }

    public w() {
        this.a = "closeFeedbackPage";
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
