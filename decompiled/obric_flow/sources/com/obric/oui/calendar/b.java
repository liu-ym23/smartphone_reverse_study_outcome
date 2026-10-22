package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f12238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaterialCalendarView f12239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CalendarDay f12240c;
    public yq.b d;
    public Integer e;
    public Integer f;
    public Integer g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f12242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDay f12243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f12244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f12245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public yq.c f12246m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public yq.a f12247n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public yq.a f12248o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f12249p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f12250q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12251r;
    public boolean s;

    public b(MaterialCalendarView r5) {
        this.d = yq.b.f23317n1;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f12241h = 4;
        this.f12242i = null;
        this.f12243j = null;
        this.f12245l = new ArrayList();
        this.f12246m = yq.c.f23318o1;
        zm.z r10 = yq.a.f23316m1;
        this.f12247n = r10;
        this.f12248o = r10;
        this.f12249p = new ArrayList();
        this.f12250q = null;
        this.f12251r = true;
        this.f12239b = r5;
        this.f12240c = CalendarDay.d();
        ArrayDeque r11 = new ArrayDeque();
        this.f12238a = r11;
        r11.iterator();
        i(null, null);
    }

    public abstract e a(CalendarDay r5, CalendarDay r10);

    public abstract d b(int r5);

    public final int c(CalendarDay r5) {
        if (r5 == null) goto L4;
        CalendarDay r10 = this.f12242i;
        LocalDate r11 = r5.f12167a;
        if (r10 != null) goto L8;
    L11:
        CalendarDay r12 = this.f12243j;
        if (r12 == null) goto L18;
        if (r11.isAfter(r12.f12167a) == false) goto L18;
        return this.f12244k.getCount() - 1;
    L18:
        return this.f12244k.a(r5);
    L8:
        if (r11.isBefore(r10.f12167a) == false) goto L11;
        return 0;
    L4:
        return this.f12244k.getCount() / 2;
    }

    public abstract int d(d r5);

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r5, int r10, Object r11) {
        d r12 = (d) r11;
        this.f12238a.remove(r12);
        r5.removeView(r12);
    }

    public final void e() {
        int r5 = 0;
    L4:
        if (r5 >= this.f12245l.size()) goto L15;
        CalendarDay r10 = (CalendarDay) this.f12245l.get(r5);
        CalendarDay r11 = this.f12242i;
        if (r11 != null) goto L8;
    L9:
        CalendarDay r12 = this.f12243j;
        if (r12 == null) goto L14;
        if (r12.f12167a.isBefore(r10.f12167a) == false) goto L14;
    L13:
        this.f12245l.remove(r5);
        this.f12239b.b(r10, false);
        r5 = r5 - 1;
    L14:
        r5 = r5 + 1;
        goto L4
    L8:
        if (r11.f12167a.isAfter(r10.f12167a) == true) goto L13;
    L15:
        Iterator r13 = this.f12238a.iterator();
    L17:
        if (r13.hasNext() == false) goto L19;
        ((d) r13.next()).j(this.f12245l);
        goto L17
    }

    public abstract boolean f(Object r5);

    public final void g(CalendarDay r5, CalendarDay r10) {
        this.f12245l.clear();
        int r11 = r5.f12167a.getYear();
        LocalDate r12 = r5.f12167a;
        LocalDate r13 = LocalDate.of(r11, r12.getMonthValue(), r12.getDayOfMonth());
        LocalDate r14 = r10.f12167a;
    L4:
        if (r13.isBefore(r14) == true) goto L10;
        if (r13.equals(r14) == true) goto L10;
        e();
        return;
    L10:
        this.f12245l.add(CalendarDay.c(r13));
        r13 = r13.plusDays(1);
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f12244k.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r5) {
        if (f(r5) == true) goto L5;
        return -2;
    L5:
        d r10 = (d) r5;
        if (r10.f != null) goto L8;
        return -2;
    L8:
        int r11 = d(r10);
        if (r11 >= 0) goto L11;
        return -2;
    L11:
        return r11;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r5) {
        return this.d.c(this.f12244k.getItem(r5));
    }

    public final void h(CalendarDay r5, boolean r10) {
        if (r10 == false) goto L7;
        if (this.f12245l.contains(r5) == true) goto L10;
        this.f12245l.add(r5);
        e();
        return;
    L10:
        return;
    L7:
        if (this.f12245l.contains(r5) == false) goto L12;
        this.f12245l.remove(r5);
        e();
        return;
    }

    public final void i(CalendarDay r5, CalendarDay r10) {
        this.f12242i = r5;
        this.f12243j = r10;
        Iterator r11 = this.f12238a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        d r12 = (d) r11.next();
        r12.g = r5;
        r12.o();
        r12.f12258h = r10;
        r12.o();
        goto L4
    L6:
        CalendarDay r13 = this.f12240c;
        if (r5 != null) goto L9;
        int r14 = r13.f12167a.getYear() - 200;
        LocalDate r15 = r13.f12167a;
        r5 = new CalendarDay(r14, r15.getMonthValue(), r15.getDayOfMonth());
    L9:
        if (r10 != null) goto L11;
        int r16 = r13.f12167a.getYear() + 200;
        LocalDate r17 = r13.f12167a;
        r10 = new CalendarDay(r16, r17.getMonthValue(), r17.getDayOfMonth());
    L11:
        this.f12244k = a(r5, r10);
        notifyDataSetChanged();
        e();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r5, int r10) {
        d r11 = b(r10);
        r11.setContentDescription(this.f12239b.getCalendarContentDescription());
        r11.setAlpha(0.0f);
        r11.l(this.f12251r);
        r11.m(this.f12246m);
        r11.g(this.f12247n);
        r11.h(this.f12248o);
        Integer r12 = this.e;
        if (r12 == null) goto L5;
        r11.k(r12.intValue());
    L5:
        boolean r13 = r11 instanceof f0;
        Iterator r14 = r11.f12260j.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        ((f) r14.next()).a();
        goto L7
    L9:
        Integer r15 = this.f;
        if (r15 == null) goto L12;
        r11.f(r15.intValue());
    L12:
        Integer r16 = this.g;
        if (r16 == null) goto L15;
        r11.n(r16.intValue());
    L15:
        r11.d = this.f12241h;
        r11.o();
        r11.g = this.f12242i;
        r11.o();
        r11.f12258h = this.f12243j;
        r11.o();
        r11.j(this.f12245l);
        r5.addView(r11);
        this.f12238a.add(r11);
        r11.i(this.f12250q);
        return r11;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r5, Object r10) {
        if (r5 != r10) goto L4;
        return true;
    L4:
        return false;
    }
}
