package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetLiveNtpTimeResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class n1<P extends JsonObject, R extends GetLiveNtpTimeResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public n1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
