package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveAnchorContractAVRecordResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ha;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class i2<P extends ha, R extends LiveAnchorContractAVRecordResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public i2() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
