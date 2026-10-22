package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f3891a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Month f3892b;
    final DateSelector<?> c;
    b d;
    final CalendarConstraints e;
    private Collection<Long> f;

    static {
        f3891a = j.c().getMaximum(4);
    }

    g(Month r3, DateSelector<?> r4, CalendarConstraints r5) {
        DateSelector<?> r6 = (DateSelector) ZeusTransformUtils.wrapperContextForParams(r4, DateSelector.class, "com.obric.memorydata.plugin");
        this.f3892b = r3;
        this.c = r6;
        this.e = r5;
        this.f = r6.getSelectedDays();
    }

    private void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.d != null) goto L6;
        this.d = new b(r4);
        return;
    }

    private void a(TextView r3, long r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.e.getDateValidator().isValid(r4) == false) goto L13;
        r3.setEnabled(true);
        if (a(r4) == false) goto L9;
        a r2 = this.d.f3882b;
    L14:
        r2.a(r3);
        return;
    L9:
        long r0 = j.b().getTimeInMillis();
        b r5 = this.d;
        if (r0 != r4) goto L12;
        r2 = r5.c;
        goto L14
    L12:
        r2 = r5.f3881a;
        goto L14
    L13:
        r3.setEnabled(false);
        r2 = this.d.g;
        goto L14
    }

    private void a(MaterialCalendarGridView r3, long r4) {
        if (Month.create(r4).equals(this.f3892b) == false) goto L6;
        int r0 = this.f3892b.getDayOfMonth(r4);
        a((TextView) ZeusTransformUtils.preCheckCast(r3.getChildAt(r3.a().c(r0) - r3.getFirstVisiblePosition()), TextView.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    private boolean a(long r5) {
        Iterator<Long> r4 = this.c.getSelectedDays().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        long r0 = ((Long) ZeusTransformUtils.preCheckCast(r4.next(), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (j.a(r5) != j.a(r0)) goto L4;
        return true;
    L9:
        return false;
    }

    int a() {
        return this.f3892b.daysFromStartOfWeekToFirstOfMonth();
    }

    public TextView a(int r6, View r7, ViewGroup r8) {
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        r0 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_day, "layout", "mtrl_calendar_day"), r8, false, "com.obric.memorydata.plugin"), TextView.class, "com.obric.memorydata.plugin");
    L5:
        int r9 = r6 - a();
        if (r9 >= 0) goto L8;
    L15:
        r0.setVisibility(8);
        r0.setEnabled(false);
    L16:
        Long r10 = a(r6);
        if (r10 != null) goto L19;
        return r0;
    L19:
        a(r0, r10.longValue());
        return r0;
    L8:
        if (r9 >= this.f3892b.daysInMonth) goto L15;
        int r11 = r9 + 1;
        r0.setTag(this.f3892b);
        r0.setText(String.format(ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getConfiguration().locale, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)}));
        long r3 = this.f3892b.getDay(r11);
        if (this.f3892b.year != Month.current().year) goto L13;
        String r12 = d.d(r3);
    L14:
        r0.setContentDescription(r12);
        r0.setVisibility(0);
        r0.setEnabled(true);
        goto L16
    L13:
        r12 = d.e(r3);
        goto L14
    }

    public Long a(int r2) {
        if (r2 >= this.f3892b.daysFromStartOfWeekToFirstOfMonth()) goto L5;
        return null;
    L5:
        if (r2 <= b()) goto L8;
        return null;
    L8:
        return Long.valueOf(this.f3892b.getDay(b(r2)));
    }

    public void a(MaterialCalendarGridView r6) {
        Iterator<Long> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a(r6, ((Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L4
    L6:
        DateSelector<?> r1 = this.c;
        if (r1 == null) goto L16;
        Iterator<Long> r2 = r1.getSelectedDays().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        a(r6, ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L10
    L12:
        this.f = this.c.getSelectedDays();
        return;
    }

    int b() {
        return (this.f3892b.daysFromStartOfWeekToFirstOfMonth() + this.f3892b.daysInMonth) - 1;
    }

    int b(int r1) {
        return (r1 - this.f3892b.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    int c(int r1) {
        return a() + (r1 - 1);
    }

    boolean d(int r2) {
        if (r2 >= a()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > b()) goto L7;
        return true;
    }

    boolean e(int r1) {
        if ((r1 % this.f3892b.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean f(int r2) {
        if (((r2 + 1) % this.f3892b.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3892b.daysInMonth + a();
    }

    @Override // android.widget.Adapter
    public /* synthetic */ Object getItem(int r1) {
        return a(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1 / this.f3892b.daysInWeek;
    }

    @Override // android.widget.Adapter
    public /* synthetic */ View getView(int r1, View r2, ViewGroup r3) {
        return a(r1, r2, r3);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
