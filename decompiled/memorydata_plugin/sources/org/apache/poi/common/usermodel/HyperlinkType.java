package org.apache.poi.common.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum HyperlinkType extends Enum<HyperlinkType> {
    private static final /* synthetic */ HyperlinkType[] $VALUES = null;
    public static final HyperlinkType DOCUMENT = null;
    public static final HyperlinkType EMAIL = null;
    public static final HyperlinkType FILE = null;
    public static final HyperlinkType NONE = null;
    public static final HyperlinkType URL = null;

    @Deprecated
    private final int code;

    static {
        HyperlinkType r0 = new HyperlinkType("NONE", 0, -1);
        NONE = r0;
        HyperlinkType r1 = new HyperlinkType("URL", 1, 1);
        URL = r1;
        HyperlinkType r3 = new HyperlinkType("DOCUMENT", 2, 2);
        DOCUMENT = r3;
        HyperlinkType r5 = new HyperlinkType("EMAIL", 3, 3);
        EMAIL = r5;
        HyperlinkType r7 = new HyperlinkType("FILE", 4, 4);
        FILE = r7;
        $VALUES = new HyperlinkType[]{r0, r1, r3, r5, r7};
    }

    @Deprecated
    private HyperlinkType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static HyperlinkType valueOf(String r2) {
        return (HyperlinkType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HyperlinkType.class, r2), HyperlinkType.class, "com.obric.memorydata.plugin");
    }

    public static HyperlinkType[] values() {
        return (HyperlinkType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HyperlinkType[].class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    int getCode() {
        return this.code;
    }
}
