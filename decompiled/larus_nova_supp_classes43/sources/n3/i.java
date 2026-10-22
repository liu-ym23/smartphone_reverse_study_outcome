package n3;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final SimpleDateFormat a = null;
    public static final SimpleDateFormat b = null;
    public static final Regex c = null;

    public static final class a {
        public final long a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final boolean f;
        public final long g;
        public final long h;
        public final int i;
        public final String j;
        public final List<c> k;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L27;
            return false;
        L27:
            if (this.g == r11.g) goto L30;
            return false;
        L30:
            if (this.h == r11.h) goto L33;
            return false;
        L33:
            if (this.i == r11.i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r11.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
            String r10 = this.c;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r1 + r12) * 31;
            String r14 = this.d;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (((r13 + r15) * 31) + this.e.hashCode()) * 31;
            if (this.f == false) goto L13;
            int r17 = 1231;
        L14:
            long r18 = this.g;
            int r19 = (((r16 + r17) * 31) + ((int) (r18 ^ (r18 >>> 32)))) * 31;
            long r20 = this.h;
            int r21 = (((r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31) + this.i) * 31;
            String r22 = this.j;
            if (r22 == null) goto L19;
            r11 = r22.hashCode();
        L19:
            return ((r21 + r11) * 31) + this.k.hashCode();
        L13:
            r17 = 1237;
            goto L14
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public final String toString() {
            return "ExceptionEvent(originalInstanceTime=" + this.a + ", title=" + this.b + ", description=" + this.c + ", location=" + this.d + ", timeZone=" + this.e + ", allDay=" + this.f + ", newStart=" + this.g + ", newEnd=" + this.h + ", status=" + this.i + ", duration=" + this.j + ", reminders=" + this.k + ')';
        }

        public a(long r10, String r11, String r12, String r13, String r14, boolean r15, long r16, long r17, int r18, String r19, List<c> r110) {
            Intrinsics.checkNotNullParameter(r11, "title");
            Intrinsics.checkNotNullParameter(r14, "timeZone");
            Intrinsics.checkNotNullParameter(r110, "reminders");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
            this.j = r19;
            this.k = r110;
        }
    }

    public static final class b {
        public final long a;
        public final String b;
        public final String c;
        public final long d;
        public final long e;
        public final String f;
        public final String g;
        public final List<c> h;
        public final boolean i;
        public final String j;
        public final String k;
        public final String l;
        public final List<a> m;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r11.i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r11.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r11.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r11.m) == true) goto L47;
            return false;
        L47:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
            String r10 = this.c;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            long r13 = this.d;
            int r14 = (((r1 + r12) * 31) + ((int) (r13 ^ (r13 >>> 32)))) * 31;
            long r15 = this.e;
            int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
            String r17 = this.f;
            if (r17 != null) goto L9;
            int r18 = 0;
        L10:
            int r19 = (((((r16 + r18) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
            if (this.i == false) goto L13;
            int r20 = 1231;
        L14:
            int r21 = (r19 + r20) * 31;
            String r22 = this.j;
            if (r22 != null) goto L17;
            int r23 = 0;
        L18:
            int r24 = (r21 + r23) * 31;
            String r25 = this.k;
            if (r25 != null) goto L21;
            int r26 = 0;
        L22:
            int r27 = (r24 + r26) * 31;
            String r28 = this.l;
            if (r28 == null) goto L27;
            r11 = r28.hashCode();
        L27:
            return ((r27 + r11) * 31) + this.m.hashCode();
        L21:
            r26 = r25.hashCode();
            goto L22
        L17:
            r23 = r22.hashCode();
            goto L18
        L13:
            r20 = 1237;
            goto L14
        L9:
            r18 = r17.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public final String toString() {
            return "LocalCalendarEvent(eventId=" + this.a + ", title=" + this.b + ", description=" + this.c + ", start=" + this.d + ", end=" + this.e + ", location=" + this.f + ", timeZone=" + this.g + ", reminders=" + this.h + ", allDay=" + this.i + ", rrule=" + this.j + ", rDate=" + this.k + ", duration=" + this.l + ", exceptions=" + this.m + ')';
        }

        public b(long r10, String r11, String r12, long r13, long r14, String r16, String r17, List<c> r18, boolean r19, String r20, String r21, String r22, List<a> r23) {
            Intrinsics.checkNotNullParameter(r11, "title");
            Intrinsics.checkNotNullParameter(r17, "timeZone");
            Intrinsics.checkNotNullParameter(r18, "reminders");
            Intrinsics.checkNotNullParameter(r23, "exceptions");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r16;
            this.g = r17;
            this.h = r18;
            this.i = r19;
            this.j = r20;
            this.k = r21;
            this.l = r22;
            this.m = r23;
        }
    }

    public static final class c {
        public final int a;
        public final int b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "Reminder(minutes=" + this.a + ", method=" + this.b + ')';
        }

        public c(int r1, int r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
        Locale r1 = Locale.US;
        SimpleDateFormat r0 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", r1);
        r0.setTimeZone(TimeZone.getTimeZone("UTC"));
        a = r0;
        b = new SimpleDateFormat("yyyyMMdd", r1);
        c = new Regex("^([-+]?)P(?:T?(?:(\\d+(?:\\.\\d+)?)H)?(?:(\\d+(?:\\.\\d+)?)M)?(?:(\\d+(?:\\.\\d+)?)S)?|(?:(\\d+(?:\\.\\d+)?)W)?(?:(\\d+(?:\\.\\d+)?)D)?(?:T(?:(\\d+(?:\\.\\d+)?)H)?(?:(\\d+(?:\\.\\d+)?)M)?(?:(\\d+(?:\\.\\d+)?)S)?)?)$", RegexOption.IGNORE_CASE);
    }

    public static String a(String r18) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r18, "\\", "\\\\", false, 4, null), ";", "\\;", false, 4, null), ",", "\\,", false, 4, null), "\n", "\\n", false, 4, null);
    }

    public static final double c(MatchResult r0, int r1) {
        Double r10 = StringsKt.toDoubleOrNull((String) ListProtector.get(r0.getGroupValues(), r1));
        if (r10 != null) goto L7;
        return 0.0d;
    L7:
        return r10.doubleValue();
    }

    public static String d(long r10, String r11) {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.US);
        r0.setTimeZone(TimeZone.getTimeZone(r11));
        return ";TZID=" + r11 + ':' + r0.format(new Date(r10));
    }

    public static long b(boolean r19, long r20, long r22, String r24) {
        long r0 = 0;
        if (r19 == true) goto L5;
    L9:
        if (r19 == true) goto L35;
        if (r22 != 0) goto L35;
        if (r24 == null) goto L26;
        String r10 = StringsKt.trim(r24).toString();
        int r11 = 1;
        if (r10.length() != 0) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == true) goto L21;
        MatchResult r13 = c.matchEntire(r10);
        if (r13 == null) goto L21;
        if (Intrinsics.areEqual(ListProtector.get(r13.getGroupValues(), 1), "-") == false) goto L25;
        r11 = -1;
    L25:
        double r14 = c(r13, 2);
        double r15 = c(r13, 3);
        double r16 = c(r13, 4);
        double r17 = c(r13, 5);
        double r18 = c(r13, 6);
        double r110 = c(r13, 7);
        double r1 = c(r13, 8);
        double r111 = c(r13, 9);
        double r21 = 24;
        double r23 = 3600;
        r0 = (long) (((((((((r17 * ((double) 7)) * r21) * r23) + ((r18 * r21) * r23)) + ((r14 + r110) * r23)) + ((r15 + r1) * ((double) 60))) + (r16 + r111)) * ((double) IServerListener.WHAT_BYTELINK_SINK_ERROR)) * ((double) r11));
    L27:
        long r25 = 0;
    L29:
        if (r0 != r25) goto L36;
        int r26 = 3600000;
    L32:
        r0 = r26;
    L36:
        return r20 + r0;
    L21:
        r25 = 0;
        goto L29
    L16:
        r12 = false;
        goto L17
    L26:
        r0 = 0;
    L35:
        return r22;
    L5:
        if (r22 != 0) goto L7;
    L8:
        r26 = 86400000;
        goto L32
    L7:
        if (r20 != r22) goto L9;
        goto L8
    }
}
