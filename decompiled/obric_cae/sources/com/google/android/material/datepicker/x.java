package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.cae.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class x extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CalendarConstraints f4741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DateSelector<?> f4742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DayViewDecorator f4743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i.f f4744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4745g;

    public static class a extends RecyclerView.c0 {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final TextView f4746t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final MaterialCalendarGridView f4747u;

        public a(LinearLayout r8, boolean r10) {
            super(r8);
            TextView r11 = (TextView) r8.findViewById(R.id.month_title);
            this.f4746t = r11;
            WeakHashMap<View, j0.h0> r12 = j0.w.f8437a;
            new j0.v().e(r11, Boolean.TRUE);
            this.f4747u = (MaterialCalendarGridView) r8.findViewById(R.id.month_grid);
            if (r10 == true) goto L6;
            r11.setVisibility(8);
            return;
        }
    }

    public x(ContextThemeWrapper r8, DateSelector r10, CalendarConstraints r11, DayViewDecorator r12, i.d r13) {
        Calendar r14 = r11.f4599a.f4621a;
        Month r15 = r11.f4602n;
        if (r14.compareTo(r15.f4621a) > 0) goto L19;
        if (r15.f4621a.compareTo(r11.f4600b.f4621a) > 0) goto L17;
        int r16 = v.f4731q;
        int r17 = i.f4683y;
        int r18 = r8.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * r16;
        if (r.f(r8) == false) goto L9;
        int r19 = r8.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    L10:
        this.f4745g = r18 + r19;
        this.f4741c = r11;
        this.f4742d = r10;
        this.f4743e = r12;
        this.f4744f = r13;
        if (this.f2302a.a() == true) goto L15;
        this.f2303b = true;
        return;
    L15:
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    L9:
        r19 = 0;
        goto L10
    L17:
        throw new IllegalArgumentException("currentPage cannot be after lastPage");
    L19:
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int a() {
        return this.f4741c.f4605q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final long b(int r8) {
        Calendar r10 = g0.c(this.f4741c.f4599a.f4621a);
        r10.add(2, r8);
        return new Month(r10).f4621a.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void c(RecyclerView.c0 r8, int r10) {
        a r11 = (a) r8;
        CalendarConstraints r12 = this.f4741c;
        Calendar r13 = g0.c(r12.f4599a.f4621a);
        r13.add(2, r10);
        Month r14 = new Month(r13);
        r11.f4746t.setText(r14.v());
        MaterialCalendarGridView r15 = (MaterialCalendarGridView) r11.f4747u.findViewById(R.id.month_grid);
        if (r15.a() != null) goto L5;
    L17:
        v r16 = new v(r14, this.f4742d, r12, this.f4743e);
        r15.setNumColumns(r14.f4624n);
        r15.setAdapter(r16);
    L18:
        r15.setOnItemClickListener(new w(this, r15));
        return;
    L5:
        if (r14.equals(r15.a().f4733a) == false) goto L17;
        r15.invalidate();
        v r17 = r15.a();
        Iterator<Long> r18 = r17.f4735m.iterator();
    L8:
        if (r18.hasNext() == false) goto L10;
        r17.e(r15, r18.next().longValue());
        goto L8
    L10:
        DateSelector<?> r19 = r17.f4734b;
        if (r19 == null) goto L18;
        Iterator r20 = r19.i().iterator();
    L14:
        if (r20.hasNext() == false) goto L16;
        r17.e(r15, ((Long) r20.next()).longValue());
        goto L14
    L16:
        r17.f4735m = r19.i();
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.c0 d(RecyclerView r8) {
        LinearLayout r10 = (LinearLayout) LayoutInflater.from(r8.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, r8, false);
        if (r.f(r8.getContext()) == false) goto L6;
        r10.setLayoutParams(new RecyclerView.p(-1, this.f4745g));
        return new a(r10, true);
    L6:
        return new a(r10, false);
    }
}
