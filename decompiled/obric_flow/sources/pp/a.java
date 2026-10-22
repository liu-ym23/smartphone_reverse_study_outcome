package pp;

import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper$Companion$CurveType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21385a = null;

    static {
        int[] r5 = new int[SmoothCornerHelper$Companion$CurveType.values().length];
        f21385a = r5;
        r5[SmoothCornerHelper$Companion$CurveType.BASIC.ordinal()] = 1;
        r5[SmoothCornerHelper$Companion$CurveType.QUADRATIC.ordinal()] = 2;
        r5[SmoothCornerHelper$Companion$CurveType.SKETCH.ordinal()] = 3;
        r5[SmoothCornerHelper$Companion$CurveType.FIGMA.ordinal()] = 4;
        r5[SmoothCornerHelper$Companion$CurveType.QUADRATIC_CAPSULE.ordinal()] = 5;
    }
}
