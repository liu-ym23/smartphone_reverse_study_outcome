package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public final enum TextStyle extends Enum<TextStyle> {
    private static final /* synthetic */ TextStyle[] $VALUES = null;
    public static final TextStyle FULL = null;
    public static final TextStyle FULL_STANDALONE = null;
    public static final TextStyle NARROW = null;
    public static final TextStyle NARROW_STANDALONE = null;
    public static final TextStyle SHORT = null;
    public static final TextStyle SHORT_STANDALONE = null;

    static {
        TextStyle r0 = new TextStyle("FULL", 0);
        FULL = r0;
        TextStyle r1 = new TextStyle("FULL_STANDALONE", 1);
        FULL_STANDALONE = r1;
        TextStyle r3 = new TextStyle("SHORT", 2);
        SHORT = r3;
        TextStyle r5 = new TextStyle("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = r5;
        TextStyle r7 = new TextStyle("NARROW", 4);
        NARROW = r7;
        TextStyle r9 = new TextStyle("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = r9;
        $VALUES = new TextStyle[]{r0, r1, r3, r5, r7, r9};
    }

    private TextStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static TextStyle valueOf(String r2) {
        return (TextStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextStyle.class, r2), TextStyle.class, "com.obric.memorydata.plugin");
    }

    public static TextStyle[] values() {
        return (TextStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextStyle[].class, "com.obric.memorydata.plugin");
    }

    public TextStyle asNormal() {
        return values()[ordinal() & (-2)];
    }

    public TextStyle asStandalone() {
        return values()[ordinal() | 1];
    }

    public boolean isStandalone() {
        if ((ordinal() & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
