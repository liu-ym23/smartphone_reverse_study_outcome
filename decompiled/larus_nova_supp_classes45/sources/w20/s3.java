package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateNotifyGiftMessageChannelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.mb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class s3<P extends mb, R extends LiveUpdateNotifyGiftMessageChannelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public s3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
