package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w implements DialogInterface.OnClickListener {
    public final /* synthetic */ CustomNoPermissionFragment a;

    public w(CustomNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "locationServicesDisabledDialog: cancel");
        int r3 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.b("dismiss_dialog", this.a.i);
        com.ss.android.lark.conditional.access.utils.a.d("dismiss", this.a.i);
    }
}
