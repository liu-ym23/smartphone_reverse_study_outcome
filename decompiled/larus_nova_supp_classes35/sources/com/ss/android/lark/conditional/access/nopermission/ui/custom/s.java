package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentCustomNoPermissionBinding;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements DialogInterface.OnClickListener {
    public final /* synthetic */ CustomNoPermissionFragment a;

    public s(CustomNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        CustomNoPermissionFragment r0 = this.a;
        qqb.a.h("retry device cert authentication");     // Catch: Throwable -> L16
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "deviceCertAuthentication fail, retry button click.");     // Catch: Throwable -> L16
        ScsFragmentCustomNoPermissionBinding r6 = r0.h;     // Catch: Throwable -> L16
        ScsFragmentCustomNoPermissionBinding r1 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");     // Catch: Throwable -> L16
        r6 = null;
    L8:
        if (r6.a.findViewWithTag("DeviceCertAuth") == null) goto L14;
        ScsFragmentCustomNoPermissionBinding r7 = r0.h;     // Catch: Throwable -> L16
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");     // Catch: Throwable -> L16
    L13:
        r1.a.findViewWithTag("DeviceCertAuth").performClick();     // Catch: Throwable -> L16
        goto L14
    L12:
        r1 = r7;
    L14:
        qqb.a.a();
        return;
    L16:
        th = move-exception;
        qqb.a.a();
        throw th;
    }
}
