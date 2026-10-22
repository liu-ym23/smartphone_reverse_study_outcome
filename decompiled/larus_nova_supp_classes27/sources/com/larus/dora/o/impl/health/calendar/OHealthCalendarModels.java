package com.larus.dora.o.impl.health.calendar;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class OHealthCalendarModels {
    public static final List<Pair<Integer, Integer>> a = null;
    public static final int b = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarModels$LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "LOADED", "FAILED", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState FAILED = null;
        public static final LoadState LOADED = null;
        public static final LoadState LOADING = null;
        public static final LoadState NOT_LOADED = null;
        public static final /* synthetic */ LoadState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoadState> getEntries() {
            return b;
        }

        static {
            LoadState r0 = new LoadState("NOT_LOADED", 0);
            NOT_LOADED = r0;
            LoadState r1 = new LoadState("LOADING", 1);
            LOADING = r1;
            LoadState r3 = new LoadState("LOADED", 2);
            LOADED = r3;
            LoadState r5 = new LoadState("FAILED", 3);
            FAILED = r5;
            LoadState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static LoadState[] values() {
            return (LoadState[]) a.clone();
        }

        public static LoadState valueOf(String r1) {
            return (LoadState) r27.a.a(LoadState.class, r1);
        }

        public LoadState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final Integer e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            Integer r5 = this.e;
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
            return "DayCell(date=" + this.a + ", dayOfMonth=" + this.b + ", isToday=" + this.c + ", hasData=" + this.d + ", score=" + this.e + ')';
        }

        public a(String r2, int r3, boolean r4, boolean r5, Integer r6) {
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
        public final List<a> c;
        public final LoadState d;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "MonthData(year=" + this.a + ", month=" + this.b + ", cells=" + this.c + ", state=" + this.d + ')';
        }

        public final String b() {
            StringCompanionObject r0 = StringCompanionObject.INSTANCE;
            return String.format(Locale.US, "%04d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)}, 2));
        }

        public static b a(b r3, LoadState r4) {
            int r0 = r3.a;
            int r1 = r3.b;
            List<a> r2 = r3.c;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r2, "cells");
            Intrinsics.checkNotNullParameter(r4, "state");
            return new b(r0, r1, r2, r4);
        }

        public b(int r2, int r3, List<a> r4, LoadState r5) {
            Intrinsics.checkNotNullParameter(r4, "cells");
            Intrinsics.checkNotNullParameter(r5, "state");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = CollectionsKt.listOf(new Pair[]{TuplesKt.to(95, Integer.valueOf(ColorProtector.parseColor("#2BD9D3"))), TuplesKt.to(80, Integer.valueOf(ColorProtector.parseColor("#00C743"))), TuplesKt.to(60, Integer.valueOf(ColorProtector.parseColor("#FF850D"))), TuplesKt.to(40, Integer.valueOf(ColorProtector.parseColor("#FF3333"))), TuplesKt.to(0, Integer.valueOf(ColorProtector.parseColor("#A60000")))});
        b = ColorProtector.parseColor("#CCCCCC");
    }

    public static String d() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    public static Pair b(String r10) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return null;
    L12:
        List r11 = StringsKt.split$default(r10, new String[]{"-"}, false, 0, 6, null);
        if (r11.size() >= 2) goto L15;
        return null;
    L15:
        Integer r3 = StringsKt.toIntOrNull((String) ListProtector.get(r11, 0));
        if (r3 == null) goto L28;
        int r4 = r3.intValue();
        Integer r12 = StringsKt.toIntOrNull((String) ListProtector.get(r11, 1));
        if (r12 == null) goto L28;
        int r13 = r12.intValue();
        if (1 <= r13) goto L22;
    L24:
        if (r0 == true) goto L27;
        return null;
    L27:
        return TuplesKt.to(Integer.valueOf(r4), Integer.valueOf(r13));
    L22:
        if (r13 >= 13) goto L24;
        r0 = true;
    L28:
        return null;
    L5:
        if (r10.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static Pair c(int r2, int r3, int r4) {
        Calendar r0 = Calendar.getInstance();
        r0.clear();
        r0.set(r2, r3 - 1, 1);
        r0.add(2, r4);
        return TuplesKt.to(Integer.valueOf(r0.get(1)), Integer.valueOf(r0.get(2) + 1));
    }

    public static b a(int r21, int r22, List r23, LoadState r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "state");
        Intrinsics.checkNotNullParameter(r25, "today");
        if (r23 != null) goto L5;
        List r4 = CollectionsKt.emptyList();
    L6:
        List r5 = CollectionsKt.filterNotNull(r4);
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L7:
        Pair r8 = null;
        if (r7.hasNext() == false) goto L14;
        e r9 = (e) r7.next();
        String r10 = r9.a();
        if (r10 == null) goto L12;
        r8 = TuplesKt.to(r10, r9);
    L12:
        if (r8 == null) goto L7;
        r6.add(r8);
        goto L7
    L14:
        Map r11 = MapsKt.toMap(r6);
        Calendar r12 = Calendar.getInstance();
        r12.clear();
        r12.setFirstDayOfWeek(2);
        r12.set(r21, r22 - 1, 1);
        SimpleDateFormat r13 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        ArrayList r14 = new ArrayList();
        int r15 = ((r12.get(7) - 2) + 7) % 7;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L17;
        r14.add(null);
        r16 = r16 + 1;
        goto L15
    L17:
        int r17 = r12.getActualMaximum(5);
        int r18 = 0;
    L18:
        if (r18 >= r17) goto L28;
        String r110 = r13.format(r12.getTime());
        e r111 = (e) r11.get(r110);
        Intrinsics.checkNotNull(r110);
        int r112 = r12.get(5);
        boolean r113 = Intrinsics.areEqual(r110, r25);
        if (r111 == null) goto L22;
        boolean r114 = Intrinsics.areEqual(r111.b(), Boolean.TRUE);
    L23:
        if (r111 == null) goto L25;
        Integer r20 = r111.c();
    L26:
        r14.add(new a(r110, r112, r113, r114, r20));
        r12.add(5, 1);
        r18 = r18 + 1;
        goto L18
    L25:
        r20 = null;
        goto L26
    L22:
        r114 = false;
        goto L23
    L28:
        return new b(r21, r22, r14, r24);
    L5:
        r4 = r23;
        goto L6
    }
}
