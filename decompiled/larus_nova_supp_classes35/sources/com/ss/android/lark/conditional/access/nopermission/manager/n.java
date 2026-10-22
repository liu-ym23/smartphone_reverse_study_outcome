package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements DialogInterface.OnClickListener {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
    }
}
