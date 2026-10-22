package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum FontFamily extends Enum<FontFamily> {
    private static final /* synthetic */ FontFamily[] $VALUES = null;
    public static final FontFamily DECORATIVE = null;
    public static final FontFamily MODERN = null;
    public static final FontFamily NOT_APPLICABLE = null;
    public static final FontFamily ROMAN = null;
    public static final FontFamily SCRIPT = null;
    public static final FontFamily SWISS = null;
    private static FontFamily[] _table;
    private int family;

    static {
        int r2 = 0;
        FontFamily r0 = new FontFamily("NOT_APPLICABLE", 0, 0);
        NOT_APPLICABLE = r0;
        FontFamily r1 = new FontFamily("ROMAN", 1, 1);
        ROMAN = r1;
        FontFamily r3 = new FontFamily("SWISS", 2, 2);
        SWISS = r3;
        FontFamily r5 = new FontFamily("MODERN", 3, 3);
        MODERN = r5;
        FontFamily r7 = new FontFamily("SCRIPT", 4, 4);
        SCRIPT = r7;
        FontFamily r9 = new FontFamily("DECORATIVE", 5, 5);
        DECORATIVE = r9;
        $VALUES = new FontFamily[]{r0, r1, r3, r5, r7, r9};
        _table = new FontFamily[6];
        FontFamily[] r4 = values();
        int r6 = r4.length;
    L3:
        if (r2 >= r6) goto L5;
        FontFamily r8 = r4[r2];
        _table[r8.getValue()] = r8;
        r2 = r2 + 1;
        goto L3
    }

    private FontFamily(String r1, int r2, int r3) {
        super(r1, r2);
        this.family = r3;
    }

    public static FontFamily valueOf(int r1) {
        return _table[r1];
    }

    public static FontFamily valueOf(String r2) {
        return (FontFamily) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontFamily.class, r2), FontFamily.class, "com.obric.memorydata.plugin");
    }

    public static FontFamily[] values() {
        return (FontFamily[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontFamily[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.family;
    }
}
