package com.cronutils.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CronType extends Enum<CronType> {
    private static final /* synthetic */ CronType[] $VALUES = null;
    public static final CronType CRON4J = null;
    public static final CronType QUARTZ = null;
    public static final CronType SPRING = null;
    public static final CronType SPRING53 = null;
    public static final CronType UNIX = null;

    static {
        CronType r0 = new CronType("CRON4J", 0);
        CRON4J = r0;
        CronType r1 = new CronType("QUARTZ", 1);
        QUARTZ = r1;
        CronType r3 = new CronType("UNIX", 2);
        UNIX = r3;
        CronType r5 = new CronType("SPRING", 3);
        SPRING = r5;
        CronType r7 = new CronType("SPRING53", 4);
        SPRING53 = r7;
        $VALUES = new CronType[]{r0, r1, r3, r5, r7};
    }

    private CronType(String r1, int r2) {
        super(r1, r2);
    }

    public static CronType valueOf(String r2) {
        return (CronType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CronType.class, r2), CronType.class, "com.obric.memorydata.plugin");
    }

    public static CronType[] values() {
        return (CronType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CronType[].class, "com.obric.memorydata.plugin");
    }
}
