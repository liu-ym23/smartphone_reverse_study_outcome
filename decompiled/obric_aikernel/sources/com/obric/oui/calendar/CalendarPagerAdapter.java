package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.oui.calendar.b;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
abstract class CalendarPagerAdapter<V extends b> extends PagerAdapter {
    private Integer color;
    private final ArrayDeque<V> currentViews;
    private Integer dateTextAppearance;
    private m9.e dayFormatter;
    private m9.e dayFormatterContentDescription;
    private List<f> decoratorResults;
    private List<d> decorators;
    private CalendarDay maxDate;
    protected final MaterialCalendarView mcv;
    private CalendarDay minDate;
    private c rangeIndex;
    private List<CalendarDay> selectedDates;
    private boolean selectionEnabled;
    private int showOtherDates;
    boolean showWeekDays;

    @NonNull
    private m9.g titleFormatter;
    private final CalendarDay today;
    private m9.h weekDayFormatter;
    private Integer weekDayTextAppearance;

    CalendarPagerAdapter(MaterialCalendarView r10) {
        this.titleFormatter = m9.g.f11061a;
        this.color = null;
        this.dateTextAppearance = null;
        this.weekDayTextAppearance = null;
        this.showOtherDates = 4;
        this.minDate = null;
        this.maxDate = null;
        this.selectedDates = new ArrayList();
        this.weekDayFormatter = m9.h.f11062a;
        m9.e r11 = m9.e.f11059a;
        this.dayFormatter = r11;
        this.dayFormatterContentDescription = r11;
        this.decorators = new ArrayList();
        this.decoratorResults = null;
        this.selectionEnabled = true;
        this.mcv = r10;
        this.today = CalendarDay.today();
        ArrayDeque<V> r12 = new ArrayDeque();
        this.currentViews = r12;
        r12.iterator();
        setRangeDates(null, null);
    }

    private void invalidateSelectedDates() {
        validateSelectedDates();
        Iterator<V> r10 = this.currentViews.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().r(this.selectedDates);
        goto L4
    }

    private void validateSelectedDates() {
        int r10 = 0;
    L4:
        if (r10 >= this.selectedDates.size()) goto L15;
        CalendarDay r11 = this.selectedDates.get(r10);
        CalendarDay r12 = this.minDate;
        if (r12 != null) goto L8;
    L9:
        CalendarDay r13 = this.maxDate;
        if (r13 == null) goto L14;
        if (r13.isBefore(r11) == false) goto L14;
    L13:
        this.selectedDates.remove(r10);
        this.mcv.E(r11);
        r10 = r10 - 1;
    L14:
        r10 = r10 + 1;
        goto L4
    L8:
        if (r12.isAfter(r11) == true) goto L13;
    }

    public void clearSelections() {
        this.selectedDates.clear();
        invalidateSelectedDates();
    }

    protected abstract c createRangeIndex(CalendarDay r10, CalendarDay r11);

    protected abstract V createView(int r10);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup r10, int r11, @NonNull Object r12) {
        b r13 = (b) r12;
        this.currentViews.remove(r13);
        r10.removeView(r13);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.rangeIndex.getCount();
    }

    protected int getDateTextAppearance() {
        Integer r10 = this.dateTextAppearance;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.intValue();
    }

    public int getIndexForDay(CalendarDay r10) {
        if (r10 == null) goto L4;
        CalendarDay r11 = this.minDate;
        if (r11 != null) goto L8;
    L11:
        CalendarDay r12 = this.maxDate;
        if (r12 == null) goto L18;
        if (r10.isAfter(r12) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.rangeIndex.a(r10);
    L8:
        if (r10.isBefore(r11) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    public CalendarDay getItem(int r10) {
        return this.rangeIndex.getItem(r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object r10) {
        if (isInstanceOfView(r10) == true) goto L5;
        return -2;
    L5:
        b r11 = (b) r10;
        if (r11.g() != null) goto L8;
        return -2;
    L8:
        int r12 = indexOf(r11);
        if (r12 >= 0) goto L11;
        return -2;
    L11:
        return r12;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r10) {
        return this.titleFormatter.a(getItem(r10));
    }

    public c getRangeIndex() {
        return this.rangeIndex;
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return Collections.unmodifiableList(this.selectedDates);
    }

    public int getShowOtherDates() {
        return this.showOtherDates;
    }

    protected int getWeekDayTextAppearance() {
        Integer r10 = this.weekDayTextAppearance;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.intValue();
    }

    protected abstract int indexOf(V r10);

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r10, int r11) {
        b r12 = createView(r11);
        r12.setContentDescription(this.mcv.getCalendarContentDescription());
        r12.setAlpha(0.0f);
        r12.t(this.selectionEnabled);
        r12.v(this.weekDayFormatter);
        r12.m(this.dayFormatter);
        r12.n(this.dayFormatterContentDescription);
        Integer r13 = this.color;
        if (r13 == null) goto L5;
        r12.s(r13.intValue());
    L5:
        Integer r14 = this.dateTextAppearance;
        if (r14 == null) goto L8;
        r12.l(r14.intValue());
    L8:
        Integer r15 = this.weekDayTextAppearance;
        if (r15 == null) goto L11;
        r12.w(r15.intValue());
    L11:
        r12.u(this.showOtherDates);
        r12.q(this.minDate);
        r12.p(this.maxDate);
        r12.r(this.selectedDates);
        r10.addView(r12);
        this.currentViews.add((V) r12);
        r12.o(this.decoratorResults);
        return r12;
    }

    public void invalidateDecorators() {
        this.decoratorResults = new ArrayList();
        Iterator<d> r10 = this.decorators.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        d r11 = r10.next();
        e r12 = new e();
        r11.b(r12);
        if (r12.f() == false) goto L4;
        this.decoratorResults.add(new f(r11, r12));
        goto L4
    L8:
        Iterator<V> r13 = this.currentViews.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        r13.next().o(this.decoratorResults);
        goto L10
    }

    protected abstract boolean isInstanceOfView(Object r10);

    public boolean isShowWeekDays() {
        return this.showWeekDays;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View r10, @NonNull Object r11) {
        if (r10 != r11) goto L4;
        return true;
    L4:
        return false;
    }

    public CalendarPagerAdapter<?> migrateStateAndReturn(CalendarPagerAdapter<?> r10) {
        r10.titleFormatter = this.titleFormatter;
        r10.color = this.color;
        r10.dateTextAppearance = this.dateTextAppearance;
        r10.weekDayTextAppearance = this.weekDayTextAppearance;
        r10.showOtherDates = this.showOtherDates;
        r10.minDate = this.minDate;
        r10.maxDate = this.maxDate;
        r10.selectedDates = this.selectedDates;
        r10.weekDayFormatter = this.weekDayFormatter;
        r10.dayFormatter = this.dayFormatter;
        r10.dayFormatterContentDescription = this.dayFormatterContentDescription;
        r10.decorators = this.decorators;
        r10.decoratorResults = this.decoratorResults;
        r10.selectionEnabled = this.selectionEnabled;
        return r10;
    }

    public void selectRange(CalendarDay r10, CalendarDay r11) {
        this.selectedDates.clear();
        LocalDate r12 = LocalDate.of(r10.getYear(), r10.getMonth(), r10.getDay());
        LocalDate r13 = r11.getDate();
    L4:
        if (r12.isBefore(r13) == true) goto L10;
        if (r12.equals(r13) == true) goto L10;
        invalidateSelectedDates();
        return;
    L10:
        this.selectedDates.add(CalendarDay.from(r12));
        r12 = r12.plusDays(1);
        goto L4
    }

    public void setDateSelected(CalendarDay r10, boolean r11) {
        if (r11 == false) goto L7;
        if (this.selectedDates.contains(r10) == true) goto L11;
        this.selectedDates.add(r10);
    L9:
        invalidateSelectedDates();
        return;
    L11:
        return;
    L7:
        if (this.selectedDates.contains(r10) == false) goto L12;
        this.selectedDates.remove(r10);
        goto L9
    }

    public void setDateTextAppearance(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.dateTextAppearance = Integer.valueOf(r10);
        Iterator<V> r11 = this.currentViews.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().l(r10);
        goto L6
    }

    public void setDayFormatter(m9.e r10) {
        m9.e r11 = this.dayFormatterContentDescription;
        if (r11 != this.dayFormatter) goto L5;
        r11 = r10;
    L5:
        this.dayFormatterContentDescription = r11;
        this.dayFormatter = r10;
        Iterator<V> r12 = this.currentViews.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r12.next().m(r10);
        goto L7
    }

    public void setDayFormatterContentDescription(m9.e r10) {
        this.dayFormatterContentDescription = r10;
        Iterator<V> r11 = this.currentViews.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().n(r10);
        goto L4
    }

    public void setDecorators(List<d> r10) {
        this.decorators = r10;
        invalidateDecorators();
    }

    public void setRangeDates(CalendarDay r10, CalendarDay r11) {
        this.minDate = r10;
        this.maxDate = r11;
        Iterator<V> r12 = this.currentViews.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        V r13 = r12.next();
        r13.q(r10);
        r13.p(r11);
        goto L4
    L6:
        if (r10 != null) goto L8;
        r10 = CalendarDay.from(this.today.getYear() - 200, this.today.getMonth(), this.today.getDay());
    L8:
        if (r11 != null) goto L10;
        r11 = CalendarDay.from(this.today.getYear() + 200, this.today.getMonth(), this.today.getDay());
    L10:
        this.rangeIndex = createRangeIndex(r10, r11);
        notifyDataSetChanged();
        invalidateSelectedDates();
    }

    public void setSelectionColor(int r10) {
        this.color = Integer.valueOf(r10);
        Iterator<V> r11 = this.currentViews.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().s(r10);
        goto L4
    }

    public void setSelectionEnabled(boolean r10) {
        this.selectionEnabled = r10;
        Iterator<V> r11 = this.currentViews.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().t(this.selectionEnabled);
        goto L4
    }

    public void setShowOtherDates(int r10) {
        this.showOtherDates = r10;
        Iterator<V> r11 = this.currentViews.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().u(r10);
        goto L4
    }

    public void setShowWeekDays(boolean r10) {
        this.showWeekDays = r10;
    }

    public void setTitleFormatter(@Nullable m9.g r10) {
        if (r10 != null) goto L4;
        r10 = m9.g.f11061a;
    L4:
        this.titleFormatter = r10;
    }

    public void setWeekDayFormatter(m9.h r10) {
        this.weekDayFormatter = r10;
        Iterator<V> r11 = this.currentViews.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().v(r10);
        goto L4
    }

    public void setWeekDayTextAppearance(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.weekDayTextAppearance = Integer.valueOf(r10);
        Iterator<V> r11 = this.currentViews.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().w(r10);
        goto L6
    }
}
