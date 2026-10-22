package com.obric.oui.calendar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes5.dex */
class n extends b {
    public n(MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.calendar.b
    public boolean a(CalendarDay r1) {
        return true;
    }

    @Override // com.obric.oui.calendar.b
    public void b(Collection<DayView> r4, LocalDate r5) {
        Collection<DayView> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L6;
        a(r6, r5);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.b
    public int f() {
        if (this.f13438b == false) goto L5;
        return 2;
    L5:
        return 1;
    }
}
