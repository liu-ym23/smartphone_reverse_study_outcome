package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes5.dex */
public class WeekPagerAdapter extends CalendarPagerAdapter<n> {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f13428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13429b;
        private final DayOfWeek c;

        public a(CalendarDay r1, CalendarDay r2, DayOfWeek r3) {
            this.c = r3;
            this.f13428a = b(r1);
            this.f13429b = a(r2) + 1;
        }

        private CalendarDay b(CalendarDay r3) {
            return CalendarDay.from(r3.getDate().with(WeekFields.of(this.c, 1).dayOfWeek(), 1));
        }

        @Override // com.obric.oui.calendar.c
        public int a() {
            return this.f13429b;
        }

        @Override // com.obric.oui.calendar.c
        public int a(CalendarDay r4) {
            WeekFields r0 = WeekFields.of(this.c, 1);
            LocalDate r5 = r4.getDate().with(r0.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.f13428a.getDate(), r5);
        }

        @Override // com.obric.oui.calendar.c
        public CalendarDay a(int r3) {
            return CalendarDay.from(this.f13428a.getDate().plusWeeks(r3));
        }
    }

    public WeekPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void clearSelections() {
        super.clearSelections();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public c createRangeIndex(CalendarDay r2, CalendarDay r3) {
        return new a(r2, r3, this.mcv.getFirstDayOfWeek());
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ b createView(int r1) {
        return createView(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public n createView(int r4) {
        return new n(this.mcv, getItem(r4), this.mcv.getFirstDayOfWeek(), this.showWeekDays);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ void destroyItem(ViewGroup r1, int r2, Object r3) {
        super.destroyItem(r1, r2, r3);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ int getIndexForDay(CalendarDay r1) {
        return super.getIndexForDay(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ CalendarDay getItem(int r1) {
        return super.getItem(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getItemPosition(Object r1) {
        return super.getItemPosition(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ CharSequence getPageTitle(int r1) {
        return super.getPageTitle(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ c getRangeIndex() {
        return super.getRangeIndex();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ List getSelectedDates() {
        return super.getSelectedDates();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ int getShowOtherDates() {
        return super.getShowOtherDates();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* synthetic */ int indexOf(b r3) {
        return indexOf((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin"));
    }

    public int indexOf(n r1) {
        CalendarDay r2 = r1.g();
        return getRangeIndex().a(r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ Object instantiateItem(ViewGroup r1, int r2) {
        return super.instantiateItem(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void invalidateDecorators() {
        super.invalidateDecorators();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public boolean isInstanceOfView(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, n.class);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ boolean isShowWeekDays() {
        return super.isShowWeekDays();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ boolean isViewFromObject(View r1, Object r2) {
        return super.isViewFromObject(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ CalendarPagerAdapter migrateStateAndReturn(CalendarPagerAdapter r1) {
        return super.migrateStateAndReturn(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void selectRange(CalendarDay r1, CalendarDay r2) {
        super.selectRange(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDateSelected(CalendarDay r1, boolean r2) {
        super.setDateSelected(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDateTextAppearance(int r1) {
        super.setDateTextAppearance(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* synthetic */ void setDayFormatter(com.obric.oui.calendar.a.e r3) {
        super.setDayFormatter((com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* synthetic */ void setDayFormatterContentDescription(com.obric.oui.calendar.a.e r3) {
        super.setDayFormatterContentDescription((com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* synthetic */ void setDecorators(List r3) {
        super.setDecorators((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setRangeDates(CalendarDay r1, CalendarDay r2) {
        super.setRangeDates(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setSelectionColor(int r1) {
        super.setSelectionColor(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setSelectionEnabled(boolean r1) {
        super.setSelectionEnabled(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setShowOtherDates(int r1) {
        super.setShowOtherDates(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setShowWeekDays(boolean r1) {
        super.setShowWeekDays(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* synthetic */ void setTitleFormatter(com.obric.oui.calendar.a.g r3) {
        super.setTitleFormatter((com.obric.oui.calendar.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.g.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* synthetic */ void setWeekDayFormatter(com.obric.oui.calendar.a.h r3) {
        super.setWeekDayFormatter((com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setWeekDayTextAppearance(int r1) {
        super.setWeekDayTextAppearance(r1);
    }
}
