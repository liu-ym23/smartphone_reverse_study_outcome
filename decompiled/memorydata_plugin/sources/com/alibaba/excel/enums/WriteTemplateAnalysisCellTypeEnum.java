package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum WriteTemplateAnalysisCellTypeEnum extends Enum<WriteTemplateAnalysisCellTypeEnum> {
    private static final /* synthetic */ WriteTemplateAnalysisCellTypeEnum[] $VALUES = null;
    public static final WriteTemplateAnalysisCellTypeEnum COLLECTION = null;
    public static final WriteTemplateAnalysisCellTypeEnum COMMON = null;

    static {
        WriteTemplateAnalysisCellTypeEnum r0 = new WriteTemplateAnalysisCellTypeEnum("COMMON", 0);
        COMMON = r0;
        WriteTemplateAnalysisCellTypeEnum r1 = new WriteTemplateAnalysisCellTypeEnum("COLLECTION", 1);
        COLLECTION = r1;
        $VALUES = new WriteTemplateAnalysisCellTypeEnum[]{r0, r1};
    }

    private WriteTemplateAnalysisCellTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static WriteTemplateAnalysisCellTypeEnum valueOf(String r2) {
        return (WriteTemplateAnalysisCellTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(WriteTemplateAnalysisCellTypeEnum.class, r2), WriteTemplateAnalysisCellTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static WriteTemplateAnalysisCellTypeEnum[] values() {
        return (WriteTemplateAnalysisCellTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WriteTemplateAnalysisCellTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
