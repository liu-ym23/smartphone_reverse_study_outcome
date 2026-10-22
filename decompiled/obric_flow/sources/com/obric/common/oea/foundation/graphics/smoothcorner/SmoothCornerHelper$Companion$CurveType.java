package com.obric.common.oea.foundation.graphics.smoothcorner;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType", "", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "QUADRATIC", "SKETCH", "FIGMA", "BASIC", "QUADRATIC_CAPSULE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum SmoothCornerHelper$Companion$CurveType extends Enum<SmoothCornerHelper$Companion$CurveType> {
    public static final SmoothCornerHelper$Companion$CurveType BASIC = null;
    public static final SmoothCornerHelper$Companion$CurveType FIGMA = null;
    public static final SmoothCornerHelper$Companion$CurveType QUADRATIC = null;
    public static final SmoothCornerHelper$Companion$CurveType QUADRATIC_CAPSULE = null;
    public static final SmoothCornerHelper$Companion$CurveType SKETCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SmoothCornerHelper$Companion$CurveType[] f11341a = null;

    static {
        SmoothCornerHelper$Companion$CurveType r5 = new SmoothCornerHelper$Companion$CurveType("QUADRATIC", 0);
        QUADRATIC = r5;
        SmoothCornerHelper$Companion$CurveType r10 = new SmoothCornerHelper$Companion$CurveType("SKETCH", 1);
        SKETCH = r10;
        SmoothCornerHelper$Companion$CurveType r11 = new SmoothCornerHelper$Companion$CurveType("FIGMA", 2);
        FIGMA = r11;
        SmoothCornerHelper$Companion$CurveType r12 = new SmoothCornerHelper$Companion$CurveType("BASIC", 3);
        BASIC = r12;
        SmoothCornerHelper$Companion$CurveType r13 = new SmoothCornerHelper$Companion$CurveType("QUADRATIC_CAPSULE", 4);
        QUADRATIC_CAPSULE = r13;
        f11341a = new SmoothCornerHelper$Companion$CurveType[]{r5, r10, r11, r12, r13};
    }

    public static SmoothCornerHelper$Companion$CurveType valueOf(String r5) {
        return (SmoothCornerHelper$Companion$CurveType) Enum.valueOf(SmoothCornerHelper$Companion$CurveType.class, r5);
    }

    public static SmoothCornerHelper$Companion$CurveType[] values() {
        return (SmoothCornerHelper$Companion$CurveType[]) f11341a.clone();
    }
}
