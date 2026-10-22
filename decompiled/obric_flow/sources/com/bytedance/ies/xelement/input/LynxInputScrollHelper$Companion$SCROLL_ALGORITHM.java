package com.bytedance.ies.xelement.input;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/xelement/input/LynxInputScrollHelper$Companion$SCROLL_ALGORITHM", "", "Lcom/bytedance/ies/xelement/input/LynxInputScrollHelper$Companion$SCROLL_ALGORITHM;", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final enum LynxInputScrollHelper$Companion$SCROLL_ALGORITHM extends Enum<LynxInputScrollHelper$Companion$SCROLL_ALGORITHM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxInputScrollHelper$Companion$SCROLL_ALGORITHM f6427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxInputScrollHelper$Companion$SCROLL_ALGORITHM f6428b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxInputScrollHelper$Companion$SCROLL_ALGORITHM f6429c = null;
    public static final LynxInputScrollHelper$Companion$SCROLL_ALGORITHM d = null;
    public static final /* synthetic */ LynxInputScrollHelper$Companion$SCROLL_ALGORITHM[] e = null;

    static {
        LynxInputScrollHelper$Companion$SCROLL_ALGORITHM r5 = new LynxInputScrollHelper$Companion$SCROLL_ALGORITHM("NONE", 0);
        f6427a = r5;
        LynxInputScrollHelper$Companion$SCROLL_ALGORITHM r10 = new LynxInputScrollHelper$Companion$SCROLL_ALGORITHM("IMMERSIVE", 1);
        f6428b = r10;
        LynxInputScrollHelper$Companion$SCROLL_ALGORITHM r11 = new LynxInputScrollHelper$Companion$SCROLL_ALGORITHM("NORMAL", 2);
        f6429c = r11;
        LynxInputScrollHelper$Companion$SCROLL_ALGORITHM r12 = new LynxInputScrollHelper$Companion$SCROLL_ALGORITHM("NOTHING", 3);
        d = r12;
        e = new LynxInputScrollHelper$Companion$SCROLL_ALGORITHM[]{r5, r10, r11, r12};
    }

    public LynxInputScrollHelper$Companion$SCROLL_ALGORITHM(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxInputScrollHelper$Companion$SCROLL_ALGORITHM valueOf(String r5) {
        return (LynxInputScrollHelper$Companion$SCROLL_ALGORITHM) Enum.valueOf(LynxInputScrollHelper$Companion$SCROLL_ALGORITHM.class, r5);
    }

    public static LynxInputScrollHelper$Companion$SCROLL_ALGORITHM[] values() {
        return (LynxInputScrollHelper$Companion$SCROLL_ALGORITHM[]) e.clone();
    }
}
