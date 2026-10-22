package com.lynx.tasm.animation.keyframe;

/* JADX INFO: loaded from: classes2.dex */
final enum LynxKeyframeAnimator$LynxAnimationPropertyType extends Enum<LynxKeyframeAnimator$LynxAnimationPropertyType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType f10071a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType f10072b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType f10073c = null;
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType d = null;
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType e = null;
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType f = null;
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType f10074h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType f10075i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxAnimationPropertyType f10076j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ LynxKeyframeAnimator$LynxAnimationPropertyType[] f10077k = null;

    static {
        LynxKeyframeAnimator$LynxAnimationPropertyType r5 = new LynxKeyframeAnimator$LynxAnimationPropertyType("TRANSLATE_X", 0);
        f10071a = r5;
        LynxKeyframeAnimator$LynxAnimationPropertyType r10 = new LynxKeyframeAnimator$LynxAnimationPropertyType("TRANSLATE_Y", 1);
        f10072b = r10;
        LynxKeyframeAnimator$LynxAnimationPropertyType r11 = new LynxKeyframeAnimator$LynxAnimationPropertyType("TRANSLATE_Z", 2);
        f10073c = r11;
        LynxKeyframeAnimator$LynxAnimationPropertyType r12 = new LynxKeyframeAnimator$LynxAnimationPropertyType("ROTATE_X", 3);
        d = r12;
        LynxKeyframeAnimator$LynxAnimationPropertyType r13 = new LynxKeyframeAnimator$LynxAnimationPropertyType("ROTATE_Y", 4);
        e = r13;
        LynxKeyframeAnimator$LynxAnimationPropertyType r14 = new LynxKeyframeAnimator$LynxAnimationPropertyType("ROTATE_Z", 5);
        f = r14;
        LynxKeyframeAnimator$LynxAnimationPropertyType r15 = new LynxKeyframeAnimator$LynxAnimationPropertyType("SCALE_X", 6);
        g = r15;
        LynxKeyframeAnimator$LynxAnimationPropertyType r16 = new LynxKeyframeAnimator$LynxAnimationPropertyType("SCALE_Y", 7);
        f10074h = r16;
        LynxKeyframeAnimator$LynxAnimationPropertyType r17 = new LynxKeyframeAnimator$LynxAnimationPropertyType("OPACITY", 8);
        f10075i = r17;
        LynxKeyframeAnimator$LynxAnimationPropertyType r18 = new LynxKeyframeAnimator$LynxAnimationPropertyType("BG_COLOR", 9);
        f10076j = r18;
        f10077k = new LynxKeyframeAnimator$LynxAnimationPropertyType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public LynxKeyframeAnimator$LynxAnimationPropertyType(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxKeyframeAnimator$LynxAnimationPropertyType valueOf(String r5) {
        return (LynxKeyframeAnimator$LynxAnimationPropertyType) Enum.valueOf(LynxKeyframeAnimator$LynxAnimationPropertyType.class, r5);
    }

    public static LynxKeyframeAnimator$LynxAnimationPropertyType[] values() {
        return (LynxKeyframeAnimator$LynxAnimationPropertyType[]) f10077k.clone();
    }
}
