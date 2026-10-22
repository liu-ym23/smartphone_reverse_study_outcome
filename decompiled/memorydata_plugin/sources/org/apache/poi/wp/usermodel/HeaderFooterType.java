package org.apache.poi.wp.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum HeaderFooterType extends Enum<HeaderFooterType> {
    private static final /* synthetic */ HeaderFooterType[] $VALUES = null;
    public static final HeaderFooterType DEFAULT = null;
    public static final HeaderFooterType EVEN = null;
    public static final HeaderFooterType FIRST = null;
    private final int code;

    static {
        HeaderFooterType r0 = new HeaderFooterType("DEFAULT", 0, 2);
        DEFAULT = r0;
        HeaderFooterType r1 = new HeaderFooterType("EVEN", 1, 1);
        EVEN = r1;
        HeaderFooterType r4 = new HeaderFooterType("FIRST", 2, 3);
        FIRST = r4;
        $VALUES = new HeaderFooterType[]{r0, r1, r4};
    }

    private HeaderFooterType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static HeaderFooterType forInt(int r5) {
        HeaderFooterType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        HeaderFooterType r3 = r0[r2];
        if (r3.code == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Invalid HeaderFooterType code: " + r5);
    }

    public static HeaderFooterType valueOf(String r2) {
        return (HeaderFooterType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HeaderFooterType.class, r2), HeaderFooterType.class, "com.obric.memorydata.plugin");
    }

    public static HeaderFooterType[] values() {
        return (HeaderFooterType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HeaderFooterType[].class, "com.obric.memorydata.plugin");
    }

    public int toInt() {
        return this.code;
    }
}
