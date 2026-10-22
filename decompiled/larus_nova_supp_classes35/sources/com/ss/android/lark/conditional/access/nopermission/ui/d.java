package com.ss.android.lark.conditional.access.nopermission.ui;

import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ DeviceAuthenticationNoPermissionFragment a;

    public d(DeviceAuthenticationNoPermissionFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        DeviceAuthenticationNoPermissionFragment r0 = this.a;
        int r1 = DeviceAuthenticationNoPermissionFragment.o;
        r0.Y90();
        if (((Boolean) r4).booleanValue() == false) goto L6;
        this.a.S90().a.postDelayed(new a(this.a), 1000);
        return;
    L6:
        if (this.a.m == false) goto L8;
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "firstLoad auth fail, show fallback UI.");
        this.a.S90().e.b.cancelAnimation();
        t4c.b.a(this.a.S90().e.a);
        t4c.b.b(this.a.S90().f);
        t4c.b.b(this.a.S90().c);
        this.a.m = false;
        return;
    L8:
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "auth fail, show auth retry dialog.");
        new UDDialogBuilder(this.a.requireContext()).cancelable(false).cancelOnTouchOutside(false).title(2131890477).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(2131391777, 2131890478, new b(this.a)).addActionButton(2131391778, 2131890476, c.a).show();
    }
}
