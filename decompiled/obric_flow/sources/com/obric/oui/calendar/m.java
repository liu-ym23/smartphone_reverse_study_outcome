package com.obric.oui.calendar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CalendarMode f12285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DayOfWeek f12286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CalendarDay f12287c;
    public CalendarDay d;
    public boolean e;
    public boolean f;
    public final /* synthetic */ MaterialCalendarView g;

    public m(MaterialCalendarView r5, m r10) {
        this.g = r5;
        this.f12285a = r10.f12285a;
        this.f12286b = r10.f12286b;
        this.f12287c = r10.f12287c;
        this.d = r10.d;
        this.e = r10.e;
        this.f = r10.f;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a() {
        MaterialCalendarView r5 = this.g;
        m r10 = new m(r5, this);
        b r11 = r5.f;
        CalendarMode r12 = r10.f12285a;
        CalendarPager r13 = r5.e;
        if (r11 != null) goto L5;
    L32:
        CalendarDay r14 = null;
    L33:
        r5.B = r10;
        r5.f12174i = r12;
        r5.f12189y = r10.f12286b;
        r5.f12176k = r10.f12287c;
        r5.f12177l = r10.d;
        r5.f12190z = r10.f;
        int r15 = j.f12282a[r12.ordinal()];
        if (r15 != 1) goto L36;
        b r16 = new n(r5);
    L41:
        b r17 = r5.f;
        if (r17 != null) goto L44;
        r5.f = r16;
    L45:
        b r18 = r5.f;
        r18.s = r5.f12190z;
        r13.setAdapter(r18);
        CalendarDay r19 = r5.f12176k;
        CalendarDay r20 = r5.f12177l;
        CalendarDay r21 = r5.g;
        r5.f.i(r19, r20);
        r5.g = r21;
        if (r19 != null) goto L48;
    L52:
        r13.setCurrentItem(r5.f.c(r21), false);
        r5.e();
        if (r5.f12187w == 1) goto L55;
    L57:
        CalendarDay r22 = CalendarDay.d();
    L58:
        r5.setCurrentDate(r22);
        if (r14 == null) goto L61;
        r13.setCurrentItem(r5.f.c(r14));
    L61:
        b r23 = r5.f;
        r23.getClass();
        r23.f12250q = new ArrayList();
        Iterator r24 = r23.f12249p.iterator();
        if (r24.hasNext() == true) goto L70;
        Iterator r25 = r23.f12238a.iterator();
    L65:
        if (r25.hasNext() == false) goto L67;
        ((d) r25.next()).i(r23.f12250q);
        goto L65
    L67:
        r5.e();
        return;
    L70:
        if (r24.next() != null) goto L74;
        new LinkedList();
        throw null;
    L74:
        throw new ClassCastException();
    L55:
        if (Collections.unmodifiableList(r5.f.f12245l).isEmpty() == true) goto L57;
        r22 = (CalendarDay) Collections.unmodifiableList(r5.f.f12245l).get(0);
        goto L58
    L48:
        if (r19.f12167a.isAfter(r21.f12167a) == true) goto L51;
        r19 = r5.g;
    L51:
        r5.g = r19;
        goto L52
    L44:
        r16.d = r17.d;
        r16.e = r17.e;
        r16.f = r17.f;
        r16.g = r17.g;
        r16.f12241h = r17.f12241h;
        r16.f12242i = r17.f12242i;
        r16.f12243j = r17.f12243j;
        r16.f12245l = r17.f12245l;
        r16.f12246m = r17.f12246m;
        r16.f12247n = r17.f12247n;
        r16.f12248o = r17.f12248o;
        r16.f12249p = r17.f12249p;
        r16.f12250q = r17.f12250q;
        r16.f12251r = r17.f12251r;
        r5.f = r16;
        goto L45
    L36:
        if (r15 != 2) goto L39;
        r16 = new WeekPagerAdapter(r5);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (r10.e == false) goto L32;
        r14 = r11.f12244k.getItem(r13.getCurrentItem());
        if (r5.f12174i == r12) goto L33;
        CalendarDay r26 = r5.getSelectedDate();
        CalendarMode r27 = r5.f12174i;
        if (r27 != CalendarMode.MONTHS) goto L19;
        if (r26 == null) goto L19;
        CalendarDay r28 = CalendarDay.c(r14.f12167a.plusDays(1));
        if (r26.equals(r14) == true) goto L30;
        LocalDate r29 = r14.f12167a;
        LocalDate r30 = r26.f12167a;
        if (r30.isAfter(r29) == false) goto L33;
        if (r30.isBefore(r28.f12167a) == false) goto L33;
    L30:
        r14 = r26;
    L19:
        if (r27 != CalendarMode.WEEKS) goto L33;
        CalendarDay r31 = CalendarDay.c(r14.f12167a.plusDays(6));
        if (r26 != null) goto L23;
    L31:
        r14 = r31;
        goto L33
    L23:
        if (r26.equals(r14) == true) goto L30;
        if (r26.equals(r31) == true) goto L30;
        LocalDate r32 = r14.f12167a;
        LocalDate r33 = r26.f12167a;
        if (r33.isAfter(r32) == false) goto L31;
        if (r33.isBefore(r31.f12167a) == false) goto L31;
        goto L30
    }

    public m(MaterialCalendarView r5) {
        this.g = r5;
        this.e = false;
        this.f12287c = null;
        this.d = null;
        this.f12285a = CalendarMode.MONTHS;
        this.f12286b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
    }

    public m(MaterialCalendarView r5, m r10, boolean r11) {
        this.g = r5;
        this.e = false;
        this.f12287c = null;
        this.d = null;
        this.f12285a = r10.f12285a;
        this.f12286b = r10.f12286b;
        this.f12287c = r10.f12287c;
        this.d = r10.d;
        this.e = r10.e;
        this.f = r10.f;
    }
}
