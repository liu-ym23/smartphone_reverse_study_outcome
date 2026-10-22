package com.lynx.canvas;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SurfaceScaleMode extends Enum<SurfaceScaleMode> {
    private static final /* synthetic */ SurfaceScaleMode[] $VALUES = null;
    public static final SurfaceScaleMode SCALE_TO_CENTER = null;
    public static final SurfaceScaleMode SCALE_TO_FILL = null;
    public static final SurfaceScaleMode SCALE_TO_FILL_AND_CROP = null;
    public static final SurfaceScaleMode SCALE_TO_FILL_WITH_SOURCE_CROP = null;
    public final int value;

    static {
        SurfaceScaleMode r0 = new SurfaceScaleMode("SCALE_TO_FILL", 0, 0);
        SCALE_TO_FILL = r0;
        SurfaceScaleMode r1 = new SurfaceScaleMode("SCALE_TO_CENTER", 1, 1);
        SCALE_TO_CENTER = r1;
        SurfaceScaleMode r3 = new SurfaceScaleMode("SCALE_TO_FILL_AND_CROP", 2, 2);
        SCALE_TO_FILL_AND_CROP = r3;
        SurfaceScaleMode r5 = new SurfaceScaleMode("SCALE_TO_FILL_WITH_SOURCE_CROP", 3, 3);
        SCALE_TO_FILL_WITH_SOURCE_CROP = r5;
        $VALUES = new SurfaceScaleMode[]{r0, r1, r3, r5};
    }

    public static SurfaceScaleMode[] values() {
        return (SurfaceScaleMode[]) $VALUES.clone();
    }

    public static SurfaceScaleMode valueOf(String r1) {
        return (SurfaceScaleMode) a.a(SurfaceScaleMode.class, r1);
    }

    private SurfaceScaleMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
