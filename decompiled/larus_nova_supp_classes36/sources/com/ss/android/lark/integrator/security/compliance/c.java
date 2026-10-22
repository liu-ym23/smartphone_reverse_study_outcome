package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static boolean a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        IOfficeAppBaseInfo r1 = OfficeSDKManager.getHostGlobalService(IOfficeAppBaseInfo.class);     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.isEnterpriseAccount() != true) goto L7;
    L8:
        Object r3 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L10
    L12:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L16;
        r3 = r4;
    L16:
        return ((Boolean) r3).booleanValue();
    L7:
        r2 = false;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
