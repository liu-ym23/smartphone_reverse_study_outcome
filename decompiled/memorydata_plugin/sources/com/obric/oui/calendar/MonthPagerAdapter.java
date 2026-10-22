package com.obric.oui.calendar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes5.dex */
class MonthPagerAdapter extends CalendarPagerAdapter<h> {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f13420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13421b;

        public a(CalendarDay r3, CalendarDay r4) {
            this.f13420a = CalendarDay.from(r3.getYear(), r3.getMonth(), 1);
            this.f13421b = a(r4) + 1;
        }

        @Override // com.obric.oui.calendar.c
        public int a() {
            return this.f13421b;
        }

        @Override // com.obric.oui.calendar.c
        public int a(CalendarDay r2) {
            return (int) Period.between(this.f13420a.getDate().withDayOfMonth(1), r2.getDate().withDayOfMonth(1)).toTotalMonths();
        }

        @Override // com.obric.oui.calendar.c
        public CalendarDay a(int r3) {
            return CalendarDay.from(this.f13420a.getDate().plusMonths(r3));
        }
    }

    MonthPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public c createRangeIndex(CalendarDay r1, CalendarDay r2) {
        return new a(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ b createView(int r1) {
        return createView(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public h createView(int r4) {
        return new h(this.mcv, getItem(r4), this.mcv.getFirstDayOfWeek(), this.showWeekDays);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* synthetic */ int indexOf(b r3) {
        return indexOf((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"));
    }

    public int indexOf(h r1) {
        CalendarDay r2 = r1.h();
        return getRangeIndex().a(r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public boolean isInstanceOfView(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, h.class);
    }
}
