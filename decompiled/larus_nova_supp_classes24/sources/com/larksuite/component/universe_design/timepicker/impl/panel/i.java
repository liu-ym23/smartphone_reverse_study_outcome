package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements OnItemSelectedListener {
    public final /* synthetic */ f a;

    public i(f r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r4) {
        int r5 = this.a.a.getYear();
        WheelView r0 = this.a.d;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getCurrentItem();
    L6:
        int r6 = r5 + r2;
        this.a.b(r6);
        f r3 = this.a;
        int r7 = r3.h;
        WheelView r8 = r3.e;
        if (r8 == null) goto L9;
        r1 = r8.getCurrentItem();
    L9:
        f r9 = this.a;
        r9.c(r6, r7 + r1);
        f.a(this.a);
        this.a.getPickerPanelDependency().onSelected(this.a.c.getCalendar());
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
