package org.apache.poi.common.usermodel.fonts;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum FontFamily extends Enum<FontFamily> {
    private static final /* synthetic */ FontFamily[] $VALUES = null;
    public static final FontFamily FF_DECORATIVE = null;
    public static final FontFamily FF_DONTCARE = null;
    public static final FontFamily FF_MODERN = null;
    public static final FontFamily FF_ROMAN = null;
    public static final FontFamily FF_SCRIPT = null;
    public static final FontFamily FF_SWISS = null;
    private int nativeId;

    static {
        FontFamily r0 = new FontFamily("FF_DONTCARE", 0, 0);
        FF_DONTCARE = r0;
        FontFamily r1 = new FontFamily("FF_ROMAN", 1, 1);
        FF_ROMAN = r1;
        FontFamily r3 = new FontFamily("FF_SWISS", 2, 2);
        FF_SWISS = r3;
        FontFamily r5 = new FontFamily("FF_MODERN", 3, 3);
        FF_MODERN = r5;
        FontFamily r7 = new FontFamily("FF_SCRIPT", 4, 4);
        FF_SCRIPT = r7;
        FontFamily r9 = new FontFamily("FF_DECORATIVE", 5, 5);
        FF_DECORATIVE = r9;
        $VALUES = new FontFamily[]{r0, r1, r3, r5, r7, r9};
    }

    private FontFamily(String r1, int r2, int r3) {
        super(r1, r2);
        this.nativeId = r3;
    }

    public static FontFamily valueOf(int r5) {
        FontFamily[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        FontFamily r3 = r0[r2];
        if (r3.nativeId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static FontFamily valueOf(String r2) {
        return (FontFamily) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontFamily.class, r2), FontFamily.class, "com.obric.memorydata.plugin");
    }

    public static FontFamily valueOfPitchFamily(byte r0) {
        return valueOf(r0 >>> 4);
    }

    public static FontFamily[] values() {
        return (FontFamily[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontFamily[].class, "com.obric.memorydata.plugin");
    }

    public int getFlag() {
        return this.nativeId;
    }
}
