package com.obric.oui.calendar;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class WeekPagerAdapter extends b<b0> {

    public static class a implements d {
        public final CalendarDay a;
        public final int b;
        public final DayOfWeek c;

        @Override // com.obric.oui.calendar.d
        public final int getCount() {
            return this.b;
        }

        @Override // com.obric.oui.calendar.d
        public final int a(CalendarDay r4) {
            WeekFields r0 = WeekFields.of(this.c, 1);
            LocalDate r5 = r4.a.with(r0.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.a.a, r5);
        }

        @Override // com.obric.oui.calendar.d
        public final CalendarDay getItem(int r4) {
            return CalendarDay.a(this.a.a.plusWeeks(r4));
        }

        public a(CalendarDay r4, CalendarDay r5, DayOfWeek r6) {
            this.c = r6;
            this.a = CalendarDay.a(r4.a.with(WeekFields.of(r6, 1).dayOfWeek(), 1));
            this.b = a(r5) + 1;
        }
    }

    public WeekPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.b
    public final c g(int r5) {
        return new b0(this.b, i(r5), this.b.getFirstDayOfWeek(), this.s);
    }

    @Override // com.obric.oui.calendar.b
    public final int k(c r2) {
        CalendarDay r3 = ((b0) r2).f;
        return this.k.a(r3);
    }

    @Override // com.obric.oui.calendar.b
    public final boolean m(Object r1) {
        return r1 instanceof b0;
    }

    @Override // com.obric.oui.calendar.b
    public final d f(CalendarDay r3, CalendarDay r4) {
        return new a(r3, r4, this.b.getFirstDayOfWeek());
    }
}
