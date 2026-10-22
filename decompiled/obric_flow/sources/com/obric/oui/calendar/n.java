package com.obric.oui.calendar;

import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends b {
    @Override // com.obric.oui.calendar.b
    public final e a(CalendarDay r5, CalendarDay r10) {
        al.a r11 = new al.a();
        LocalDate r12 = r5.f12167a;
        r11.f314b = new CalendarDay(r12.getYear(), r12.getMonthValue(), 1);
        r11.f313a = r11.a(r10) + 1;
        return r11;
    }

    @Override // com.obric.oui.calendar.b
    public final d b(int r5) {
        CalendarDay r10 = this.f12244k.getItem(r5);
        MaterialCalendarView r11 = this.f12239b;
        return new o(r11, r10, r11.getFirstDayOfWeek(), this.s);
    }

    @Override // com.obric.oui.calendar.b
    public final int d(d r5) {
        CalendarDay r10 = ((o) r5).f;
        return this.f12244k.a(r10);
    }

    @Override // com.obric.oui.calendar.b
    public final boolean f(Object r5) {
        return r5 instanceof o;
    }
}
