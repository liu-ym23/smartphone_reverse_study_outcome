package com.bytedance.sdk.account.save.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final enum InfoType extends Enum<InfoType> {
    private static final /* synthetic */ InfoType[] $VALUES = null;
    public static final InfoType INFO_TYPE_1 = null;
    public static final InfoType INFO_TYPE_2 = null;
    public static final InfoType INFO_TYPE_3 = null;
    private int type;

    static {
        InfoType r0 = new InfoType("INFO_TYPE_1", 0, 1);
        INFO_TYPE_1 = r0;
        InfoType r1 = new InfoType("INFO_TYPE_2", 1, 2);
        INFO_TYPE_2 = r1;
        InfoType r4 = new InfoType("INFO_TYPE_3", 2, 4);
        INFO_TYPE_3 = r4;
        $VALUES = new InfoType[]{r0, r1, r4};
    }

    private InfoType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }

    public static int getValue(List<InfoType> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r4 != null) goto L5;
        return 0;
    L5:
        InfoType r1 = INFO_TYPE_1;
        if (r4.contains(r1) == false) goto L8;
        r0 = 0 + r1.type;
    L8:
        InfoType r2 = INFO_TYPE_2;
        if (r4.contains(r2) == false) goto L11;
        r0 = r0 + r2.type;
    L11:
        InfoType r5 = INFO_TYPE_3;
        if (r4.contains(r5) == true) goto L14;
        return r0;
    L14:
        return r0 + r5.type;
    }

    public static InfoType valueOf(String r2) {
        return (InfoType) ZeusTransformUtils.preCheckCast(Enum.valueOf(InfoType.class, r2), InfoType.class, "com.obric.memorydata.plugin");
    }

    public static InfoType[] values() {
        return (InfoType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InfoType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.type;
    }
}
