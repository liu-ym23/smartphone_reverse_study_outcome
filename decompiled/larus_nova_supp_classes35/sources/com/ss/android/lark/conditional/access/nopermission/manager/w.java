package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w implements DialogInterface.OnClickListener {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        ScsLogger.d("SecurityPolicyDialogFragment", "DeviceOwnershipErrorDialog got it button click.");
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b.clear();
        SecurityPolicyDialogActionManager.b();
    }
}
