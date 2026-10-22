package org.ehcache.core.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum StatisticType extends Enum<StatisticType> {
    private static final /* synthetic */ StatisticType[] $VALUES = null;
    public static final StatisticType COUNTER = null;
    public static final StatisticType GAUGE = null;

    static {
        StatisticType r0 = new StatisticType("COUNTER", 0);
        COUNTER = r0;
        StatisticType r1 = new StatisticType("GAUGE", 1);
        GAUGE = r1;
        $VALUES = new StatisticType[]{r0, r1};
    }

    private StatisticType(String r1, int r2) {
        super(r1, r2);
    }

    public static StatisticType valueOf(String r2) {
        return (StatisticType) ZeusTransformUtils.preCheckCast(Enum.valueOf(StatisticType.class, r2), StatisticType.class, "com.obric.memorydata.plugin");
    }

    public static StatisticType[] values() {
        return (StatisticType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StatisticType[].class, "com.obric.memorydata.plugin");
    }
}
