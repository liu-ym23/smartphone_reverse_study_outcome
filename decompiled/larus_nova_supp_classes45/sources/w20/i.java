package w20;

import com.bytedance.android.live.browser.jsbridge.base.AppInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class i<P extends JSONObject, R extends AppInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public i() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
