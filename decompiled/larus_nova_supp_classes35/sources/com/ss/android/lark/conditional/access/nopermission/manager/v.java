package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v implements DialogInterface.OnClickListener {
    public final /* synthetic */ InternalSecurityAction a;

    public v(InternalSecurityAction r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        ScsLogger.d("SecurityPolicyDialogFragment", "DeviceOwnershipErrorDialog retry button click.");
        SecurityPolicyDialogActionManager r3 = SecurityPolicyDialogActionManager.a;
        InternalSecurityAction r4 = this.a;
        r3.getClass();
        SecurityPolicyDialogActionManager.c(r4);
    }
}
