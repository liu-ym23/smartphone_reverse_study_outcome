package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveCreateQuestionContainerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.oa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n2<P extends oa, R extends LiveCreateQuestionContainerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public n2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
