package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NonNull
    private final CalendarConstraints calendarConstraints;
    private final DateSelector<?> dateSelector;
    private final int itemHeight;
    private final MaterialCalendar.f onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(@NonNull LinearLayout r10, boolean r11) {
            super(r10);
            TextView r12 = (TextView) r10.findViewById(q5.f.month_title);
            this.monthTitle = r12;
            ViewCompat.setAccessibilityHeading(r12, true);
            this.monthGrid = (MaterialCalendarGridView) r10.findViewById(q5.f.month_grid);
            if (r11 == true) goto L6;
            r12.setVisibility(8);
            return;
        }
    }

    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f3181c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MonthsPagerAdapter f3182g;

        a(MonthsPagerAdapter r10, MaterialCalendarGridView r11) {
            this.f3182g = r10;
            this.f3181c = r11;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r10, View r11, int r12, long r13) {
            if (this.f3181c.b().n(r12) == false) goto L6;
            MonthsPagerAdapter.access$000(this.f3182g).a(this.f3181c.b().c(r12).longValue());
            return;
        }
    }

    MonthsPagerAdapter(@NonNull Context r10, DateSelector<?> r11, @NonNull CalendarConstraints r12, MaterialCalendar.f r13) {
        Month r14 = r12.getStart();
        Month r15 = r12.getEnd();
        Month r16 = r12.getOpenAt();
        if (r14.compareTo2(r16) > 0) goto L15;
        if (r16.compareTo2(r15) > 0) goto L13;
        int r17 = g.f3223k * MaterialCalendar.getDayHeight(r10);
        if (MaterialDatePicker.isFullscreen(r10) == false) goto L9;
        int r18 = MaterialCalendar.getDayHeight(r10);
    L10:
        this.itemHeight = r17 + r18;
        this.calendarConstraints = r12;
        this.dateSelector = r11;
        this.onDayClickListener = r13;
        setHasStableIds(true);
        return;
    L9:
        r18 = 0;
        goto L10
    L13:
        throw new IllegalArgumentException("currentPage cannot be after lastPage");
    L15:
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    static /* synthetic */ MaterialCalendar.f access$000(MonthsPagerAdapter r10) {
        return r10.onDayClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        return this.calendarConstraints.getStart().monthsLater(r10).getStableId();
    }

    @NonNull
    Month getPageMonth(int r10) {
        return this.calendarConstraints.getStart().monthsLater(r10);
    }

    @NonNull
    CharSequence getPageTitle(int r10) {
        return getPageMonth(r10).getLongName();
    }

    int getPosition(@NonNull Month r10) {
        return this.calendarConstraints.getStart().monthsUntil(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((ViewHolder) r10, r11);
    }

    public void onBindViewHolder(@NonNull ViewHolder r10, int r11) {
        Month r12 = this.calendarConstraints.getStart().monthsLater(r11);
        r10.monthTitle.setText(r12.getLongName());
        MaterialCalendarGridView r13 = (MaterialCalendarGridView) r10.monthGrid.findViewById(q5.f.month_grid);
        if (r13.b() != null) goto L5;
    L7:
        g r14 = new g(r12, this.dateSelector, this.calendarConstraints);
        r13.setNumColumns(r12.daysInWeek);
        r13.setAdapter(r14);
    L8:
        r13.setOnItemClickListener(new a(this, r13));
        return;
    L5:
        if (r12.equals(r13.b().f3224c) == false) goto L7;
        r13.invalidate();
        r13.b().m(r13);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        LinearLayout r12 = (LinearLayout) LayoutInflater.from(r10.getContext()).inflate(q5.h.mtrl_calendar_month_labeled, r10, false);
        if (MaterialDatePicker.isFullscreen(r10.getContext()) == false) goto L7;
        r12.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(r12, true);
    L7:
        return new ViewHolder(r12, false);
    }
}
