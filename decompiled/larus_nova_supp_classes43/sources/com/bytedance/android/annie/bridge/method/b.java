package com.bytedance.android.annie.bridge.method;

import android.text.TextUtils;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.AppInfoResultModel;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "appInfo")
public final class b extends e7.a<JSONObject, AppInfoResultModel> {
    public b() {
    }

    public final void invoke(Object r10, CallContext r11) throws Exception {
        JSONObject r12 = (JSONObject) r10;
        AppInfoResultModel r13 = new AppInfoResultModel();
        com.bytedance.android.annie.ng.g.b.getClass();
        r13.a(String.valueOf(com.bytedance.android.annie.ng.e.a.a));
        r13.d(String.valueOf(AnnieXMonitorConstants.a()));
        String r0 = r11.getContext().getPackageManager().getPackageInfo(r11.getContext().getPackageName(), 0).versionName;     // Catch: Exception -> L5
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L9;
        com.bytedance.android.annie.ng.g.b.getClass();
        r0 = com.bytedance.android.annie.ng.e.a.c;
    L9:
        r13.b(r0);
        com.bytedance.android.annie.ng.g.b.getClass();
        r13.h(com.bytedance.android.annie.ng.e.a.c);
        r13.i(r0);
        String r1 = ((i9.d) Annie.getService(i9.d.class)).k0();
        if (r1 == null) goto L12;
        r13.j(r1);
    L12:
        r13.c(AppInfoResultModel.Code.Success);
        r13.e(NetworkUtils.getNetworkAccessType(r11.getContext().getApplicationContext()));
        com.bytedance.android.annie.util.p r14 = com.bytedance.android.annie.util.p.a;
        r13.f(Integer.valueOf(r14.d()));
        r13.g(Integer.valueOf(r14.e()));
        finishWithResult(r13);
        return;
    L5:
        r0 = "";
        goto L7
    }
}
