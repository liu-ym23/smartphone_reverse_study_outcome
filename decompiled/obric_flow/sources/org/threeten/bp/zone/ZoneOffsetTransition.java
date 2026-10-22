package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes3.dex */
public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    public ZoneOffsetTransition(LocalDateTime r5, ZoneOffset r10, ZoneOffset r11) {
        this.transition = r5;
        this.offsetBefore = r10;
        this.offsetAfter = r11;
    }

    public static ZoneOffsetTransition of(LocalDateTime r5, ZoneOffset r10, ZoneOffset r11) {
        jm.c.p(r5, "transition");
        jm.c.p(r10, "offsetBefore");
        jm.c.p(r11, "offsetAfter");
        if (r10.equals(r11) == true) goto L11;
        if (r5.getNano() != 0) goto L9;
        return new ZoneOffsetTransition(r5, r10, r11);
    L9:
        throw new IllegalArgumentException("Nano-of-second must be zero");
    L11:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    public static ZoneOffsetTransition readExternal(DataInput r5) throws IOException {
        long r10 = Ser.readEpochSec(r5);
        ZoneOffset r11 = Ser.readOffset(r5);
        ZoneOffset r12 = Ser.readOffset(r5);
        if (r11.equals(r12) == true) goto L7;
        return new ZoneOffsetTransition(r10, r11, r12);
    L7:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffsetTransition r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZoneOffsetTransition) == false) goto L16;
        ZoneOffsetTransition r10 = (ZoneOffsetTransition) r5;
        if (this.transition.equals(r10.transition) == false) goto L15;
        if (this.offsetBefore.equals(r10.offsetBefore) == false) goto L15;
        if (this.offsetAfter.equals(r10.offsetAfter) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds(getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds());
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds());
    }

    public Instant getInstant() {
        return this.transition.toInstant(this.offsetBefore);
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public List<ZoneOffset> getValidOffsets() {
        if (isGap() == false) goto L7;
        return Collections.emptyList();
    L7:
        return Arrays.asList(new ZoneOffset[]{getOffsetBefore(), getOffsetAfter()});
    }

    public int hashCode() {
        int r5 = this.transition.hashCode() ^ this.offsetBefore.hashCode();
        return Integer.rotateLeft(this.offsetAfter.hashCode(), 16) ^ r5;
    }

    public boolean isGap() {
        if (getOffsetAfter().getTotalSeconds() <= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOverlap() {
        if (getOffsetAfter().getTotalSeconds() >= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidOffset(ZoneOffset r5) {
        if (isGap() == false) goto L6;
        return false;
    L6:
        if (getOffsetBefore().equals(r5) == false) goto L8;
    L9:
        return true;
    L8:
        if (getOffsetAfter().equals(r5) == true) goto L9;
        return false;
    }

    public long toEpochSecond() {
        return this.transition.toEpochSecond(this.offsetBefore);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Transition[");
        if (isGap() == false) goto L5;
        String r10 = "Gap";
    L6:
        r5.append(r10);
        r5.append(" at ");
        r5.append(this.transition);
        r5.append(this.offsetBefore);
        r5.append(" to ");
        r5.append(this.offsetAfter);
        r5.append(']');
        return r5.toString();
    L5:
        r10 = "Overlap";
        goto L6
    }

    public void writeExternal(DataOutput r5) throws IOException {
        Ser.writeEpochSec(toEpochSecond(), r5);
        Ser.writeOffset(this.offsetBefore, r5);
        Ser.writeOffset(this.offsetAfter, r5);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffsetTransition r5) {
        return getInstant().compareTo2(r5.getInstant());
    }

    public ZoneOffsetTransition(long r5, ZoneOffset r10, ZoneOffset r11) {
        this.transition = LocalDateTime.ofEpochSecond(r5, 0, r10);
        this.offsetBefore = r10;
        this.offsetAfter = r11;
    }
}
