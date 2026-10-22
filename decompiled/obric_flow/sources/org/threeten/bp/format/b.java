package org.threeten.bp.format;

import ai.j0;
import com.bytedance.ai.event.MessageIndication;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final b f = null;
    public static final b g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f21199h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f21200i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f21201j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f21202k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f21203l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f21204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f21205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f21206c;
    public final ResolverStyle d;
    public final IsoChronology e;

    static {
        s r5 = new s();
        ChronoField r10 = ChronoField.YEAR;
        SignStyle r11 = SignStyle.EXCEEDS_PAD;
        r5.m(r10, 4, 10, r11);
        r5.c('-');
        ChronoField r12 = ChronoField.MONTH_OF_YEAR;
        r5.l(r12, 2);
        r5.c('-');
        ChronoField r13 = ChronoField.DAY_OF_MONTH;
        r5.l(r13, 2);
        ResolverStyle r14 = ResolverStyle.STRICT;
        b r15 = r5.r(r14);
        IsoChronology r16 = IsoChronology.INSTANCE;
        b r17 = r15.f(r16);
        f = r17;
        s r18 = new s();
        DateTimeFormatterBuilder$SettingsParser r19 = DateTimeFormatterBuilder$SettingsParser.INSENSITIVE;
        r18.b(r19);
        r18.a(r17);
        k r110 = k.d;
        r18.b(r110);
        r18.r(r14).f(r16);
        s r111 = new s();
        r111.b(r19);
        r111.a(r17);
        r111.o();
        r111.b(r110);
        r111.r(r14).f(r16);
        s r112 = new s();
        ChronoField r113 = ChronoField.HOUR_OF_DAY;
        r112.l(r113, 2);
        r112.c(':');
        ChronoField r20 = ChronoField.MINUTE_OF_HOUR;
        r112.l(r20, 2);
        r112.o();
        r112.c(':');
        ChronoField r114 = ChronoField.SECOND_OF_MINUTE;
        r112.l(r114, 2);
        r112.o();
        r112.b(new h(ChronoField.NANO_OF_SECOND, 0, 9, true));
        b r21 = r112.r(r14);
        g = r21;
        s r22 = new s();
        r22.b(r19);
        r22.a(r21);
        r22.b(r110);
        f21199h = r22.r(r14);
        s r23 = new s();
        r23.b(r19);
        r23.a(r21);
        r23.o();
        r23.b(r110);
        r23.r(r14);
        s r24 = new s();
        r24.b(r19);
        r24.a(r17);
        r24.c('T');
        r24.a(r21);
        b r25 = r24.r(r14).f(r16);
        f21200i = r25;
        s r26 = new s();
        r26.b(r19);
        r26.a(r25);
        r26.b(r110);
        b r27 = r26.r(r14).f(r16);
        f21201j = r27;
        s r28 = new s();
        r28.a(r27);
        r28.o();
        r28.c('[');
        DateTimeFormatterBuilder$SettingsParser r29 = DateTimeFormatterBuilder$SettingsParser.SENSITIVE;
        r28.b(r29);
        com.bytedance.frameworks.baselib.network.http.cronet.b r115 = s.f21241h;
        r28.b(new q(r115, "ZoneRegionId()"));
        r28.c(']');
        f21202k = r28.r(r14).f(r16);
        s r30 = new s();
        r30.a(r25);
        r30.o();
        r30.b(r110);
        r30.o();
        r30.c('[');
        r30.b(r29);
        r30.b(new q(r115, "ZoneRegionId()"));
        r30.c(']');
        r30.r(r14).f(r16);
        s r31 = new s();
        r31.b(r19);
        r31.m(r10, 4, 10, r11);
        r31.c('-');
        r31.l(ChronoField.DAY_OF_YEAR, 3);
        r31.o();
        r31.b(r110);
        r31.r(r14).f(r16);
        s r32 = new s();
        r32.b(r19);
        r32.m(org.threeten.bp.temporal.b.f21285c, 4, 10, r11);
        r32.d("-W");
        r32.l(org.threeten.bp.temporal.b.f21284b, 2);
        r32.c('-');
        ChronoField r33 = ChronoField.DAY_OF_WEEK;
        r32.l(r33, 1);
        r32.o();
        r32.b(r110);
        r32.r(r14).f(r16);
        s r34 = new s();
        r34.b(r19);
        r34.b(new i());
        f21203l = r34.r(r14);
        s r35 = new s();
        r35.b(r19);
        r35.l(r10, 4);
        r35.l(r12, 2);
        r35.l(r13, 2);
        r35.o();
        r35.f("+HHMMss", "Z");
        r35.r(r14).f(r16);
        HashMap r36 = new HashMap();
        r36.put(1L, "Mon");
        r36.put(2L, "Tue");
        r36.put(3L, "Wed");
        r36.put(4L, "Thu");
        r36.put(5L, "Fri");
        r36.put(6L, "Sat");
        r36.put(7L, "Sun");
        HashMap r37 = new HashMap();
        r37.put(1L, "Jan");
        r37.put(2L, "Feb");
        r37.put(3L, "Mar");
        r37.put(4L, "Apr");
        r37.put(5L, "May");
        r37.put(6L, "Jun");
        r37.put(7L, "Jul");
        r37.put(8L, "Aug");
        r37.put(9L, "Sep");
        r37.put(10L, "Oct");
        r37.put(11L, "Nov");
        r37.put(12L, "Dec");
        s r38 = new s();
        r38.b(r19);
        r38.b(DateTimeFormatterBuilder$SettingsParser.LENIENT);
        r38.o();
        r38.h(r33, r36);
        r38.d(", ");
        r38.n();
        r38.m(r13, 1, 2, SignStyle.NOT_NEGATIVE);
        r38.c(' ');
        r38.h(r12, r37);
        r38.c(' ');
        r38.l(r10, 4);
        r38.c(' ');
        r38.l(r113, 2);
        r38.c(':');
        r38.l(r20, 2);
        r38.o();
        r38.c(':');
        r38.l(r114, 2);
        r38.n();
        r38.c(' ');
        r38.f("+HHMM", "GMT");
        r38.r(ResolverStyle.SMART).f(r16);
    }

    public b(f r5, Locale r10, z r11, ResolverStyle r12, IsoChronology r13) {
        jm.c.p(r5, "printerParser");
        this.f21204a = r5;
        jm.c.p(r10, "locale");
        this.f21205b = r10;
        jm.c.p(r11, "decimalStyle");
        this.f21206c = r11;
        jm.c.p(r12, "resolverStyle");
        this.d = r12;
        this.e = r13;
    }

    public final String a(org.threeten.bp.temporal.d r5) {
        StringBuilder r10 = new StringBuilder(32);
        b(r5, r10);
        return r10.toString();
    }

    public final void b(org.threeten.bp.temporal.d r5, Appendable r10) {
        jm.c.p(r5, "temporal");
        jm.c.p(r10, "appendable");
        w r11 = new w(r5, this);     // Catch: IOException -> L7
        boolean r12 = r10 instanceof StringBuilder;     // Catch: IOException -> L7
        f r13 = this.f21204a;
        if (r12 == false) goto L9;
        r13.print(r11, (StringBuilder) r10);     // Catch: IOException -> L7
        return;
    L9:
        StringBuilder r14 = new StringBuilder(32);     // Catch: IOException -> L7
        r13.print(r11, r14);     // Catch: IOException -> L7
        r10.append(r14);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new DateTimeException(e.getMessage(), e);
    }

    public final Object c(CharSequence r5, org.threeten.bp.temporal.i r10) {
        jm.c.p(r5, MessageIndication.CONTENT_TYPE_TEXT);
        jm.c.p(r10, "type");
        a r11 = d(r5);     // Catch: RuntimeException -> L5 DateTimeParseException -> L7
        r11.i(this.d);     // Catch: RuntimeException -> L5 DateTimeParseException -> L7
        return r10.d(r11);
    L7:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (r5.length() <= 64) goto L12;
        String r12 = r5.subSequence(0, 64).toString() + "...";
    L13:
        StringBuilder r13 = j0.x("Text '", r12, "' could not be parsed: ");
        r13.append(e.getMessage());
        throw new DateTimeParseException(r13.toString(), r5, 0, e);
    L12:
        r12 = r5.toString();
        goto L13
    }

    public final a d(CharSequence r5) {
        ParsePosition r10 = new ParsePosition(0);
        t r11 = e(r5, r10);
        if (r11 == null) goto L12;
        if (r10.getErrorIndex() >= 0) goto L12;
        if (r10.getIndex() < r5.length()) goto L12;
        return r11.a();
    L12:
        if (r5.length() <= 64) goto L14;
        String r12 = r5.subSequence(0, 64).toString() + "...";
    L16:
        if (r10.getErrorIndex() < 0) goto L19;
        StringBuilder r13 = j0.x("Text '", r12, "' could not be parsed at index ");
        r13.append(r10.getErrorIndex());
        throw new DateTimeParseException(r13.toString(), r5, r10.getErrorIndex());
    L19:
        StringBuilder r14 = j0.x("Text '", r12, "' could not be parsed, unparsed text found at index ");
        r14.append(r10.getIndex());
        throw new DateTimeParseException(r14.toString(), r5, r10.getIndex());
    L14:
        r12 = r5.toString();
        goto L16
    }

    public final t e(CharSequence r5, ParsePosition r10) {
        jm.c.p(r5, MessageIndication.CONTENT_TYPE_TEXT);
        jm.c.p(r10, "position");
        u r11 = new u(this);
        int r12 = r10.getIndex();
        int r13 = this.f21204a.parse(r11, r5, r12);
        if (r13 >= 0) goto L6;
        r10.setErrorIndex(~r13);
        return null;
    L6:
        r10.setIndex(r13);
        return r11.b();
    }

    public final b f(IsoChronology r10) {
        if (jm.c.k(r10, this.e) == false) goto L5;
        return this;
    L5:
        z r5 = this.f21206c;
        ResolverStyle r11 = this.d;
        return new b(this.f21204a, this.f21205b, r5, r11, r10);
    }

    public final String toString() {
        String r5 = this.f21204a.toString();
        if (r5.startsWith("[") == false) goto L6;
        return r5;
    L6:
        return androidx.constraintlayout.motion.widget.a.n(r5, 1, 1);
    }
}
