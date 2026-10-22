package com.obric.oui.indicator;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/obric/oui/indicator/IndicatorAnimator$RenderReason", "", "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "", "logValue", "Ljava/lang/String;", "getLogValue", "()Ljava/lang/String;", "SCROLL", "REFRESH_DOTS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum IndicatorAnimator$RenderReason extends Enum<IndicatorAnimator$RenderReason> {
    public static final IndicatorAnimator$RenderReason REFRESH_DOTS = null;
    public static final IndicatorAnimator$RenderReason SCROLL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IndicatorAnimator$RenderReason[] f13426a = null;
    private final String logValue;

    static {
        IndicatorAnimator$RenderReason r5 = new IndicatorAnimator$RenderReason("SCROLL", 0, "scroll");
        SCROLL = r5;
        IndicatorAnimator$RenderReason r10 = new IndicatorAnimator$RenderReason("REFRESH_DOTS", 1, "refreshDots");
        REFRESH_DOTS = r10;
        f13426a = new IndicatorAnimator$RenderReason[]{r5, r10};
    }

    public IndicatorAnimator$RenderReason(String r5, int r10, String r11) {
        super(r5, r10);
        this.logValue = r11;
    }

    public static IndicatorAnimator$RenderReason valueOf(String r5) {
        return (IndicatorAnimator$RenderReason) Enum.valueOf(IndicatorAnimator$RenderReason.class, r5);
    }

    public static IndicatorAnimator$RenderReason[] values() {
        return (IndicatorAnimator$RenderReason[]) f13426a.clone();
    }

    public final String getLogValue() {
        return this.logValue;
    }
}
