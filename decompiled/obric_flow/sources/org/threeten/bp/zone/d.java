package org.threeten.bp.zone;

import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public d() {
    }

    public static d of(ZoneOffset r10, ZoneOffset r11, List<ZoneOffsetTransition> r12, List<ZoneOffsetTransition> r13, List<ZoneOffsetTransitionRule> r14) {
        jm.c.p(r10, "baseStandardOffset");
        jm.c.p(r11, "baseWallOffset");
        jm.c.p(r12, "standardOffsetTransitionList");
        jm.c.p(r13, "transitionList");
        jm.c.p(r14, "lastRules");
        return new StandardZoneRules(r10, r11, r12, r13, r14);
    }

    public abstract ZoneOffset getOffset(Instant r5);

    public abstract ZoneOffsetTransition getTransition(LocalDateTime r5);

    public abstract List getValidOffsets(LocalDateTime r5);

    public abstract boolean isDaylightSavings(Instant r5);

    public abstract boolean isFixedOffset();

    public abstract boolean isValidOffset(LocalDateTime r5, ZoneOffset r10);

    public static d of(ZoneOffset r5) {
        jm.c.p(r5, "offset");
        return new ZoneRules$Fixed(r5);
    }
}
