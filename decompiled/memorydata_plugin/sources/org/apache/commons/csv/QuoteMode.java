package org.apache.commons.csv;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum QuoteMode extends Enum<QuoteMode> {
    private static final /* synthetic */ QuoteMode[] $VALUES = null;
    public static final QuoteMode ALL = null;
    public static final QuoteMode ALL_NON_NULL = null;
    public static final QuoteMode MINIMAL = null;
    public static final QuoteMode NONE = null;
    public static final QuoteMode NON_NUMERIC = null;

    static {
        QuoteMode r0 = new QuoteMode("ALL", 0);
        ALL = r0;
        QuoteMode r1 = new QuoteMode("ALL_NON_NULL", 1);
        ALL_NON_NULL = r1;
        QuoteMode r3 = new QuoteMode("MINIMAL", 2);
        MINIMAL = r3;
        QuoteMode r5 = new QuoteMode("NON_NUMERIC", 3);
        NON_NUMERIC = r5;
        QuoteMode r7 = new QuoteMode("NONE", 4);
        NONE = r7;
        $VALUES = new QuoteMode[]{r0, r1, r3, r5, r7};
    }

    private QuoteMode(String r1, int r2) {
        super(r1, r2);
    }

    public static QuoteMode valueOf(String r2) {
        return (QuoteMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(QuoteMode.class, r2), QuoteMode.class, "com.obric.memorydata.plugin");
    }

    public static QuoteMode[] values() {
        return (QuoteMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), QuoteMode[].class, "com.obric.memorydata.plugin");
    }
}
