package org.threeten.bp.chrono;

import cn.nubia.neopush.commons.AppUtil;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.b;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
final class ChronoLocalDateTimeImpl<D extends b> extends c implements Serializable {
    private static final long serialVersionUID = 4556003607393004514L;
    private final D date;
    private final LocalTime time;

    /* JADX WARN: Multi-variable type inference failed */
    public ChronoLocalDateTimeImpl(b r5, LocalTime r10) {
        jm.c.p(r5, "date");
        jm.c.p(r10, "time");
        this.date = r5;
        this.time = r10;
    }

    public static <R extends b> ChronoLocalDateTimeImpl<R> of(R r5, LocalTime r10) {
        return new ChronoLocalDateTimeImpl(r5, r10);
    }

    public static c readExternal(ObjectInput r5) throws IOException, ClassNotFoundException {
        return ((b) r5.readObject()).atTime((LocalTime) r5.readObject());
    }

    private Object writeReplace() {
        return new Ser((byte) 12, this);
    }

    public final ChronoLocalDateTimeImpl a(b r17, long r18, long r20, long r22, long r24) {
        if ((((r18 | r20) | r22) | r24) == 0) goto L5;
        long r10 = r22 / 86400;
        long r11 = r20 / 1440;
        long r12 = r18 / 24;
        long r13 = r12 + (r11 + (r10 + (r24 / 86400000000000L)));
        long r14 = (r22 % 86400) * 1000000000;
        long r5 = (r20 % 1440) * 60000000000L;
        long r15 = r5 + (r14 + (r24 % 86400000000000L));
        long r16 = ((r18 % 24) * 3600000000000L) + r15;
        long r19 = this.time.toNanoOfDay();
        long r21 = r16 + r19;
        long r23 = jm.c.l(r21, 86400000000000L) + r13;
        long r25 = jm.c.o(r21, 86400000000000L);
        if (r25 != r19) goto L9;
        LocalTime r26 = this.time;
    L11:
        return b(r17.plus(r23, ChronoUnit.DAYS), r26);
    L9:
        r26 = LocalTime.ofNanoOfDay(r25);
        goto L11
    L5:
        return b(r17, this.time);
    }

    @Override // org.threeten.bp.chrono.c
    public g atZone(ZoneId r5) {
        return ChronoZonedDateTimeImpl.ofBest(this, r5, null);
    }

    public final ChronoLocalDateTimeImpl b(org.threeten.bp.temporal.c r5, LocalTime r10) {
        D r11 = this.date;
        if (r11 != r5) goto L8;
        if (this.time != r10) goto L8;
        return this;
    L8:
        return new ChronoLocalDateTimeImpl(r11.getChronology().ensureChronoLocalDate(r5), r10);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L10;
        if (r5.isTimeBased() == false) goto L8;
        return this.time.get(r5);
    L8:
        return this.date.get(r5);
    L10:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L10;
        if (r5.isTimeBased() == false) goto L8;
        return this.time.getLong(r5);
    L8:
        return this.date.getLong(r5);
    L10:
        return r5.getFrom(this);
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public ChronoLocalDateTimeImpl<D> plusSeconds(long r11) {
        return a(this.date, 0, 0, r11, 0);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L10;
        if (r5.isTimeBased() == false) goto L8;
        return this.time.range(r5);
    L8:
        return this.date.range(r5);
    L10:
        return r5.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.c
    public D toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.chrono.c
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r10, org.threeten.bp.temporal.j r11) {
        c r12 = toLocalDate().getChronology().localDateTime(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L24;
        ChronoUnit r5 = (ChronoUnit) r11;
        if (r5.isTimeBased() == false) goto L18;
        ChronoField r13 = ChronoField.EPOCH_DAY;
        long r14 = r12.getLong(r13) - this.date.getLong(r13);
        switch(d.f21170a[r5.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L17;
        };
    L9:
        r14 = jm.c.t(2, r14);
        goto L17
    L10:
        r14 = jm.c.t(24, r14);
        goto L17
    L11:
        r14 = jm.c.t(1440, r14);
        goto L17
    L12:
        r14 = jm.c.t(86400, r14);
        goto L17
    L13:
        r14 = jm.c.u(r14, AppUtil.MILLIS_IN_DAYS);
        goto L17
    L14:
        r14 = jm.c.u(r14, 86400000000L);
        goto L17
    L15:
        r14 = jm.c.u(r14, 86400000000000L);
    L17:
        return jm.c.r(r14, this.time.until(r12.toLocalTime(), r11));
    L18:
        b r15 = r12.toLocalDate();
        if (r12.toLocalTime().isBefore(this.time) == false) goto L22;
        r15 = r15.minus(1, ChronoUnit.DAYS);
    L22:
        return this.date.until(r15, r11);
    L24:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public void writeExternal(ObjectOutput r5) throws IOException {
        r5.writeObject(this.date);
        r5.writeObject(this.time);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    @Override // org.threeten.bp.temporal.c
    public ChronoLocalDateTimeImpl<D> plus(long r16, org.threeten.bp.temporal.j r18) {
        if ((r18 instanceof ChronoUnit) == false) goto L23;
        switch(d.f21170a[((ChronoUnit) r18).ordinal()]) {
            case 1: goto L21;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        D r5 = this.date;
        ChronoLocalDateTimeImpl r10 = b(r5.plus(r16 / 256, ChronoUnit.DAYS), this.time);
        D r11 = r10.date;
        return r10.a(r11, (r16 % 256) * 12, 0, 0, 0);
    L16:
        long r12 = r16 / AppUtil.MILLIS_IN_DAYS;
        ChronoLocalDateTimeImpl r13 = b(this.date.plus(r12, ChronoUnit.DAYS), this.time);
        long r14 = (r16 % AppUtil.MILLIS_IN_DAYS) * 1000000;
        return r13.a(r13.date, 0, 0, 0, r14);
    L18:
        D r15 = this.date;
        ChronoLocalDateTimeImpl r17 = b(r15.plus(r16 / 86400000000L, ChronoUnit.DAYS), this.time);
        D r19 = r17.date;
        return r17.a(r19, 0, 0, 0, (r16 % 86400000000L) * 1000);
    L7:
        return b(this.date.plus(r16, r18), this.time);
    L11:
        return a(this.date, r16, 0, 0, 0);
    L13:
        return a(this.date, 0, r16, 0, 0);
    L15:
        return plusSeconds(r16);
    L21:
        return a(this.date, 0, 0, 0, r16);
    L23:
        return this.date.getChronology().ensureChronoLocalDateTime(r18.addTo(this, r16));
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public boolean isSupported(org.threeten.bp.temporal.j r5) {
        if ((r5 instanceof ChronoUnit) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    @Override // org.threeten.bp.temporal.c
    public ChronoLocalDateTimeImpl<D> with(org.threeten.bp.temporal.e r5) {
        if ((r5 instanceof b) == false) goto L7;
        return b((b) r5, this.time);
    L7:
        if ((r5 instanceof LocalTime) == false) goto L11;
        return b(this.date, (LocalTime) r5);
    L11:
        if ((r5 instanceof ChronoLocalDateTimeImpl) == false) goto L15;
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) r5);
    L15:
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) r5.adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.c
    public ChronoLocalDateTimeImpl<D> with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L11;
        if (r5.isTimeBased() == false) goto L9;
        return b(this.date, this.time.with(r5, r10));
    L9:
        return b(this.date.with(r5, r10), this.time);
    L11:
        return this.date.getChronology().ensureChronoLocalDateTime(r5.adjustInto(this, r10));
    }
}
