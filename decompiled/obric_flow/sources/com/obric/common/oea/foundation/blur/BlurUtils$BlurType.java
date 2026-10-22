package com.obric.common.oea.foundation.blur;

/* JADX INFO: loaded from: classes2.dex */
public final enum BlurUtils$BlurType extends Enum<BlurUtils$BlurType> {
    public static final BlurUtils$BlurType NONE = null;
    public static final BlurUtils$BlurType NORMAL_BLUR = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_DOWN_UP = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_LEFT_RIGHT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_RIGHT_LEFT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_UP_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlurUtils$BlurType[] f11332a = null;

    static {
        BlurUtils$BlurType r5 = new BlurUtils$BlurType("NONE", 0);
        NONE = r5;
        BlurUtils$BlurType r10 = new BlurUtils$BlurType("NORMAL_BLUR", 1);
        NORMAL_BLUR = r10;
        BlurUtils$BlurType r11 = new BlurUtils$BlurType("PROGRESS_BLUR_DOWN_UP", 2);
        PROGRESS_BLUR_DOWN_UP = r11;
        BlurUtils$BlurType r12 = new BlurUtils$BlurType("PROGRESS_BLUR_UP_DOWN", 3);
        PROGRESS_BLUR_UP_DOWN = r12;
        BlurUtils$BlurType r13 = new BlurUtils$BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4);
        PROGRESS_BLUR_LEFT_RIGHT = r13;
        BlurUtils$BlurType r14 = new BlurUtils$BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5);
        PROGRESS_BLUR_RIGHT_LEFT = r14;
        f11332a = new BlurUtils$BlurType[]{r5, r10, r11, r12, r13, r14};
    }

    public static BlurUtils$BlurType valueOf(String r5) {
        return (BlurUtils$BlurType) Enum.valueOf(BlurUtils$BlurType.class, r5);
    }

    public static BlurUtils$BlurType[] values() {
        return (BlurUtils$BlurType[]) f11332a.clone();
    }
}
