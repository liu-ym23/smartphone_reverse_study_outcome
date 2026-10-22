package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.oui.calendar.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes5.dex */
abstract class CalendarPagerAdapter<V extends b> extends PagerAdapter {
    private Integer color;
    private final ArrayDeque<V> currentViews;
    private Integer dateTextAppearance;
    private com.obric.oui.calendar.a.e dayFormatter;
    private com.obric.oui.calendar.a.e dayFormatterContentDescription;
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
    private com.obric.oui.calendar.a.g titleFormatter;
    private final CalendarDay today;
    private com.obric.oui.calendar.a.h weekDayFormatter;
    private Integer weekDayTextAppearance;

    CalendarPagerAdapter(MaterialCalendarView r3) {
        this.titleFormatter = com.obric.oui.calendar.a.g.f13435a;
        this.color = null;
        this.dateTextAppearance = null;
        this.weekDayTextAppearance = null;
        this.showOtherDates = 4;
        this.minDate = null;
        this.maxDate = null;
        this.selectedDates = new ArrayList();
        this.weekDayFormatter = com.obric.oui.calendar.a.h.f13436a;
        com.obric.oui.calendar.a.e r1 = com.obric.oui.calendar.a.e.f13433a;
        this.dayFormatter = r1;
        this.dayFormatterContentDescription = r1;
        this.decorators = new ArrayList();
        this.decoratorResults = null;
        this.selectionEnabled = true;
        this.mcv = r3;
        this.today = CalendarDay.today();
        ArrayDeque<V> r4 = new ArrayDeque();
        this.currentViews = r4;
        r4.iterator();
        setRangeDates(null, null);
    }

    private void invalidateSelectedDates() {
        validateSelectedDates();
        Iterator<V> r0 = this.currentViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).a(this.selectedDates);
        goto L4
    }

    private void validateSelectedDates() {
        int r0 = 0;
    L4:
        if (r0 >= this.selectedDates.size()) goto L15;
        CalendarDay r1 = (CalendarDay) ZeusTransformUtils.preCheckCast(this.selectedDates.get(r0), CalendarDay.class, "com.obric.memorydata.plugin");
        CalendarDay r2 = this.minDate;
        if (r2 != null) goto L8;
    L9:
        CalendarDay r3 = this.maxDate;
        if (r3 == null) goto L14;
        if (r3.isBefore(r1) == false) goto L14;
    L13:
        this.selectedDates.remove(r0);
        this.mcv.b(r1);
        r0 = r0 - 1;
    L14:
        r0 = r0 + 1;
        goto L4
    L8:
        if (r2.isAfter(r1) == true) goto L13;
    }

    public void clearSelections() {
        this.selectedDates.clear();
        invalidateSelectedDates();
    }

    public abstract c createRangeIndex(CalendarDay r1, CalendarDay r2);

    public abstract V createView(int r1);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r2, int r3, Object r4) {
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
        this.currentViews.remove(r5);
        r2.removeView(r5);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.rangeIndex.a();
    }

    public int getDateTextAppearance() {
        Integer r0 = this.dateTextAppearance;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public int getIndexForDay(CalendarDay r2) {
        if (r2 == null) goto L4;
        CalendarDay r0 = this.minDate;
        if (r0 != null) goto L8;
    L11:
        CalendarDay r1 = this.maxDate;
        if (r1 == null) goto L18;
        if (r2.isAfter(r1) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.rangeIndex.a(r2);
    L8:
        if (r2.isBefore(r0) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    public CalendarDay getItem(int r1) {
        return this.rangeIndex.a(r1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r4) {
        if (isInstanceOfView(r4) == true) goto L6;
        return -2;
    L6:
        if (((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin")).g() != null) goto L8;
        return -2;
    L8:
        int r3 = indexOf((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin"));
        if (r3 >= 0) goto L11;
        return -2;
    L11:
        return r3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r2) {
        return this.titleFormatter.a(getItem(r2));
    }

    public c getRangeIndex() {
        return this.rangeIndex;
    }

    public List<CalendarDay> getSelectedDates() {
        return Collections.unmodifiableList(this.selectedDates);
    }

    public int getShowOtherDates() {
        return this.showOtherDates;
    }

    public int getWeekDayTextAppearance() {
        Integer r0 = this.weekDayTextAppearance;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public abstract int indexOf(V r1);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r2, int r3) {
        b r4 = createView(r3);
        r4.setContentDescription(this.mcv.getCalendarContentDescription());
        r4.setAlpha(0.0f);
        r4.a(this.selectionEnabled);
        r4.a(this.weekDayFormatter);
        r4.a(this.dayFormatter);
        r4.b(this.dayFormatterContentDescription);
        Integer r0 = this.color;
        if (r0 == null) goto L6;
        r4.d(r0.intValue());
    L6:
        if (ZeusTransformUtils.instanceOf(r4, n.class) == false) goto L8;
        CalendarMode r1 = CalendarMode.WEEKS;
    L9:
        r4.a(r1);
        Integer r5 = this.dateTextAppearance;
        if (r5 == null) goto L12;
        r4.b(r5.intValue());
    L12:
        Integer r6 = this.weekDayTextAppearance;
        if (r6 == null) goto L15;
        r4.a(r6.intValue());
    L15:
        r4.c(this.showOtherDates);
        r4.b(this.minDate);
        r4.c(this.maxDate);
        r4.a(this.selectedDates);
        r2.addView(r4);
        this.currentViews.add((V) r4);
        r4.a(this.decoratorResults);
        return r4;
    L8:
        r1 = CalendarMode.MONTHS;
        goto L9
    }

    public void invalidateDecorators() {
        this.decoratorResults = new ArrayList();
        Iterator<d> r0 = this.decorators.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.memorydata.plugin");
        e r2 = new e();
        r1.a(r2);
        if (r2.b() == false) goto L4;
        this.decoratorResults.add(new f(r1, r2));
        goto L4
    L8:
        Iterator<V> r3 = this.currentViews.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).a(this.decoratorResults);
        goto L10
    }

    public abstract boolean isInstanceOfView(Object r1);

    public boolean isShowWeekDays() {
        return this.showWeekDays;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    public CalendarPagerAdapter<?> migrateStateAndReturn(CalendarPagerAdapter<?> r2) {
        r2.titleFormatter = this.titleFormatter;
        r2.color = this.color;
        r2.dateTextAppearance = this.dateTextAppearance;
        r2.weekDayTextAppearance = this.weekDayTextAppearance;
        r2.showOtherDates = this.showOtherDates;
        r2.minDate = this.minDate;
        r2.maxDate = this.maxDate;
        r2.selectedDates = this.selectedDates;
        r2.weekDayFormatter = this.weekDayFormatter;
        r2.dayFormatter = this.dayFormatter;
        r2.dayFormatterContentDescription = this.dayFormatterContentDescription;
        r2.decorators = this.decorators;
        r2.decoratorResults = this.decoratorResults;
        r2.selectionEnabled = this.selectionEnabled;
        return r2;
    }

    public void selectRange(CalendarDay r3, CalendarDay r4) {
        this.selectedDates.clear();
        LocalDate r5 = LocalDate.of(r3.getYear(), r3.getMonth(), r3.getDay());
        LocalDate r6 = r4.getDate();
    L4:
        if (r5.isBefore(r6) == true) goto L10;
        if (r5.equals(r6) == true) goto L10;
        invalidateSelectedDates();
        return;
    L10:
        this.selectedDates.add(CalendarDay.from(r5));
        r5 = r5.plusDays(1);
        goto L4
    }

    public void setDateSelected(CalendarDay r1, boolean r2) {
        if (r2 == false) goto L7;
        if (this.selectedDates.contains(r1) == true) goto L11;
        this.selectedDates.add(r1);
    L9:
        invalidateSelectedDates();
        return;
    L11:
        return;
    L7:
        if (this.selectedDates.contains(r1) == false) goto L12;
        this.selectedDates.remove(r1);
        goto L9
    }

    public void setDateTextAppearance(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.dateTextAppearance = Integer.valueOf(r4);
        Iterator<V> r3 = this.currentViews.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).b(r4);
        goto L6
    }

    public void setDayFormatter(com.obric.oui.calendar.a.e r4) {
        com.obric.oui.calendar.a.e r5 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin");
        com.obric.oui.calendar.a.e r0 = this.dayFormatterContentDescription;
        if (r0 != this.dayFormatter) goto L5;
        r0 = r5;
    L5:
        this.dayFormatterContentDescription = r0;
        this.dayFormatter = r5;
        Iterator<V> r3 = this.currentViews.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).a(r5);
        goto L7
    }

    public void setDayFormatterContentDescription(com.obric.oui.calendar.a.e r4) {
        com.obric.oui.calendar.a.e r5 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin");
        this.dayFormatterContentDescription = r5;
        Iterator<V> r3 = this.currentViews.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).b(r5);
        goto L4
    }

    public void setDecorators(List<d> r3) {
        this.decorators = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        invalidateDecorators();
    }

    public void setRangeDates(CalendarDay r5, CalendarDay r6) {
        this.minDate = r5;
        this.maxDate = r6;
        Iterator<V> r0 = this.currentViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
        r1.b(r5);
        r1.c(r6);
        goto L4
    L6:
        if (r5 != null) goto L8;
        r5 = CalendarDay.from(this.today.getYear() - 200, this.today.getMonth(), this.today.getDay());
    L8:
        if (r6 != null) goto L10;
        r6 = CalendarDay.from(this.today.getYear() + 200, this.today.getMonth(), this.today.getDay());
    L10:
        this.rangeIndex = createRangeIndex(r5, r6);
        notifyDataSetChanged();
        invalidateSelectedDates();
    }

    public void setSelectionColor(int r4) {
        this.color = Integer.valueOf(r4);
        Iterator<V> r3 = this.currentViews.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).d(r4);
        goto L4
    }

    public void setSelectionEnabled(boolean r4) {
        this.selectionEnabled = r4;
        Iterator<V> r5 = this.currentViews.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin")).a(this.selectionEnabled);
        goto L4
    }

    public void setShowOtherDates(int r4) {
        this.showOtherDates = r4;
        Iterator<V> r3 = this.currentViews.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).c(r4);
        goto L4
    }

    public void setShowWeekDays(boolean r1) {
        this.showWeekDays = r1;
    }

    public void setTitleFormatter(com.obric.oui.calendar.a.g r3) {
        com.obric.oui.calendar.a.g r4 = (com.obric.oui.calendar.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.g.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.g.f13435a;
    L5:
        this.titleFormatter = r4;
    }

    public void setWeekDayFormatter(com.obric.oui.calendar.a.h r4) {
        com.obric.oui.calendar.a.h r5 = (com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.calendar.a.h.class, "com.obric.memorydata.plugin");
        this.weekDayFormatter = r5;
        Iterator<V> r3 = this.currentViews.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).a(r5);
        goto L4
    }

    public void setWeekDayTextAppearance(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.weekDayTextAppearance = Integer.valueOf(r4);
        Iterator<V> r3 = this.currentViews.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).a(r4);
        goto L6
    }
}
