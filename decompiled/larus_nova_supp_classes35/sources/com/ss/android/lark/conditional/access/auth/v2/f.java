package com.ss.android.lark.conditional.access.auth.v2;

import android.content.Context;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public final Context a;
    public final SecurityPolicyAuthManager b;

    public final Context getContext() {
        return this.a;
    }

    public f(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        SecurityPolicyAuthManager r0 = new SecurityPolicyAuthManager();
        this.b = r0;
        Intrinsics.checkNotNullParameter(r3, "ctx");
        boolean r1 = true;
        r0.a = true;
        r0.d = r3;
        r0.m();
        if (r0.b.length() > 0) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        r0.k(FileAuthMonitor.UpdateTrigger.ColdBoot);
    L8:
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerUserSwitchListener(new d0());
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerLoginListener(new e0(r0));
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerLogoutListener(new f0(r0));
        List r4 = com.ss.android.lark.security.compliance.infra.storage.c.a;
        c0 r5 = new c0();
        Intrinsics.checkNotNullParameter(r5, "task");
        ((ArrayList) com.ss.android.lark.security.compliance.infra.storage.c.a).add(r5);
    }

    public final ValidateResult a(PolicyModel r5, ValidateConfig r6) {
        Intrinsics.checkNotNullParameter(r5, "p");
        SecurityPolicyAuthManager r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "model");
        com.ss.android.lark.conditional.access.auth.v2.service.d r1 = r0.q;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "policyModel");
        boolean r3 = false;
        c r2 = new com.ss.android.lark.conditional.access.auth.v2.service.chain.g(r1.d, 0, r5, r6).a(r5);
        com.ss.android.lark.conditional.access.utils.e.c(r6, r2);
        if (r6 != null) goto L5;
    L7:
        if (r3 == true) goto L9;
        r1.c(new i8b.t(r2.i()));
    L9:
        r2.q(r5.getPointKey());
        return g.a(r2);
    L5:
        if (r6.getIgnoreReportUserOperate() != true) goto L7;
        r3 = true;
        goto L7
    }
}
