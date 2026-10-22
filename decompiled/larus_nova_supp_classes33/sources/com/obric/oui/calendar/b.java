package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.oui.calendar.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class b<V extends c> extends PagerAdapter {
    public final ArrayDeque<V> a;
    public final MaterialCalendarView b;
    public final CalendarDay c;
    public mla.g d;
    public Integer e;
    public Integer f;
    public Integer g;
    public int h;
    public CalendarDay i;
    public CalendarDay j;
    public d k;
    public List<CalendarDay> l;
    public mla.h m;
    public mla.e n;
    public mla.e o;
    public List<f> p;
    public List<h> q;
    public boolean r;
    public boolean s;

    public abstract d f(CalendarDay r1, CalendarDay r2);

    public abstract V g(int r1);

    public final boolean isViewFromObject(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    public abstract int k(V r1);

    public final void l() {
        int r1 = 0;
    L4:
        if (r1 >= this.l.size()) goto L15;
        CalendarDay r2 = (CalendarDay) ListProtector.get(this.l, r1);
        CalendarDay r3 = this.i;
        if (r3 != null) goto L8;
    L9:
        CalendarDay r4 = this.j;
        if (r4 == null) goto L14;
        if (r4.a.isBefore(r2.a) == false) goto L14;
    L13:
        ListProtector.remove(this.l, r1);
        this.b.b(r2, false);
        r1 = r1 - 1;
    L14:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r3.a.isAfter(r2.a) == true) goto L13;
    L15:
        Iterator<V> r0 = this.a.iterator();
    L17:
        if (r0.hasNext() == false) goto L19;
        r0.next().j(this.l);
        goto L17
    }

    public abstract boolean m(Object r1);

    public final int getCount() {
        return this.k.getCount();
    }

    public final List<CalendarDay> j() {
        return Collections.unmodifiableList(this.l);
    }

    public b(MaterialCalendarView r3) {
        this.d = mla.g.a;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 4;
        this.i = null;
        this.j = null;
        this.l = new ArrayList();
        this.m = mla.h.a;
        mla.c r1 = mla.e.a;
        this.n = r1;
        this.o = r1;
        this.p = new ArrayList();
        this.q = null;
        this.r = true;
        this.b = r3;
        this.c = CalendarDay.e();
        ArrayDeque<V> r4 = new ArrayDeque();
        this.a = r4;
        r4.iterator();
        p(null, null);
    }

    public final int getItemPosition(Object r3) {
        if (m(r3) == true) goto L5;
        return -2;
    L5:
        c r4 = (c) r3;
        if (r4.f != null) goto L8;
        return -2;
    L8:
        int r5 = k(r4);
        if (r5 >= 0) goto L11;
        return -2;
    L11:
        return r5;
    }

    public final CharSequence getPageTitle(int r2) {
        return this.d.a(i(r2));
    }

    public final int h(CalendarDay r3) {
        if (r3 == null) goto L4;
        CalendarDay r0 = this.i;
        if (r0 != null) goto L8;
    L11:
        CalendarDay r1 = this.j;
        if (r1 == null) goto L18;
        if (r3.a.isAfter(r1.a) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.k.a(r3);
    L8:
        if (r3.a.isBefore(r0.a) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    public final CalendarDay i(int r2) {
        return this.k.getItem(r2);
    }

    public final Object instantiateItem(ViewGroup r3, int r4) {
        c r5 = g(r4);
        r5.setContentDescription(this.b.getCalendarContentDescription());
        r5.setAlpha(0.0f);
        r5.l(this.r);
        r5.m(this.m);
        r5.g(this.n);
        r5.h(this.o);
        Integer r0 = this.e;
        if (r0 == null) goto L5;
        r5.k(r0.intValue());
    L5:
        boolean r1 = r5 instanceof b0;
        CalendarMode r2 = CalendarMode.MONTHS;
        Iterator r6 = ((ArrayList) r5.j).iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((e) r6.next()).b();
        goto L7
    L9:
        Integer r7 = this.f;
        if (r7 == null) goto L12;
        r5.f(r7.intValue());
    L12:
        Integer r8 = this.g;
        if (r8 == null) goto L15;
        r5.n(r8.intValue());
    L15:
        r5.d = this.h;
        r5.o();
        r5.g = this.i;
        r5.o();
        r5.h = this.j;
        r5.o();
        r5.j(this.l);
        r3.addView(r5);
        this.a.add((V) r5);
        r5.i(this.q);
        return r5;
    }

    public final void n(CalendarDay r3, CalendarDay r4) {
        this.l.clear();
        LocalDate r5 = LocalDate.of(r3.d(), r3.c(), r3.b());
        LocalDate r6 = r4.a;
    L4:
        if (r5.isBefore(r6) == true) goto L10;
        if (r5.equals(r6) == true) goto L10;
        l();
        return;
    L10:
        this.l.add(CalendarDay.a(r5));
        r5 = r5.plusDays(1);
        goto L4
    }

    public final void o(CalendarDay r1, boolean r2) {
        if (r2 == false) goto L7;
        if (this.l.contains(r1) == true) goto L10;
        this.l.add(r1);
        l();
        return;
    L10:
        return;
    L7:
        if (this.l.contains(r1) == false) goto L12;
        this.l.remove(r1);
        l();
        return;
    }

    public final void p(CalendarDay r4, CalendarDay r5) {
        this.i = r4;
        this.j = r5;
        Iterator<V> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        V r1 = r0.next();
        r1.g = r4;
        r1.o();
        r1.h = r5;
        r1.o();
        goto L4
    L6:
        if (r4 != null) goto L8;
        r4 = new CalendarDay(this.c.d() - 200, this.c.c(), this.c.b());
    L8:
        if (r5 != null) goto L10;
        r5 = new CalendarDay(this.c.d() + ErrorCode.ENTITY_NOT_EXIST_ERROR, this.c.c(), this.c.b());
    L10:
        this.k = f(r4, r5);
        notifyDataSetChanged();
        l();
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        c r4 = (c) r3;
        this.a.remove(r4);
        r1.removeView(r4);
    }
}
