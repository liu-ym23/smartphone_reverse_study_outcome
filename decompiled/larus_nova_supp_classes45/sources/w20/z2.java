package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveHighlightTranscodingResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ua;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class z2<P extends ua, R extends LiveHighlightTranscodingResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public z2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
