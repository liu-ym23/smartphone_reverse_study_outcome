package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.obric.cae.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class v extends BaseAdapter {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f4731q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f4732r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f4733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f4734b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Collection<Long> f4735m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f4736n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CalendarConstraints f4737o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DayViewDecorator f4738p;

    static {
        f4731q = g0.g(null).getMaximum(4);
        f4732r = (g0.g(null).getMaximum(7) + g0.g(null).getMaximum(5)) - 1;
    }

    public v(Month r8, DateSelector<?> r10, CalendarConstraints r11, DayViewDecorator r12) {
        this.f4733a = r8;
        this.f4734b = r10;
        this.f4737o = r11;
        this.f4738p = r12;
        this.f4735m = r10.i();
    }

    public final int b() {
        int r8 = this.f4737o.f4603o;
        Month r10 = this.f4733a;
        Calendar r11 = r10.f4621a;
        int r12 = r11.get(7);
        if (r8 > 0) goto L6;
        r8 = r11.getFirstDayOfWeek();
    L6:
        int r13 = r12 - r8;
        if (r13 < 0) goto L9;
        return r13;
    L9:
        return r13 + r10.f4624n;
    }

    public final Long c(int r8) {
        if (r8 < b()) goto L9;
        int r10 = b();
        Month r11 = this.f4733a;
        if (r8 > ((r10 + r11.f4625o) - 1)) goto L11;
        int r12 = (r8 - b()) + 1;
        Calendar r13 = g0.c(r11.f4621a);
        r13.set(5, r12);
        return Long.valueOf(r13.getTimeInMillis());
    L11:
        return null;
    L9:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(TextView r12, long r13, int r15) {
        if (r12 != null) goto L4;
        return;
    L4:
        Context r8 = r12.getContext();
        boolean r10 = true;
        if (g0.f().getTimeInMillis() != r13) goto L7;
        boolean r11 = true;
    L8:
        DateSelector<?> r14 = this.f4734b;
        Iterator r16 = r14.e().iterator();
    L10:
        if (r16.hasNext() == false) goto L16;
        F r17 = ((i0.c) r16.next()).f8079a;
        if (r17 == 0) goto L10;
        if (((Long) r17).longValue() != r13) goto L10;
        boolean r18 = true;
    L17:
        Iterator r19 = r14.e().iterator();
    L19:
        if (r19.hasNext() == false) goto L25;
        S r20 = ((i0.c) r19.next()).f8080b;
        if (r20 == 0) goto L19;
        if (((Long) r20).longValue() != r13) goto L19;
        boolean r21 = true;
    L26:
        Calendar r22 = g0.f();
        Calendar r23 = g0.g(null);
        r23.setTimeInMillis(r13);
        if (r22.get(1) != r23.get(1)) goto L29;
        boolean r24 = true;
    L30:
        if (r24 == false) goto L32;
        String r25 = g0.b("MMMMEEEEd", Locale.getDefault()).format(new Date(r13));
    L33:
        if (r11 == false) goto L35;
        r25 = String.format(r8.getString(R.string.mtrl_picker_today_description), new Object[]{r25});
    L35:
        if (r18 == false) goto L37;
        r25 = String.format(r8.getString(R.string.mtrl_picker_start_date_description), new Object[]{r25});
    L39:
        r12.setContentDescription(r25);
        if (this.f4737o.f4601m.c(r13) == false) goto L59;
        r12.setEnabled(true);
        Iterator r26 = r14.i().iterator();
    L43:
        if (r26.hasNext() == false) goto L47;
        if (g0.a(r13) != g0.a(((Long) r26.next()).longValue())) goto L43;
        boolean r27 = true;
    L48:
        r12.setSelected(r27);
        if (r27 == false) goto L52;
        a r110 = this.f4736n.f4645b;
    L61:
        if (this.f4738p != null) goto L63;
    L65:
        r110.b(r12);
        return;
    L63:
        if (r15 == (-1)) goto L65;
        int r111 = this.f4733a.f4623m;
        r110.b(r12);
        r12.setCompoundDrawables(null, null, null, null);
        r12.setContentDescription(r25);
        return;
    L52:
        if (g0.f().getTimeInMillis() == r13) goto L55;
        r10 = false;
    L55:
        b r112 = this.f4736n;
        if (r10 == false) goto L58;
        r110 = r112.f4646c;
        goto L61
    L58:
        r110 = r112.f4644a;
        goto L61
    L47:
        r27 = false;
        goto L48
    L59:
        r12.setEnabled(false);
        r110 = this.f4736n.f4650g;
        goto L61
    L37:
        if (r21 == false) goto L39;
        r25 = String.format(r8.getString(R.string.mtrl_picker_end_date_description), new Object[]{r25});
        goto L39
    L32:
        r25 = g0.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(r13));
        goto L33
    L29:
        r24 = false;
        goto L30
    L25:
        r21 = false;
        goto L26
    L16:
        r18 = false;
        goto L17
    L7:
        r11 = false;
        goto L8
    }

    public final void e(MaterialCalendarGridView r8, long r10) {
        Month r11 = Month.u(r10);
        Month r12 = this.f4733a;
        if (r11.equals(r12) == false) goto L6;
        Calendar r13 = g0.c(r12.f4621a);
        r13.setTimeInMillis(r10);
        int r14 = r13.get(5);
        d((TextView) r8.getChildAt((r8.a().b() + (r14 - 1)) - r8.getFirstVisiblePosition()), r10, r14);
        return;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f4732r;
    }

    @Override // android.widget.Adapter
    public final /* bridge */ /* synthetic */ Object getItem(int r8) {
        return c(r8);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r8) {
        return r8 / this.f4733a.f4624n;
    }

    @Override // android.widget.Adapter
    public final View getView(int r8, View r10, ViewGroup r11) {
        Context r12 = r11.getContext();
        if (this.f4736n != null) goto L5;
        this.f4736n = new b(r12);
    L5:
        TextView r13 = (TextView) r10;
        if (r10 != null) goto L8;
        r13 = (TextView) LayoutInflater.from(r11.getContext()).inflate(R.layout.mtrl_calendar_day, r11, false);
    L8:
        int r14 = r8 - b();
        if (r14 < 0) goto L14;
        Month r15 = this.f4733a;
        if (r14 >= r15.f4625o) goto L14;
        int r16 = r14 + 1;
        r13.setTag(r15);
        r13.setText(String.format(r13.getResources().getConfiguration().locale, "%d", new Object[]{Integer.valueOf(r16)}));
        r13.setVisibility(0);
        r13.setEnabled(true);
    L15:
        Long r17 = c(r8);
        if (r17 == null) goto L19;
        d(r13, r17.longValue(), r16);
    L19:
        return r13;
    L14:
        r13.setVisibility(8);
        r13.setEnabled(false);
        r16 = -1;
        goto L15
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
