package com.lynx.tasm.behavior.ui.accessibility;

/* JADX INFO: loaded from: classes2.dex */
public final enum LynxAccessibilityHelper$LynxAccessibilityTraits extends Enum<LynxAccessibilityHelper$LynxAccessibilityTraits> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxAccessibilityHelper$LynxAccessibilityTraits f10397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LynxAccessibilityHelper$LynxAccessibilityTraits[] f10398b = null;

    static {
        LynxAccessibilityHelper$LynxAccessibilityTraits r5 = new LynxAccessibilityHelper$LynxAccessibilityTraits("NONE", 0);
        f10397a = r5;
        f10398b = new LynxAccessibilityHelper$LynxAccessibilityTraits[]{r5, new LynxAccessibilityHelper$LynxAccessibilityTraits("IMAGE", 1), new LynxAccessibilityHelper$LynxAccessibilityTraits("BUTTON", 2)};
    }

    public LynxAccessibilityHelper$LynxAccessibilityTraits(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxAccessibilityHelper$LynxAccessibilityTraits valueOf(String r5) {
        return (LynxAccessibilityHelper$LynxAccessibilityTraits) Enum.valueOf(LynxAccessibilityHelper$LynxAccessibilityTraits.class, r5);
    }

    public static LynxAccessibilityHelper$LynxAccessibilityTraits[] values() {
        return (LynxAccessibilityHelper$LynxAccessibilityTraits[]) f10398b.clone();
    }
}
