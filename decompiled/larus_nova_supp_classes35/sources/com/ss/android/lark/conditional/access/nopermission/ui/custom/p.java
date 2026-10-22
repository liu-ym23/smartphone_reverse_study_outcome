package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentCustomNoPermissionBinding;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ CustomNoPermissionFragment a;

    public p(CustomNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        CustomNoPermissionFragment r4 = this.a;
        qqb.a.h("retry device authentication");     // Catch: Throwable -> L9
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "deviceAuthentication fail, retry button click.");     // Catch: Throwable -> L9
        ScsFragmentCustomNoPermissionBinding r5 = r4.h;     // Catch: Throwable -> L9
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");     // Catch: Throwable -> L9
        r5 = null;
    L6:
        r5.a.findViewWithTag("DeviceAuth").performClick();     // Catch: Throwable -> L9
        qqb.a.a();
        return;
    L9:
        th = move-exception;
        qqb.a.a();
        throw th;
    }
}
