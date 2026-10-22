package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum StatisticType extends Enum<StatisticType> {
    private static final /* synthetic */ StatisticType[] $VALUES = null;
    public static final StatisticType COUNTER = null;
    public static final StatisticType GAUGE = null;
    public static final StatisticType RATE = null;
    public static final StatisticType RATIO = null;
    public static final StatisticType TABLE = null;

    static {
        StatisticType r0 = new StatisticType("COUNTER", 0);
        COUNTER = r0;
        StatisticType r1 = new StatisticType("RATE", 1);
        RATE = r1;
        StatisticType r3 = new StatisticType("RATIO", 2);
        RATIO = r3;
        StatisticType r5 = new StatisticType("GAUGE", 3);
        GAUGE = r5;
        StatisticType r7 = new StatisticType("TABLE", 4);
        TABLE = r7;
        $VALUES = new StatisticType[]{r0, r1, r3, r5, r7};
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
