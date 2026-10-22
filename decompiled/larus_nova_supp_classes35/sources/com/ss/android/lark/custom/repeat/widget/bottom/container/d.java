package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import oab.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ CustomRepeatBottomContainer a;

    public d(CustomRepeatBottomContainer r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        CustomRepeatBottomContainer r4 = this.a;
        r4.mSwitchDate.setTextColor(qab.c.a(r4.getContext(), 2131106622));
        CustomRepeatBottomContainer r5 = this.a;
        r5.mSwitchWeek.setTextColor(qab.c.a(r5.getContext(), 2131105548));
        this.a.mCustomRepeatMonthly.setVisibility(8);
        this.a.mChooseRepeatWeeksViewGroup.setVisibility(0);
        this.a.b();
        CustomRepeatBottomContainer r6 = this.a;
        r6.a = false;
        e r7 = r6.h;
        if (r7 == null) goto L6;
        r7.f();
        CustomRepeatBottomContainer r8 = this.a;
        r8.a(r8.c, r8.q);
        return;
    }
}
