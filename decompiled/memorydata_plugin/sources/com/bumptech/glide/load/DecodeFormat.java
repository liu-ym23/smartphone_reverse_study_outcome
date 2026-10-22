package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum DecodeFormat extends Enum<DecodeFormat> {
    private static final /* synthetic */ DecodeFormat[] $VALUES = null;
    public static final DecodeFormat DEFAULT = null;
    public static final DecodeFormat PREFER_ARGB_8888 = null;
    public static final DecodeFormat PREFER_RGB_565 = null;

    private static /* synthetic */ DecodeFormat[] $values() {
        return new DecodeFormat[]{PREFER_ARGB_8888, PREFER_RGB_565};
    }

    static {
        DecodeFormat r0 = new DecodeFormat("PREFER_ARGB_8888", 0);
        PREFER_ARGB_8888 = r0;
        PREFER_RGB_565 = new DecodeFormat("PREFER_RGB_565", 1);
        $VALUES = $values();
        DEFAULT = r0;
    }

    private DecodeFormat(String r1, int r2) {
        super(r1, r2);
    }

    public static DecodeFormat valueOf(String r2) {
        return (DecodeFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(DecodeFormat.class, r2), DecodeFormat.class, "com.obric.memorydata.plugin");
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DecodeFormat[].class, "com.obric.memorydata.plugin");
    }
}
