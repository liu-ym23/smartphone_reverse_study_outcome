package com.obric.oui.calendar;

import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b0 extends c {
    @Override // com.obric.oui.calendar.c
    public final boolean e(CalendarDay r1) {
        return true;
    }

    @Override // com.obric.oui.calendar.c
    public final int d() {
        if (this.i == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.obric.oui.calendar.c
    public final void b(Collection<e> r4, LocalDate r5) {
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L6;
        a(r4, r5);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    public b0(MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }
}
