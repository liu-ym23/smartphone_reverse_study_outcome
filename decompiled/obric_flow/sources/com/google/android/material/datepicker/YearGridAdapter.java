package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        public ViewHolder(TextView r5) {
            super(r5);
            this.textView = r5;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> r5) {
        this.materialCalendar = r5;
    }

    public static /* synthetic */ MaterialCalendar access$000(YearGridAdapter r5) {
        return r5.materialCalendar;
    }

    @NonNull
    private View.OnClickListener createYearClickListener(final int r5) {
        return new AnonymousClass1(this, r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    public int getPositionForYear(int r5) {
        return r5 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    public int getYearForPosition(int r5) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + r5;
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

    public void onBindViewHolder(@NonNull ViewHolder r10, int r11) {
        int r12 = getYearForPosition(r11);
        r10.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r12)}));
        TextView r5 = r10.textView;
        r5.setContentDescription(DateStrings.getYearContentDescription(r5.getContext(), r12));
        CalendarStyle r13 = this.materialCalendar.getCalendarStyle();
        Calendar r14 = UtcDates.getTodayCalendar();
        if (r14.get(1) != r12) goto L5;
        CalendarItemStyle r15 = r13.todayYear;
    L6:
        Iterator<Long> r16 = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
    L8:
        if (r16.hasNext() == false) goto L12;
        r14.setTimeInMillis(r16.next().longValue());
        if (r14.get(1) != r12) goto L8;
        r15 = r13.selectedYear;
        goto L8
    L12:
        r15.styleItem(r10.textView);
        r10.textView.setOnClickListener(createYearClickListener(r12));
        return;
    L5:
        r15 = r13.year;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
        return new ViewHolder((TextView) LayoutInflater.from(r5.getContext()).inflate(R.layout.mtrl_calendar_year, r5, false));
    }
}
