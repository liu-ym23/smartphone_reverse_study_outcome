package com.bytedance.android.live.recharge;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ CustomRechargeDialogFragment a;

    public f(CustomRechargeDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        EditText r6 = this.a.o;
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.getText()) == true) goto L42;
        Editable r7 = r6.getText();
        if (r7 == null) goto L11;
        String r8 = r7.toString();
        if (r8 == null) goto L11;
        long r0 = (long) (CastLongProtector.parseLong(r8) * 100.0f);
    L12:
        RechargeDialogContext r9 = this.a.f;
        if (r9 == null) goto L21;
        a0 r10 = r9.getRepository();
        if (r10 == null) goto L21;
        PropertyOwner r12 = r10.C;
        if (r12 == null) goto L21;
        com.bytedance.android.live.recharge.deal.i r13 = (com.bytedance.android.live.recharge.deal.i) r12.a;
        if (r13 == null) goto L21;
        com.bytedance.android.live.recharge.deal.d r14 = com.bytedance.android.live.recharge.deal.j.a(r13, r0, false, 6);
    L22:
        RechargeDialogContext r1 = this.a.f;
        if (r1 == null) goto L36;
        a0 r2 = r1.getRepository();
        if (r2 == null) goto L36;
        PropertyOwner r3 = r2.L;
        if (r3 == null) goto L36;
        if (((Boolean) r3.a).booleanValue() != true) goto L36;
        ToggleButton r4 = this.a.y;
        if (r4 == null) goto L33;
        r4.setVisibility(0);
    L33:
        ToggleButton r15 = this.a.y;
        if (r15 == null) goto L39;
        r15.setChecked(false);
    L39:
        this.a.U90(r14, false);
        return;
    L36:
        ToggleButton r16 = this.a.y;
        if (r16 == null) goto L39;
        r16.setVisibility(8);
    L21:
        r14 = null;
    L11:
        r0 = 0;
        goto L12
    }
}
