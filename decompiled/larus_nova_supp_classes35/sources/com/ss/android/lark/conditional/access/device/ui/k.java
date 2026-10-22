package com.ss.android.lark.conditional.access.device.ui;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserScopeDeviceDeclareFragment a;

    public k(UserScopeDeviceDeclareFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "click ApplyRejectDialog");
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        UserScopeDeviceDeclareFragment r4 = this.a;
        int r5 = UserScopeDeviceDeclareFragment.m;
        r4.da0();
    }
}
