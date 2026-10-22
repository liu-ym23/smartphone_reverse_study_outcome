package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements DialogInterface.OnClickListener {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "deviceAuthentication fail, cancel button click.");
    }
}
