package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum PreferredColorSpace extends Enum<PreferredColorSpace> {
    private static final /* synthetic */ PreferredColorSpace[] $VALUES = null;
    public static final PreferredColorSpace DISPLAY_P3 = null;
    public static final PreferredColorSpace SRGB = null;

    private static /* synthetic */ PreferredColorSpace[] $values() {
        return new PreferredColorSpace[]{SRGB, DISPLAY_P3};
    }

    static {
        SRGB = new PreferredColorSpace("SRGB", 0);
        DISPLAY_P3 = new PreferredColorSpace("DISPLAY_P3", 1);
        $VALUES = $values();
    }

    private PreferredColorSpace(String r1, int r2) {
        super(r1, r2);
    }

    public static PreferredColorSpace valueOf(String r2) {
        return (PreferredColorSpace) ZeusTransformUtils.preCheckCast(Enum.valueOf(PreferredColorSpace.class, r2), PreferredColorSpace.class, "com.obric.memorydata.plugin");
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PreferredColorSpace[].class, "com.obric.memorydata.plugin");
    }
}
