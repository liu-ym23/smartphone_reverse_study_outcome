package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 implements DialogInterface.OnClickListener {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        ScsLogger.d("SecurityPolicyDialogFragment", "NetworkDialog button click.");
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
    }
}
