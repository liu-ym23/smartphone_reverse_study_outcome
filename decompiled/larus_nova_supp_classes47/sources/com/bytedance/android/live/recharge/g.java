package com.bytedance.android.live.recharge;

import android.view.View;
import android.widget.ToggleButton;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ CustomRechargeDialogFragment a;

    public g(CustomRechargeDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        RechargeDialogContext r6 = this.a.f;
        boolean r0 = false;
        if (r6 == null) goto L13;
        PropertyOwner<Boolean> r7 = r6.isAcceptAgreement();
        if (r7 == null) goto L13;
        if (((Boolean) r7.a).booleanValue() == true) goto L13;
        ToggleButton r8 = this.a.y;
        if (r8 == null) goto L13;
        if (r8.isChecked() != true) goto L13;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_homepage_check_safe_agreement_click", false, 0);
    L13:
        RechargeDialogContext r9 = this.a.f;
        if (r9 == null) goto L24;
        PropertyOwner<Boolean> r10 = r9.isAcceptAgreement();
        if (r10 == null) goto L25;
        ToggleButton r2 = this.a.y;
        if (r2 != null) goto L20;
    L22:
        r10.a(Boolean.valueOf(r0));
        return;
    L20:
        if (r2.isChecked() != true) goto L22;
        r0 = true;
        goto L22
    L25:
        return;
    }
}
