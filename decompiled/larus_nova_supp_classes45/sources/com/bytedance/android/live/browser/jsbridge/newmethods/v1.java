package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isInstalledApp")
public final class v1 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public v1() {
    }

    public final Object invoke(Object r3, CallContext r4) throws Exception {
        String r5 = ((JSONObject) r3).optString("schema", "");
        PackageManager r6 = r4.getContext().getPackageManager();     // Catch: Exception -> L8
        Intent r0 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L8
        r0.setData(UriProtector.parse(r5));     // Catch: Exception -> L8
        List<ResolveInfo> r7 = r6.queryIntentActivities(r0, 64);     // Catch: Exception -> L8
        if (r7 == null) goto L10;
        if (r7.size() <= 0) goto L10;
        int r8 = 1;
    L11:
        JSONObject r9 = new JSONObject();
        r9.put("isInstalled", r8);
        return r9;
    L10:
        r8 = 0;
    L8:
        e = move-exception;
        Logger.d("CheckAppInstalledMethod", "exception:" + e.toString());
        goto L10
    }
}
