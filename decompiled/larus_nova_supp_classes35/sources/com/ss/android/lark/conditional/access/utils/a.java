package com.ss.android.lark.conditional.access.utils;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap a(InternalSecurityAction r4) {
        HashMap r0 = new HashMap();
        if (r4 != null) goto L5;
        return r0;
    L5:
        m8b.c r1 = com.ss.android.lark.conditional.access.network.model.response.a.b(r4.getCurrentAction());
        r0.put("action_name", r4.getCurrentAction().getName());
        r0.put("policy_type", r4.getCurrentAction().getParams().get("policyType"));
        r0.put("challenge_type", r1.a);
        r0.put("geo_challenge_type", DisplayUtilsKt.c(r4));
        FileAuthMonitor.UpdateTrigger[] r2 = FileAuthMonitor.a;
        r0.put("log_id", FileAuthMonitor.a(r4));
        return r0;
    }

    public static void b(String r9, InternalSecurityAction r10) {
        Intrinsics.checkNotNullParameter(r9, "button");
        Intrinsics.checkNotNullParameter("geo_auth", "pageType");
        HashMap r4 = a(r10);
        r4.put("button", r9);
        r4.put("page_type", "geo_auth");
        u4c.a.a("advanced_login_button_click", r4, null, null, 0, 28);
    }

    public static void d(String r7, InternalSecurityAction r8) {
        Intrinsics.checkNotNullParameter(r7, "event");
        HashMap r2 = a(r8);
        r2.put("event", r7);
        u4c.a.a("advanced_login_perm_dialog", r2, null, null, 0, 28);
    }

    public static void c(String r8, String r9, InternalSecurityAction r10) {
        Intrinsics.checkNotNullParameter(r8, "branch");
        Intrinsics.checkNotNullParameter(r9, "reason");
        HashMap r3 = a(r10);
        r3.put("branch", r8);
        r3.put("reason", r9);
        u4c.a.a("advanced_login_dispatch", r3, null, null, 0, 28);
    }

    public static void f(String r7, String r8, InternalSecurityAction r9) {
        Intrinsics.checkNotNullParameter(r7, "pageType");
        Intrinsics.checkNotNullParameter(r8, "pageEvent");
        HashMap r2 = a(r9);
        r2.put("page_type", r7);
        r2.put("page_event", r8);
        u4c.a.a("advanced_login_view", r2, null, null, 0, 28);
    }

    public static void e(String r2, boolean r3, long r4, String r6, long r7, InternalSecurityAction r9) {
        Intrinsics.checkNotNullParameter(r2, "pageType");
        Intrinsics.checkNotNullParameter(r6, "reason");
        HashMap r10 = a(r9);
        r10.put("page_type", r2);
        r10.put(ChameleonOpenTracker.OpenResult.SUCCESS, Boolean.valueOf(r3));
        r10.put("code", Long.valueOf(r4));
        r10.put("reason", r6);
        u4c.a.a("advanced_login_result", r10, MapsKt.mapOf(TuplesKt.to("duration_ms", Long.valueOf(r7))), null, 0, 24);
    }
}
