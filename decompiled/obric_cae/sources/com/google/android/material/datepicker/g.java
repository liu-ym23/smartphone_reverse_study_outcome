package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.obric.cae.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f4675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4676b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4677m;

    public g() {
        Calendar r8 = g0.g(null);
        this.f4675a = r8;
        this.f4676b = r8.getMaximum(7);
        this.f4677m = r8.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4676b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r8) {
        int r10 = this.f4676b;
        if (r8 < r10) goto L5;
        return null;
    L5:
        int r11 = r8 + this.f4677m;
        if (r11 <= r10) goto L9;
        r11 = r11 - r10;
    L9:
        return Integer.valueOf(r11);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r8) {
        return 0;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public final View getView(int r8, View r10, ViewGroup r11) {
        TextView r12 = (TextView) r10;
        if (r10 != null) goto L5;
        r12 = (TextView) LayoutInflater.from(r11.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, r11, false);
    L5:
        int r13 = r8 + this.f4677m;
        int r14 = this.f4676b;
        if (r13 <= r14) goto L8;
        r13 = r13 - r14;
    L8:
        Calendar r15 = this.f4675a;
        r15.set(7, r13);
        r12.setText(r15.getDisplayName(7, 4, r12.getResources().getConfiguration().locale));
        r12.setContentDescription(String.format(r11.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), new Object[]{r15.getDisplayName(7, 2, Locale.getDefault())}));
        return r12;
    }

    public g(int r8) {
        Calendar r10 = g0.g(null);
        this.f4675a = r10;
        this.f4676b = r10.getMaximum(7);
        this.f4677m = r8;
    }
}
