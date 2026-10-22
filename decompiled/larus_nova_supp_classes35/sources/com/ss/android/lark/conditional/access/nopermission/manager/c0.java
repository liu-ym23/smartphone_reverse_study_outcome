package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 implements DialogInterface.OnClickListener {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
        ScsLogger.d("SecurityPolicyDialogFragment", "NormalDialog button click.");
    }
}
