package com.obric.oui.calendar;

import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j extends c {
    public int k;

    @Override // com.obric.oui.calendar.c
    public final int d() {
        if (this.i == false) goto L6;
        return this.k + 1;
    L6:
        return this.k;
    }

    @Override // com.obric.oui.calendar.c
    public final boolean e(CalendarDay r2) {
        if (r2.c() != this.f.c()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.calendar.c
    public final void b(Collection<e> r8, LocalDate r9) {
        LocalDate r0 = this.f.a;
        DayOfWeek r1 = this.c;
        boolean r3 = true;
        if ((this.d & 1) != 0) goto L6;
        r3 = false;
    L6:
        LocalDate r2 = c.c(r0, r1, r3);
        LocalDate r4 = r0.withDayOfMonth(r0.lengthOfMonth());
        this.k = (int) ((((ChronoUnit.DAYS.between(r2, r4) + 1) + 7) - 1) / 7);
        int r5 = 0;
    L8:
        if (r5 >= this.k) goto L14;
        int r6 = 0;
    L11:
        if (r6 >= 7) goto L13;
        a(r8, r9);
        r9 = r9.plusDays(1);
        r6 = r6 + 1;
        goto L11
    L13:
        r5 = r5 + 1;
        goto L8
    }

    public j(MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }
}
