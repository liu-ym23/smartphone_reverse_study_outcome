package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class g extends BaseAdapter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f3223k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Month f3224c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final DateSelector<?> f3225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Collection<Long> f3226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    b f3227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final CalendarConstraints f3228j;

    static {
        f3223k = j.q().getMaximum(4);
    }

    g(Month r10, DateSelector<?> r11, CalendarConstraints r12) {
        this.f3224c = r10;
        this.f3225g = r11;
        this.f3228j = r12;
        this.f3226h = r11.getSelectedDays();
    }

    private void e(Context r10) {
        if (this.f3227i != null) goto L6;
        this.f3227i = new b(r10);
        return;
    }

    private boolean h(long r10) {
        Iterator<Long> r11 = this.f3225g.getSelectedDays().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        long r12 = r11.next().longValue();
        if (j.a(r10) != j.a(r12)) goto L4;
        return true;
    L9:
        return false;
    }

    private void k(@Nullable TextView r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f3228j.getDateValidator().isValid(r11) == false) goto L13;
        r10.setEnabled(true);
        if (h(r11) == false) goto L9;
        a r12 = this.f3227i.f3202b;
    L14:
        r12.d(r10);
        return;
    L9:
        long r13 = j.o().getTimeInMillis();
        b r14 = this.f3227i;
        if (r13 != r11) goto L12;
        r12 = r14.f3203c;
        goto L14
    L12:
        r12 = r14.f3201a;
        goto L14
    L13:
        r10.setEnabled(false);
        r12 = this.f3227i.f3207g;
        goto L14
    }

    private void l(MaterialCalendarGridView r10, long r11) {
        if (Month.create(r11).equals(this.f3224c) == false) goto L6;
        int r12 = this.f3224c.getDayOfMonth(r11);
        k((TextView) r10.getChildAt(r10.b().a(r12) - r10.getFirstVisiblePosition()), r11);
        return;
    }

    int a(int r10) {
        return b() + (r10 - 1);
    }

    int b() {
        return this.f3224c.daysFromStartOfWeekToFirstOfMonth();
    }

    @Nullable
    public Long c(int r10) {
        if (r10 >= this.f3224c.daysFromStartOfWeekToFirstOfMonth()) goto L5;
        return null;
    L5:
        if (r10 <= i()) goto L8;
        return null;
    L8:
        return Long.valueOf(this.f3224c.getDay(j(r10)));
    }

    @NonNull
    public TextView d(int r10, @Nullable View r11, @NonNull ViewGroup r12) {
        e(r12.getContext());
        TextView r13 = (TextView) r11;
        if (r11 != null) goto L5;
        r13 = (TextView) LayoutInflater.from(r12.getContext()).inflate(q5.h.mtrl_calendar_day, r12, false);
    L5:
        int r14 = r10 - b();
        if (r14 < 0) goto L15;
        Month r15 = this.f3224c;
        if (r14 >= r15.daysInMonth) goto L15;
        int r16 = r14 + 1;
        r13.setTag(r15);
        r13.setText(String.format(r13.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r16)}));
        long r17 = this.f3224c.getDay(r16);
        if (this.f3224c.year != Month.current().year) goto L13;
        CharSequence r18 = d.g(r17);
    L14:
        r13.setContentDescription(r18);
        r13.setVisibility(0);
        r13.setEnabled(true);
    L16:
        Long r19 = c(r10);
        if (r19 != null) goto L19;
        return r13;
    L19:
        k(r13, r19.longValue());
        return r13;
    L13:
        r18 = d.l(r17);
    L15:
        r13.setVisibility(8);
        r13.setEnabled(false);
        goto L16
    }

    boolean f(int r10) {
        if ((r10 % this.f3224c.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean g(int r10) {
        if (((r10 + 1) % this.f3224c.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3224c.daysInMonth + b();
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return c(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10 / this.f3224c.daysInWeek;
    }

    @Override // android.widget.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ View getView(int r10, @Nullable View r11, @NonNull ViewGroup r12) {
        return d(r10, r11, r12);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i() {
        return (this.f3224c.daysFromStartOfWeekToFirstOfMonth() + this.f3224c.daysInMonth) - 1;
    }

    int j(int r10) {
        return (r10 - this.f3224c.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public void m(MaterialCalendarGridView r10) {
        Iterator<Long> r11 = this.f3226h.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        l(r10, r11.next().longValue());
        goto L4
    L6:
        DateSelector<?> r12 = this.f3225g;
        if (r12 == null) goto L16;
        Iterator<Long> r13 = r12.getSelectedDays().iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        l(r10, r13.next().longValue());
        goto L10
    L12:
        this.f3226h = this.f3225g.getSelectedDays();
        return;
    }

    boolean n(int r10) {
        if (r10 >= b()) goto L5;
    L7:
        return false;
    L5:
        if (r10 > i()) goto L7;
        return true;
    }
}
