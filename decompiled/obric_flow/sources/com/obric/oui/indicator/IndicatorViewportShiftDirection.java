package com.obric.oui.indicator;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", "", "", "stepDistance", "resolveExitTranslation", "(F)F", "exitTranslationSign", "F", "FORWARD", "BACKWARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum IndicatorViewportShiftDirection extends Enum<IndicatorViewportShiftDirection> {
    public static final IndicatorViewportShiftDirection BACKWARD = null;
    public static final IndicatorViewportShiftDirection FORWARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IndicatorViewportShiftDirection[] f13439a = null;
    private final float exitTranslationSign;

    static {
        IndicatorViewportShiftDirection r5 = new IndicatorViewportShiftDirection(0, "FORWARD", -1.0f);
        FORWARD = r5;
        IndicatorViewportShiftDirection r10 = new IndicatorViewportShiftDirection(1, "BACKWARD", 1.0f);
        BACKWARD = r10;
        f13439a = new IndicatorViewportShiftDirection[]{r5, r10};
    }

    public IndicatorViewportShiftDirection(int r5, String r10, float r11) {
        super(r10, r5);
        this.exitTranslationSign = r11;
    }

    public static IndicatorViewportShiftDirection valueOf(String r5) {
        return (IndicatorViewportShiftDirection) Enum.valueOf(IndicatorViewportShiftDirection.class, r5);
    }

    public static IndicatorViewportShiftDirection[] values() {
        return (IndicatorViewportShiftDirection[]) f13439a.clone();
    }

    public final float resolveExitTranslation(float r5) {
        return this.exitTranslationSign * r5;
    }
}
