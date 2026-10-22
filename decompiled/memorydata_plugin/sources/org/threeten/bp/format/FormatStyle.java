package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public final enum FormatStyle extends Enum<FormatStyle> {
    private static final /* synthetic */ FormatStyle[] $VALUES = null;
    public static final FormatStyle FULL = null;
    public static final FormatStyle LONG = null;
    public static final FormatStyle MEDIUM = null;
    public static final FormatStyle SHORT = null;

    static {
        FormatStyle r0 = new FormatStyle("FULL", 0);
        FULL = r0;
        FormatStyle r1 = new FormatStyle("LONG", 1);
        LONG = r1;
        FormatStyle r3 = new FormatStyle("MEDIUM", 2);
        MEDIUM = r3;
        FormatStyle r5 = new FormatStyle("SHORT", 3);
        SHORT = r5;
        $VALUES = new FormatStyle[]{r0, r1, r3, r5};
    }

    private FormatStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static FormatStyle valueOf(String r2) {
        return (FormatStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(FormatStyle.class, r2), FormatStyle.class, "com.obric.memorydata.plugin");
    }

    public static FormatStyle[] values() {
        return (FormatStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FormatStyle[].class, "com.obric.memorydata.plugin");
    }
}
