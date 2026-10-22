package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import android.content.Intent;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x implements DialogInterface.OnClickListener {
    public final /* synthetic */ CustomNoPermissionFragment a;

    public x(CustomNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "locationServicesDisabledDialog: open location source settings");
        int r5 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.b("go_to_settings", this.a.i);
        com.ss.android.lark.conditional.access.utils.a.d("dismiss", this.a.i);
        CustomNoPermissionFragment r6 = this.a;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Intent r1 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");     // Catch: Throwable -> L5
        r1.addFlags(268468224);     // Catch: Throwable -> L5
        r6.requireContext().startActivity(r1);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L13;
        int r2 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "open location source settings failed: " + r8.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
