package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import oab.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ CustomRepeatBottomContainer a;

    public c(CustomRepeatBottomContainer r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        CustomRepeatBottomContainer r4 = this.a;
        r4.mSwitchDate.setTextColor(qab.c.a(r4.getContext(), 2131105548));
        CustomRepeatBottomContainer r5 = this.a;
        r5.mSwitchWeek.setTextColor(qab.c.a(r5.getContext(), 2131106622));
        this.a.mCustomRepeatMonthly.setVisibility(0);
        CustomRepeatBottomContainer r6 = this.a;
        r6.a(r6.c, r6.q);
        this.a.mChooseRepeatWeeksViewGroup.setVisibility(8);
        CustomRepeatBottomContainer r7 = this.a;
        r7.a = true;
        e r8 = r7.h;
        if (r8 == null) goto L6;
        r8.i();
        CustomRepeatBottomContainer r9 = this.a;
        r9.a(r9.c, r9.q);
        return;
    }
}
