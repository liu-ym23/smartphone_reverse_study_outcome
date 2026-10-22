package com.larksuite.component.universe_design.timepicker.impl.panel;

import com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.util.CalendarDate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements OnItemSelectedListener {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.base.OnItemSelectedListener
    public final void onItemSelected(int r4) {
        d r5 = this.a;
        WheelView r0 = r5.c;
        if (r0 == null) goto L6;
        CalendarDate r1 = new CalendarDate(r5.a);
        r1.setMonthDay(r1.getMonthDay() + r0.getCurrentItem());
        r5.d.setYear(r1.getYear());
        r5.d.setMonth(r1.getMonth());
        r5.d.setMonthDay(r1.getMonthDay());
    L6:
        this.a.getPickerPanelDependency().onSelected(this.a.d.getCalendar());
    }
}
