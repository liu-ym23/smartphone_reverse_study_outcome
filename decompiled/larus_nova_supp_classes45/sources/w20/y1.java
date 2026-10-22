package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetVisualEventTrackingSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class y1<P extends JsonObject, R extends GetVisualEventTrackingSettingsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public y1() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
