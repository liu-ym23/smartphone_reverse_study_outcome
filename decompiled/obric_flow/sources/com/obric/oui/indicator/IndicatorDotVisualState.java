package com.obric.oui.indicator;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotVisualState;", "", "ACTIVE", "NORMAL", "EDGE", "HIDDEN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum IndicatorDotVisualState extends Enum<IndicatorDotVisualState> {
    public static final IndicatorDotVisualState ACTIVE = null;
    public static final IndicatorDotVisualState EDGE = null;
    public static final IndicatorDotVisualState HIDDEN = null;
    public static final IndicatorDotVisualState NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IndicatorDotVisualState[] f13432a = null;

    static {
        IndicatorDotVisualState r5 = new IndicatorDotVisualState("ACTIVE", 0);
        ACTIVE = r5;
        IndicatorDotVisualState r10 = new IndicatorDotVisualState("NORMAL", 1);
        NORMAL = r10;
        IndicatorDotVisualState r11 = new IndicatorDotVisualState("EDGE", 2);
        EDGE = r11;
        IndicatorDotVisualState r12 = new IndicatorDotVisualState("HIDDEN", 3);
        HIDDEN = r12;
        f13432a = new IndicatorDotVisualState[]{r5, r10, r11, r12};
    }

    public static IndicatorDotVisualState valueOf(String r5) {
        return (IndicatorDotVisualState) Enum.valueOf(IndicatorDotVisualState.class, r5);
    }

    public static IndicatorDotVisualState[] values() {
        return (IndicatorDotVisualState[]) f13432a.clone();
    }
}
