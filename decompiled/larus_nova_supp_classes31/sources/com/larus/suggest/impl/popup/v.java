package com.larus.suggest.impl.popup;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public v() {
    }

    public static /* synthetic */ void b(String r7, String r8) {
        a("candidate_unavailable", 5, r7, r8, null, null, null);
    }

    public static void a(String r2, int r3, String r4, String r5, Boolean r6, Boolean r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "errorMsg");
        JSONObject r0 = new JSONObject();
        r0.put("error_code", r3);
        r0.put("error_msg", r2);
        r0.put("event_type", "biz_intercept_dialog");
        r0.put("activity_id", r4);
        r0.put("group_id", r5);
        r0.put("is_minor_checked", r6);
        r0.put("is_minor_showed", r7);
        r0.put("is_commerce_shown", r8);
        com.larus.platform.service.o.a.reportEvent("dev_nex_pulse_dialog_monitor", r0);
    }
}
