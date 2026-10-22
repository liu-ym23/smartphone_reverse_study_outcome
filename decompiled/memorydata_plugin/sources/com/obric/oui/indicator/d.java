package com.obric.oui.indicator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0000¨\u0006\r"}, d2 = {"computeViewportState", "Lcom/obric/oui/indicator/IndicatorViewportState;", "totalCount", "", "current", "maxVisibleDots", "resolveViewportRange", "Lkotlin/ranges/IntRange;", "visibleCount", "resolveViewportShiftDirection", "Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", "currentRange", "nextRange", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class d {
    public static final IndicatorViewportShiftDirection a(IntRange r1, IntRange r2) {
        Intrinsics.checkNotNullParameter(r1, "currentRange");
        Intrinsics.checkNotNullParameter(r2, "nextRange");
        int r3 = r2.getFirst() - r1.getFirst();
        if (r3 == (-1)) goto L9;
        if (r3 == 1) goto L11;
        return null;
    L11:
        return IndicatorViewportShiftDirection.FORWARD;
    L9:
        return IndicatorViewportShiftDirection.BACKWARD;
    }

    public static final c a(int r1, int r2, int r3) {
        return new c(r1, r2, b(r1, r2, Math.min(r1, r3)));
    }

    private static final IntRange b(int r2, int r3, int r4) {
        if (r2 <= r4) goto L5;
        int r5 = r3 - (r4 / 2);
        int r6 = RangesKt.coerceIn(r5, 0, r2 - r4);
        return RangesKt.until(r6, r4 + r6);
    L5:
        return RangesKt.until(0, r2);
    }
}
