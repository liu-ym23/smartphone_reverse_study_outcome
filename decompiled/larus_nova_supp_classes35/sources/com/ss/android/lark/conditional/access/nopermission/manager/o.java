package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ InternalSecurityAction a;

    public o(InternalSecurityAction r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        SecurityPolicyDialogActionManager r4 = SecurityPolicyDialogActionManager.a;
        r4.getClass();
        SecurityPolicyDialogActionManager.b();
        r4.f(25, this.a);
    }
}
