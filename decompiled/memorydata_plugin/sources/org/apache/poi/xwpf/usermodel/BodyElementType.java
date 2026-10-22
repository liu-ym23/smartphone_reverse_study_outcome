package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum BodyElementType extends Enum<BodyElementType> {
    private static final /* synthetic */ BodyElementType[] $VALUES = null;
    public static final BodyElementType CONTENTCONTROL = null;
    public static final BodyElementType PARAGRAPH = null;
    public static final BodyElementType TABLE = null;

    static {
        BodyElementType r0 = new BodyElementType("CONTENTCONTROL", 0);
        CONTENTCONTROL = r0;
        BodyElementType r1 = new BodyElementType("PARAGRAPH", 1);
        PARAGRAPH = r1;
        BodyElementType r3 = new BodyElementType("TABLE", 2);
        TABLE = r3;
        $VALUES = new BodyElementType[]{r0, r1, r3};
    }

    private BodyElementType(String r1, int r2) {
        super(r1, r2);
    }

    public static BodyElementType valueOf(String r2) {
        return (BodyElementType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BodyElementType.class, r2), BodyElementType.class, "com.obric.memorydata.plugin");
    }

    public static BodyElementType[] values() {
        return (BodyElementType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BodyElementType[].class, "com.obric.memorydata.plugin");
    }
}
