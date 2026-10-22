package com.larus.account.saas.security.internal;

import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "path");
        SaasTracking r1 = SaasTracking.a;
        JSONObject r2 = new JSONObject();
        r2.put("path", r3);
        Unit r4 = Unit.INSTANCE;
        r1.reportEvent("doubao_account_network_request", r2);
    }

    public static void b(String r3, boolean r4, Integer r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "path");
        SaasTracking r1 = SaasTracking.a;
        JSONObject r2 = new JSONObject();
        r2.put("path", r3);
        r2.put("success", r4 ? 1 : 0);
        if (r5 == null) goto L5;
        r2.put("err_code", r5.intValue());
    L5:
        if (r6 == null) goto L7;
        r2.put("err_msg", r6);
    L7:
        Unit r7 = Unit.INSTANCE;
        r1.reportEvent("doubao_account_network_result", r2);
    }
}
