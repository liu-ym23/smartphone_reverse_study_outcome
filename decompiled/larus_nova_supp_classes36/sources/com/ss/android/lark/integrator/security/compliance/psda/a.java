package com.ss.android.lark.integrator.security.compliance.psda;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import okhttp3.Request;
import w4c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Request r9) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("scs.scs_infra.sla") == true) goto L5;
        return;
    L5:
        List r0 = c.a().m0();
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L13:
        String r2 = u4c.a.a;
        u4c.a.a("scs_network_state_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("path", r9.url().url().getPath()), TuplesKt.to("domain", r9.url().url().getHost()), TuplesKt.to("event_type", "REPORTNETREQUESTSTART")}), null, null, 0, 28);
        return;
    L8:
        if (r0.contains(r9.url().url().getPath()) != true) goto L10;
        r1 = true;
        goto L11
    }

    public static void a(String r7, String r8, int r9, String r10) {
        String r0 = u4c.a.a;
        u4c.a.a("scs_network_state_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("domain", r7), TuplesKt.to("path", r8), TuplesKt.to("error_code", Integer.valueOf(r9)), TuplesKt.to("error_msg", r10)}), null, null, 0, 28);
    }
}
