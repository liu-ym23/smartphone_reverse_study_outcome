package com.larus.uaigc.instruction;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import tx9.s3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public static final void a(Context r6) {
        t19.s r0 = t19.s.a;
        z2 r1 = z2.a;
        FlowDowngradeToastConfig r2 = r1.getFlowDowngradeToastConfig();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getTrafficDegradationFeatureDisableCn();
    L6:
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L15;
        String r7 = AppHost.a.getApplication().getString(2131910602);
    L14:
        String r8 = r7;
        Intrinsics.checkNotNull(r8);
        t19.s.j(r0, r6, r8, null, false, 28);
        s3.a("cre_bty_dg");
        return;
    L15:
        FlowDowngradeToastConfig r9 = r1.getFlowDowngradeToastConfig();
        if (r9 == null) goto L18;
        r3 = r9.getTrafficDegradationFeatureDisableCn();
    L18:
        r7 = String.valueOf(r3);
        goto L14
    L8:
        if (r4.length() == 0) goto L11;
        r5 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}
