package w20;

import com.bytedance.android.live.browser.jsbridge.base.CheckEffectInUsedResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.c8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class s<P extends c8, R extends CheckEffectInUsedResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public s() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
