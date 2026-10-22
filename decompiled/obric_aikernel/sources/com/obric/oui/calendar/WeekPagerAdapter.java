package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public class WeekPagerAdapter extends CalendarPagerAdapter<o> {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f6333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DayOfWeek f6335c;

        public a(@NonNull CalendarDay r10, @NonNull CalendarDay r11, DayOfWeek r12) {
            this.f6335c = r12;
            this.f6333a = b(r10);
            this.f6334b = a(r11) + 1;
        }

        private CalendarDay b(@NonNull CalendarDay r10) {
            return CalendarDay.from(r10.getDate().with(WeekFields.of(this.f6335c, 1).dayOfWeek(), 1));
        }

        @Override // com.obric.oui.calendar.c
        public int a(CalendarDay r10) {
            WeekFields r11 = WeekFields.of(this.f6335c, 1);
            LocalDate r12 = r10.getDate().with(r11.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.f6333a.getDate(), r12);
        }

        @Override // com.obric.oui.calendar.c
        public int getCount() {
            return this.f6334b;
        }

        @Override // com.obric.oui.calendar.c
        public CalendarDay getItem(int r10) {
            return CalendarDay.from(this.f6333a.getDate().plusWeeks(r10));
        }
    }

    public WeekPagerAdapter(MaterialCalendarView r10) {
        super(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void clearSelections() {
        super.clearSelections();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected c createRangeIndex(CalendarDay r10, CalendarDay r11) {
        return new a(r10, r11, this.mcv.getFirstDayOfWeek());
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ b createView(int r10) {
        return createView(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected o createView(int r10) {
        return new o(this.mcv, getItem(r10), this.mcv.getFirstDayOfWeek(), this.showWeekDays);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ void destroyItem(@NonNull ViewGroup r10, int r11, @NonNull Object r12) {
        super.destroyItem(r10, r11, r12);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ int getIndexForDay(CalendarDay r10) {
        return super.getIndexForDay(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ CalendarDay getItem(int r10) {
        return super.getItem(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getItemPosition(@NonNull Object r10) {
        return super.getItemPosition(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ CharSequence getPageTitle(int r10) {
        return super.getPageTitle(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ c getRangeIndex() {
        return super.getRangeIndex();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    @NonNull
    public /* bridge */ /* synthetic */ List getSelectedDates() {
        return super.getSelectedDates();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ int getShowOtherDates() {
        return super.getShowOtherDates();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ int indexOf(b r10) {
        return indexOf((o) r10);
    }

    protected int indexOf(o r10) {
        CalendarDay r11 = r10.g();
        return getRangeIndex().a(r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NonNull
    public /* bridge */ /* synthetic */ Object instantiateItem(@NonNull ViewGroup r10, int r11) {
        return super.instantiateItem(r10, r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void invalidateDecorators() {
        super.invalidateDecorators();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected boolean isInstanceOfView(Object r10) {
        return r10 instanceof o;
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ boolean isShowWeekDays() {
        return super.isShowWeekDays();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ boolean isViewFromObject(@NonNull View r10, @NonNull Object r11) {
        return super.isViewFromObject(r10, r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ CalendarPagerAdapter migrateStateAndReturn(CalendarPagerAdapter r10) {
        return super.migrateStateAndReturn(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void selectRange(CalendarDay r10, CalendarDay r11) {
        super.selectRange(r10, r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDateSelected(CalendarDay r10, boolean r11) {
        super.setDateSelected(r10, r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDateTextAppearance(int r10) {
        super.setDateTextAppearance(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDayFormatter(m9.e r10) {
        super.setDayFormatter(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDayFormatterContentDescription(m9.e r10) {
        super.setDayFormatterContentDescription(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDecorators(List r10) {
        super.setDecorators(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setRangeDates(CalendarDay r10, CalendarDay r11) {
        super.setRangeDates(r10, r11);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setSelectionColor(int r10) {
        super.setSelectionColor(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setSelectionEnabled(boolean r10) {
        super.setSelectionEnabled(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setShowOtherDates(int r10) {
        super.setShowOtherDates(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setShowWeekDays(boolean r10) {
        super.setShowWeekDays(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setTitleFormatter(@Nullable m9.g r10) {
        super.setTitleFormatter(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setWeekDayFormatter(m9.h r10) {
        super.setWeekDayFormatter(r10);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setWeekDayTextAppearance(int r10) {
        super.setWeekDayTextAppearance(r10);
    }
}
