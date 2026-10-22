package org.threeten.bp.chrono;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.b;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;

/* JADX INFO: loaded from: classes3.dex */
final class ChronoZonedDateTimeImpl<D extends b> extends g implements Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final ChronoLocalDateTimeImpl<D> dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    public ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl r5, ZoneId r10, ZoneOffset r11) {
        jm.c.p(r5, "dateTime");
        this.dateTime = r5;
        jm.c.p(r11, "offset");
        this.offset = r11;
        jm.c.p(r10, "zone");
        this.zone = r10;
    }

    public static <R extends b> g ofBest(ChronoLocalDateTimeImpl<R> r10, ZoneId r11, ZoneOffset r12) {
        jm.c.p(r10, "localDateTime");
        jm.c.p(r11, "zone");
        if ((r11 instanceof ZoneOffset) == true) goto L5;
        org.threeten.bp.zone.d r5 = r11.getRules();
        LocalDateTime r13 = LocalDateTime.from(r10);
        List r14 = r5.getValidOffsets(r13);
        if (r14.size() != 1) goto L10;
        r12 = (ZoneOffset) r14.get(0);
    L17:
        jm.c.p(r12, "offset");
        return new ChronoZonedDateTimeImpl(r10, r11, r12);
    L10:
        if (r14.size() != 0) goto L12;
        ZoneOffsetTransition r15 = r5.getTransition(r13);
        r10 = r10.plusSeconds(r15.getDuration().getSeconds());
        r12 = r15.getOffsetAfter();
        goto L17
    L12:
        if (r12 != null) goto L14;
    L16:
        r12 = (ZoneOffset) r14.get(0);
        goto L17
    L14:
        if (r14.contains(r12) == false) goto L16;
    L5:
        return new ChronoZonedDateTimeImpl(r10, r11, (ZoneOffset) r11);
    }

    public static <R extends b> ChronoZonedDateTimeImpl<R> ofInstant(i r5, Instant r10, ZoneId r11) {
        ZoneOffset r12 = r11.getRules().getOffset(r10);
        jm.c.p(r12, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) r5.localDateTime(LocalDateTime.ofEpochSecond(r10.getEpochSecond(), r10.getNano(), r12)), r11, r12);
    }

    public static g readExternal(ObjectInput r5) throws IOException, ClassNotFoundException {
        c r10 = (c) r5.readObject();
        ZoneOffset r11 = (ZoneOffset) r5.readObject();
        ZoneId r12 = (ZoneId) r5.readObject();
        return r10.atZone(r11).withZoneSameLocal(r12);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        if (compareTo((g) r5) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.chrono.g
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // org.threeten.bp.chrono.g
    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        int r5 = toLocalDateTime().hashCode() ^ getOffset().hashCode();
        return Integer.rotateLeft(getZone().hashCode(), 3) ^ r5;
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
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.g
    public c toLocalDateTime() {
        return this.dateTime;
    }

    public String toString() {
        String r5 = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() != getZone()) goto L5;
        return r5;
    L5:
        return r5 + '[' + getZone().toString() + ']';
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        g r11 = toLocalDate().getChronology().zonedDateTime(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L7;
        g r12 = r11.withZoneSameInstant(this.offset);
        return this.dateTime.until(r12.toLocalDateTime(), r10);
    L7:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public g withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition r5 = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (r5 != null) goto L5;
    L10:
        return this;
    L5:
        if (r5.isOverlap() == false) goto L10;
        ZoneOffset r10 = r5.getOffsetBefore();
        if (r10.equals(this.offset) == true) goto L10;
        return new ChronoZonedDateTimeImpl(this.dateTime, this.zone, r10);
    }

    public g withLaterOffsetAtOverlap() {
        ZoneOffsetTransition r5 = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (r5 == null) goto L8;
        ZoneOffset r10 = r5.getOffsetAfter();
        if (r10.equals(getOffset()) == true) goto L8;
        return new ChronoZonedDateTimeImpl(this.dateTime, this.zone, r10);
    L8:
        return this;
    }

    @Override // org.threeten.bp.chrono.g
    public g withZoneSameInstant(ZoneId r5) {
        jm.c.p(r5, "zone");
        if (this.zone.equals(r5) == true) goto L7;
        Instant r10 = this.dateTime.toInstant(this.offset);
        return ofInstant(toLocalDate().getChronology(), r10, r5);
    L7:
        return this;
    }

    @Override // org.threeten.bp.chrono.g
    public g withZoneSameLocal(ZoneId r5) {
        return ofBest(this.dateTime, r5, this.offset);
    }

    public void writeExternal(ObjectOutput r5) throws IOException {
        r5.writeObject(this.dateTime);
        r5.writeObject(this.offset);
        r5.writeObject(this.zone);
    }

    @Override // org.threeten.bp.temporal.c
    public g plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L7;
        return with(this.dateTime.plus(r5, r10));
    L7:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r10.addTo(this, r5));
    }

    @Override // org.threeten.bp.temporal.c
    public g with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        ChronoField r11 = (ChronoField) r5;
        int r12 = h.f21173a[r11.ordinal()];
        if (r12 == 1) goto L13;
        if (r12 != 2) goto L9;
        ZoneOffset r13 = ZoneOffset.ofTotalSeconds(r11.checkValidIntValue(r10));
        Instant r14 = this.dateTime.toInstant(r13);
        ZoneId r15 = this.zone;
        return ofInstant(toLocalDate().getChronology(), r14, r15);
    L9:
        return ofBest(this.dateTime.with(r5, r10), this.zone, this.offset);
    L13:
        return plus(r10 - toEpochSecond(), ChronoUnit.SECONDS);
    L15:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r5.adjustInto(this, r10));
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L9;
        if (r5 != null) goto L6;
    L8:
        return false;
    L6:
        if (r5.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
    }
}
