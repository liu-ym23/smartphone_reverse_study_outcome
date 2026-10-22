package com.bytedance.android.ec.common.impl.utils;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final enum ECDisplayUtils$ScreenType extends Enum<ECDisplayUtils$ScreenType> {
    public static final ECDisplayUtils$ScreenType FULL_SCREEN = null;
    public static final ECDisplayUtils$ScreenType NORMAL_SCREEN = null;
    public static final ECDisplayUtils$ScreenType UNKNOWN = null;
    public static final /* synthetic */ ECDisplayUtils$ScreenType[] a = null;

    static {
        ECDisplayUtils$ScreenType r0 = new ECDisplayUtils$ScreenType("FULL_SCREEN", 0);
        FULL_SCREEN = r0;
        ECDisplayUtils$ScreenType r1 = new ECDisplayUtils$ScreenType("NORMAL_SCREEN", 1);
        NORMAL_SCREEN = r1;
        ECDisplayUtils$ScreenType r10 = new ECDisplayUtils$ScreenType("UNKNOWN", 2);
        UNKNOWN = r10;
        a = new ECDisplayUtils$ScreenType[]{r0, r1, r10};
    }

    public static ECDisplayUtils$ScreenType[] values() {
        return (ECDisplayUtils$ScreenType[]) a.clone();
    }

    public static ECDisplayUtils$ScreenType valueOf(String r1) {
        return (ECDisplayUtils$ScreenType) a.a(ECDisplayUtils$ScreenType.class, r1);
    }

    public ECDisplayUtils$ScreenType(String r1, int r10) {
        super(r1, r10);
    }
}
