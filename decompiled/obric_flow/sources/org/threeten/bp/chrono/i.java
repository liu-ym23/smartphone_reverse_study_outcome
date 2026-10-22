package org.threeten.bp.chrono;

import ai.j0;
import androidx.core.text.util.LocalePreferences;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.format.r;
import org.threeten.bp.format.s;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements Comparable {
    public static final org.threeten.bp.temporal.i FROM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f21174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f21175b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f21176c = null;

    static {
        FROM = new wc.f(14);
        f21174a = new ConcurrentHashMap();
        f21175b = new ConcurrentHashMap();
        Method r5 = Locale.class.getMethod("getUnicodeLocaleType", new Class[]{String.class});     // Catch: Throwable -> L5
    L6:
        f21176c = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public i() {
    }

    public static void a() {
        ConcurrentHashMap r5 = f21174a;
        if (r5.isEmpty() == false) goto L10;
        b(IsoChronology.INSTANCE);
        b(ThaiBuddhistChronology.INSTANCE);
        b(MinguoChronology.INSTANCE);
        b(JapaneseChronology.INSTANCE);
        HijrahChronology r10 = HijrahChronology.INSTANCE;
        b(r10);
        r5.putIfAbsent("Hijrah", r10);
        ConcurrentHashMap r11 = f21175b;
        r11.putIfAbsent(LocalePreferences.CalendarType.ISLAMIC, r10);
        Iterator r12 = ServiceLoader.load(i.class, i.class.getClassLoader()).iterator();
    L6:
        if (r12.hasNext() == false) goto L16;
        i r13 = (i) r12.next();
        r5.putIfAbsent(r13.getId(), r13);
        String r14 = r13.getCalendarType();
        if (r14 == null) goto L6;
        r11.putIfAbsent(r14, r13);
        goto L6
    L16:
        return;
    }

    public static void b(i r5) {
        f21174a.putIfAbsent(r5.getId(), r5);
        String r10 = r5.getCalendarType();
        if (r10 == null) goto L6;
        f21175b.putIfAbsent(r10, r5);
        return;
    }

    public static i from(org.threeten.bp.temporal.d r5) {
        jm.c.p(r5, "temporal");
        i r10 = (i) r5.query(org.threeten.bp.temporal.h.f21287b);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return IsoChronology.INSTANCE;
    }

    public static Set<i> getAvailableChronologies() {
        a();
        return new HashSet(f21174a.values());
    }

    public static i of(String r5) {
        a();
        i r10 = (i) f21174a.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        i r11 = (i) f21175b.get(r5);
        if (r11 == null) goto L9;
        return r11;
    L9:
        throw new DateTimeException(j0.C("Unknown chronology: ", r5));
    }

    public static i ofLocale(Locale r5) {
        a();
        jm.c.p(r5, "locale");
        Method r10 = f21176c;
        if (r10 == null) goto L7;
        String r11 = (String) r10.invoke(r5, new Object[]{"ca"});     // Catch: Throwable -> L23
    L10:
        if (r11 == null) goto L22;
        if ("iso".equals(r11) == true) goto L22;
        if ("iso8601".equals(r11) == true) goto L22;
        i r12 = (i) f21175b.get(r11);
        if (r12 == null) goto L20;
        return r12;
    L20:
        throw new DateTimeException("Unknown calendar system: ".concat(r11));
    L22:
        return IsoChronology.INSTANCE;
    L9:
        r11 = "iso";
        goto L10
    L7:
        if (r5.equals(JapaneseChronology.LOCALE) == false) goto L9;
        r11 = "japanese";
        goto L10
    }

    public static i readExternal(DataInput r5) throws IOException {
        return of(r5.readUTF());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r5) {
        return compareTo((i) r5);
    }

    public abstract b date(int r5, int r10, int r11);

    public abstract b date(org.threeten.bp.temporal.d r5);

    public abstract b dateEpochDay(long r5);

    public <D extends b> D ensureChronoLocalDate(org.threeten.bp.temporal.c r5) {
        D r10 = (D) r5;
        if (equals(r10.getChronology()) == false) goto L6;
        return r10;
    L6:
        throw new ClassCastException("Chrono mismatch, expected: " + getId() + ", actual: " + r10.getChronology().getId());
    }

    public <D extends b> ChronoLocalDateTimeImpl<D> ensureChronoLocalDateTime(org.threeten.bp.temporal.c r5) {
        ChronoLocalDateTimeImpl<D> r10 = (ChronoLocalDateTimeImpl) r5;
        if (equals(r10.toLocalDate().getChronology()) == false) goto L6;
        return r10;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r10.toLocalDate().getChronology().getId());
    }

    public <D extends b> ChronoZonedDateTimeImpl<D> ensureChronoZonedDateTime(org.threeten.bp.temporal.c r5) {
        ChronoZonedDateTimeImpl<D> r10 = (ChronoZonedDateTimeImpl) r5;
        if (equals(r10.toLocalDate().getChronology()) == false) goto L6;
        return r10;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r10.toLocalDate().getChronology().getId());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        if (compareTo((i) r5) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public abstract j eraOf(int r5);

    public abstract String getCalendarType();

    public String getDisplayName(TextStyle r5, Locale r10) {
        s r11 = new s();
        jm.c.p(r5, "textStyle");
        r11.b(new r(r5, 1));
        return r11.q(r10).a(new org.threeten.bp.m(this, 1));
    }

    public abstract String getId();

    public int hashCode() {
        int r5 = getClass().hashCode();
        return getId().hashCode() ^ r5;
    }

    public abstract boolean isLeapYear(long r5);

    public c localDateTime(org.threeten.bp.temporal.d r5) {
        return date(r5).atTime(LocalTime.from(r5));
    L4:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + r5.getClass(), e);
    }

    public e period(int r5, int r10, int r11) {
        return new ChronoPeriodImpl(this, r5, r10, r11);
    }

    public abstract ValueRange range(ChronoField r5);

    public String toString() {
        return getId();
    }

    public void updateResolveMap(Map<org.threeten.bp.temporal.g, Long> r5, ChronoField r10, long r11) {
        Long r12 = r5.get(r10);
        if (r12 != null) goto L5;
    L9:
        r5.put(r10, Long.valueOf(r11));
        return;
    L5:
        if (r12.longValue() == r11) goto L9;
        throw new DateTimeException("Invalid state, field: " + r10 + " " + r12 + " conflicts with " + r10 + " " + r11);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeUTF(getId());
    }

    public abstract g zonedDateTime(Instant r5, ZoneId r10);

    public g zonedDateTime(org.threeten.bp.temporal.d r5) {
        ZoneId r10 = ZoneId.from(r5);     // Catch: DateTimeException -> L7
        return zonedDateTime(Instant.from(r5), r10);
    L6:
        return ChronoZonedDateTimeImpl.ofBest(ensureChronoLocalDateTime(localDateTime(r5)), r10, null);
    L7:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + r5.getClass(), e);
    }

    public int compareTo(i r5) {
        return getId().compareTo(r5.getId());
    }
}
