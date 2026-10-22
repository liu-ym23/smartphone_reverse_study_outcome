package xb;

import android.database.DataSetObserver;
import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.MaterialCalendarView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;
import xb.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<V extends e> extends i1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<V> f13776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MaterialCalendarView f13777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CalendarDay f13778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f13779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f13780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f13781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDay f13783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CalendarDay f13784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f13785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<CalendarDay> f13786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public yb.g f13787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public yb.e f13788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public yb.e f13789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<h> f13790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<j> f13791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13793t;

    public d(MaterialCalendarView r8) {
        yb.d r10 = yb.f.f14110a;
        this.f13779f = null;
        this.f13780g = null;
        this.f13781h = null;
        this.f13782i = 4;
        this.f13783j = null;
        this.f13784k = null;
        this.f13786m = new ArrayList();
        this.f13787n = yb.g.f14111a;
        yb.c r11 = yb.e.f14109a;
        this.f13788o = r11;
        this.f13789p = r11;
        this.f13790q = new ArrayList();
        this.f13791r = null;
        this.f13792s = true;
        this.f13777d = r8;
        this.f13778e = CalendarDay.A();
        ArrayDeque<V> r12 = new ArrayDeque();
        this.f13776c = r12;
        r12.iterator();
        o(null, null);
    }

    @Override // i1.a
    public final int a() {
        return this.f13785l.getCount();
    }

    public abstract f b(CalendarDay r8, CalendarDay r10);

    public abstract V c(int r8);

    public final int d() {
        Integer r8 = this.f13780g;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.intValue();
    }

    public final int e(CalendarDay r8) {
        if (r8 == null) goto L4;
        CalendarDay r10 = this.f13783j;
        if (r10 != null) goto L8;
    L11:
        CalendarDay r11 = this.f13784k;
        if (r11 == null) goto L18;
        if (r8.y(r11) == false) goto L18;
        return a() - 1;
    L18:
        return this.f13785l.a(r8);
    L8:
        if (r8.z(r10) == false) goto L11;
        return 0;
    L4:
        return a() / 2;
    }

    public final CalendarDay f(int r8) {
        return this.f13785l.getItem(r8);
    }

    public final List<CalendarDay> g() {
        return Collections.unmodifiableList(this.f13786m);
    }

    public final int h() {
        Integer r8 = this.f13781h;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.intValue();
    }

    public abstract int i(V r8);

    public final void j() {
        int r8 = 0;
    L4:
        if (r8 >= this.f13786m.size()) goto L15;
        CalendarDay r10 = this.f13786m.get(r8);
        CalendarDay r11 = this.f13783j;
        if (r11 != null) goto L8;
    L9:
        CalendarDay r12 = this.f13784k;
        if (r12 == null) goto L14;
        if (r12.z(r10) == false) goto L14;
    L13:
        this.f13786m.remove(r8);
        this.f13777d.getClass();
        r8 = r8 - 1;
    L14:
        r8 = r8 + 1;
        goto L4
    L8:
        if (r11.y(r10) == true) goto L13;
    L15:
        Iterator<V> r13 = this.f13776c.iterator();
    L17:
        if (r13.hasNext() == false) goto L19;
        r13.next().k(this.f13786m);
        goto L17
    }

    public abstract boolean k(e r8);

    public final void l(d r8) {
        r8.f13779f = this.f13779f;
        r8.f13780g = this.f13780g;
        r8.f13781h = this.f13781h;
        r8.f13782i = this.f13782i;
        r8.f13783j = this.f13783j;
        r8.f13784k = this.f13784k;
        r8.f13786m = this.f13786m;
        r8.f13787n = this.f13787n;
        r8.f13788o = this.f13788o;
        r8.f13789p = this.f13789p;
        r8.f13790q = this.f13790q;
        r8.f13791r = this.f13791r;
        r8.f13792s = this.f13792s;
    }

    public final void m(CalendarDay r8, CalendarDay r10) {
        this.f13786m.clear();
        LocalDate r11 = LocalDate.of(r8.x(), r8.w(), r8.v());
        LocalDate r12 = r10.u();
    L4:
        if (r11.isBefore(r12) == true) goto L10;
        if (r11.equals(r12) == true) goto L10;
        j();
        return;
    L10:
        this.f13786m.add(CalendarDay.t(r11));
        r11 = r11.plusDays(1);
        goto L4
    }

    public final void n(CalendarDay r8, boolean r10) {
        if (r10 == false) goto L7;
        if (this.f13786m.contains(r8) == true) goto L11;
        this.f13786m.add(r8);
    L9:
        j();
        return;
    L11:
        return;
    L7:
        if (this.f13786m.contains(r8) == false) goto L12;
        this.f13786m.remove(r8);
        goto L9
    }

    public final void o(CalendarDay r8, CalendarDay r10) {
        this.f13783j = r8;
        this.f13784k = r10;
        Iterator<V> r11 = this.f13776c.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        V r12 = r11.next();
        r12.f13800q = r8;
        r12.q();
        r12.f13801r = r10;
        r12.q();
        goto L4
    L6:
        if (r8 != null) goto L8;
        r8 = new CalendarDay(this.f13778e.x() - 200, this.f13778e.w(), this.f13778e.v());
    L8:
        if (r10 != null) goto L10;
        r10 = new CalendarDay(this.f13778e.x() + 200, this.f13778e.w(), this.f13778e.v());
    L10:
        this.f13785l = b(r8, r10);
        monitor-enter(this);
        DataSetObserver r13 = this.f8085b;     // Catch: Throwable -> L18
        if (r13 == null) goto L15;
        r13.onChanged();     // Catch: Throwable -> L18
    L15:
        monitor-exit(this);     // Catch: Throwable -> L18
        this.f8084a.notifyChanged();
        j();
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void p(boolean r8) {
        this.f13793t = r8;
    }
}
