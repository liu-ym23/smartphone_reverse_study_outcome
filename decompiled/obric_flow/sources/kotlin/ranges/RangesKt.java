package kotlin.ranges;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/ranges/RangesKt__RangesKt", "kotlin/ranges/RangesKt___RangesKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class RangesKt extends RangesKt___RangesKt {
    private RangesKt() {
    }

    public static /* bridge */ /* synthetic */ double a(double r10) {
        return RangesKt___RangesKt.coerceIn(r10, 0.0d, 1.0d);
    }

    public static /* bridge */ /* synthetic */ long b(long r5, LongRange r10) {
        return RangesKt___RangesKt.coerceIn(r5, r10);
    }
}
