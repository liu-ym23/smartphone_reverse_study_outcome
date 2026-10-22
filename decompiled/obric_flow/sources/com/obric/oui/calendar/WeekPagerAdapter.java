package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes3.dex */
public class WeekPagerAdapter extends b {
    @Override // com.obric.oui.calendar.b
    public final e a(CalendarDay r5, CalendarDay r10) {
        return new com.bytedance.salamander.anniex.b0(r5, r10, this.f12239b.getFirstDayOfWeek());
    }

    @Override // com.obric.oui.calendar.b
    public final d b(int r5) {
        CalendarDay r10 = this.f12244k.getItem(r5);
        MaterialCalendarView r11 = this.f12239b;
        return new f0(r11, r10, r11.getFirstDayOfWeek(), this.s);
    }

    @Override // com.obric.oui.calendar.b
    public final int d(d r5) {
        CalendarDay r10 = ((f0) r5).f;
        return this.f12244k.a(r10);
    }

    @Override // com.obric.oui.calendar.b
    public final boolean f(Object r5) {
        return r5 instanceof f0;
    }
}
