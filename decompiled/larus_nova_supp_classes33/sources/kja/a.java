package kja;

import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[SmoothCornerHelper.Companion.CurveType.values().length];
        a = r0;
        r0[SmoothCornerHelper.Companion.CurveType.BASIC.ordinal()] = 1;
        r0[SmoothCornerHelper.Companion.CurveType.QUADRATIC.ordinal()] = 2;
        r0[SmoothCornerHelper.Companion.CurveType.SKETCH.ordinal()] = 3;
        r0[SmoothCornerHelper.Companion.CurveType.FIGMA.ordinal()] = 4;
        r0[SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE.ordinal()] = 5;
    }
}
