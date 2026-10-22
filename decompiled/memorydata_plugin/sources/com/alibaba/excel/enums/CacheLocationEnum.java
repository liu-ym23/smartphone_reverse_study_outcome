package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum CacheLocationEnum extends Enum<CacheLocationEnum> {
    private static final /* synthetic */ CacheLocationEnum[] $VALUES = null;
    public static final CacheLocationEnum MEMORY = null;
    public static final CacheLocationEnum NONE = null;
    public static final CacheLocationEnum THREAD_LOCAL = null;

    static {
        CacheLocationEnum r0 = new CacheLocationEnum("THREAD_LOCAL", 0);
        THREAD_LOCAL = r0;
        CacheLocationEnum r1 = new CacheLocationEnum("MEMORY", 1);
        MEMORY = r1;
        CacheLocationEnum r3 = new CacheLocationEnum("NONE", 2);
        NONE = r3;
        $VALUES = new CacheLocationEnum[]{r0, r1, r3};
    }

    private CacheLocationEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CacheLocationEnum valueOf(String r2) {
        return (CacheLocationEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(CacheLocationEnum.class, r2), CacheLocationEnum.class, "com.obric.memorydata.plugin");
    }

    public static CacheLocationEnum[] values() {
        return (CacheLocationEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CacheLocationEnum[].class, "com.obric.memorydata.plugin");
    }
}
