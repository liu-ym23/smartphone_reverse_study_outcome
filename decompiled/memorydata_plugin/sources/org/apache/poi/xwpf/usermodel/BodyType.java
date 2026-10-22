package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum BodyType extends Enum<BodyType> {
    private static final /* synthetic */ BodyType[] $VALUES = null;
    public static final BodyType COMMENT = null;
    public static final BodyType CONTENTCONTROL = null;
    public static final BodyType DOCUMENT = null;
    public static final BodyType FOOTER = null;
    public static final BodyType FOOTNOTE = null;
    public static final BodyType HEADER = null;
    public static final BodyType TABLECELL = null;

    static {
        BodyType r0 = new BodyType("CONTENTCONTROL", 0);
        CONTENTCONTROL = r0;
        BodyType r1 = new BodyType("DOCUMENT", 1);
        DOCUMENT = r1;
        BodyType r3 = new BodyType("HEADER", 2);
        HEADER = r3;
        BodyType r5 = new BodyType("FOOTER", 3);
        FOOTER = r5;
        BodyType r7 = new BodyType("FOOTNOTE", 4);
        FOOTNOTE = r7;
        BodyType r9 = new BodyType("TABLECELL", 5);
        TABLECELL = r9;
        BodyType r11 = new BodyType("COMMENT", 6);
        COMMENT = r11;
        $VALUES = new BodyType[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private BodyType(String r1, int r2) {
        super(r1, r2);
    }

    public static BodyType valueOf(String r2) {
        return (BodyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BodyType.class, r2), BodyType.class, "com.obric.memorydata.plugin");
    }

    public static BodyType[] values() {
        return (BodyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BodyType[].class, "com.obric.memorydata.plugin");
    }
}
