package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class e extends BaseAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f3219i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Calendar f3220c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f3222h;

    static {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r10 = 4;
    L6:
        f3219i = r10;
        return;
    L5:
        r10 = 1;
        goto L6
    }

    public e() {
        Calendar r10 = j.q();
        this.f3220c = r10;
        this.f3221g = r10.getMaximum(7);
        this.f3222h = r10.getFirstDayOfWeek();
    }

    private int b(int r10) {
        int r11 = r10 + this.f3222h;
        int r12 = this.f3221g;
        if (r11 > r12) goto L5;
        return r11;
    L5:
        return r11 - r12;
    }

    @Nullable
    public Integer a(int r10) {
        if (r10 < this.f3221g) goto L7;
        return null;
    L7:
        return Integer.valueOf(b(r10));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3221g;
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return a(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return 0;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int r10, @Nullable View r11, @NonNull ViewGroup r12) {
        TextView r13 = (TextView) r11;
        if (r11 != null) goto L5;
        r13 = (TextView) LayoutInflater.from(r12.getContext()).inflate(q5.h.mtrl_calendar_day_of_week, r12, false);
    L5:
        this.f3220c.set(7, b(r10));
        r13.setText(this.f3220c.getDisplayName(7, f3219i, r13.getResources().getConfiguration().locale));
        r13.setContentDescription(String.format(r12.getContext().getString(q5.j.mtrl_picker_day_of_week_column_header), new Object[]{this.f3220c.getDisplayName(7, 2, Locale.getDefault())}));
        return r13;
    }
}
