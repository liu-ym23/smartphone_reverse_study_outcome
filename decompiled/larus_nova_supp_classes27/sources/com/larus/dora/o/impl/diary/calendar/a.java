package com.larus.dora.o.impl.diary.calendar;

import com.larus.dora.o.impl.diary.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final List<String> a = null;
    public static final SimpleDateFormat b = null;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.calendar.a$a, reason: collision with other inner class name */
    public static final class C0094a {
        public final String a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final i e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0094a) == true) goto L8;
            return false;
        L8:
            C0094a r6 = (C0094a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L10;
            r2 = 1237;
        L10:
            int r4 = (r3 + r2) * 31;
            i r5 = this.e;
            if (r5 != null) goto L13;
            int r6 = 0;
        L15:
            return r4 + r6;
        L13:
            r6 = r5.hashCode();
            goto L15
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "DayCell(date=" + this.a + ", dayOfMonth=" + this.b + ", isToday=" + this.c + ", isFuture=" + this.d + ", brief=" + this.e + ')';
        }

        public C0094a(String r2, int r3, boolean r4, boolean r5, i r6) {
            Intrinsics.checkNotNullParameter(r2, "date");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final List<C0094a> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "MonthData(year=" + this.a + ", month=" + this.b + ", cells=" + this.c + ')';
        }

        public b(int r2, int r3, List<C0094a> r4) {
            Intrinsics.checkNotNullParameter(r4, "cells");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final List<C0094a> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "WeekData(days=" + this.a + ')';
        }

        public c(List<C0094a> r2) {
            Intrinsics.checkNotNullParameter(r2, "days");
            this.a = r2;
        }
    }

    static {
        a = CollectionsKt.listOf(new String[]{"一", "二", "三", "四", "五", "六", "日"});
        b = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public static List b(List r13) {
        Intrinsics.checkNotNullParameter(r13, "briefItems");
        String r0 = b.format(new Date());
        ArrayList r1 = new ArrayList();
        Iterator r14 = r13.iterator();
    L3:
        Pair r3 = null;
        if (r14.hasNext() == false) goto L10;
        i r2 = (i) r14.next();
        String r4 = r2.b();
        if (r4 == null) goto L8;
        r3 = TuplesKt.to(r4, r2);
    L8:
        if (r3 == null) goto L3;
        r1.add(r3);
        goto L3
    L10:
        Map r15 = MapsKt.toMap(r1);
        String r5 = (String) CollectionsKt.minOrNull(r15.keySet());
        if (r5 != null) goto L13;
        r5 = r0;
    L13:
        Calendar r6 = c(r5);
        if (r6 == null) goto L16;
        r6.set(5, 1);
        Calendar r7 = c(r0);
        if (r7 == null) goto L20;
        r7.set(5, 1);
        ArrayList r8 = new ArrayList();
    L23:
        if (r6.getTimeInMillis() > r7.getTimeInMillis()) goto L31;
        int r9 = r6.get(1);
        int r10 = r6.get(2) + 1;
        ArrayList r11 = new ArrayList();
        int r12 = ((r6.get(7) - 2) + 7) % 7;
        int r16 = 0;
        int r17 = 0;
    L25:
        if (r17 >= r12) goto L27;
        r11.add(null);
        r17 = r17 + 1;
        goto L25
    L27:
        int r18 = r6.getActualMaximum(5);
    L28:
        if (r16 >= r18) goto L30;
        r11.add(a(r6, r0, r15));
        r6.add(5, 1);
        r16 = r16 + 1;
        goto L28
    L30:
        r8.add(new b(r9, r10, r11));
        goto L23
    L31:
        return r8;
    L20:
        return CollectionsKt.emptyList();
    L16:
        return CollectionsKt.emptyList();
    }

    public static Calendar c(String r3) {
        Calendar r1 = Calendar.getInstance();     // Catch: Exception -> L9
        r1.setFirstDayOfWeek(2);     // Catch: Exception -> L9
        Date r4 = b.parse(r3);     // Catch: Exception -> L9
        if (r4 != null) goto L6;
        return null;
    L6:
        r1.setTime(r4);     // Catch: Exception -> L9
        return r1;
    L12:
        return null;
    }

    public static int d(List r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "weeks");
        if (r6 != null) goto L5;
        return -1;
    L5:
        Iterator r7 = r5.iterator();
        int r2 = 0;
    L7:
        if (r7.hasNext() == false) goto L29;
        List<C0094a> r3 = ((c) r7.next()).a;
        if ((r3 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((C0094a) r4.next()).a, r6) == false) goto L15;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L23;
        r2 = r2 + 1;
        goto L7
    L23:
        return r2;
    L19:
        r8 = false;
        goto L20
    L11:
        if (r3.isEmpty() == false) goto L13;
    L29:
        return -1;
    }

    public static C0094a a(Calendar r8, String r9, Map r10) {
        String r3 = b.format(r8.getTime());
        int r4 = r8.get(5);
        boolean r5 = Intrinsics.areEqual(r3, r9);
        if (r3.compareTo(r9) <= 0) goto L5;
        boolean r6 = true;
    L7:
        return new C0094a(r3, r4, r5, r6, (i) r10.get(r3));
    L5:
        r6 = false;
        goto L7
    }
}
