package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class JapaneseEra extends fv.a implements Serializable {
    static final int ERA_OFFSET = 2;
    public static final JapaneseEra HEISEI = null;
    public static final JapaneseEra MEIJI = null;
    public static final JapaneseEra SHOWA = null;
    public static final JapaneseEra TAISHO = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f21162c = null;
    private static final long serialVersionUID = 1466499369062886794L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient LocalDate f21163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient String f21164b;
    private final int eraValue;

    static {
        JapaneseEra r5 = new JapaneseEra(-1, LocalDate.of(1868, 9, 8), "Meiji");
        MEIJI = r5;
        JapaneseEra r10 = new JapaneseEra(0, LocalDate.of(1912, 7, 30), "Taisho");
        TAISHO = r10;
        JapaneseEra r11 = new JapaneseEra(1, LocalDate.of(1926, 12, 25), "Showa");
        SHOWA = r11;
        JapaneseEra r12 = new JapaneseEra(2, LocalDate.of(1989, 1, 8), "Heisei");
        HEISEI = r12;
        f21162c = new AtomicReference(new JapaneseEra[]{r5, r10, r11, r12});
    }

    public JapaneseEra(int r5, LocalDate r10, String r11) {
        this.eraValue = r5;
        this.f21163a = r10;
        this.f21164b = r11;
    }

    public static JapaneseEra from(LocalDate r5) {
        if (r5.isBefore(MEIJI.f21163a) == true) goto L13;
        JapaneseEra[] r10 = (JapaneseEra[]) f21162c.get();
        int r11 = r10.length - 1;
    L5:
        if (r11 < 0) goto L10;
        JapaneseEra r12 = r10[r11];
        if (r5.compareTo(r12.f21163a) >= 0) goto L8;
        r11 = r11 - 1;
        goto L5
    L8:
        return r12;
    L10:
        return null;
    L13:
        throw new DateTimeException("Date too early: " + r5);
    }

    public static JapaneseEra of(int r5) {
        JapaneseEra[] r10 = (JapaneseEra[]) f21162c.get();
        if (r5 < MEIJI.eraValue) goto L9;
        if (r5 > r10[r10.length - 1].eraValue) goto L9;
        return r10[r5 + 1];
    L9:
        throw new DateTimeException("japaneseEra is invalid");
    }

    public static JapaneseEra readExternal(DataInput r5) throws IOException {
        return of(r5.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        return of(this.eraValue);
    L4:
        e = move-exception;
        InvalidObjectException r5 = new InvalidObjectException("Invalid era");
        r5.initCause(e);
        throw r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JapaneseEra registerEra(LocalDate r10, String r11) {
        AtomicReference r5 = f21162c;
        JapaneseEra[] r12 = (JapaneseEra[]) r5.get();
        if (r12.length > 4) goto L18;
        jm.c.p(r10, "since");
        jm.c.p(r11, "name");
        if (r10.isAfter(HEISEI.f21163a) == false) goto L16;
        JapaneseEra r13 = new JapaneseEra(3, r10, r11);
        JapaneseEra[] r14 = (JapaneseEra[]) Arrays.copyOf(r12, 5);
        r14[4] = r13;
    L8:
        if (r5.compareAndSet(r12, r14) == true) goto L9;
        if (r5.get() == r12) goto L8;
        throw new DateTimeException("Only one additional Japanese era can be added");
    L9:
        return r13;
    L16:
        throw new DateTimeException("Invalid since date for additional Japanese era, must be after Heisei");
    L18:
        throw new DateTimeException("Only one additional Japanese era can be added");
    }

    public static JapaneseEra valueOf(String r5) {
        jm.c.p(r5, "japaneseEra");
        JapaneseEra[] r10 = (JapaneseEra[]) f21162c.get();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        JapaneseEra r13 = r10[r12];
        if (r5.equals(r13.f21164b) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        throw new IllegalArgumentException("Era not found: ".concat(r5));
    }

    public static JapaneseEra[] values() {
        JapaneseEra[] r5 = (JapaneseEra[]) f21162c.get();
        return (JapaneseEra[]) Arrays.copyOf(r5, r5.length);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public LocalDate endDate() {
        int r5 = this.eraValue;
        int r10 = r5 + 1;
        JapaneseEra[] r11 = values();
        if (r10 < (r11.length - 1)) goto L7;
        return LocalDate.MAX;
    L7:
        return r11[r5 + 2].startDate().minusDays(1);
    }

    @Override // org.threeten.bp.chrono.j
    public int getValue() {
        return this.eraValue;
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        ChronoField r10 = ChronoField.ERA;
        if (r5 != r10) goto L7;
        return JapaneseChronology.INSTANCE.range(r10);
    L7:
        return super.range(r5);
    }

    public LocalDate startDate() {
        return this.f21163a;
    }

    public String toString() {
        return this.f21164b;
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeByte(getValue());
    }
}
