package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements DialogInterface.OnClickListener {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "deviceAuthentication fail, cancel button click.");
    }
}
