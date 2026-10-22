package org.apache.poi.common.usermodel.fonts;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum FontPitch extends Enum<FontPitch> {
    private static final /* synthetic */ FontPitch[] $VALUES = null;
    public static final FontPitch DEFAULT = null;
    public static final FontPitch FIXED = null;
    public static final FontPitch VARIABLE = null;
    private int nativeId;

    static {
        FontPitch r0 = new FontPitch("DEFAULT", 0, 0);
        DEFAULT = r0;
        FontPitch r1 = new FontPitch("FIXED", 1, 1);
        FIXED = r1;
        FontPitch r3 = new FontPitch("VARIABLE", 2, 2);
        VARIABLE = r3;
        $VALUES = new FontPitch[]{r0, r1, r3};
    }

    private FontPitch(String r1, int r2, int r3) {
        super(r1, r2);
        this.nativeId = r3;
    }

    public static byte getNativeId(FontPitch r0, FontFamily r1) {
        return (byte) (r0.getNativeId() | (r1.getFlag() << 4));
    }

    public static FontPitch valueOf(int r5) {
        FontPitch[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        FontPitch r3 = r0[r2];
        if (r3.nativeId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static FontPitch valueOf(String r2) {
        return (FontPitch) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontPitch.class, r2), FontPitch.class, "com.obric.memorydata.plugin");
    }

    public static FontPitch valueOfPitchFamily(byte r0) {
        return valueOf(r0 & 3);
    }

    public static FontPitch[] values() {
        return (FontPitch[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontPitch[].class, "com.obric.memorydata.plugin");
    }

    public int getNativeId() {
        return this.nativeId;
    }
}
