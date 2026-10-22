package com.obric.common.oea.foundation.graphics.smoothcorner;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7757a = null;

    static {
        int[] r0 = new int[SmoothCornerHelper.Companion.CurveType.values().length];
        f7757a = r0;
        r0[SmoothCornerHelper.Companion.CurveType.BASIC.ordinal()] = 1;
        r0[SmoothCornerHelper.Companion.CurveType.QUADRATIC.ordinal()] = 2;
        r0[SmoothCornerHelper.Companion.CurveType.SKETCH.ordinal()] = 3;
        r0[SmoothCornerHelper.Companion.CurveType.FIGMA.ordinal()] = 4;
        r0[SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE.ordinal()] = 5;
    }
}
