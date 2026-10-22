package androidx.recyclerview.base;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/recyclerview/base/FluidRubberBand;", "", "()V", "Companion", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidRubberBand {
    public static final Companion Companion = null;
    private static final float RUBBER_BAND_COEFFICIENT = 0.55f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/recyclerview/base/FluidRubberBand$Companion;", "", "()V", "RUBBER_BAND_COEFFICIENT", "", "distance", TypedValues.CycleType.S_WAVE_OFFSET, "range", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final float distance(float r2, float r3) {
            if (r2 >= 0.0f) goto L5;
        L9:
            return 0.0f;
        L5:
            if (r3 <= 0.0f) goto L9;
            float r1 = RangesKt.coerceAtMost(r2, r3 - 1.0E-5f);
            return ((r3 * r1) / (r3 - r1)) / FluidRubberBand.RUBBER_BAND_COEFFICIENT;
        }

        public final float offset(float r2, float r3) {
            if (r2 >= 0.0f) goto L5;
            return 0.0f;
        L5:
            if (r3 > 0.0f) goto L8;
            return 0.0f;
        L8:
            return (1.0f - (1.0f / (((r2 / r3) * FluidRubberBand.RUBBER_BAND_COEFFICIENT) + 1.0f))) * r3;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FluidRubberBand() {
    }
}
