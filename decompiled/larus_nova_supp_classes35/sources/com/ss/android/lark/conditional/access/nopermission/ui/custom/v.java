package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v implements DialogInterface.OnClickListener {
    public final /* synthetic */ CustomNoPermissionFragment a;

    public v(CustomNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "geoPermissionDeniedDialog: open system settings");
        int r7 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.b("go_to_settings", this.a.i);
        com.ss.android.lark.conditional.access.utils.a.d("dismiss", this.a.i);
        CustomNoPermissionFragment r8 = this.a;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Intent r1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Throwable -> L5
        r1.setData(Uri.fromParts("package", r8.requireContext().getPackageName(), null));     // Catch: Throwable -> L5
        r1.addFlags(268468224);     // Catch: Throwable -> L5
        r8.requireContext().startActivity(r1);     // Catch: Throwable -> L5
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L13;
        int r2 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "open app settings failed: " + r10.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
