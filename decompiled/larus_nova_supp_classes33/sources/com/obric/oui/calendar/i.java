package com.obric.oui.calendar;

import org.threeten.bp.Period;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i extends b<j> {

    public static class a implements d {
        public final CalendarDay a;
        public final int b;

        @Override // com.obric.oui.calendar.d
        public final int getCount() {
            return this.b;
        }

        @Override // com.obric.oui.calendar.d
        public final int a(CalendarDay r3) {
            return (int) Period.between(this.a.a.withDayOfMonth(1), r3.a.withDayOfMonth(1)).toTotalMonths();
        }

        @Override // com.obric.oui.calendar.d
        public final CalendarDay getItem(int r4) {
            return CalendarDay.a(this.a.a.plusMonths(r4));
        }

        public a(CalendarDay r4, CalendarDay r5) {
            this.a = new CalendarDay(r4.d(), r4.c(), 1);
            this.b = a(r5) + 1;
        }
    }

    public i(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.b
    public final c g(int r5) {
        return new j(this.b, i(r5), this.b.getFirstDayOfWeek(), this.s);
    }

    @Override // com.obric.oui.calendar.b
    public final int k(c r2) {
        CalendarDay r3 = ((j) r2).f;
        return this.k.a(r3);
    }

    @Override // com.obric.oui.calendar.b
    public final boolean m(Object r1) {
        return r1 instanceof j;
    }

    @Override // com.obric.oui.calendar.b
    public final d f(CalendarDay r2, CalendarDay r3) {
        return new a(r2, r3);
    }
}
