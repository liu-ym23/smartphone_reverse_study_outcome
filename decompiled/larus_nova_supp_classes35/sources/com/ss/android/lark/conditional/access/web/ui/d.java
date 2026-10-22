package com.ss.android.lark.conditional.access.web.ui;

import android.content.DialogInterface;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserScopeBindDeviceWebFragment a;

    public d(UserScopeBindDeviceWebFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        UDCheckBox r3 = this.a.o;
        if (r3 == null) goto L5;
        r3.setChecked(true);
    L5:
        ((BindDeviceWebViewModel) this.a.i.getValue()).bindDeviceWeb(this.a.j);
        int r4 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", " policy notice bindDeviceWeb, web did: " + this.a.j);
    }
}
