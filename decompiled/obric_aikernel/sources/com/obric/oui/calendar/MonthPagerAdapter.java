package com.obric.oui.calendar;

import androidx.annotation.NonNull;
import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes2.dex */
class MonthPagerAdapter extends CalendarPagerAdapter<h> {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f6325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6326b;

        public a(@NonNull CalendarDay r10, @NonNull CalendarDay r11) {
            this.f6325a = CalendarDay.from(r10.getYear(), r10.getMonth(), 1);
            this.f6326b = a(r11) + 1;
        }

        @Override // com.obric.oui.calendar.c
        public int a(CalendarDay r10) {
            return (int) Period.between(this.f6325a.getDate().withDayOfMonth(1), r10.getDate().withDayOfMonth(1)).toTotalMonths();
        }

        @Override // com.obric.oui.calendar.c
        public int getCount() {
            return this.f6326b;
        }

        @Override // com.obric.oui.calendar.c
        public CalendarDay getItem(int r10) {
            return CalendarDay.from(this.f6325a.getDate().plusMonths(r10));
        }
    }

    MonthPagerAdapter(MaterialCalendarView r10) {
        super(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected c createRangeIndex(CalendarDay r10, CalendarDay r11) {
        return new a(r10, r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ b createView(int r10) {
        return createView(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected h createView(int r10) {
        return new h(this.mcv, getItem(r10), this.mcv.getFirstDayOfWeek(), this.showWeekDays);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ int indexOf(b r10) {
        return indexOf((h) r10);
    }

    protected int indexOf(h r10) {
        CalendarDay r11 = r10.y();
        return getRangeIndex().a(r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected boolean isInstanceOfView(Object r10) {
        return r10 instanceof h;
    }
}
