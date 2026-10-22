package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NonNull
    private final CalendarConstraints calendarConstraints;
    private final DateSelector<?> dateSelector;

    @Nullable
    private final DayViewDecorator dayViewDecorator;
    private final int itemHeight;
    private final MaterialCalendar.OnDayClickListener onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        public ViewHolder(@NonNull LinearLayout r5, boolean r10) {
            super(r5);
            TextView r11 = (TextView) r5.findViewById(R.id.month_title);
            this.monthTitle = r11;
            ViewCompat.setAccessibilityHeading(r11, true);
            this.monthGrid = (MaterialCalendarGridView) r5.findViewById(R.id.month_grid);
            if (r10 == true) goto L6;
            r11.setVisibility(8);
            return;
        }
    }

    public MonthsPagerAdapter(@NonNull Context r5, DateSelector<?> r10, @NonNull CalendarConstraints r11, @Nullable DayViewDecorator r12, MaterialCalendar.OnDayClickListener r13) {
        Month r14 = r11.getStart();
        Month r15 = r11.getEnd();
        Month r16 = r11.getOpenAt();
        if (r14.compareTo2(r16) > 0) goto L15;
        if (r16.compareTo2(r15) > 0) goto L13;
        int r17 = MonthAdapter.MAXIMUM_WEEKS;
        int r18 = MaterialCalendar.getDayHeight(r5) * r17;
        if (MaterialDatePicker.isFullscreen(r5) == false) goto L9;
        int r19 = MaterialCalendar.getDayHeight(r5);
    L10:
        this.itemHeight = r18 + r19;
        this.calendarConstraints = r11;
        this.dateSelector = r10;
        this.dayViewDecorator = r12;
        this.onDayClickListener = r13;
        setHasStableIds(true);
        return;
    L9:
        r19 = 0;
        goto L10
    L13:
        throw new IllegalArgumentException("currentPage cannot be after lastPage");
    L15:
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    public static /* synthetic */ MaterialCalendar.OnDayClickListener access$000(MonthsPagerAdapter r5) {
        return r5.onDayClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r5) {
        return this.calendarConstraints.getStart().monthsLater(r5).getStableId();
    }

    @NonNull
    public Month getPageMonth(int r5) {
        return this.calendarConstraints.getStart().monthsLater(r5);
    }

    @NonNull
    public CharSequence getPageTitle(int r5) {
        return getPageMonth(r5).getLongName();
    }

    public int getPosition(@NonNull Month r5) {
        return this.calendarConstraints.getStart().monthsUntil(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r5, int r10) {
        onBindViewHolder((ViewHolder) r5, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
        return onCreateViewHolder(r5, r10);
    }

    public void onBindViewHolder(@NonNull ViewHolder r5, int r10) {
        Month r11 = this.calendarConstraints.getStart().monthsLater(r10);
        r5.monthTitle.setText(r11.getLongName());
        final MaterialCalendarGridView r12 = (MaterialCalendarGridView) r5.monthGrid.findViewById(R.id.month_grid);
        if (r12.getAdapter() != null) goto L5;
    L7:
        MonthAdapter r13 = new MonthAdapter(r11, this.dateSelector, this.calendarConstraints, this.dayViewDecorator);
        r12.setNumColumns(r11.daysInWeek);
        r12.setAdapter(r13);
    L8:
        r12.setOnItemClickListener(new AnonymousClass1(this, r12));
        return;
    L5:
        if (r11.equals(r12.getAdapter().month) == false) goto L7;
        r12.invalidate();
        r12.getAdapter().updateSelectedStates(r12);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
        LinearLayout r11 = (LinearLayout) LayoutInflater.from(r5.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, r5, false);
        if (MaterialDatePicker.isFullscreen(r5.getContext()) == false) goto L7;
        r11.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(r11, true);
    L7:
        return new ViewHolder(r11, false);
    }
}
