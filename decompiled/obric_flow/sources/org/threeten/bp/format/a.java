package org.threeten.bp.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends fv.c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f21194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.threeten.bp.chrono.i f21195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZoneId f21196c;
    public org.threeten.bp.chrono.b d;
    public LocalTime e;
    public Period f;

    public a() {
        this.f21194a = new HashMap();
    }

    public final void a(ChronoField r5, long r10) {
        jm.c.p(r5, "field");
        HashMap r11 = this.f21194a;
        Long r12 = (Long) r11.get(r5);
        if (r12 != null) goto L5;
    L9:
        r11.put(r5, Long.valueOf(r10));
        return;
    L5:
        if (r12.longValue() == r10) goto L9;
        throw new DateTimeException("Conflict found: " + r5 + " " + r12 + " differs from " + r5 + " " + r10 + ": " + this);
    }

    public final void b(LocalDate r10) {
        if (r10 == null) goto L16;
        this.d = r10;
        HashMap r11 = this.f21194a;
        Iterator r5 = r11.keySet().iterator();
    L5:
        if (r5.hasNext() == false) goto L28;
        org.threeten.bp.temporal.g r12 = (org.threeten.bp.temporal.g) r5.next();
        if ((r12 instanceof ChronoField) == false) goto L5;
        if (r12.isDateBased() == false) goto L5;
        long r13 = r10.getLong(r12);     // Catch: DateTimeException -> L17
        Long r14 = (Long) r11.get(r12);
        if (r13 == r14.longValue()) goto L5;
        throw new DateTimeException("Conflict found: Field " + r12 + " " + r13 + " differs from " + r12 + " " + r14 + " derived from " + r10);
    L28:
        return;
    }

    public final void c(org.threeten.bp.temporal.d r10) {
        Iterator r11 = this.f21194a.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r5 = (Map.Entry) r11.next();
        org.threeten.bp.temporal.g r12 = (org.threeten.bp.temporal.g) r5.getKey();
        long r13 = ((Long) r5.getValue()).longValue();
        if (r10.isSupported(r12) == false) goto L4;
        long r14 = r10.getLong(r12);     // Catch: RuntimeException -> L14
        if (r14 != r13) goto L12;
        r11.remove();
        goto L4
    L12:
        throw new DateTimeException("Cross check failed: " + r12 + " " + r14 + " vs " + r12 + " " + r13);
    }

    public final void e(ResolverStyle r5) {
        boolean r10 = this.f21195b instanceof IsoChronology;
        HashMap r11 = this.f21194a;
        if (r10 == false) goto L5;
        b(IsoChronology.INSTANCE.resolveDate(r11, r5));
        return;
    L5:
        ChronoField r12 = ChronoField.EPOCH_DAY;
        if (r11.containsKey(r12) == false) goto L10;
        b(LocalDate.ofEpochDay(((Long) r11.remove(r12)).longValue()));
        return;
    }

    public final void f() {
        HashMap r5 = this.f21194a;
        if (r5.containsKey(ChronoField.INSTANT_SECONDS) == false) goto L11;
        ZoneId r10 = this.f21196c;
        if (r10 == null) goto L7;
        g(r10);
        return;
    L7:
        Long r11 = (Long) r5.get(ChronoField.OFFSET_SECONDS);
        if (r11 == null) goto L13;
        g(ZoneOffset.ofTotalSeconds(r11.intValue()));
        return;
    L13:
        return;
    }

    public final void g(ZoneId r5) {
        HashMap r10 = this.f21194a;
        ChronoField r11 = ChronoField.INSTANT_SECONDS;
        org.threeten.bp.chrono.g r12 = this.f21195b.zonedDateTime(Instant.ofEpochSecond(((Long) r10.remove(r11)).longValue()), r5);
        if (this.d != null) goto L5;
        this.d = r12.toLocalDate();
    L6:
        a(ChronoField.SECOND_OF_DAY, r12.toLocalTime().toSecondOfDay());
        return;
    L5:
        k(r11, r12.toLocalDate());
        goto L6
    }

    @Override // org.threeten.bp.temporal.d
    public final long getLong(org.threeten.bp.temporal.g r5) {
        jm.c.p(r5, "field");
        Long r10 = (Long) this.f21194a.get(r5);
        if (r10 != null) goto L19;
        org.threeten.bp.chrono.b r11 = this.d;
        if (r11 != null) goto L7;
    L10:
        LocalTime r12 = this.e;
        if (r12 == null) goto L17;
        if (r12.isSupported(r5) == false) goto L17;
        return this.e.getLong(r5);
    L17:
        throw new DateTimeException(kotlin.collections.a.h("Field not found: ", r5));
    L7:
        if (r11.isSupported(r5) == false) goto L10;
        return this.d.getLong(r5);
    L19:
        return r10.longValue();
    }

    public final void h(ResolverStyle r15) {
        HashMap r5 = this.f21194a;
        ChronoField r10 = ChronoField.CLOCK_HOUR_OF_DAY;
        long r11 = 0;
        if (r5.containsKey(r10) == false) goto L16;
        long r12 = ((Long) r5.remove(r10)).longValue();
        if (r15 != ResolverStyle.LENIENT) goto L7;
    L12:
        ChronoField r13 = ChronoField.HOUR_OF_DAY;
        if (r12 != 24) goto L15;
        r12 = 0;
    L15:
        a(r13, r12);
        goto L16
    L7:
        if (r15 == ResolverStyle.SMART) goto L9;
    L11:
        r10.checkValidValue(r12);
        goto L12
    L9:
        if (r12 != 0) goto L11;
    L16:
        ChronoField r14 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (r5.containsKey(r14) == false) goto L31;
        long r16 = ((Long) r5.remove(r14)).longValue();
        if (r15 != ResolverStyle.LENIENT) goto L21;
    L26:
        ChronoField r17 = ChronoField.HOUR_OF_AMPM;
        if (r16 == 12) goto L30;
        r11 = r16;
    L30:
        a(r17, r11);
        goto L31
    L21:
        if (r15 == ResolverStyle.SMART) goto L23;
    L25:
        r14.checkValidValue(r16);
        goto L26
    L23:
        if (r16 != 0) goto L25;
    L31:
        ResolverStyle r18 = ResolverStyle.LENIENT;
        if (r15 == r18) goto L39;
        ChronoField r19 = ChronoField.AMPM_OF_DAY;
        if (r5.containsKey(r19) == false) goto L36;
        r19.checkValidValue(((Long) r5.get(r19)).longValue());
    L36:
        ChronoField r20 = ChronoField.HOUR_OF_AMPM;
        if (r5.containsKey(r20) == false) goto L39;
        r20.checkValidValue(((Long) r5.get(r20)).longValue());
    L39:
        ChronoField r21 = ChronoField.AMPM_OF_DAY;
        if (r5.containsKey(r21) == false) goto L44;
        ChronoField r22 = ChronoField.HOUR_OF_AMPM;
        if (r5.containsKey(r22) == false) goto L44;
        long r23 = ((Long) r5.remove(r21)).longValue();
        a(ChronoField.HOUR_OF_DAY, (r23 * 12) + ((Long) r5.remove(r22)).longValue());
    L44:
        ChronoField r24 = ChronoField.NANO_OF_DAY;
        if (r5.containsKey(r24) == false) goto L50;
        long r25 = ((Long) r5.remove(r24)).longValue();
        if (r15 == r18) goto L49;
        r24.checkValidValue(r25);
    L49:
        a(ChronoField.SECOND_OF_DAY, r25 / 1000000000);
        a(ChronoField.NANO_OF_SECOND, r25 % 1000000000);
    L50:
        ChronoField r26 = ChronoField.MICRO_OF_DAY;
        if (r5.containsKey(r26) == false) goto L56;
        long r27 = ((Long) r5.remove(r26)).longValue();
        if (r15 == r18) goto L55;
        r26.checkValidValue(r27);
    L55:
        a(ChronoField.SECOND_OF_DAY, r27 / 1000000);
        a(ChronoField.MICRO_OF_SECOND, r27 % 1000000);
    L56:
        ChronoField r28 = ChronoField.MILLI_OF_DAY;
        if (r5.containsKey(r28) == false) goto L62;
        long r29 = ((Long) r5.remove(r28)).longValue();
        if (r15 == r18) goto L61;
        r28.checkValidValue(r29);
    L61:
        a(ChronoField.SECOND_OF_DAY, r29 / 1000);
        a(ChronoField.MILLI_OF_SECOND, r29 % 1000);
    L62:
        ChronoField r30 = ChronoField.SECOND_OF_DAY;
        if (r5.containsKey(r30) == false) goto L68;
        long r110 = ((Long) r5.remove(r30)).longValue();
        if (r15 == r18) goto L67;
        r30.checkValidValue(r110);
    L67:
        a(ChronoField.HOUR_OF_DAY, r110 / 3600);
        a(ChronoField.MINUTE_OF_HOUR, (r110 / 60) % 60);
        a(ChronoField.SECOND_OF_MINUTE, r110 % 60);
    L68:
        ChronoField r31 = ChronoField.MINUTE_OF_DAY;
        if (r5.containsKey(r31) == false) goto L74;
        long r111 = ((Long) r5.remove(r31)).longValue();
        if (r15 == r18) goto L73;
        r31.checkValidValue(r111);
    L73:
        a(ChronoField.HOUR_OF_DAY, r111 / 60);
        a(ChronoField.MINUTE_OF_HOUR, r111 % 60);
    L74:
        if (r15 == r18) goto L81;
        ChronoField r112 = ChronoField.MILLI_OF_SECOND;
        if (r5.containsKey(r112) == false) goto L78;
        r112.checkValidValue(((Long) r5.get(r112)).longValue());
    L78:
        ChronoField r113 = ChronoField.MICRO_OF_SECOND;
        if (r5.containsKey(r113) == false) goto L81;
        r113.checkValidValue(((Long) r5.get(r113)).longValue());
    L81:
        ChronoField r114 = ChronoField.MILLI_OF_SECOND;
        if (r5.containsKey(r114) == false) goto L86;
        ChronoField r32 = ChronoField.MICRO_OF_SECOND;
        if (r5.containsKey(r32) == false) goto L86;
        long r33 = ((Long) r5.remove(r114)).longValue();
        a(r32, (((Long) r5.get(r32)).longValue() % 1000) + (r33 * 1000));
    L86:
        ChronoField r34 = ChronoField.MICRO_OF_SECOND;
        if (r5.containsKey(r34) == false) goto L92;
        ChronoField r35 = ChronoField.NANO_OF_SECOND;
        if (r5.containsKey(r35) == false) goto L92;
        a(r34, ((Long) r5.get(r35)).longValue() / 1000);
        r5.remove(r34);
    L92:
        if (r5.containsKey(r114) == false) goto L97;
        ChronoField r36 = ChronoField.NANO_OF_SECOND;
        if (r5.containsKey(r36) == false) goto L97;
        a(r114, ((Long) r5.get(r36)).longValue() / 1000000);
        r5.remove(r114);
    L97:
        if (r5.containsKey(r34) == false) goto L100;
        a(ChronoField.NANO_OF_SECOND, ((Long) r5.remove(r34)).longValue() * 1000);
        return;
    L100:
        if (r5.containsKey(r114) == false) goto L104;
        a(ChronoField.NANO_OF_SECOND, ((Long) r5.remove(r114)).longValue() * 1000000);
        return;
    }

    public final void i(ResolverStyle r20) {
        HashMap r5 = this.f21194a;
        f();
        e(r20);
        h(r20);
        int r10 = 0;
    L4:
        if (r10 >= 100) goto L35;
        Iterator r11 = r5.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L35;
        org.threeten.bp.temporal.g r12 = (org.threeten.bp.temporal.g) ((Map.Entry) r11.next()).getKey();
        org.threeten.bp.temporal.d r13 = r12.resolve(r5, this, r20);
        if (r13 != null) goto L11;
        if (r5.containsKey(r12) == true) goto L7;
    L23:
        r10 = r10 + 1;
        goto L4
    L11:
        if ((r13 instanceof org.threeten.bp.chrono.g) == false) goto L21;
        org.threeten.bp.chrono.g r14 = (org.threeten.bp.chrono.g) r13;
        ZoneId r15 = this.f21196c;
        if (r15 != null) goto L16;
        this.f21196c = r14.getZone();
    L17:
        r13 = r14.toLocalDateTime();
        goto L21
    L16:
        if (r15.equals(r14.getZone()) == true) goto L17;
        throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.f21196c);
    L21:
        if ((r13 instanceof org.threeten.bp.chrono.b) == false) goto L25;
        k(r12, (org.threeten.bp.chrono.b) r13);
        goto L23
    L25:
        if ((r13 instanceof LocalTime) == false) goto L28;
        j(r12, (LocalTime) r13);
        goto L23
    L28:
        if ((r13 instanceof org.threeten.bp.chrono.c) == false) goto L31;
        org.threeten.bp.chrono.c r16 = (org.threeten.bp.chrono.c) r13;
        k(r12, r16.toLocalDate());
        j(r12, r16.toLocalTime());
        goto L23
    L31:
        throw new DateTimeException("Unknown type: ".concat(r13.getClass().getName()));
    L35:
        if (r10 == 100) goto L132;
        if (r10 <= 0) goto L38;
        f();
        e(r20);
        h(r20);
    L38:
        ChronoField r17 = ChronoField.HOUR_OF_DAY;
        Long r18 = (Long) r5.get(r17);
        ChronoField r19 = ChronoField.MINUTE_OF_HOUR;
        Long r21 = (Long) r5.get(r19);
        ChronoField r22 = ChronoField.SECOND_OF_MINUTE;
        Long r23 = (Long) r5.get(r22);
        ChronoField r110 = ChronoField.NANO_OF_SECOND;
        Long r111 = (Long) r5.get(r110);
        if (r18 == null) goto L88;
        if (r21 != null) goto L45;
        if (r23 != null) goto L88;
        if (r111 != null) goto L88;
    L45:
        if (r21 == null) goto L50;
        if (r23 != null) goto L50;
        if (r111 != null) goto L88;
    L50:
        if (r20 != ResolverStyle.LENIENT) goto L52;
        ChronoField r24 = r17;
        long r25 = r18.longValue();
        if (r21 == null) goto L85;
        if (r23 == null) goto L84;
        if (r111 != null) goto L83;
        r111 = 0L;
    L83:
        long r26 = jm.c.r(jm.c.r(jm.c.r(jm.c.u(r25, 3600000000000L), jm.c.u(r21.longValue(), 60000000000L)), jm.c.u(r23.longValue(), 1000000000)), r111.longValue());
        int r27 = (int) jm.c.l(r26, 86400000000000L);
        this.e = LocalTime.ofNanoOfDay(jm.c.o(r26, 86400000000000L));
        this.f = Period.ofDays(r27);
    L86:
        r5.remove(r24);
        r5.remove(r19);
        r5.remove(r22);
        r5.remove(r110);
        goto L88
    L84:
        long r28 = jm.c.r(jm.c.u(r25, 3600), jm.c.u(r21.longValue(), 60));
        int r29 = (int) jm.c.l(r28, 86400);
        this.e = LocalTime.ofSecondOfDay(jm.c.o(r28, 86400));
        this.f = Period.ofDays(r29);
        goto L86
    L85:
        int r30 = jm.c.x(jm.c.l(r25, 24));
        this.e = LocalTime.of(jm.c.n(24, r25), 0);
        this.f = Period.ofDays(r30);
        goto L86
    L52:
        if (r20 == ResolverStyle.SMART) goto L54;
    L65:
        r24 = r17;
        int r31 = r24.checkValidIntValue(r18.longValue());
        if (r21 == null) goto L75;
        int r32 = r19.checkValidIntValue(r21.longValue());
        if (r23 == null) goto L73;
        int r33 = r22.checkValidIntValue(r23.longValue());
        if (r111 == null) goto L72;
        this.e = LocalTime.of(r31, r32, r33, r110.checkValidIntValue(r111.longValue()));
        goto L86
    L72:
        this.e = LocalTime.of(r31, r32, r33);
        goto L86
    L73:
        if (r111 != null) goto L86;
        this.e = LocalTime.of(r31, r32);
        goto L86
    L75:
        if (r23 != null) goto L86;
        if (r111 != null) goto L86;
        this.e = LocalTime.of(r31, 0);
        goto L86
    L54:
        if (r18.longValue() != 24) goto L65;
        if (r21 != null) goto L57;
    L58:
        if (r23 != null) goto L60;
    L61:
        if (r111 != null) goto L63;
    L64:
        r18 = 0L;
        this.f = Period.ofDays(1);
        goto L65
    L63:
        if (r111.longValue() != 0) goto L65;
    L60:
        if (r23.longValue() != 0) goto L65;
    L57:
        if (r21.longValue() != 0) goto L65;
    L88:
        if (r5.size() <= 0) goto L99;
        org.threeten.bp.chrono.b r34 = this.d;
        if (r34 == null) goto L94;
        LocalTime r35 = this.e;
        if (r35 == null) goto L94;
        c(r34.atTime(r35));
    L94:
        if (r34 == null) goto L96;
        c(r34);
        goto L99
    L96:
        org.threeten.bp.temporal.d r36 = this.e;
        if (r36 == null) goto L99;
        c(r36);
    L99:
        Period r37 = this.f;
        if (r37 == null) goto L109;
        if (r37.isZero() == true) goto L109;
        org.threeten.bp.chrono.b r38 = this.d;
        if (r38 == null) goto L109;
        if (this.e == null) goto L109;
        this.d = r38.plus(this.f);
        this.f = Period.ZERO;
    L109:
        if (this.e == null) goto L111;
    L120:
        org.threeten.bp.chrono.b r39 = this.d;
        if (r39 == null) goto L143;
        LocalTime r40 = this.e;
        if (r40 != null) goto L125;
        return;
    L125:
        if (this.f21196c == null) goto L127;
        org.threeten.bp.chrono.g r41 = r39.atTime(r40).atZone(this.f21196c);
        ChronoField r42 = ChronoField.INSTANT_SECONDS;
        r5.put(r42, Long.valueOf(r41.getLong(r42)));
        return;
    L127:
        Long r43 = (Long) r5.get(ChronoField.OFFSET_SECONDS);
        if (r43 == null) goto L146;
        org.threeten.bp.chrono.g r44 = this.d.atTime(this.e).atZone(ZoneOffset.ofTotalSeconds(r43.intValue()));
        ChronoField r45 = ChronoField.INSTANT_SECONDS;
        r5.put(r45, Long.valueOf(r44.getLong(r45)));
        return;
    L146:
        return;
    L143:
        return;
    L111:
        if (r5.containsKey(ChronoField.INSTANT_SECONDS) == true) goto L117;
        if (r5.containsKey(ChronoField.SECOND_OF_DAY) == true) goto L117;
        if (r5.containsKey(r22) == false) goto L120;
    L117:
        if (r5.containsKey(r110) == false) goto L119;
        long r46 = ((Long) r5.get(r110)).longValue();
        r5.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(r46 / 1000));
        r5.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(r46 / 1000000));
        goto L120
    L119:
        r5.put(r110, 0L);
        r5.put(ChronoField.MICRO_OF_SECOND, 0L);
        r5.put(ChronoField.MILLI_OF_SECOND, 0L);
        goto L120
    L132:
        throw new DateTimeException("Badly written field");
    }

    @Override // org.threeten.bp.temporal.d
    public final boolean isSupported(org.threeten.bp.temporal.g r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.f21194a.containsKey(r5) == true) goto L15;
        org.threeten.bp.chrono.b r10 = this.d;
        if (r10 != null) goto L10;
    L11:
        LocalTime r11 = this.e;
        if (r11 != null) goto L14;
        return false;
    L14:
        if (r11.isSupported(r5) == true) goto L15;
        return false;
    L10:
        if (r10.isSupported(r5) == false) goto L11;
    L15:
        return true;
    }

    public final void j(org.threeten.bp.temporal.g r5, LocalTime r10) {
        long r11 = r10.toNanoOfDay();
        Long r12 = (Long) this.f21194a.put(ChronoField.NANO_OF_DAY, Long.valueOf(r11));
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.longValue() != r11) goto L8;
        return;
    L8:
        throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(r12.longValue()) + " differs from " + r10 + " while resolving  " + r5);
    }

    public final void k(org.threeten.bp.temporal.g r10, org.threeten.bp.chrono.b r11) {
        if (this.f21195b.equals(r11.getChronology()) == false) goto L13;
        long r5 = r11.toEpochDay();
        Long r12 = (Long) this.f21194a.put(ChronoField.EPOCH_DAY, Long.valueOf(r5));
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.longValue() != r5) goto L10;
        return;
    L10:
        throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(r12.longValue()) + " differs from " + LocalDate.ofEpochDay(r5) + " while resolving  " + r10);
    L13:
        throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.f21195b);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public final Object query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L7;
        return this.f21196c;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L11;
        return this.f21195b;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f) goto L17;
        org.threeten.bp.chrono.b r10 = this.d;
        if (r10 != null) goto L15;
        return null;
    L15:
        return LocalDate.from(r10);
    L17:
        if (r5 != org.threeten.bp.temporal.h.g) goto L21;
        return this.e;
    L21:
        if (r5 == org.threeten.bp.temporal.h.d) goto L31;
        if (r5 == org.threeten.bp.temporal.h.e) goto L31;
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L29;
        return null;
    L29:
        return r5.d(this);
    L31:
        return r5.d(this);
    }

    public final String toString() {
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.x(128, "DateTimeBuilder[");
        HashMap r10 = this.f21194a;
        if (r10.size() <= 0) goto L5;
        r5.append("fields=");
        r5.append(r10);
    L5:
        r5.append(", ");
        r5.append(this.f21195b);
        r5.append(", ");
        r5.append(this.f21196c);
        r5.append(", ");
        r5.append(this.d);
        r5.append(", ");
        r5.append(this.e);
        r5.append(']');
        return r5.toString();
    }
}
