package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class MonthAdapter extends BaseAdapter {
    private static final int MAXIMUM_GRID_CELLS = 0;
    static final int MAXIMUM_WEEKS = 0;
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;

    @Nullable
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    static {
        MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
        MAXIMUM_GRID_CELLS = (UtcDates.getUtcCalendar().getMaximum(7) + UtcDates.getUtcCalendar().getMaximum(5)) - 1;
    }

    public MonthAdapter(Month r5, DateSelector<?> r10, CalendarConstraints r11, @Nullable DayViewDecorator r12) {
        this.month = r5;
        this.dateSelector = r10;
        this.calendarConstraints = r11;
        this.dayViewDecorator = r12;
        this.previouslySelectedDates = r10.getSelectedDays();
    }

    private String getDayContentDescription(Context r10, long r11) {
        return DateStrings.getDayContentDescription(r10, r11, isToday(r11), isStartOfRange(r11), isEndOfRange(r11));
    }

    private void initializeStyles(Context r5) {
        if (this.calendarStyle != null) goto L6;
        this.calendarStyle = new CalendarStyle(r5);
        return;
    }

    private boolean isSelected(long r5) {
        Iterator<Long> r10 = this.dateSelector.getSelectedDays().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        long r11 = r10.next().longValue();
        if (UtcDates.canonicalYearMonthDay(r5) != UtcDates.canonicalYearMonthDay(r11)) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isToday(long r5) {
        if (UtcDates.getTodayCalendar().getTimeInMillis() != r5) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateSelectedState(@Nullable TextView r19, long r20, int r22) {
        if (r19 != null) goto L5;
        return;
    L5:
        Context r10 = r19.getContext();
        String r11 = getDayContentDescription(r10, r20);
        r19.setContentDescription(r11);
        boolean r12 = this.calendarConstraints.getDateValidator().isValid(r20);
        if (r12 == false) goto L15;
        r19.setEnabled(true);
        boolean r5 = isSelected(r20);
        r19.setSelected(r5);
        if (r5 == false) goto L12;
        CalendarItemStyle r13 = this.calendarStyle.selectedDay;
    L10:
        CalendarItemStyle r14 = r13;
        boolean r15 = r5;
    L16:
        DayViewDecorator r16 = this.dayViewDecorator;
        if (r16 != null) goto L19;
    L21:
        r14.styleItem(r19);
        return;
    L19:
        if (r22 == (-1)) goto L21;
        Month r17 = this.month;
        int r18 = r17.year;
        int r21 = r17.month;
        ColorStateList r23 = r16.getBackgroundColor(r10, r18, r21, r22, r12, r15);
        boolean r24 = r15;
        r14.styleItem(r19, r23, this.dayViewDecorator.getTextColor(r10, r18, r21, r22, r12, r24));
        Drawable r110 = this.dayViewDecorator.getCompoundDrawableLeft(r10, r18, r21, r22, r12, r24);
        Drawable r111 = this.dayViewDecorator.getCompoundDrawableTop(r10, r18, r21, r22, r12, r24);
        Drawable r25 = this.dayViewDecorator.getCompoundDrawableRight(r10, r18, r21, r22, r12, r24);
        boolean r26 = r15;
        r19.setCompoundDrawables(r110, r111, r25, this.dayViewDecorator.getCompoundDrawableBottom(r10, r18, r21, r22, r12, r26));
        r19.setContentDescription(this.dayViewDecorator.getContentDescription(r10, r18, r21, r22, r12, r26, r11));
        return;
    L12:
        if (isToday(r20) == false) goto L14;
        r13 = this.calendarStyle.todayDay;
        goto L10
    L14:
        r13 = this.calendarStyle.day;
        goto L10
    L15:
        r19.setEnabled(false);
        r15 = false;
        r14 = this.calendarStyle.invalidDay;
        goto L16
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView r5, long r10) {
        if (Month.create(r10).equals(this.month) == false) goto L6;
        int r11 = this.month.getDayOfMonth(r10);
        updateSelectedState((TextView) r5.getChildAt(r5.getAdapter().dayToPosition(r11) - r5.getFirstVisiblePosition()), r10, r11);
        return;
    }

    public int dayToPosition(int r5) {
        return firstPositionInMonth() + (r5 - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r5) {
        return getItem(r5);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r5) {
        return r5 / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ View getView(int r5, @Nullable View r10, @NonNull ViewGroup r11) {
        return getView(r5, r10, r11);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @VisibleForTesting
    public boolean isEndOfRange(long r5) {
        Iterator<Pair<Long, Long>> r10 = this.dateSelector.getSelectedRanges().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Long r11 = r10.next().second;
        if (r11 == null) goto L4;
        if (r11.longValue() != r5) goto L4;
        return true;
    L11:
        return false;
    }

    public boolean isFirstInRow(int r5) {
        if ((r5 % this.month.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLastInRow(int r5) {
        if (((r5 + 1) % this.month.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @VisibleForTesting
    public boolean isStartOfRange(long r5) {
        Iterator<Pair<Long, Long>> r10 = this.dateSelector.getSelectedRanges().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Long r11 = r10.next().first;
        if (r11 == null) goto L4;
        if (r11.longValue() != r5) goto L4;
        return true;
    L11:
        return false;
    }

    public int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int r5) {
        return (r5 - firstPositionInMonth()) + 1;
    }

    public void updateSelectedStates(MaterialCalendarGridView r5) {
        Iterator<Long> r10 = this.previouslySelectedDates.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        updateSelectedStateForDate(r5, r10.next().longValue());
        goto L4
    L6:
        DateSelector<?> r11 = this.dateSelector;
        if (r11 == null) goto L16;
        Iterator<Long> r12 = r11.getSelectedDays().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        updateSelectedStateForDate(r5, r12.next().longValue());
        goto L10
    L12:
        this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        return;
    }

    public boolean withinMonth(int r5) {
        if (r5 >= firstPositionInMonth()) goto L5;
    L7:
        return false;
    L5:
        if (r5 > lastPositionInMonth()) goto L7;
        return true;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int r5) {
        if (r5 >= firstPositionInMonth()) goto L5;
        return null;
    L5:
        if (r5 <= lastPositionInMonth()) goto L8;
        return null;
    L8:
        return Long.valueOf(this.month.getDay(positionToDay(r5)));
    }

    @Override // android.widget.Adapter
    @NonNull
    public TextView getView(int r10, @Nullable View r11, @NonNull ViewGroup r12) {
        initializeStyles(r12.getContext());
        TextView r5 = (TextView) r11;
        if (r11 != null) goto L5;
        r5 = (TextView) LayoutInflater.from(r12.getContext()).inflate(R.layout.mtrl_calendar_day, r12, false);
    L5:
        int r13 = r10 - firstPositionInMonth();
        if (r13 < 0) goto L11;
        Month r14 = this.month;
        if (r13 >= r14.daysInMonth) goto L11;
        int r15 = r13 + 1;
        r5.setTag(r14);
        r5.setText(String.format(r5.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r15)}));
        r5.setVisibility(0);
        r5.setEnabled(true);
    L12:
        Long r16 = getItem(r10);
        if (r16 != null) goto L15;
        return r5;
    L15:
        updateSelectedState(r5, r16.longValue(), r15);
        return r5;
    L11:
        r5.setVisibility(8);
        r5.setEnabled(false);
        r15 = -1;
        goto L12
    }
}
