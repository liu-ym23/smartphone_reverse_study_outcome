package com.bytedance.android.live.recharge.widget;

import android.view.View;
import android.widget.ToggleButton;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ RechargeBottomWidget a;

    public e(RechargeBottomWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        boolean r0 = false;
        if (((Boolean) this.a.h.isAcceptAgreement().a).booleanValue() == true) goto L9;
        ToggleButton r6 = this.a.r;
        if (r6 == null) goto L9;
        if (r6.isChecked() != true) goto L9;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_homepage_check_safe_agreement_click", false, 0);
    L9:
        PropertyOwner<Boolean> r7 = this.a.h.isAcceptAgreement();
        ToggleButton r2 = this.a.r;
        if (r2 != null) goto L12;
    L14:
        r7.a(Boolean.valueOf(r0));
        return;
    L12:
        if (r2.isChecked() != true) goto L14;
        r0 = true;
        goto L14
    }
}
