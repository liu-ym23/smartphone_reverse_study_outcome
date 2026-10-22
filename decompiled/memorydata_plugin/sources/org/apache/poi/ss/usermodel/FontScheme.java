package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum FontScheme extends Enum<FontScheme> {
    private static final /* synthetic */ FontScheme[] $VALUES = null;
    public static final FontScheme MAJOR = null;
    public static final FontScheme MINOR = null;
    public static final FontScheme NONE = null;
    private static final FontScheme[] _table = null;
    private final int value;

    static {
        FontScheme r0 = new FontScheme("NONE", 0, 1);
        NONE = r0;
        FontScheme r1 = new FontScheme("MAJOR", 1, 2);
        MAJOR = r1;
        FontScheme r4 = new FontScheme("MINOR", 2, 3);
        MINOR = r4;
        $VALUES = new FontScheme[]{r0, r1, r4};
        _table = new FontScheme[]{null, r0, r1, r4};
    }

    private FontScheme(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static FontScheme valueOf(int r1) {
        return _table[r1];
    }

    public static FontScheme valueOf(String r2) {
        return (FontScheme) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontScheme.class, r2), FontScheme.class, "com.obric.memorydata.plugin");
    }

    public static FontScheme[] values() {
        return (FontScheme[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontScheme[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
