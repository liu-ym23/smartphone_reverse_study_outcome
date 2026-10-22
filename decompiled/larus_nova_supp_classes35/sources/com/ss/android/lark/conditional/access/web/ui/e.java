package com.ss.android.lark.conditional.access.web.ui;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserScopeBindDeviceWebFragment a;

    public e(UserScopeBindDeviceWebFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L4;
        r1.dismiss();
    L4:
        int r3 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "dismiss policy notice, web did: " + this.a.j);
    }
}
