package com.obric.common.oea.foundation.blur;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum BlurUtils$BlurType extends Enum<BlurUtils$BlurType> {
    public static final BlurUtils$BlurType NONE = null;
    public static final BlurUtils$BlurType NORMAL_BLUR = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_DOWN_UP = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_LEFT_RIGHT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_RIGHT_LEFT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_UP_DOWN = null;
    public static final /* synthetic */ BlurUtils$BlurType[] a = null;

    static {
        BlurUtils$BlurType r0 = new BlurUtils$BlurType("NONE", 0);
        NONE = r0;
        BlurUtils$BlurType r1 = new BlurUtils$BlurType("NORMAL_BLUR", 1);
        NORMAL_BLUR = r1;
        BlurUtils$BlurType r3 = new BlurUtils$BlurType("PROGRESS_BLUR_DOWN_UP", 2);
        PROGRESS_BLUR_DOWN_UP = r3;
        BlurUtils$BlurType r5 = new BlurUtils$BlurType("PROGRESS_BLUR_UP_DOWN", 3);
        PROGRESS_BLUR_UP_DOWN = r5;
        BlurUtils$BlurType r7 = new BlurUtils$BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4);
        PROGRESS_BLUR_LEFT_RIGHT = r7;
        BlurUtils$BlurType r9 = new BlurUtils$BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5);
        PROGRESS_BLUR_RIGHT_LEFT = r9;
        a = new BlurUtils$BlurType[]{r0, r1, r3, r5, r7, r9};
    }

    public static BlurUtils$BlurType[] values() {
        return (BlurUtils$BlurType[]) a.clone();
    }

    public static BlurUtils$BlurType valueOf(String r1) {
        return (BlurUtils$BlurType) a.a(BlurUtils$BlurType.class, r1);
    }

    public BlurUtils$BlurType(String r1, int r2) {
        super(r1, r2);
    }
}
