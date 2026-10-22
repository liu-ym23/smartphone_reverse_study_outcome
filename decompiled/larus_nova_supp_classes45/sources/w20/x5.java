package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendGiftPlayerEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.de;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class x5<P extends de, R extends SendGiftPlayerEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public x5() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
