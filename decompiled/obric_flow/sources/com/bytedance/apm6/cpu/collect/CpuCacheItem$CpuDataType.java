package com.bytedance.apm6.cpu.collect;

/* JADX INFO: loaded from: classes2.dex */
public final enum CpuCacheItem$CpuDataType extends Enum<CpuCacheItem$CpuDataType> {
    public static final CpuCacheItem$CpuDataType BACK = null;
    public static final CpuCacheItem$CpuDataType FRONT = null;
    public static final CpuCacheItem$CpuDataType MIX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CpuCacheItem$CpuDataType[] f3922a = null;

    static {
        CpuCacheItem$CpuDataType r5 = new CpuCacheItem$CpuDataType("MIX", 0);
        MIX = r5;
        CpuCacheItem$CpuDataType r10 = new CpuCacheItem$CpuDataType("FRONT", 1);
        FRONT = r10;
        CpuCacheItem$CpuDataType r11 = new CpuCacheItem$CpuDataType("BACK", 2);
        BACK = r11;
        f3922a = new CpuCacheItem$CpuDataType[]{r5, r10, r11};
    }

    public static CpuCacheItem$CpuDataType valueOf(String r5) {
        return (CpuCacheItem$CpuDataType) Enum.valueOf(CpuCacheItem$CpuDataType.class, r5);
    }

    public static CpuCacheItem$CpuDataType[] values() {
        return (CpuCacheItem$CpuDataType[]) f3922a.clone();
    }
}
