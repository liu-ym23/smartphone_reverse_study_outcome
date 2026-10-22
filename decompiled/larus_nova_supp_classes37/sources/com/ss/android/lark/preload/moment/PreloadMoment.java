package com.ss.android.lark.preload.moment;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PreloadMoment extends Enum<PreloadMoment> {
    public static final PreloadMoment FIRST_SCREEN_SHOWED = null;
    public static final PreloadMoment IDLE = null;
    public static final PreloadMoment IMMEDIATELY = null;
    public static final /* synthetic */ PreloadMoment[] a = null;

    static {
        PreloadMoment r0 = new PreloadMoment("IDLE", 0);
        IDLE = r0;
        PreloadMoment r1 = new PreloadMoment("FIRST_SCREEN_SHOWED", 1);
        FIRST_SCREEN_SHOWED = r1;
        PreloadMoment r3 = new PreloadMoment("IMMEDIATELY", 2);
        IMMEDIATELY = r3;
        a = new PreloadMoment[]{r0, r1, r3};
    }

    public static PreloadMoment[] values() {
        return (PreloadMoment[]) a.clone();
    }

    public static PreloadMoment valueOf(String r1) {
        return (PreloadMoment) a.a(PreloadMoment.class, r1);
    }

    public PreloadMoment(String r1, int r2) {
        super(r1, r2);
    }
}
