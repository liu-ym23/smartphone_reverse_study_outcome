package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class DaysOfWeekAdapter extends BaseAdapter {
    private static final int CALENDAR_DAY_STYLE = 0;
    private static final int NARROW_FORMAT = 4;

    @NonNull
    private final Calendar calendar;
    private final int daysInWeek;
    private final int firstDayOfWeek;

    static {
        CALENDAR_DAY_STYLE = 4;
    }

    public DaysOfWeekAdapter() {
        Calendar r5 = UtcDates.getUtcCalendar();
        this.calendar = r5;
        this.daysInWeek = r5.getMaximum(7);
        this.firstDayOfWeek = r5.getFirstDayOfWeek();
    }

    private int positionToDayOfWeek(int r5) {
        int r10 = r5 + this.firstDayOfWeek;
        int r11 = this.daysInWeek;
        if (r10 > r11) goto L5;
        return r10;
    L5:
        return r10 - r11;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.daysInWeek;
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r5) {
        return getItem(r5);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r5) {
        return 0;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int r5, @Nullable View r10, @NonNull ViewGroup r11) {
        TextView r12 = (TextView) r10;
        if (r10 != null) goto L5;
        r12 = (TextView) LayoutInflater.from(r11.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, r11, false);
    L5:
        this.calendar.set(7, positionToDayOfWeek(r5));
        Locale r13 = r12.getResources().getConfiguration().locale;
        r12.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, r13));
        r12.setContentDescription(String.format(r11.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), new Object[]{this.calendar.getDisplayName(7, 2, Locale.getDefault())}));
        return r12;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Integer getItem(int r5) {
        if (r5 < this.daysInWeek) goto L7;
        return null;
    L7:
        return Integer.valueOf(positionToDayOfWeek(r5));
    }

    public DaysOfWeekAdapter(int r5) {
        Calendar r10 = UtcDates.getUtcCalendar();
        this.calendar = r10;
        this.daysInWeek = r10.getMaximum(7);
        this.firstDayOfWeek = r5;
    }
}
