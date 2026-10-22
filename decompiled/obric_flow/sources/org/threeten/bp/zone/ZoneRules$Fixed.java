package org.threeten.bp.zone;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes3.dex */
final class ZoneRules$Fixed extends d implements Serializable {
    private static final long serialVersionUID = -8733721350312276297L;
    private final ZoneOffset offset;

    public ZoneRules$Fixed(ZoneOffset r5) {
        this.offset = r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZoneRules$Fixed) == false) goto L10;
        return this.offset.equals(((ZoneRules$Fixed) r5).offset);
    L10:
        if ((r5 instanceof StandardZoneRules) == false) goto L18;
        StandardZoneRules r10 = (StandardZoneRules) r5;
        if (r10.isFixedOffset() == false) goto L17;
        if (this.offset.equals(r10.getOffset(Instant.EPOCH)) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public Duration getDaylightSavings(Instant r5) {
        return Duration.ZERO;
    }

    @Override // org.threeten.bp.zone.d
    public ZoneOffset getOffset(Instant r5) {
        return this.offset;
    }

    public ZoneOffset getStandardOffset(Instant r5) {
        return this.offset;
    }

    @Override // org.threeten.bp.zone.d
    public ZoneOffsetTransition getTransition(LocalDateTime r5) {
        return null;
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Collections.emptyList();
    }

    public List<ZoneOffsetTransition> getTransitions() {
        return Collections.emptyList();
    }

    @Override // org.threeten.bp.zone.d
    public List<ZoneOffset> getValidOffsets(LocalDateTime r5) {
        return Collections.singletonList(this.offset);
    }

    public int hashCode() {
        int r5 = this.offset.hashCode() + 31;
        return ((this.offset.hashCode() + 31) ^ r5) ^ 1;
    }

    @Override // org.threeten.bp.zone.d
    public boolean isDaylightSavings(Instant r5) {
        return false;
    }

    @Override // org.threeten.bp.zone.d
    public boolean isFixedOffset() {
        return true;
    }

    @Override // org.threeten.bp.zone.d
    public boolean isValidOffset(LocalDateTime r5, ZoneOffset r10) {
        return this.offset.equals(r10);
    }

    public ZoneOffsetTransition nextTransition(Instant r5) {
        return null;
    }

    public ZoneOffsetTransition previousTransition(Instant r5) {
        return null;
    }

    public String toString() {
        return "FixedRules:" + this.offset;
    }

    public ZoneOffset getOffset(LocalDateTime r5) {
        return this.offset;
    }
}
