package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements DialogInterface.OnClickListener {
    public final /* synthetic */ InternalSecurityAction a;

    public s(InternalSecurityAction r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        SecurityPolicyDialogActionManager r4 = SecurityPolicyDialogActionManager.a;
        r4.getClass();
        SecurityPolicyDialogActionManager.b();
        r4.f(21, this.a);
        ScsLogger.d("SecurityPolicyDialogFragment", "DeviceCertRetryDialog retry button click.");
    }
}
