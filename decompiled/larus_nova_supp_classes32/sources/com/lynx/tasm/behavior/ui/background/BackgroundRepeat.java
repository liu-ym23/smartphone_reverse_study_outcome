package com.lynx.tasm.behavior.ui.background;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum BackgroundRepeat extends Enum<BackgroundRepeat> {
    public static final BackgroundRepeat NO_REPEAT = null;
    public static final BackgroundRepeat REPEAT = null;
    public static final BackgroundRepeat REPEAT_X = null;
    public static final BackgroundRepeat REPEAT_Y = null;
    public static final BackgroundRepeat ROUND = null;
    public static final BackgroundRepeat SPACE = null;
    public static final /* synthetic */ BackgroundRepeat[] a = null;

    static {
        BackgroundRepeat r0 = new BackgroundRepeat("REPEAT", 0);
        REPEAT = r0;
        BackgroundRepeat r1 = new BackgroundRepeat("NO_REPEAT", 1);
        NO_REPEAT = r1;
        BackgroundRepeat r3 = new BackgroundRepeat("REPEAT_X", 2);
        REPEAT_X = r3;
        BackgroundRepeat r5 = new BackgroundRepeat("REPEAT_Y", 3);
        REPEAT_Y = r5;
        BackgroundRepeat r7 = new BackgroundRepeat("ROUND", 4);
        ROUND = r7;
        BackgroundRepeat r9 = new BackgroundRepeat("SPACE", 5);
        SPACE = r9;
        a = new BackgroundRepeat[]{r0, r1, r3, r5, r7, r9};
    }

    public static BackgroundRepeat[] values() {
        return (BackgroundRepeat[]) a.clone();
    }

    public static BackgroundRepeat valueOf(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return REPEAT;
    L16:
        return SPACE;
    L18:
        return ROUND;
    L20:
        return REPEAT_Y;
    L22:
        return REPEAT_X;
    L24:
        return NO_REPEAT;
    L26:
        return REPEAT;
    }

    public static BackgroundRepeat valueOf(String r1) {
        return (BackgroundRepeat) a.a(BackgroundRepeat.class, r1);
    }

    public BackgroundRepeat(String r1, int r2) {
        super(r1, r2);
    }
}
